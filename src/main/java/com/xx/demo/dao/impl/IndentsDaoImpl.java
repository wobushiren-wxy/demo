package com.xx.demo.dao.impl;

import java.util.List;
import java.util.Map;
import org.apache.ibatis.session.SqlSessionFactory;
import com.alonew.db.dao.AbstractDAO;
import com.xx.demo.dao.IndentsDao;
import com.xx.demo.dao.mapper.sessionfactory.DefaultSessionFactory;
import com.xx.demo.model.pojo.Indent;


// ############################订单信息表###############################
public class IndentsDaoImpl extends AbstractDAO implements IndentsDao {

	@Override
	public Long countIndentsByCondition(Map<String, Object> condition) {
		return (Long) this.selectOne(
				"com.xx.demo.dao.mapper.indents.IndentsMapper.countIndentsByCondition",
				condition);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Indent> getIndentListByCondition(Map<String, Object> condition) {
		return (List<Indent>) this
				.selectList(
						"com.xx.demo.dao.mapper.indents.IndentsMapper.getIndentListByCondition",
						condition);
	}

	@Override
	public Indent getIndentById(Long id) {
		return (Indent) this.selectOne(
				"com.xx.demo.dao.mapper.indents.IndentsMapper.getIndentById", id);
	}
	//为了写服务端获取indentno我另外加了这个
	@Override
	public Indent getIndentByIndentNo(String indentno) {
		return (Indent) this.selectOne(
				"com.xx.demo.dao.mapper.indents.IndentsMapper.getIndentByIndentNo", indentno);
	}
	
	
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Indent> getAllIndents() {
		return (List<Indent>) this
				.selectList("com.xx.demo.dao.mapper.indents.IndentsMapper.getAllIndents");
	}
	
	// SessionFactory
	@Override
	public SqlSessionFactory sessionFactory() {
		return DefaultSessionFactory.getInstance().getSessionFactory();
	}

	


}
