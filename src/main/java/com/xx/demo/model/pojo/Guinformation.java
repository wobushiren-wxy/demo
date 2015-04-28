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
public class Guinformation extends BaseVOLong implements ISessionFactory {

	private static final long serialVersionUID = -5532841215499042624L;

	private String guuser;// 用户名
	private String gupwd;// 密码
	private String guname;// 客户姓名
	private String guphone;// 客户电话
	private String gumail;// 邮箱
	private String gusex;// 性别
	private String gubirthday;// 性别
	private Date gutime;// 创建时间
	private String gunote;// 备注

	public Guinformation() {
		super();
	}



	public Guinformation(String guuser, String gupwd, String guname,
			String guphone, String gumail, String gusex, String gubirthday, Date gutime, String gunote) {
		super();
		this.guuser = guuser;
		this.gupwd = gupwd;
		this.guname = guname;
		this.guphone = guphone;
		this.gumail = gumail;
		this.gusex = gusex;
		this.gubirthday = gubirthday;
		this.gutime = gutime;
		this.gunote = gunote;
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



	public String getGumail() {
		return gumail;
	}



	public void setGumail(String gumail) {
		this.gumail = gumail;
	}



	public String getGusex() {
		return gusex;
	}



	public void setGusex(String gusex) {
		this.gusex = gusex;
	}



	public String getGubirthday() {
		return gubirthday;
	}



	public void setGubirthday(String gubirthday) {
		this.gubirthday = gubirthday;
	}



	public Date getGutime() {
		return gutime;
	}



	public void setGutime(Date gutime) {
		this.gutime = gutime;
	}



	public String getGunote() {
		return gunote;
	}



	public void setGunote(String gunote) {
		this.gunote = gunote;
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
		return "guinformation";
	}

	@Override
	public BaseSessionFactory sessionFactory() {
		return DefaultSessionFactory.getInstance();
	}

}
