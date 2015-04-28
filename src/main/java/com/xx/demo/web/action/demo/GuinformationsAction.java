package com.xx.demo.web.action.demo;

import java.util.HashMap;
import java.util.Map;

import com.google.gson.Gson;
import com.xx.demo.biz.service.ServiceFactory;
import com.xx.demo.common.utils.LoggerManager;
import com.xx.demo.dao.DaoFactory;
import com.xx.demo.model.enums.ErrorCode;
import com.xx.demo.model.resp.BaseRes;
import com.xx.demo.model.resp.GuinformationRes;
import com.xx.demo.web.action.base.BaseAction;

public class GuinformationsAction extends BaseAction {

	private static final long serialVersionUID = 1L;

	private String orderField = "guuser";//排序字段	默认排序字段guuser	

	private String orderDirection = "asc";//排序方式	默认升序asc
	
	//private int retNums = 1;如果要用的话记得下面获取客户端参数要写进去
	
	private String guuser="1";

	private String gupwd ="1";
	
	private String guname = "";

	private String guphone = null;

	public String getcreateGuinformationsByCondition() {
		LoggerManager.def.info("获取客户端参数：guuser=" + guuser +  ",gupwd=" + gupwd + "," 
				+ "guname=" + guname + ","  + "guphone=" + guphone );
			Gson gson = new Gson();
			try {

				GuinformationRes guinformationRes = new GuinformationRes(null, guuser,
						gupwd,guname,guphone);

				BaseRes baseRes = ServiceFactory.getGuinformationsService()
					.createGuinformation(guinformationRes);
				
				String gsonString = gson.toJson(baseRes);
				LoggerManager.def.info("#####getGuinformationsByCondition,Gson串 = "
						+ gsonString + "########");
				// 返回json数据给客户端
				this.print(gsonString);
			} catch (Exception e) {
				LoggerManager.def.error("#####getGuinformationsByCondition errors" + e);
				this.print(gson.toJson(new BaseRes(ErrorCode.SYSTEM_ERROR)));
			}
			return null;
		}


	public String getGuinformationsByCondition() {
		LoggerManager.def.info("获取客户端参数：orderField="
				+ orderField + ",orderDirection=" + orderDirection 
				+  ",guuser=" + guuser +  ",gupwd=" + gupwd);
		Gson gson = new Gson();
		try {
			Map<String, Object> logincondition = new HashMap<String, Object>();
			logincondition.put("guuser", guuser);
			logincondition.put("gupwd", gupwd);
			
			Map<String, Object> condition = new HashMap<String, Object>();
			condition.put("start", 0);
			condition.put("num", 1000);//这个是返回的值，先设置1000，到时候要改成表中元素的个数
			condition.put("orderField", orderField);
			condition.put("orderDirection", orderDirection);
			
			if (DaoFactory.getLoginDao().getGuinformationByMiuser(logincondition) == null) {
			
				//这里写账号密码错误返回的情况
				System.out.println("error");
				//错误的情况下返回"error"这里用2个error表示账号密码错误，今后在写注册的时候要写限制不能用error为用户名
				condition.put("error", guuser);
				condition.put("error", gupwd);
			}
			
			else{
				condition.put("guuser", guuser);
				condition.put("gupwd", gupwd);
			}
			
			BaseRes baseRes = ServiceFactory.getGuinformationsService()
					.getLoginGuinformationsByCondition(condition);
			
			String gsonString = gson.toJson(baseRes);
			LoggerManager.def.info("#####getGuinformationsByCondition,Gson串 = "
					+ gsonString + "########");
			// 返回json数据给客户端
			this.print(gsonString);
		} catch (Exception e) {
			LoggerManager.def.error("#####getGuinformationsByCondition errors" + e);
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

	
	public String getGuuser() {
		return guuser;
	}

	public void setGuuser(String guuser) {
		this.guuser = guuser;
	}

	public String getGupwd() {
		return gupwd;
	}

	public void setGupwd(String gupwd) {
		this.gupwd = gupwd;
	}
	
	public String getGuname() {
		return guname;
	}

	public void setGuname(String guname) {
		this.guname = guname;
	}

	public String getGuphone() {
		return guphone;
	}

	public void setGuphone(String guphone) {
		this.guphone = guphone;
	}
}
