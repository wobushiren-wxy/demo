package com.xx.demo.web.action.demo;

import java.util.HashMap;
import java.util.Map;

import com.google.gson.Gson;
import com.xx.demo.biz.service.ServiceFactory;
import com.xx.demo.common.utils.LoggerManager;
import com.xx.demo.model.enums.ErrorCode;
import com.xx.demo.model.resp.BaseRes;
import com.xx.demo.model.resp.FoodevaluationRes;
import com.xx.demo.web.action.base.BaseAction;

public class FoodevaluationsAction extends BaseAction {

	private static final long serialVersionUID = 1L;

	private int start = 0;
	
	private int retNums = 5;
	
	private String orderField = "cptime";//排序字段	默认排序字段guuser	

	private String orderDirection = "desc";//排序方式	默认升序asc
	
	private String carteno = null;
	private String guuser = null;// 用户名
	private String cartename = null;// 菜名
	

	private String carteping = null;// 菜评价
	
	
	public String createFoodevaluation() {
		LoggerManager.def.info("获取客户端参数：carteno="
				+ carteno + ",guuser=" + guuser 
				+  ",carteping=" + carteping  );
		Gson gson = new Gson();
		
		try {
			FoodevaluationRes foodevaluationRes = new FoodevaluationRes(null,carteno,guuser,carteping);
			
			
			
			BaseRes baseRes = ServiceFactory.getFoodevaluationsService()
					.createFoodevaluations(foodevaluationRes);
			String gsonString = gson.toJson(baseRes);
			LoggerManager.def.info("#####createFoodevaluation,Gson串 = "
					+ gsonString + "########");
			
		} catch (Exception e) {
			LoggerManager.def.error("#####createFoodevaluation errors" + e);
			this.print(gson.toJson(new BaseRes(ErrorCode.SYSTEM_ERROR)));
		}
		
		return null;
		
		
		
	}

	public String getFoodevaluationListCartenoByCondition() {
		LoggerManager.def.info("获取客户端参数：start="
				+ start + ",retNums=" + retNums 
				+  ",orderField=" + orderField +  ",orderDirection=" + orderDirection
				+  ",carteno=" + carteno );
		Gson gson = new Gson();
		try {
			
			Map<String, Object> condition = new HashMap<String, Object>();
			condition.put("start", start);
			condition.put("num", retNums);//这个是返回的值
			condition.put("orderField", orderField);
			condition.put("orderDirection", orderDirection);
			condition.put("carteno", carteno);
			
			BaseRes baseRes = ServiceFactory.getFoodevaluationsService()
					.getFoodevaluationListCartenoByCondition(condition);
			
			String gsonString = gson.toJson(baseRes);
			LoggerManager.def.info("#####getFoodevaluationsByCondition,Gson串 = "
					+ gsonString + "########");
			// 返回json数据给客户端
			this.print(gsonString);
		} catch (Exception e) {
			LoggerManager.def.error("#####getFoodevaluationsByCondition errors" + e);
			this.print(gson.toJson(new BaseRes(ErrorCode.SYSTEM_ERROR)));
		}
		return null;
	}

	
	
	public String getCartename() {
		return cartename;
	}

	public void setCartename(String cartename) {
		this.cartename = cartename;
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



	public String getCarteno() {
		return carteno;
	}

	public void setCarteno(String carteno) {
		this.carteno = carteno;
	}
	
	public String getGuuser() {
		return guuser;
	}

	public void setGuuser(String guuser) {
		this.guuser = guuser;
	}

	public String getCarteping() {
		return carteping;
	}

	public void setCarteping(String carteping) {
		this.carteping = carteping;
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
