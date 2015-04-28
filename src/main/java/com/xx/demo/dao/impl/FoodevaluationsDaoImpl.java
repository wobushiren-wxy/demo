package com.xx.demo.dao.impl;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSessionFactory;
import com.alonew.db.dao.AbstractDAO;
import com.xx.demo.dao.FoodevaluationsDao;
import com.xx.demo.dao.mapper.sessionfactory.DefaultSessionFactory;
import com.xx.demo.model.pojo.Foodevaluation;


//###########################客户信息管理表############################
public class FoodevaluationsDaoImpl extends AbstractDAO implements FoodevaluationsDao {

	@Override
	public Long countFoodevaluationsByCondition(Map<String, Object> condition) {
		return (Long) this.selectOne(
				"com.xx.demo.dao.mapper.fooddevalus.FoodevaluationsMapper.countFoodevaluationsByCondition",
				condition);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Foodevaluation> getFoodevaluationListCartenoByCondition(
			Map<String, Object> condition) {
		return (List<Foodevaluation>) this
				.selectList(
						"com.xx.demo.dao.mapper.fooddevalus.FoodevaluationsMapper.getFoodevaluationListCartenoByCondition",
						condition);
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Foodevaluation> getFoodevaluationListByCondition(Map<String, Object> condition) {
		return (List<Foodevaluation>) this
				.selectList(
						"com.xx.demo.dao.mapper.fooddevalus.FoodevaluationsMapper.getFoodevaluationListByCondition",
						condition);
	}

	@Override
	public Foodevaluation getFoodevaluationById(Long id) {
		return (Foodevaluation) this.selectOne(
				"com.xx.demo.dao.mapper.fooddevalus.FoodevaluationsMapper.getFoodevaluationById", id);
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Foodevaluation> getAllFoodevaluations() {
		return (List<Foodevaluation>) this
				.selectList("com.xx.demo.dao.mapper.fooddevalus.FoodevaluationsMapper.getAllFoodevaluations");
	}

	// SessionFactory
	@Override
	public SqlSessionFactory sessionFactory() {
		return DefaultSessionFactory.getInstance().getSessionFactory();
	}


}
