package com.xx.demo.dao;

import java.util.List;
import java.util.Map;

import com.xx.demo.model.pojo.Subscribe;


//###########################客户信息管理表############################
public interface SubscribesDao {
	
	/**
	 * 正常的
	 */
	Long countSubscribesByCondition(Map<String, Object> condition);
	
	public List<Subscribe> getSubscribeListByCondition(
			Map<String, Object> condition);
	
	public List<Subscribe> getAllSubscribes();
	
	Subscribe getSubscribeById(Long id);

}
