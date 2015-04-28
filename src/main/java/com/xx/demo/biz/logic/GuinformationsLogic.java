package com.xx.demo.biz.logic;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import com.xx.demo.model.pojo.Guinformation;


public interface GuinformationsLogic {

	// #################################客户信息管理表###################################
	
	/**
	 * Atguuser
	 */
	Long countGuinformationsByConditionAtguuser(Map<String, Object> condition);
	
	List<Guinformation> getGuinformationListByConditionAtguuser(
			Map<String, Object> condition);

	Long countGuinformationsByCondition(Map<String, Object> condition);

	List<Guinformation> getGuinformationListByCondition(
			Map<String, Object> condition);
	
	List<Guinformation> getAllGuinformation();

	void createGuinformation(Guinformation guinformation) throws SQLException;

	Guinformation getGuinformationById(Long id);

	void updateGuinformation(Guinformation guinformation) throws SQLException;

	void deleteGuinformationById(Long[] ids) throws SQLException;

}
