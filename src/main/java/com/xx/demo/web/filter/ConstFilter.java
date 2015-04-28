package com.xx.demo.web.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import com.alonew.core.web.util.IpUtil;

public class ConstFilter implements Filter {

	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		// 这个filter用来设置一些页面静态常量的
		request.setAttribute("hostip", IpUtil.hostip);
		request.setAttribute("hostidport", IpUtil.hostIpLast + ":" + request.getLocalPort());
		chain.doFilter(request, response);
	}

	@Override
	public void destroy() {
		
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		
	}

	

}
