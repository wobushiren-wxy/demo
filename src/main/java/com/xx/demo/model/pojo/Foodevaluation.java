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
public class Foodevaluation extends BaseVOLong implements ISessionFactory {

	private static final long serialVersionUID = -5532841215499042624L;

	
	private String carteno;// 菜单号
	private String guuser;// 用户名
	private String cartename;// 菜名
	private String carteping;// 菜评价
	private Date cptime;// 添加时间


	public Foodevaluation() {
		super();
	}


	public Foodevaluation(String carteno, String guuser, String cartename,
			String carteping, Date cptime) {
		super();
		this.carteno = carteno;
		this.guuser = guuser;
		this.cartename = cartename;
		this.carteping = carteping;
		this.cptime = cptime;
	}



	public String getCarteno() {
		return carteno;
	}


	public void setCarteno(String carteno) {
		this.carteno = carteno;
	}


	public String getGuuser() {
		return guuser;
	}


	public void setGuuser(String guuser) {
		this.guuser = guuser;
	}


	public String getCartename() {
		return cartename;
	}


	public void setCartename(String cartename) {
		this.cartename = cartename;
	}


	public String getCarteping() {
		return carteping;
	}


	public void setCarteping(String carteping) {
		this.carteping = carteping;
	}


	public Date getCptime() {
		return cptime;
	}

	
	public void setCptime(Date cptime) {
		this.cptime = cptime;
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
		return "foodevaluation";
	}

	@Override
	public BaseSessionFactory sessionFactory() {
		return DefaultSessionFactory.getInstance();
	}

}
