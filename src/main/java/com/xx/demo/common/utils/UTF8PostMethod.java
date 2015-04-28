package com.xx.demo.common.utils;

import org.apache.commons.httpclient.methods.PostMethod;

/**
 * 需要覆盖getRequestCharSet方法来设置utf-8编码格式。
 * @author linmin
 *
 */
public class UTF8PostMethod extends PostMethod{
	public UTF8PostMethod(String url){
		super(url);
	}
	@Override
	public String getRequestCharSet() {
		return "utf-8";
	}
}
