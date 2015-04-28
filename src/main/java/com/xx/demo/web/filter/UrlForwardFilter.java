package com.xx.demo.web.filter;

import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.regex.Pattern;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;


/**
 * 用来forward一些地址的
 * 
 * @author penpen
 * 
 */
public class UrlForwardFilter implements Filter {

	static interface Transformable {

		String transform(String uri);
	}

//	private static Transformable worldTransformer = new Transformable() {
//		
//		public String transform(String uri) {
//			return uri.replace("/index.do/", "/common/");
//		}
//	};
//
//	private static Transformable commonTransformer = new Transformable() {
//
//		
//		public String transform(String uri) {
//			return uri.replaceFirst("/common", "");
//		}
//	};
//	private static Transformable _commonTransformer = new Transformable() {
//
//		
//		public String transform(String uri) {
//			if (PlatformConstant.PLATFORM.equals("4399") || PlatformConstant.PLATFORM.equals("manyou")) {
//				return "/common/index/iframe.w";
//			}
//			return "/common/index/home.w";
//		}
//	};
//	private static Transformable _rootTransformer = new Transformable() {
//
//		
//		public String transform(String uri) {
//			System.out.println("PlatformFactory.PLATFORM " + PlatformFactory.PLATFORM);
//			if (PlatformFactory.PLATFORM == PlatformEnum.QZONE) {
//				return "/qzone/index/home.w";
//			}
//			return "/index.jsp";
//		}
//	};
	private static final ConcurrentHashMap<String, String> URLMAP = new ConcurrentHashMap<String, String>();
	static final Map<Pattern, Object> PATTERNS = new LinkedHashMap<Pattern, Object>();
	static {
//		PATTERNS.put(Pattern.compile("^/(common/)?manyou/pay/r$"), "/manyou/pay/r.w");
//		PATTERNS.put(Pattern.compile("^/(common/)?manyou/pay/callback$"), "/manyou/pay/callback.w");
//		PATTERNS.put(Pattern.compile("^/index\\.do/.*\\.(w|php|action)$"), worldTransformer);
//		PATTERNS.put(Pattern.compile("^/test/?"), "/test/index/home.w");
//		PATTERNS.put(Pattern.compile("^/qzone/?"), "/qzone/index/home.w");
//		PATTERNS.put(Pattern.compile("^/kaixin/?"), "/kaixin/index/home.w");
//		PATTERNS.put(Pattern.compile("^/common/?"), _commonTransformer);
//		PATTERNS.put(Pattern.compile("^/common/(renren|manyou|ourgame|4399)/.*"),commonTransformer);
//		PATTERNS.put(Pattern.compile("^/wap/?"), "/wap/index/home.w");
//		PATTERNS.put(Pattern.compile("/"), _rootTransformer);
//		PATTERNS.put(Pattern.compile(""), _rootTransformer);
	}

	private static final String NULLTARGET = "$WAR.URI.NULLTARGET";

	private static String transform(String uri) {
		String target = URLMAP.get(uri);
		if (target == null) {
			Set<Map.Entry<Pattern, Object>> set = PATTERNS.entrySet();
			for (Map.Entry<Pattern, Object> entry : set) {
				if (entry.getKey().matcher(uri).matches()) {
					Object obj = entry.getValue();
					if (obj instanceof Transformable) {
						target = ((Transformable) obj).transform(uri);
					} else {
						target = obj.toString();
					}
					URLMAP.putIfAbsent(uri, target);
					return target;
				}
			}
			URLMAP.putIfAbsent(uri, NULLTARGET);
			return null;
		} else {
			return target == NULLTARGET ? null : target;
		}
	}

	
	public void destroy() {

	}

	
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest) request;
		String uri = req.getRequestURI();
		if (uri != null) {
			String target = transform(uri);
			if (target != null) {
				request.getRequestDispatcher(target).forward(request, response);
				return;
			}
		}
		chain.doFilter(request, response);
	}

	
	public void init(FilterConfig filterConfig) throws ServletException {

	}

	public static void main(String[] args) {
		// System.out.println(transform("/index.do"));
		// System.out.println(Pattern.compile("^/index\\.do/.*\\.(w|php|action)$").matcher("/index.do/a.action").matches());
		System.out.println(Pattern.compile("").matcher("").matches());
//		String uri = "/common/aad/dsd/common";
//		System.out.println(uri.replaceFirst("/common", ""));
	}

}
