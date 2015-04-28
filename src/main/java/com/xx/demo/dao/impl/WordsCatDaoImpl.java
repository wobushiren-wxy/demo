package com.xx.demo.dao.impl;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSessionFactory;

import com.alonew.db.dao.AbstractDAO;
import com.xx.demo.dao.WordsCatDao;
import com.xx.demo.dao.mapper.sessionfactory.DefaultSessionFactory;
import com.xx.demo.model.pojo.WordCat;

public class WordsCatDaoImpl extends AbstractDAO implements WordsCatDao {

	@Override
	public Long countWordsCatByCondition(Map<String, Object> condition) {
		return (Long) this.selectOne(
				"com.xx.demo.dao.mapper.words.WordsCatMapper.countWordsCatByCondition",
				condition);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<WordCat> getWordCatListByCondition(Map<String, Object> condition) {
		return (List<WordCat>) this
				.selectList(
						"com.xx.demo.dao.mapper.words.WordsCatMapper.getWordCatListByCondition",
						condition);
	}

	@Override
	public WordCat getWordCatById(Long id) {
		return (WordCat) this.selectOne(
				"com.xx.demo.dao.mapper.words.WordsCatMapper.getWordCatById", id);
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<WordCat> getAllWordsCat() {
		return (List<WordCat>) this
				.selectList("com.xx.demo.dao.mapper.words.WordsCatMapper.getAllWordsCat");
	}

	// SessionFactory
	@Override
	public SqlSessionFactory sessionFactory() {
		return DefaultSessionFactory.getInstance().getSessionFactory();
	}


}
