package com.xx.demo.model.resp;

public class CarteRes {

	public String getCarteimgurl() {
		return carteimgurl;
	}

	public void setCarteimgurl(String carteimgurl) {
		this.carteimgurl = carteimgurl;
	}

	private Long wid;
	
	private String carteno; // 菜单编号
	private String cartename;// 菜单名
	private String carteimgurl;//图片路径
	private byte[] carteimgbyte;//存储图片
	
	
	public CarteRes(Long wid, String carteno, String cartename,
			String carteimgurl, byte[] carteimgbyte, float price) {
		super();
		this.wid = wid;
		this.carteno = carteno;
		this.cartename = cartename;
		this.carteimgurl = carteimgurl;
		this.carteimgbyte = carteimgbyte;
		this.price = price;
	}

	public byte[] getCarteimgbyte() {
		return carteimgbyte;
	}

	public CarteRes(Long wid, String carteno, String cartename,
			byte[] carteimgbyte, float price) {
		super();
		this.wid = wid;
		this.carteno = carteno;
		this.cartename = cartename;
		this.carteimgbyte = carteimgbyte;
		this.price = price;
	}

	public void setCarteimgbyte(byte[] carteimgbyte) {
		this.carteimgbyte = carteimgbyte;
	}

	

	public CarteRes(Long wid, String carteno, String cartename,
			String carteimgurl, float price) {
		super();
		this.wid = wid;
		this.carteno = carteno;
		this.cartename = cartename;
		this.carteimgurl = carteimgurl;
		this.price = price;
	}

	private float price;// 价格

	public Long getWid() {
		return wid;
	}

	public void setWid(Long wid) {
		this.wid = wid;
	}

	public String getCarteno() {
		return carteno;
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

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	public CarteRes(Long wid, String carteno, String cartename, float price) {
		super();
		this.wid = wid;
		this.carteno = carteno;
		this.cartename = cartename;
		this.price = price;
	}
   
	

}
