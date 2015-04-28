package com.xx.demo.biz.logic;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import com.xx.demo.model.pojo.Foodevaluation;


public interface FoodevaluationsLogic {

	// #################################菜评管理###################################
	Long countFoodevaluationsByCondition(Map<String, Object> condition);
	
	//这个要多发送一个Carteno
	List<Foodevaluation> getFoodevaluationListCartenoByCondition(
			Map<String, Object> condition);
	
	List<Foodevaluation> getFoodevaluationListByCondition(
			Map<String, Object> condition);
	
	List<Foodevaluation> getAllFoodevaluation();

	void createFoodevaluation(Foodevaluation foodevaluation) throws SQLException;

	Foodevaluation getFoodevaluationById(Long id);

	void updateFoodevaluation(Foodevaluation foodevaluation) throws SQLException;

	void deleteFoodevaluationById(Long[] ids) throws SQLException;

}
