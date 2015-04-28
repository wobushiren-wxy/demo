package com.xx.demo.model.resp;

public class SubscribeRes {

	private Long wid;
	

	private String subno;// 预约号
	private String subtime;// 预约时间
	private String guuser;// 用户名
	private String subnums;// 人数

	


	public SubscribeRes(Long wid, String subno, String subtime, String guuser,
			String subnums) {
		super();
		this.wid = wid;
		this.subno = subno;
		this.subtime = subtime;
		this.guuser = guuser;
		this.subnums = subnums;
	}


	public Long getWid() {
		return wid;
	}


	public void setWid(Long wid) {
		this.wid = wid;
	}


	public String getSubno() {
		return subno;
	}


	public void setSubno(String subno) {
		this.subno = subno;
	}


	public String getSubtime() {
		return subtime;
	}


	public void setSubtime(String subtime) {
		this.subtime = subtime;
	}


	public String getGuuser() {
		return guuser;
	}


	public void setGuuser(String guuser) {
		this.guuser = guuser;
	}


	public String getSubnums() {
		return subnums;
	}


	public void setSubnums(String subnums) {
		this.subnums = subnums;
	}



}
