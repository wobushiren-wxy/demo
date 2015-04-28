package com.xx.demo.dao.impl;

import java.util.Map;

import org.apache.ibatis.session.SqlSessionFactory;

import com.alonew.db.dao.AbstractDAO;
import com.xx.demo.dao.LoginDao;
import com.xx.demo.dao.mapper.sessionfactory.DefaultSessionFactory;
import com.xx.demo.model.pojo.Guinformation;
import com.xx.demo.model.pojo.ManagerInf;

public class LoginDaoImpl extends AbstractDAO implements LoginDao {
	//后台登陆
	@Override
	public ManagerInf getManagerInfByMiuser(Map<String, Object> condition) {
		return (ManagerInf) this.selectOne(
				"com.xx.demo.dao.mapper.login.LoginMapper.getLoginByCondition",
				condition);
	}
	
	//客户端登陆
	@Override
	public Guinformation getGuinformationByMiuser(Map<String, Object> condition) {
		return (Guinformation) this.selectOne(
				"com.xx.demo.dao.mapper.login.LoginMapper.getGuinformationLoginByCondition",
				condition);
	}
	
	@Override
	public SqlSessionFactory sessionFactory() {
		return DefaultSessionFactory.getInstance().getSessionFactory();
	}

	
}
