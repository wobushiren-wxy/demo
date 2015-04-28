package com.xx.demo.biz.logic;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import com.xx.demo.model.pojo.Imgtransmission;


public interface ImgtransmissionsLogic {

	// #################################图片管理###################################
	
	/**
	 * Atguuser
	 */
	
	Long countImgtransmissionsByCondition(Map<String, Object> condition);

	List<Imgtransmission> getImgtransmissionListByCondition(
			Map<String, Object> condition);
	
	List<Imgtransmission> getAllImgtransmission();

	void createImgtransmission(Imgtransmission imgtransmission) throws SQLException;

	Imgtransmission getImgtransmissionById(Long id);

	void updateImgtransmission(Imgtransmission imgtransmission) throws SQLException;

	void deleteImgtransmissionById(Long[] ids) throws SQLException;

}
