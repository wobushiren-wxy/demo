package com.xx.demo.model.pojo;

import java.util.Date;

import com.alonew.core.commons.model.BaseVOLong;
import com.alonew.db.dao.BaseSessionFactory;
import com.alonew.db.dao.ISessionFactory;
import com.xx.demo.dao.mapper.sessionfactory.DefaultSessionFactory;

/**
 * 餐饮店分类
 * 
 * @author chlingm
 * 
 */
public class Foodshop extends BaseVOLong implements ISessionFactory {

	private static final long serialVersionUID = -5532841215499042624L;

	private String businesslicense;// 营业执照
	private String fsname;// 店名
	private String fsphone;// 联系电话
	private String fsaddress;// 地址
	private String fsdescribe;//描述
	private String fsnote;// 备注
	private Date fstime;// 时间

	public Foodshop() {
		super();
	}



	

	public String getBusinesslicense() {
		return businesslicense;
	}





	public void setBusinesslicense(String businesslicense) {
		this.businesslicense = businesslicense;
	}





	public String getFsname() {
		return fsname;
	}





	public void setFsname(String fsname) {
		this.fsname = fsname;
	}





	public String getFsphone() {
		return fsphone;
	}





	public void setFsphone(String fsphone) {
		this.fsphone = fsphone;
	}





	public String getFsaddress() {
		return fsaddress;
	}





	public void setFsaddress(String fsaddress) {
		this.fsaddress = fsaddress;
	}





	public String getFsdescribe() {
		return fsdescribe;
	}





	public void setFsdescribe(String fsdescribe) {
		this.fsdescribe = fsdescribe;
	}





	public String getFsnote() {
		return fsnote;
	}





	public void setFsnote(String fsnote) {
		this.fsnote = fsnote;
	}





	public Date getFstime() {
		return fstime;
	}





	public void setFstime(Date fstime) {
		this.fstime = fstime;
	}





	public Foodshop(String businesslicense, String fsname, String fsphone,
			String fsaddress, String fsdescribe, String fsnote, Date fstime) {
		super();
		this.businesslicense = businesslicense;
		this.fsname = fsname;
		this.fsphone = fsphone;
		this.fsaddress = fsaddress;
		this.fsdescribe = fsdescribe;
		this.fsnote = fsnote;
		this.fstime = fstime;
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
		return "foodshop";
	}

	@Override
	public BaseSessionFactory sessionFactory() {
		return DefaultSessionFactory.getInstance();
	}

}
