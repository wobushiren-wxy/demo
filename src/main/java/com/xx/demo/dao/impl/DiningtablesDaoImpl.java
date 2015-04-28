package com.xx.demo.dao.impl;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSessionFactory;

import com.alonew.db.dao.AbstractDAO;
import com.xx.demo.dao.DiningtablesDao;
import com.xx.demo.dao.mapper.sessionfactory.DefaultSessionFactory;
import com.xx.demo.model.pojo.Diningtable;


// ##############################桌面表################################
public class DiningtablesDaoImpl extends AbstractDAO implements DiningtablesDao {

	@Override
	public Long countDiningtablesByCondition(Map<String, Object> condition) {
		return (Long) this.selectOne(
				"com.xx.demo.dao.mapper.diningtables.DiningtablesMapper.countDiningtablesByCondition",
				condition);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Diningtable> getDiningtableListByCondition(Map<String, Object> condition) {
		return (List<Diningtable>) this
				.selectList(
						"com.xx.demo.dao.mapper.diningtables.DiningtablesMapper.getDiningtableListByCondition",
						condition);
	}

	@Override
	public Diningtable getDiningtableById(Long id) {
		return (Diningtable) this.selectOne(
				"com.xx.demo.dao.mapper.diningtables.DiningtablesMapper.getDiningtableById", id);
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Diningtable> getAllDiningtables() {
		return (List<Diningtable>) this
				.selectList("com.xx.demo.dao.mapper.diningtables.DiningtablesMapper.getAllDiningtables");
	}

	// SessionFactory
	@Override
	public SqlSessionFactory sessionFactory() {
		return DefaultSessionFactory.getInstance().getSessionFactory();
	}

	@Override
	public Diningtable getDiningtableByCondition(Map<String, Object> condition) {
		return (Diningtable) this.selectOne(
				"com.xx.demo.dao.mapper.diningtables.DiningtablesMapper.getDiningtableByCondition",
				condition);
	}


}
