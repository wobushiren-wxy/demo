package com.xx.demo.biz.logic;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import com.xx.demo.model.pojo.Diningtable;


public interface DiningtablesLogic {

	// ####################################桌面表#######################################
	Long countDiningtablesByCondition(Map<String, Object> condition);

	List<Diningtable> getDiningtableListByCondition(
			Map<String, Object> condition);
	
	List<Diningtable> getAllDiningtable();

	void createDiningtable(Diningtable diningtable) throws SQLException;

	Diningtable getDiningtableById(Long id);

	void updateDiningtable(Diningtable diningtable) throws SQLException;

	void deleteDiningtableById(Long[] ids) throws SQLException;
	
	Diningtable getDiningtableByCondition(Map<String, Object> condition);

}
