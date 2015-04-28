package com.xx.demo.web.action.demo;



import com.google.gson.Gson;
import com.xx.demo.biz.service.ServiceFactory;
import com.xx.demo.common.utils.LoggerManager;
import com.xx.demo.model.enums.ErrorCode;
import com.xx.demo.model.resp.BaseRes;
import com.xx.demo.model.resp.SubscribeRes;
import com.xx.demo.web.action.base.BaseAction;

public class SubscribesAction extends BaseAction {

	private static final long serialVersionUID = 1L;

	private String orderField = "subno";//排序字段	默认排序字段subno	

	private String orderDirection = "asc";//排序方式	默认升序asc
	
	//private int retNums = 1;如果要用的话记得下面获取客户端参数要写进去	注掉是可以用
	private String subno = null;
	private String subtime = null;
	private String guuser = null;
	private String subnums = null;
	


	public String getcreateSubscribesByCondition() {
		LoggerManager.def.info("获取客户端参数：orderField=" + orderField + ",orderDirection=" + orderDirection 
			+ ",subno=" + subno +  ",subtime=" + subtime + "," + "guuser=" + guuser + ","
				+ "subnums=" + subnums);
		Gson gson = new Gson();
		try {
			//将数据传入SubscribeRes中
			SubscribeRes subscribeRes = new SubscribeRes(null, subno, 
					subtime,guuser,subnums);
			
			
			BaseRes baseRes = ServiceFactory.getSubscribesService()
				.createSubscribe(subscribeRes);
			
			String gsonString = gson.toJson(baseRes);
			LoggerManager.def.info("#####getSubscribesByCondition,Gson串 = "
					+ gsonString + "########");
			// 返回json数据给客户端
			this.print(gsonString);
		} catch (Exception e) {
			LoggerManager.def.error("#####getSubscribesByCondition errors" + e);
			this.print(gson.toJson(new BaseRes(ErrorCode.SYSTEM_ERROR)));
		}
		return null;
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




	public String getSubno() {
		return subno;
	}




	public void setSubno(String subno) {
		this.subno = subno;
	}




	public String getSubtime() {
		return subtime;
	}




	public void setSubtime(String subtime) {
		this.subtime = subtime;
	}




	public String getGuuser() {
		return guuser;
	}




	public void setGuuser(String guuser) {
		this.guuser = guuser;
	}




	public String getSubnums() {
		return subnums;
	}




	public void setSubnums(String subnums) {
		this.subnums = subnums;
	}



	
}
