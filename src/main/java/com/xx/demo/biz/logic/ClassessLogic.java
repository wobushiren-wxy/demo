package com.xx.demo.biz.logic;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import com.xx.demo.model.pojo.Classes;


public interface ClassessLogic {

	// ##############################类别表###################################
	Long countClassessByCondition(Map<String, Object> condition);

	List<Classes> getClassesListByCondition(
			Map<String, Object> condition);
	
	List<Classes> getAllClasses();

	void createClasses(Classes classes) throws SQLException;

	Classes getClassesById(Long id);

	void updateClasses(Classes classes) throws SQLException;

	void deleteClassesById(Long[] ids) throws SQLException;

}
