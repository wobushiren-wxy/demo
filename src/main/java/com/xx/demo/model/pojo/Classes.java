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
public class Classes extends BaseVOLong implements ISessionFactory {

	private static final long serialVersionUID = -5532841215499042624L;

	private String classesno;
	private String classesname;
    private Date classestime;
	private String classesnote;

	public Classes() {
		super();
	}



	

	public String getClassesno() {
		return classesno;
	}





	public void setClassesno(String classesno) {
		this.classesno = classesno;
	}





	public String getClassesname() {
		return classesname;
	}





	public void setClassesname(String classesname) {
		this.classesname = classesname;
	}





	public Date getClassestime() {
		return classestime;
	}





	public void setClassestime(Date classestime) {
		this.classestime = classestime;
	}





	public String getClassesnote() {
		return classesnote;
	}





	public void setClassesnote(String classesnote) {
		this.classesnote = classesnote;
	}
   




	public Classes(String classesno, String classesname, Date classestime,
			String classesnote) {
		super();
		this.classesno = classesno;
		this.classesname = classesname;
		this.classestime = classestime;
		this.classesnote = classesnote;
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
		return "classes";
	}

	@Override
	public BaseSessionFactory sessionFactory() {
		return DefaultSessionFactory.getInstance();
	}

}
