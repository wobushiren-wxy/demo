package com.xx.demo.dao;

import java.util.List;
import java.util.Map;

import com.xx.demo.model.pojo.Guinformation;


//###########################客户信息管理表############################
public interface GuinformationsDao {
	
	Long countGuinformationsByConditionAtguuser(Map<String, Object> condition);
	
	public List<Guinformation> getGuinformationListByConditionAtguuser(
			Map<String, Object> condition);

	
	/**
	 * 正常的
	 */
	Long countGuinformationsByCondition(Map<String, Object> condition);
	
	public List<Guinformation> getGuinformationListByCondition(
			Map<String, Object> condition);
	
	public List<Guinformation> getAllGuinformations();
	
	Guinformation getGuinformationById(Long id);

}
