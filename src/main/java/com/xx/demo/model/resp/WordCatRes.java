package com.xx.demo.model.resp;

public class WordCatRes {

	private Long wid;
	
	private String name;// 分类名称

	private String comment;// 分类描述

	private Long addtime;// 添加时间

	
	public WordCatRes(Long wid, String name, String comment, Long addtime) {
		super();
		this.wid = wid;
		this.name = name;
		this.comment = comment;
		this.addtime = addtime;
	}
	

	public Long getWid() {
		return wid;
	}


	public void setWid(Long wid) {
		this.wid = wid;
	}


	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public Long getAddtime() {
		return addtime;
	}

	public void setAddtime(Long addtime) {
		this.addtime = addtime;
	}

}
