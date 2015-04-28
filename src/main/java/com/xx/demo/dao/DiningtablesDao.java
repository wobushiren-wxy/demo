package com.xx.demo.dao;

import java.util.List;
import java.util.Map;

import com.xx.demo.model.pojo.Diningtable;


// ##############################桌面表################################
public interface DiningtablesDao {
	Long countDiningtablesByCondition(Map<String, Object> condition);

	public List<Diningtable> getDiningtableListByCondition(
			Map<String, Object> condition);
	
	public List<Diningtable> getAllDiningtables();
	
	Diningtable getDiningtableById(Long id);
	
	Diningtable getDiningtableByCondition(Map<String, Object> condition);

}
