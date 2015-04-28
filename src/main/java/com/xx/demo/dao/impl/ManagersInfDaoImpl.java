package com.xx.demo.dao.impl;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSessionFactory;

import com.alonew.db.dao.AbstractDAO;
import com.xx.demo.dao.ManagersInfDao;
import com.xx.demo.dao.mapper.sessionfactory.DefaultSessionFactory;
import com.xx.demo.model.pojo.ManagerInf;

public class ManagersInfDaoImpl extends AbstractDAO implements ManagersInfDao {

	@Override
	public Long countManagersInfByCondition(Map<String, Object> condition) {
		return (Long) this.selectOne(
				"com.xx.demo.dao.mapper.managers.ManagersInfMapper.countManagersInfByCondition",
				condition);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<ManagerInf> getManagerInfListByCondition(Map<String, Object> condition) {
		return (List<ManagerInf>) this
				.selectList(
						"com.xx.demo.dao.mapper.managers.ManagersInfMapper.getManagerInfListByCondition",
						condition);
	}

	@Override
	public ManagerInf getManagerInfById(Long id) {
		return (ManagerInf) this.selectOne(
				"com.xx.demo.dao.mapper.managers.ManagersInfMapper.getManagerInfById", id);
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<ManagerInf> getAllManagersInf() {
		return (List<ManagerInf>) this
				.selectList("com.xx.demo.dao.mapper.managers.ManagersInfMapper.getAllManagersInf");
	}

	// SessionFactory
	@Override
	public SqlSessionFactory sessionFactory() {
		return DefaultSessionFactory.getInstance().getSessionFactory();
	}


}
