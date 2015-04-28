package com.xx.demo.web.action.base;

import com.alonew.core.web.action.base.Struts2Action;
import com.alonew.json.JSONException;
import com.alonew.json.JSONObject;

public abstract class PrintAction extends Struts2Action {

	private static final long serialVersionUID = 8896130269789673672L;

	
	private void doPrint(JSONObject json){
//		json.put("_cmd", request.getRequestURI());
//		json.put("server_time", System.currentTimeMillis() / 1000);
//		json.put("error_code", ErrorCode.OPERATE_SUCCESS);
//		json.put("map_reset_time", ItgirlUtils.restoreTime());
//		json.put("environment", "prod");
		this.print(json.toString());
	}
	
	protected void printData(JSONObject data){
		JSONObject json = new JSONObject();
		try {
			json.put("data", data);
		} catch (JSONException e) {
			e.printStackTrace();
		}
		doPrint(json);
	}
	
	protected void printData(boolean result){
		JSONObject data = new JSONObject();
		try {
			data.put("result", result);
		} catch (JSONException e) {
			e.printStackTrace();
		}
		printData(data);
	}
	
	protected void printModels(JSONObject models){
		JSONObject json = new JSONObject();
		try {
			json.put("models", models);
		} catch (JSONException e) {
			e.printStackTrace();
		}
		doPrint(json);
	}
}
