package com.xx.demo.biz.logic;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import com.xx.demo.model.pojo.Subscribe;


public interface SubscribesLogic {

	// #################################客户信息管理表###################################

	Long countSubscribesByCondition(Map<String, Object> condition);

	List<Subscribe> getSubscribeListByCondition(
			Map<String, Object> condition);
	
	List<Subscribe> getAllSubscribe();

	void createSubscribe(Subscribe guinformation) throws SQLException;

	Subscribe getSubscribeById(Long id);

	void updateSubscribe(Subscribe guinformation) throws SQLException;

	void deleteSubscribeById(Long[] ids) throws SQLException;

}
