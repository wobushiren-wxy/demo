package com.xx.demo.web.action.demo;

import java.util.HashMap;
import java.util.Map;

import com.google.gson.Gson;
import com.xx.demo.biz.service.ServiceFactory;
import com.xx.demo.common.utils.LoggerManager;
import com.xx.demo.model.enums.ErrorCode;
import com.xx.demo.model.resp.BaseRes;
import com.xx.demo.web.action.base.BaseAction;

public class CartesAction extends BaseAction {

	private static final long serialVersionUID = 1L;

	private int retNums = 1;//默认每页显示个数1
	
	private int start = 0;//默认第几个开始0表示第1个开始

	private String orderField = "carteno";//排序字段

	private String orderDirection = "desc";//排序方式

	

	public String getCartesByCondition() {
		LoggerManager.def.info("获取客户端参数：start=" + start + ",retNums=" + retNums + ",orderField="
				+ orderField + ",orderDirection=" + orderDirection);
		Gson gson = new Gson();
		try {
			Map<String, Object> condition = new HashMap<String, Object>();
			condition.put("start", start);
			condition.put("num", retNums);
			condition.put("orderField", orderField);
			condition.put("orderDirection", orderDirection);
			BaseRes baseRes = ServiceFactory.getCartesService()
					.getCartesByCondition(condition);
			String gsonString = gson.toJson(baseRes);
			LoggerManager.def.info("#####getCartesByCondition,Gson串 = "
					+ gsonString + "########");
			// 返回json数据给客户端
			this.print(gsonString);
		} catch (Exception e) {
			LoggerManager.def.error("#####getCartesByCondition errors" + e);
			this.print(gson.toJson(new BaseRes(ErrorCode.SYSTEM_ERROR)));
		}
		return null;
	}

	public int getStart() {
		return start;
	}

	public void setStart(int start) {
		this.start = start;
	}
	
	public int getRetNums() {
		return retNums;
	}

	public void setRetNums(int retNums) {
		this.retNums = retNums;
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
