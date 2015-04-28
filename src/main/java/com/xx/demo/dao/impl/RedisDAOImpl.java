package com.xx.demo.dao.impl;

import java.sql.SQLException;
import java.util.List;

import org.apache.ibatis.session.SqlSessionFactory;

import com.alonew.db.dao.AbstractDAO;
import com.xx.demo.dao.RedisDAO;
import com.xx.demo.dao.mapper.sessionfactory.DefaultSessionFactory;
import com.xx.demo.redis.RedisMaster;
import com.xx.demo.redis.RedisSlave;

public class RedisDAOImpl extends AbstractDAO implements RedisDAO {

	@Override
	public SqlSessionFactory sessionFactory() {
		return DefaultSessionFactory.getInstance().getSessionFactory();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<RedisMaster> getRedisMasters() throws SQLException {
		return (List<RedisMaster>) this.selectList("com.xx.demo.dao.mapper.redis.RedisMapper.getRedisMasters");
	}
	@SuppressWarnings("unchecked")
	@Override
	public List<RedisSlave> getRedisSlaves() throws SQLException {
		return (List<RedisSlave>) this.selectList("com.lenovo.storage.dao.mapper.redis.RedisMapper.getRedisSlaves");
	}

}
