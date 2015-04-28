package com.xx.demo.dao.impl;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSessionFactory;

import com.alonew.db.dao.AbstractDAO;
import com.xx.demo.dao.ImgtransmissionsDao;
import com.xx.demo.dao.mapper.sessionfactory.DefaultSessionFactory;
import com.xx.demo.model.pojo.Imgtransmission;


//###########################客户信息管理表############################
public class ImgtransmissionsDaoImpl extends AbstractDAO implements ImgtransmissionsDao {

	/**
	 * Atguuser
	 */
	
	@Override
	public Long countImgtransmissionsByCondition(Map<String, Object> condition) {
		return (Long) this.selectOne(
				"com.xx.demo.dao.mapper.imgtrans.ImgtransmissionsMapper.countImgtransmissionsByCondition",
				condition);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Imgtransmission> getImgtransmissionListByCondition(Map<String, Object> condition) {
		return (List<Imgtransmission>) this
				.selectList(
						"com.xx.demo.dao.mapper.imgtrans.ImgtransmissionsMapper.getImgtransmissionListByCondition",
						condition);
	}

	@Override
	public Imgtransmission getImgtransmissionById(Long id) {
		return (Imgtransmission) this.selectOne(
				"com.xx.demo.dao.mapper.imgtrans.ImgtransmissionsMapper.getImgtransmissionById", id);
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Imgtransmission> getAllImgtransmissions() {
		return (List<Imgtransmission>) this
				.selectList("com.xx.demo.dao.mapper.imgtrans.ImgtransmissionsMapper.getAllImgtransmissions");
	}

	// SessionFactory
	@Override
	public SqlSessionFactory sessionFactory() {
		return DefaultSessionFactory.getInstance().getSessionFactory();
	}

	


}
