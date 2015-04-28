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
public class Carte extends BaseVOLong implements ISessionFactory {

	private static final long serialVersionUID = -5532841215499042624L;

	private String carteno;//菜名编号
	private String cartename;//菜名
	private String material;//材料
	private String synopsis;//简介
	private String classesno;//类别编号
	private float price;//价格
	private String cartenote;//备注
	private String carteimgurl;	//菜品图片路径
	private Date cartetime;//创建时间

	public Carte() {
		super();
	}

	
	//没加菜品图片路径
	public Carte(String carteno, String cartename, String material,
			String synopsis, String classesno, float price, String cartenote,
			Date cartetime) {
		super();
		this.carteno = carteno;
		this.cartename = cartename;
		this.material = material;
		this.synopsis = synopsis;
		this.classesno = classesno;
		this.price = price;
		this.cartenote = cartenote;
		this.cartetime = cartetime;
	}



	public Carte(String carteno, String cartename, String material,
			String synopsis, String classesno, float price, String cartenote,
			String carteimgurl, Date cartetime) {
		super();
		this.carteno = carteno;
		this.cartename = cartename;
		this.material = material;
		this.synopsis = synopsis;
		this.classesno = classesno;
		this.price = price;
		this.cartenote = cartenote;
		this.carteimgurl = carteimgurl;
		this.cartetime = cartetime;
	}



	public String getCarteno() {
		return carteno;
	}



	public String getCarteimgurl() {
		return carteimgurl;
	}



	public void setCarteimgurl(String carteimgurl) {
		this.carteimgurl = carteimgurl;
	}



	public void setCarteno(String carteno) {
		this.carteno = carteno;
	}



	public String getCartename() {
		return cartename;
	}



	public void setCartename(String cartename) {
		this.cartename = cartename;
	}



	public String getMaterial() {
		return material;
	}



	public void setMaterial(String material) {
		this.material = material;
	}



	public String getSynopsis() {
		return synopsis;
	}



	public void setSynopsis(String synopsis) {
		this.synopsis = synopsis;
	}



	public String getClassesno() {
		return classesno;
	}



	public void setClassesno(String classesno) {
		this.classesno = classesno;
	}



	public float getPrice() {
		return price;
	}



	public void setPrice(float price) {
		this.price = price;
	}



	public String getCartenote() {
		return cartenote;
	}



	public void setCartenote(String cartenote) {
		this.cartenote = cartenote;
	}



	public Date getCartetime() {
		return cartetime;
	}



	public void setCartetime(Date cartetime) {
		this.cartetime = cartetime;
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
		return "carte";
	}

	@Override
	public BaseSessionFactory sessionFactory() {
		return DefaultSessionFactory.getInstance();
	}



}
