package com.xx.demo.model.resp;

public class FoodevaluationRes {

	private Long wid;
	

	private String carteno;// 菜单号
	private String guuser;// 用户名
	public FoodevaluationRes(Long wid, String carteno, String guuser,
			String carteping) {
		super();
		this.wid = wid;
		this.carteno = carteno;
		this.guuser = guuser;
		this.carteping = carteping;
	}


	private String cartename;// 菜名
	private String carteping;// 菜评价

	
	public Long getWid() {
		return wid;
	}


	public String getCartename() {
		return cartename;
	}


	public void setCartename(String cartename) {
		this.cartename = cartename;
	}


	public FoodevaluationRes(Long wid, String carteno, String guuser,
			String cartename, String carteping) {
		super();
		this.wid = wid;
		this.carteno = carteno;
		this.guuser = guuser;
		this.cartename = cartename;
		this.carteping = carteping;
	}


	


	public FoodevaluationRes(String carteno, String guuser, String carteping) {
		super();
		this.carteno = carteno;
		this.guuser = guuser;
		this.carteping = carteping;
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


	public String getGuuser() {
		return guuser;
	}


	public void setGuuser(String guuser) {
		this.guuser = guuser;
	}



	public String getCarteping() {
		return carteping;
	}


	public void setCarteping(String carteping) {
		this.carteping = carteping;
	}



}
