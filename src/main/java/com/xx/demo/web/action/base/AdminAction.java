package com.xx.demo.web.action.base;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.StringUtils;
import org.apache.struts2.ServletActionContext;

import com.alonew.core.commons.page.Page;
import com.alonew.core.web.action.base.Struts2Action;
import com.xx.demo.common.utils.DwzResponse;

public abstract class AdminAction extends Struts2Action {

	private static final long serialVersionUID = -3721271320756045097L;

	// 字段排序
	protected String orderField;
	//排序方式
	protected String orderDirection;
	
	/**
	 * 获取分页参数
	 * 
	 * @return
	 */
	protected Page fetchPageParams() {
		Page page = new Page();
		String pageNum = request.getParameter("pageNum"); // 页码
		String numPerPage = request.getParameter("numPerPage"); // 每页显示数
		if (null != pageNum && null != numPerPage) {
			page.setPageNum(Integer.parseInt(pageNum));
			page.setNumPerPage(Integer.parseInt(numPerPage));
		}
		return page;
	}

	protected String ajaxDone(int statusCode, String message) {
		HttpServletRequest request = ServletActionContext.getRequest();
		String navTabId = StringUtils.trimToEmpty(request.getParameter("navTabId")); //param.navTabId
		String rel = StringUtils.trimToEmpty(request.getParameter("rel"));; //param.rel
		String callbackType = StringUtils.trimToEmpty(request.getParameter("callbackType"));; //param.callbackType
		String forwardUrl = StringUtils.trimToEmpty(request.getParameter("forwardUrl"));; //param.forwardUrl
		
		DwzResponse dwzResponse = new DwzResponse();
		dwzResponse.setStatusCode(statusCode);
		dwzResponse.setMessage(message);
		dwzResponse.setNavTabId(navTabId);
		dwzResponse.setRel(rel);
		dwzResponse.setCallbackType(callbackType);
		dwzResponse.setForwardUrl(forwardUrl);
		
		this.print(dwzResponse.toJson());
		
		return null;
	}

	protected String ajaxDoneSuccess(String message) {
		return ajaxDone(200, message);
	}

	protected String ajaxDoneError(String message) {
		return ajaxDone(300, message);
	}

	public String getOrderField() {
		return orderField;
	}

	public void setOrderField(String orderField) {
		this.orderField = orderField;
	}

	public String getOrderDirection() {
		return orderDirection;
	}

	public void setOrderDirection(String orderDirection) {
		this.orderDirection = orderDirection;
	}
	
}
