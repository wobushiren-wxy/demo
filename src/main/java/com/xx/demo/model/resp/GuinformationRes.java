package com.xx.demo.model.resp;

public class GuinformationRes {

	private Long wid;
	

	private String guuser;	// 用户名

	private String gupwd;	// 密码
	
	private String guname;	//姓名

	private String guphone;	//电话

	
	public GuinformationRes(Long wid, String guuser, String gupwd) {
		super();
		this.wid = wid;
		this.guuser = guuser;
		this.gupwd = gupwd;
	}
	

	public GuinformationRes(Long wid, String guuser, String gupwd,
			String guname, String guphone) {
		super();
		this.wid = wid;
		this.guuser = guuser;
		this.gupwd = gupwd;
		this.guname = guname;
		this.guphone = guphone;
	}


	public Long getWid() {
		return wid;
	}


	public void setWid(Long wid) {
		this.wid = wid;
	}


	public String getGuuser() {
		return guuser;
	}


	public void setGuuser(String guuser) {
		this.guuser = guuser;
	}


	public String getGupwd() {
		return gupwd;
	}


	public void setGupwd(String gupwd) {
		this.gupwd = gupwd;
	}

	public String getGuname() {
		return guname;
	}


	public void setGuname(String guname) {
		this.guname = guname;
	}


	public String getGuphone() {
		return guphone;
	}


	public void setGuphone(String guphone) {
		this.guphone = guphone;
	}

}
