package com.xx.demo.model.pojo;

import java.util.Date;

import com.alonew.core.commons.model.BaseVOLong;
import com.alonew.db.dao.BaseSessionFactory;
import com.alonew.db.dao.ISessionFactory;
import com.xx.demo.dao.mapper.sessionfactory.DefaultSessionFactory;

/**
 * 系统签名分类
 * 
 * 
 */
public class Imgtransmission extends BaseVOLong implements ISessionFactory {

	private static final long serialVersionUID = -5532841215499042624L;

	private String imgname;// 图片名
	private String imgpath;// 地址
	private String miuser;// 上传人员
	private Date imgtime;// 创建时间
	private String imgnote;// 备注

	public Imgtransmission() {
		super();
	}


	public Imgtransmission(String imgname, String imgpath, String miuser,
			Date imgtime, String imgnote) {
		super();
		this.imgname = imgname;
		this.imgpath = imgpath;
		this.miuser = miuser;
		this.imgtime = imgtime;
		this.imgnote = imgnote;
	}


	public String getImgname() {
		return imgname;
	}


	public void setImgname(String imgname) {
		this.imgname = imgname;
	}


	public String getImgpath() {
		return imgpath;
	}


	public void setImgpath(String imgpath) {
		this.imgpath = imgpath;
	}


	public String getMiuser() {
		return miuser;
	}


	public void setMiuser(String miuser) {
		this.miuser = miuser;
	}


	public Date getImgtime() {
		return imgtime;
	}


	public void setImgtime(Date imgtime) {
		this.imgtime = imgtime;
	}


	public String getImgnote() {
		return imgnote;
	}


	public void setImgnote(String imgnote) {
		this.imgnote = imgnote;
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
		return "imgtransmission";
	}

	@Override
	public BaseSessionFactory sessionFactory() {
		return DefaultSessionFactory.getInstance();
	}

}
