package com.xx.demo.model.resp;

public class IndentRes {

	private Long wid;
	
	private String indentno;// 订单号
	private String indentstate;// 订单状态		
	private String dtno;// 桌号
	private String carteno;// 菜单号
	private float pricsum;// 总价
	private String indentnote;// 备注
	


	public IndentRes(Long wid, String indentno, String indentstate,
			String dtno, String carteno, float pricsum, String indentnote) {
		super();
		this.wid = wid;
		this.indentno = indentno;
		this.indentstate = indentstate;
		this.dtno = dtno;
		this.carteno = carteno;
		this.pricsum = pricsum;
		this.indentnote = indentnote;
	}


	public Long getWid() {
		return wid;
	}


	public void setWid(Long wid) {
		this.wid = wid;
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


	public String getIndentnote() {
		return indentnote;
	}


	public void setIndentnote(String indentnote) {
		this.indentnote = indentnote;
	}





}
