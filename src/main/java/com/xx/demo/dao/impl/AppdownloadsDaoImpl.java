package com.xx.demo.dao.impl;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSessionFactory;

import com.alonew.db.dao.AbstractDAO;
import com.xx.demo.dao.AppdownloadsDao;
import com.xx.demo.dao.mapper.sessionfactory.DefaultSessionFactory;
import com.xx.demo.model.pojo.Appdownload;


//###########################客户信息管理表############################
public class AppdownloadsDaoImpl extends AbstractDAO implements AppdownloadsDao {

	@Override
	public Long countAppdownloadsByCondition(Map<String, Object> condition) {
		return (Long) this.selectOne(
				"com.xx.demo.dao.mapper.appdowns.AppdownloadsMapper.countAppdownloadsByCondition",
				condition);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Appdownload> getAppdownloadListByCondition(Map<String, Object> condition) {
		return (List<Appdownload>) this
				.selectList(
						"com.xx.demo.dao.mapper.appdowns.AppdownloadsMapper.getAppdownloadListByCondition",
						condition);
	}

	@Override
	public Appdownload getAppdownloadById(Long id) {
		return (Appdownload) this.selectOne(
				"com.xx.demo.dao.mapper.appdowns.AppdownloadsMapper.getAppdownloadById", id);
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Appdownload> getAllAppdownloads() {
		return (List<Appdownload>) this
				.selectList("com.xx.demo.dao.mapper.appdowns.AppdownloadsMapper.getAllAppdownloads");
	}

	// SessionFactory
	@Override
	public SqlSessionFactory sessionFactory() {
		return DefaultSessionFactory.getInstance().getSessionFactory();
	}

}
