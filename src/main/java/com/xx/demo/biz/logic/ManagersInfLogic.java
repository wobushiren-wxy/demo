package com.xx.demo.biz.logic;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import com.xx.demo.model.pojo.ManagerInf;


public interface ManagersInfLogic {

	// ###########################管理员信息表##############################
	Long countManagersInfByCondition(Map<String, Object> condition);

	List<ManagerInf> getManagerInfListByCondition(
			Map<String, Object> condition);
	
	List<ManagerInf> getAllManagerInf();

	void createManagerInf(ManagerInf managerInf) throws SQLException;

	ManagerInf getManagerInfById(Long id);

	void updateManagerInf(ManagerInf managerInf) throws SQLException;

	void deleteManagerInfById(Long[] ids) throws SQLException;

}
