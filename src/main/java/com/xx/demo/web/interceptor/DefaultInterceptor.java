package com.xx.demo.web.interceptor;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

public class DefaultInterceptor extends AbstractInterceptor {

	private static final long serialVersionUID = -8492579989747450326L;

	
	public String intercept(ActionInvocation ai) throws Exception {
		return ai.invoke();
	}

}
