package com.xx.demo.common.utils;

import com.alonew.json.JSONArray;
import com.alonew.json.JSONException;

public class JsonUtil {
	public static boolean contains(JSONArray array, int id) {
		for (int i = 0; i < array.length(); i++) {
			if (array.optInt(i) == id) {
				return true;
			}
		}
		return false;
	}
	
	public static JSONArray stringToArray(String str) throws JSONException{
		return new JSONArray(str);
	}
	
	public static boolean removeInt(JSONArray origin, int value) {
		int index = -1;
		for (int i = 0; i < origin.length(); i++) {
			if (origin.optInt(i) == value) {
				index = i;
				break;
			}
		}
		if (index == -1) {
			// 不存在该值
			return false;
		}
		origin.remove(index);
		return true;
	}
}
