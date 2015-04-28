package com.xx.demo.dao;

import java.sql.SQLException;

import com.alonew.core.commons.model.BaseVO;
import com.alonew.core.commons.model.BaseVOLong;
import com.alonew.core.commons.model.BaseVOString;
import com.alonew.db.dao.BaseCommonDAO;
import com.alonew.db.dao.BaseSessionFactory;
import com.alonew.db.dao.CommonDAO;
import com.alonew.db.dao.ISessionFactory;
import com.xx.demo.dao.mapper.sessionfactory.DefaultSessionFactory;

public class SessionCommonDAO implements CommonDAO {

	private final CommonDAO defaultCommon = new BaseCommonDAO(
			DefaultSessionFactory.getInstance());

	private CommonDAO common(Object vo) {
		if (vo instanceof ISessionFactory) {
			ISessionFactory iSessionFactory = (ISessionFactory) vo;
			BaseSessionFactory sessionFactory = iSessionFactory.sessionFactory();
			if (sessionFactory instanceof DefaultSessionFactory) {
				return defaultCommon;
			} 
		} else {
			throw new RuntimeException("not instanceof ISessionFactory！！！");
		}
		return null;
	}

	public int insert(BaseVO vo) throws SQLException {
		return common(vo).insert(vo);
	}

	public long insert(BaseVOLong vo) throws SQLException {
		return common(vo).insert(vo);
	}

	public String insert(BaseVOString vo) throws SQLException {
		return common(vo).insert(vo);
	}

	public int replace(BaseVO vo) throws SQLException {
		return common(vo).replace(vo);
	}

	public long replace(BaseVOLong vo) throws SQLException {
		return common(vo).replace(vo);
	}

	public String replace(BaseVOString vo) throws SQLException {
		return common(vo).replace(vo);
	}

	public int deleteById(BaseVO vo) throws SQLException {
		return common(vo).deleteById(vo);
	}

	public int deleteById(BaseVOLong vo) throws SQLException {
		return common(vo).deleteById(vo);
	}


	public int deleteById(BaseVOString vo) throws SQLException {
		return common(vo).deleteById(vo);
	}

	public int updateById(BaseVO vo, String... keys) throws SQLException {
		return common(vo).updateById(vo, keys);
	}

	public int updateById(BaseVOLong vo, String... keys) throws SQLException {
		return common(vo).updateById(vo, keys);
	}

	public int updateById(BaseVOString vo, String... keys) throws SQLException {
		return common(vo).updateById(vo, keys);
	}

	public int updateById(BaseVO vo, boolean allowNull, String... keys)
			throws SQLException {
		return common(vo).updateById(vo, allowNull, keys);
	}

	public int updateById(BaseVOLong vo, boolean allowNull, String... keys)
			throws SQLException {
		return common(vo).updateById(vo, allowNull, keys);
	}

	public int updateById(BaseVOString vo, boolean allowNull, String... keys)
			throws SQLException {
		return common(vo).updateById(vo, allowNull, keys);
	}

}
