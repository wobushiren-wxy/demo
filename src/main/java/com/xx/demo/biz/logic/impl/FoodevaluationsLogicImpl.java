package com.xx.demo.biz.logic.impl;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;
import com.xx.demo.biz.logic.FoodevaluationsLogic;
import com.xx.demo.dao.DaoFactory;
import com.xx.demo.model.pojo.Foodevaluation;


//###############################菜评表################################
public class FoodevaluationsLogicImpl implements FoodevaluationsLogic {

	@Override
	public Long countFoodevaluationsByCondition(Map<String, Object> condition) {
		return DaoFactory.getFoodevaluationsDao().countFoodevaluationsByCondition(condition);
	}

	@Override
	public List<Foodevaluation> getFoodevaluationListByCondition(Map<String, Object> condition) {
		return DaoFactory.getFoodevaluationsDao().getFoodevaluationListByCondition(condition);
	}
	
	@Override
	public List<Foodevaluation> getFoodevaluationListCartenoByCondition(
			Map<String, Object> condition) {
		return DaoFactory.getFoodevaluationsDao().getFoodevaluationListCartenoByCondition(condition);
	}
	
	

	@Override
	public void createFoodevaluation(Foodevaluation foodevaluation) throws SQLException {
		DaoFactory.getCommon().insert(foodevaluation);
	}

	@Override
	public Foodevaluation getFoodevaluationById(Long id) {
		return DaoFactory.getFoodevaluationsDao().getFoodevaluationById(id);
	}

	//time我没有写进去
	@Override
	public void updateFoodevaluation(Foodevaluation foodevaluation) throws SQLException {
		DaoFactory.getCommon().updateById(foodevaluation, "carteno", "guuser", "cartename", "carteping", "cptime");
	}

	@Override
	public void deleteFoodevaluationById(Long[] ids) throws SQLException {
		for (long id : ids) {
			 Foodevaluation foodevaluation = DaoFactory.getFoodevaluationsDao().getFoodevaluationById(id);
			 DaoFactory.getCommon().deleteById(foodevaluation);
		}

	}

	@Override
	public List<Foodevaluation> getAllFoodevaluation() {
		return DaoFactory.getFoodevaluationsDao().getAllFoodevaluations();
	}

	

}
