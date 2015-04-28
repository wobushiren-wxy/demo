package com.xx.demo.model.resp;


public class DiningtableRes {

	private String dtno;//桌号
	private String dtname;//桌名（占时表示状态）
	private String dtnote;//备注


	public DiningtableRes(String dtno, String dtname, String dtnote) {
		super();
		this.dtno = dtno;
		this.dtname = dtname;
		this.dtnote = dtnote;
	}



	public DiningtableRes(String dtno, String dtname) {
		super();
		this.dtno = dtno;
		this.dtname = dtname;
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



	public String getDtnote() {
		return dtnote;
	}



	public void setDtnote(String dtnote) {
		this.dtnote = dtnote;
	}




}
