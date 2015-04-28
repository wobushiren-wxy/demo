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
public class Indent extends BaseVOLong implements ISessionFactory {

	private static final long serialVersionUID = -5532841215499042624L;

	private String indentno;// 订单号
	private String indentstate;// 订单状态
	private String dtno;// 桌号
	private String carteno;// 菜单号
	private float pricsum;// 总价
	private Date indenttime;// 创建时间
	private String indentnote;// 备注
	
	public Indent() {
		super();
	}



	public Indent(String indentno, String indentstate, String dtno,
			String carteno, float pricsum, Date indenttime, String indentnote) {
		super();
		this.indentno = indentno;
		this.indentstate = indentstate;
		this.dtno = dtno;
		this.carteno = carteno;
		this.pricsum = pricsum;
		this.indenttime = indenttime;
		this.indentnote = indentnote;
	}




	public String getIndentno() {
		return indentno;
	}



	public void setIndentno(String indentno) {
		this.indentno = indentno;
	}



	public String getIndentstate() {
		return indentstate;
	}



	public void setIndentstate(String indentstate) {
		this.indentstate = indentstate;
	}



	public String getDtno() {
		return dtno;
	}



	public void setDtno(String dtno) {
		this.dtno = dtno;
	}



	public String getCarteno() {
		return carteno;
	}



	public void setCarteno(String carteno) {
		this.carteno = carteno;
	}



	public float getPricsum() {
		return pricsum;
	}



	public void setPricsum(float pricsum) {
		this.pricsum = pricsum;
	}



	public Date getIndenttime() {
		return indenttime;
	}



	public void setIndenttime(Date indenttime) {
		this.indenttime = indenttime;
	}



	public String getIndentnote() {
		return indentnote;
	}



	public void setIndentnote(String indentnote) {
		this.indentnote = indentnote;
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
		return "indent";
	}

	@Override
	public BaseSessionFactory sessionFactory() {
		return DefaultSessionFactory.getInstance();
	}

}
