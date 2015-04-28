package com.xx.demo.web.action.admin;

import com.alonew.core.web.action.base.Struts2Action;
import com.xx.demo.dao.DaoFactory;
import com.xx.demo.model.pojo.ManagerInf;

import java.util.HashMap;
import java.util.Map;

public class LoginAction extends Struts2Action {

	private static final long serialVersionUID = 1L;
	private String miuser;
	private String mipwd;
	private String jurisdiction;
	private String error;

	public String home() {
		return "home";
	}

	/**
	 * 退出系统,清除会话
	 * 
	 */
	public String logout() {
		return "home";
	}

	public String index() {
		return "index";
	}
//权限问题这边还要写一下。。
	public String submit() {
		Map<String, Object> condition = new HashMap<String, Object>();
		condition.put("miuser", miuser);
		condition.put("mipwd", mipwd);
		/*("jurisdiction", jurisdiction )*/
		
		// DaoFactory.getLoginDao().CheckUser(condition);
		if (DaoFactory.getLoginDao().getManagerInfByMiuser(condition) == null) {
			
			return "false";
		}
		ManagerInf mangerInf=DaoFactory.getLoginDao().getManagerInfByMiuser(condition);
		
		
		
		if(mangerInf.getJurisdiction().equals("001")){
			return "success";	
		}
		
		return "success";
		
	}

	public String getError() {
		return error;
	}

	public String getMiuser() {
		return miuser;
	}

	public void setMiuser(String miuser) {
		this.miuser = miuser;
	}

	public String getMipwd() {
		return mipwd;
	}

	public void setMipwd(String mipwd) {
		this.mipwd = mipwd;
	}

	public String getJurisdiction() {
		return jurisdiction;
	}

	public void setJurisdiction(String jurisdiction) {
		this.jurisdiction = jurisdiction;
	}
	
	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public void setError(String error) {
		this.error = error;
	}

}
