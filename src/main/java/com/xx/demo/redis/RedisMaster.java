package com.xx.demo.redis;

import com.alonew.core.commons.model.BaseVO;
import com.alonew.db.dao.BaseSessionFactory;
import com.alonew.db.dao.ISessionFactory;
import com.xx.demo.dao.mapper.sessionfactory.DefaultSessionFactory;

public class RedisMaster extends BaseVO implements ISessionFactory{

	private static final long serialVersionUID = -9051591531241351887L;
	
	private String name;
	private String host;
	private int port;
	private String type;
	private long begin;
	private long end;
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getHost() {
		return host;
	}

	public void setHost(String host) {
		this.host = host;
	}

	public int getPort() {
		return port;
	}

	public void setPort(int port) {
		this.port = port;
	}
	

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public long getBegin() {
		return begin;
	}

	public void setBegin(long begin) {
		this.begin = begin;
	}

	public long getEnd() {
		return end;
	}

	public void setEnd(long end) {
		this.end = end;
	}

	@Override
	protected String[] escape() {
		return defaultEscape;
	}

	@Override
	protected String table() {
		return "redis_master";
	}

	@Override
	public BaseSessionFactory sessionFactory() {
		return DefaultSessionFactory.getInstance();
	}

}
