package com.xx.demo.biz.logic.impl;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;
import com.xx.demo.biz.logic.SubscribesLogic;
import com.xx.demo.dao.DaoFactory;
import com.xx.demo.model.pojo.Subscribe;


//###########################客户信息管理表############################
public class SubscribesLogicImpl implements SubscribesLogic {


	
	@Override
	public Long countSubscribesByCondition(Map<String, Object> condition) {
		return DaoFactory.getSubscribesDao().countSubscribesByCondition(condition);
	}

	@Override
	public List<Subscribe> getSubscribeListByCondition(Map<String, Object> condition) {
		return DaoFactory.getSubscribesDao().getSubscribeListByCondition(condition);
	}

	@Override
	public void createSubscribe(Subscribe subscribe) throws SQLException {
		DaoFactory.getCommon().insert(subscribe);
	}

	@Override
	public Subscribe getSubscribeById(Long id) {
		return DaoFactory.getSubscribesDao().getSubscribeById(id);
	}

	//time我没有写进去
	@Override
	public void updateSubscribe(Subscribe subscribe) throws SQLException {
		DaoFactory.getCommon().updateById(subscribe, "subno", "subtime", "guuser", "subnums", "subnote");
	}

	@Override
	public void deleteSubscribeById(Long[] ids) throws SQLException {
		for (long id : ids) {
			 Subscribe subscribe = DaoFactory.getSubscribesDao().getSubscribeById(id);
			 DaoFactory.getCommon().deleteById(subscribe);
		}

	}

	@Override
	public List<Subscribe> getAllSubscribe() {
		return DaoFactory.getSubscribesDao().getAllSubscribes();
	}

	

}
