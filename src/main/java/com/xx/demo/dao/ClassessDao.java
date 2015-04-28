package com.xx.demo.dao;

import java.util.List;
import java.util.Map;

import com.xx.demo.model.pojo.Classes;


//#############################类别表##################################
public interface ClassessDao {
	Long countClassessByCondition(Map<String, Object> condition);

	public List<Classes> getClassesListByCondition(
			Map<String, Object> condition);
	
	public List<Classes> getAllClassess();
	
	Classes getClassesById(Long id);

}
