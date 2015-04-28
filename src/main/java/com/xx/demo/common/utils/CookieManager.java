package com.xx.demo.common.utils;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class CookieManager {
	public static String getCookie(HttpServletRequest request, String key) {
		Cookie[] cookies = request.getCookies();
		if (cookies == null) {
			return null;
		}
		for (Cookie cookie : cookies) {
			if (cookie.getName().trim().equalsIgnoreCase(key)) {
				return cookie.getValue();
			}
		}
		return null;
	}

	public static void setCookie(HttpServletRequest request, HttpServletResponse response, String key,
			String value) {
		setCookie(request, response, key, value, -1);
	}

	public static void delCookie(HttpServletRequest request, HttpServletResponse response, String key) {
		setCookie(request, response, key, null);
	}
    
	public static boolean isFirst = true;
	
	public static void setCookie(HttpServletRequest request, HttpServletResponse response, String key,
			String value, int expireSec) {
		String domain = request.getServerName();
		if(isFirst){
			System.out.println("domain  " + domain);
			isFirst = false;
		}
		setCookie(response, key, value, domain, "/", expireSec);
	}

	public static void setCookie(HttpServletResponse response, String key,
			String value, String domain, String path, int expireSec) {
		Cookie cookie = new Cookie(key, value);
		cookie.setDomain(domain);
		cookie.setPath(path);
		if (expireSec == -1) {

		} else {
			cookie.setMaxAge(expireSec);
		}
		response.addCookie(cookie);
	}
}