package com.xx.demo.redis;

public class RedisSlave extends RedisMaster {

	private static final long serialVersionUID = -223644969148888353L;
	
	private int slaveof;
	
	public int getSlaveof() {
		return slaveof;
	}

	public void setSlaveof(int slaveof) {
		this.slaveof = slaveof;
	}

	@Override
	protected String table() {
		return "redis_slave";
	}

}
