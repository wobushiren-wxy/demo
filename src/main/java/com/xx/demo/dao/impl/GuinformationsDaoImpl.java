package com.xx.demo.dao.impl;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSessionFactory;

import com.alonew.db.dao.AbstractDAO;
import com.xx.demo.dao.GuinformationsDao;
import com.xx.demo.dao.mapper.sessionfactory.DefaultSessionFactory;
import com.xx.demo.model.pojo.Guinformation;


//###########################客户信息管理表############################
public class GuinformationsDaoImpl extends AbstractDAO implements GuinformationsDao {

	/**
	 * Atguuser
	 */
	@Override
	public Long countGuinformationsByConditionAtguuser(
			Map<String, Object> condition) {
		return (Long) this.selectOne(
				"com.xx.demo.dao.mapper.guinformas.GuinformationsMapper.countGuinformationsByConditionAtguuser",
				condition);
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Guinformation> getGuinformationListByConditionAtguuser(
			Map<String, Object> condition) {
		return (List<Guinformation>) this.selectList(
			"com.xx.demo.dao.mapper.guinformas.GuinformationsMapper.getGuinformationListByConditionAtguuser",
			condition);
	}
	
	@Override
	public Long countGuinformationsByCondition(Map<String, Object> condition) {
		return (Long) this.selectOne(
				"com.xx.demo.dao.mapper.guinformas.GuinformationsMapper.countGuinformationsByCondition",
				condition);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Guinformation> getGuinformationListByCondition(Map<String, Object> condition) {
		return (List<Guinformation>) this
				.selectList(
						"com.xx.demo.dao.mapper.guinformas.GuinformationsMapper.getGuinformationListByCondition",
						condition);
	}

	@Override
	public Guinformation getGuinformationById(Long id) {
		return (Guinformation) this.selectOne(
				"com.xx.demo.dao.mapper.guinformas.GuinformationsMapper.getGuinformationById", id);
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Guinformation> getAllGuinformations() {
		return (List<Guinformation>) this
				.selectList("com.xx.demo.dao.mapper.guinformas.GuinformationsMapper.getAllGuinformations");
	}

	// SessionFactory
	@Override
	public SqlSessionFactory sessionFactory() {
		return DefaultSessionFactory.getInstance().getSessionFactory();
	}

	


}
