package com.xx.demo.model.pojo;

import java.util.Date;

import com.alonew.core.commons.model.BaseVOLong;
import com.alonew.db.dao.BaseSessionFactory;
import com.alonew.db.dao.ISessionFactory;
import com.xx.demo.dao.mapper.sessionfactory.DefaultSessionFactory;

/**
 * 系统签名分类
 * 
 * @author chlingm
 * 
 */
public class ManagerInf extends BaseVOLong implements ISessionFactory {

	private static final long serialVersionUID = -5532841215499042624L;

	private String miuser;// 用户名
	private String mipwd;// 密码
	private String jurisdiction;// 权限号
	private String miname;// 管理员姓名
	private Date mitime;// 添加时间
	private String minote;// 备注

	public ManagerInf() {
		super();
	}



	public ManagerInf(String miuser, String mipwd, String jurisdiction,
			String miname, Date mitime, String minote) {
		super();
		this.miuser = miuser;
		this.mipwd = mipwd;
		this.jurisdiction = jurisdiction;
		this.miname = miname;
		this.mitime = mitime;
		this.minote = minote;
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



	public String getMiname() {
		return miname;
	}



	public void setMiname(String miname) {
		this.miname = miname;
	}



	public Date getMitime() {
		return mitime;
	}



	public void setMitime(Date mitime) {
		this.mitime = mitime;
	}



	public String getMinote() {
		return minote;
	}



	public void setMinote(String minote) {
		this.minote = minote;
	}



	@Override
	protected String[] escape() {
		return defaultEscape;
	}

	/**
	 * pojo对应的数据库表
	 */
	@Override
	protected String table() {
		return "managerinf";
	}

	@Override
	public BaseSessionFactory sessionFactory() {
		return DefaultSessionFactory.getInstance();
	}

}
