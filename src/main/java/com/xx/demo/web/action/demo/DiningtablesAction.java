package com.xx.demo.web.action.demo;

import java.util.HashMap;
import java.util.Map;

import com.google.gson.Gson;
import com.xx.demo.biz.service.ServiceFactory;
import com.xx.demo.common.utils.LoggerManager;
import com.xx.demo.model.enums.ErrorCode;
import com.xx.demo.model.resp.BaseRes;
import com.xx.demo.model.resp.DiningtableRes;
import com.xx.demo.web.action.base.BaseAction;

public class DiningtablesAction extends BaseAction {

	private static final long serialVersionUID = 1L;
	
	private int start = 0;
	
	private int retNums = 1;//返回个数

	private String orderField = "dtno";//排序字段	默认排序字段guuser	

	private String orderDirection = "asc";//排序方式	默认升序asc
	
	//private int retNums = 1;如果要用的话记得下面获取客户端参数要写进去
	
	private String dtno = null;
	
	private String dtname = null;
	
	private String dtnote = null;
	
	private DiningtableRes diningtableRes;


	public String updateDiningtables(){
		LoggerManager.def.info("获取客户端参数：dtno=" + dtno + ",dtname=" + dtname + ",orderField="
				+ orderField + ",orderDirection=" + orderDirection);
		Gson gson = new Gson();
		try {
			DiningtableRes diningtableRes = new DiningtableRes(
				dtno,dtname,dtnote);
			BaseRes baseRes = ServiceFactory.getDiningtablesService()
					.updateDiningtables(diningtableRes);
			String gsonString = gson.toJson(baseRes);
			LoggerManager.def.info("#####updateDiningtables,Gson串 = "
					+ gsonString + "########");
			// 返回json数据给客户端
			this.print(gsonString);
			
		}catch (Exception e) {
			LoggerManager.def.error("#####getDiningtablesByCondition errors" + e);
			this.print(gson.toJson(new BaseRes(ErrorCode.SYSTEM_ERROR)));
		}
		return null;
	}

	

	public String getDiningtablesByCondition() {
		LoggerManager.def.info("获取客户端参数：start=" + start + ",retNums=" + retNums + ",orderField="
				+ orderField + ",orderDirection=" + orderDirection);
		Gson gson = new Gson();
		try {
			Map<String, Object> condition = new HashMap<String, Object>();
			condition.put("start", start);
			condition.put("num", retNums);
			condition.put("orderField", orderField);
			condition.put("orderDirection", orderDirection);
			BaseRes baseRes = ServiceFactory.getDiningtablesService()
					.getDiningtablesByCondition(condition);
			String gsonString = gson.toJson(baseRes);
			LoggerManager.def.info("#####getDiningtablesByCondition,Gson串 = "
					+ gsonString + "########");
			// 返回json数据给客户端
			this.print(gsonString);
		} catch (Exception e) {
			LoggerManager.def.error("#####getDiningtablesByCondition errors" + e);
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



	public String getDtno() {
		return dtno;
	}



	public void setDtno(String dtno) {
		this.dtno = dtno;
	}



	public String getDtname() {
		return dtname;
	}



	public void setDtname(String dtname) {
		this.dtname = dtname;
	}



	public String getDtnote() {
		return dtnote;
	}



	public void setDtnote(String dtnote) {
		this.dtnote = dtnote;
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
	
	public DiningtableRes getDiningtableRes() {
		return diningtableRes;
	}

	public void setDiningtableRes(DiningtableRes diningtableRes) {
		this.diningtableRes = diningtableRes;
	}

}
