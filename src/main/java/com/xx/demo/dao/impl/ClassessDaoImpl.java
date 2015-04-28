package com.xx.demo.dao.impl;

import java.util.List;
import java.util.Map;
import org.apache.ibatis.session.SqlSessionFactory;
import com.alonew.db.dao.AbstractDAO;
import com.xx.demo.dao.ClassessDao;
import com.xx.demo.dao.mapper.sessionfactory.DefaultSessionFactory;
import com.xx.demo.model.pojo.Classes;


//#############################类别表##################################
public class ClassessDaoImpl extends AbstractDAO implements ClassessDao {

	@Override
	public Long countClassessByCondition(Map<String, Object> condition) {
		return (Long) this.selectOne(
				"com.xx.demo.dao.mapper.classess.ClassessMapper.countClassessByCondition",
				condition);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Classes> getClassesListByCondition(Map<String, Object> condition) {
		return (List<Classes>) this
				.selectList(
						"com.xx.demo.dao.mapper.classess.ClassessMapper.getClassesListByCondition",
						condition);
	}

	@Override
	public Classes getClassesById(Long id) {
		return (Classes) this.selectOne(
				"com.xx.demo.dao.mapper.classess.ClassessMapper.getClassesById", id);
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Classes> getAllClassess() {
		return (List<Classes>) this
				.selectList("com.xx.demo.dao.mapper.classess.ClassessMapper.getAllClassess");
	}

	// SessionFactory
	@Override
	public SqlSessionFactory sessionFactory() {
		return DefaultSessionFactory.getInstance().getSessionFactory();
	}


}
