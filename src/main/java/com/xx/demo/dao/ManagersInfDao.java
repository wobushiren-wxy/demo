package com.xx.demo.dao;

import java.util.List;
import java.util.Map;

import com.xx.demo.model.pojo.ManagerInf;


public interface ManagersInfDao {
	Long countManagersInfByCondition(Map<String, Object> condition);

	public List<ManagerInf> getManagerInfListByCondition(
			Map<String, Object> condition);
	
	public List<ManagerInf> getAllManagersInf();
	
	ManagerInf getManagerInfById(Long id);

}
