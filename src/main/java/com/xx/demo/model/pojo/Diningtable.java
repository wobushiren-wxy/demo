package com.xx.demo.model.pojo;

import java.util.Date;

import com.alonew.core.commons.model.BaseVOLong;
import com.alonew.db.dao.BaseSessionFactory;
import com.alonew.db.dao.ISessionFactory;
import com.xx.demo.dao.mapper.sessionfactory.DefaultSessionFactory;

/**
 * 菜单表
 * 
 * @author chlingm
 * 
 */
public class Diningtable extends BaseVOLong implements ISessionFactory {

	private static final long serialVersionUID = -5532841215499042624L;

	private String dtno;//桌号
	private String dtname;//桌名
	private Date dttime;//创建时间
	private String dtnote;//备注

	public Diningtable() {
		super();
	}

	

	public Diningtable(String dtno, String dtname, Date dttime, String dtnote) {
		super();
		this.dtno = dtno;
		this.dtname = dtname;
		this.dttime = dttime;
		this.dtnote = dtnote;
	}



	public Diningtable(String dtno, String dtname, String dtnote) {
		super();
		this.dtno = dtno;
		this.dtname = dtname;
		this.dtnote = dtnote;
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



	public Date getDttime() {
		return dttime;
	}



	public void setDttime(Date dttime) {
		this.dttime = dttime;
	}



	public String getDtnote() {
		return dtnote;
	}



	public void setDtnote(String dtnote) {
		this.dtnote = dtnote;
	}



	public static long getSerialversionuid() {
		return serialVersionUID;
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
		return "diningtable";
	}

	@Override
	public BaseSessionFactory sessionFactory() {
		return DefaultSessionFactory.getInstance();
	}

}
