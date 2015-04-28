package com.xx.demo.web.interceptor;

import java.lang.reflect.Method;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alonew.core.web.action.base.Struts2Action;
import com.alonew.core.web.annotation.PostCheck;
import com.alonew.core.web.util.ActionMethodUtil;
import com.alonew.core.web.util.ActionUtil;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

/**
 * post请求验证
 * 
 * @author chlingm
 * 
 */
public class CommonCheckInterceptor extends AbstractInterceptor {

	private static final long serialVersionUID = 495254921117512933L;

	
	public String intercept(ActionInvocation ai) {
		Object object = ai.getAction();
		HttpServletRequest request = null;
		HttpServletResponse response = null;
		if (object instanceof Struts2Action) {
			Struts2Action action = (Struts2Action) object;
			Method method = ActionMethodUtil.getActionMethod(ai);
			request = action.getServletRequest();
			response = action.getServletResponse();
			if (method != null) {
				PostCheck pc = method.getAnnotation(PostCheck.class);
				if (pc != null) {
					boolean success = true;
					if (pc.post()) {
						success = ActionUtil.chkPost(request, response);
					}
					if (success && pc.referer()) {
						success = ActionUtil.chkReferer(request, response);
					}
					if (!success) {
						response.setStatus(403);
						return null;
					}
				}
			}
		} else {
			// 这里应该是直接走JSP页面的
		}
		try {
			return ai.invoke();
		} catch (Exception e) {
			e.printStackTrace();
			handleException(request, e);
			return "handleException";
		}
	}

	private void handleException(HttpServletRequest request, Exception e){
		int ret = 500;
		if(request != null){
			request.setAttribute("errmsg", e.getMessage());
			request.setAttribute("ret", ret);
			request.setAttribute("cmd", request.getRequestURI());
		}
	}
}
