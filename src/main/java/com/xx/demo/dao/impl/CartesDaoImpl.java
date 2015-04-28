package com.xx.demo.dao.impl;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSessionFactory;

import com.alonew.db.dao.AbstractDAO;
import com.xx.demo.dao.CartesDao;
import com.xx.demo.dao.mapper.sessionfactory.DefaultSessionFactory;
import com.xx.demo.model.pojo.Carte;


// #########################菜单表###############################
public class CartesDaoImpl extends AbstractDAO implements CartesDao {

	@Override
	public Long countCartesByCondition(Map<String, Object> condition) {
		return (Long) this.selectOne(
				"com.xx.demo.dao.mapper.cartes.CartesMapper.countCartesByCondition",
				condition);
	}
	
	@Override
	public Carte getCartesByCondition(Map<String, Object> condition) {
		return (Carte) this.selectOne(
				"com.xx.demo.dao.mapper.cartes.CartesMapper.getCartesByCondition",
				condition);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Carte> getCarteListByCondition(Map<String, Object> condition) {
		return (List<Carte>) this
				.selectList(
						"com.xx.demo.dao.mapper.cartes.CartesMapper.getCarteListByCondition",
						condition);
	}

	@Override
	public Carte getCarteById(Long id) {
		return (Carte) this.selectOne(
				"com.xx.demo.dao.mapper.cartes.CartesMapper.getCarteById", id);
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Carte> getAllCartes() {
		return (List<Carte>) this
				.selectList("com.xx.demo.dao.mapper.cartes.CartesMapper.getAllCartes");
	}

	// SessionFactory
	@Override
	public SqlSessionFactory sessionFactory() {
		return DefaultSessionFactory.getInstance().getSessionFactory();
	}


}
