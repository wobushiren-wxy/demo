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
public class Subscribe extends BaseVOLong implements ISessionFactory {

	private static final long serialVersionUID = -5532841215499042624L;

	private String subno;// 预约号
	private String subtime;// 预约时间
	private String guuser;// 用户名
	private String subnums;// 人数
	private Date subcreattime;// 创建时间
	private String subnote;// 备注
	
	public Subscribe() {
		super();
	}

	public Subscribe(String subno, String subtime, String guuser,
			String subnums, Date subcreattime, String subnote) {
		super();
		this.subno = subno;
		this.subtime = subtime;
		this.guuser = guuser;
		this.subnums = subnums;
		this.subcreattime = subcreattime;
		this.subnote = subnote;
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

	public Date getSubcreattime() {
		return subcreattime;
	}

	public void setSubcreattime(Date subcreattime) {
		this.subcreattime = subcreattime;
	}


	public String getSubnote() {
		return subnote;
	}

	public void setSubnote(String subnote) {
		this.subnote = subnote;
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
		return "subscribe";
	}

	@Override
	public BaseSessionFactory sessionFactory() {
		return DefaultSessionFactory.getInstance();
	}

}
