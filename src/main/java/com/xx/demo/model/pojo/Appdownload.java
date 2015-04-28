package com.xx.demo.model.pojo;

import java.util.Date;

import com.alonew.core.commons.model.BaseVOLong;
import com.alonew.db.dao.BaseSessionFactory;
import com.alonew.db.dao.ISessionFactory;
import com.xx.demo.dao.mapper.sessionfactory.DefaultSessionFactory;

/**
 * 系统签名分类
 * 
 * 
 */
public class Appdownload extends BaseVOLong implements ISessionFactory {

	private static final long serialVersionUID = -5532841215499042624L;

	private String appver;//App 版本号
	private String apppath;// 上传
	private String appurl;// 下载
	private String miuser;// 上传人员
	private Date apptime;// 创建时间
	private String appnote;// 备注
	
	
	
	
	public Appdownload(String appver, String apppath, String appurl,
			String miuser, Date apptime, String appnote) {
		super();
		this.appver = appver;
		this.apppath = apppath;
		this.appurl = appurl;
		this.miuser = miuser;
		this.apptime = apptime;
		this.appnote = appnote;
	}

	public Appdownload() {
		super();
	}

	public String getAppver() {
		return appver;
	}

	public void setAppver(String appver) {
		this.appver = appver;
	}
	
	
	public String getApppath() {
		return apppath;
	}

	public void setApppath(String apppath) {
		this.apppath = apppath;
	}

	public String getAppurl() {
		return appurl;
	}

	public void setAppurl(String appurl) {
		this.appurl = appurl;
	}

	public String getAppnote() {
		return appnote;
	}

	public void setAppnote(String appnote) {
		this.appnote = appnote;
	}

	public String getMiuser() {
		return miuser;
	}

	public void setMiuser(String miuser) {
		this.miuser = miuser;
	}

	public Date getApptime() {
		return apptime;
	}

	public void setApptime(Date apptime) {
		this.apptime = apptime;
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
		return "appdownload";
	}

	@Override
	public BaseSessionFactory sessionFactory() {
		return DefaultSessionFactory.getInstance();
	}

}
