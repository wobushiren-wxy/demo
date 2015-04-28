package com.xx.demo.dao;

import java.util.List;
import java.util.Map;

import com.xx.demo.model.pojo.Imgtransmission;


//###########################图片管理表############################
public interface ImgtransmissionsDao {
	
	/**
	 * 正常的
	 */
	Long countImgtransmissionsByCondition(Map<String, Object> condition);
	
	public List<Imgtransmission> getImgtransmissionListByCondition(
			Map<String, Object> condition);
	
	public List<Imgtransmission> getAllImgtransmissions();
	
	Imgtransmission getImgtransmissionById(Long id);

}
