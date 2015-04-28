package com.xx.demo.dao;

import java.sql.SQLException;
import java.util.List;

import com.xx.demo.redis.RedisMaster;
import com.xx.demo.redis.RedisSlave;

public interface RedisDAO {

	public List<RedisMaster> getRedisMasters() throws SQLException;
	
	public List<RedisSlave> getRedisSlaves() throws SQLException;
	
}
