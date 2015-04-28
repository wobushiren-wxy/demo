package com.xx.demo.dao;

import java.util.List;
import java.util.Map;

import com.xx.demo.model.pojo.Foodevaluation;


//###########################客户信息管理表############################
public interface FoodevaluationsDao {
	Long countFoodevaluationsByCondition(Map<String, Object> condition);
	
	public List<Foodevaluation> getFoodevaluationListCartenoByCondition(
			Map<String, Object> condition);
	
	public List<Foodevaluation> getFoodevaluationListByCondition(
			Map<String, Object> condition);
	
	public List<Foodevaluation> getAllFoodevaluations();
	
	Foodevaluation getFoodevaluationById(Long id);

}
