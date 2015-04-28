package com.xx.demo.dao.impl;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSessionFactory;

import com.alonew.db.dao.AbstractDAO;
import com.xx.demo.dao.SubscribesDao;
import com.xx.demo.dao.mapper.sessionfactory.DefaultSessionFactory;
import com.xx.demo.model.pojo.Subscribe;


//###########################预约信息表############################
public class SubscribesDaoImpl extends AbstractDAO implements SubscribesDao {

	
	@Override
	public Long countSubscribesByCondition(Map<String, Object> condition) {
		return (Long) this.selectOne(
				"com.xx.demo.dao.mapper.subscribes.SubscribesMapper.countSubscribesByCondition",
				condition);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Subscribe> getSubscribeListByCondition(Map<String, Object> condition) {
		return (List<Subscribe>) this
				.selectList(
						"com.xx.demo.dao.mapper.subscribes.SubscribesMapper.getSubscribeListByCondition",
						condition);
	}

	@Override
	public Subscribe getSubscribeById(Long id) {
		return (Subscribe) this.selectOne(
				"com.xx.demo.dao.mapper.subscribes.SubscribesMapper.getSubscribeById", id);
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Subscribe> getAllSubscribes() {
		return (List<Subscribe>) this
				.selectList("com.xx.demo.dao.mapper.subscribes.SubscribesMapper.getAllSubscribes");
	}

	// SessionFactory
	@Override
	public SqlSessionFactory sessionFactory() {
		return DefaultSessionFactory.getInstance().getSessionFactory();
	}

	


}
