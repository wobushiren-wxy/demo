package com.xx.demo.biz.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.xx.demo.biz.logic.LogicFactory;
import com.xx.demo.biz.service.FoodevaluationsService;
import com.xx.demo.common.utils.LoggerManager;
import com.xx.demo.model.enums.ErrorCode;
import com.xx.demo.model.pojo.Carte;
import com.xx.demo.model.pojo.Foodevaluation;
import com.xx.demo.model.resp.BaseRes;
import com.xx.demo.model.resp.FoodevaluationRes;

public class FoodevaluationsServiceImpl implements FoodevaluationsService {

	@Override
	public BaseRes createFoodevaluations(FoodevaluationRes foodevaluationRes) {
		
		try{
			Foodevaluation foodevaluation = new Foodevaluation(foodevaluationRes.getCarteno(),
					foodevaluationRes.getGuuser(),foodevaluationRes.getCartename(),
					foodevaluationRes.getCarteping(),null);
			
			

			Map<String, Object> condition = new HashMap<String, Object>();
			condition.put("carteno", foodevaluationRes.getCarteno());
			Carte carte = LogicFactory.getCartesLogic().getCartesByCondition(condition);
			foodevaluation.setCartename(carte.getCartename());
			
			foodevaluation.setCptime(new Date());
			
			
			LogicFactory.getFoodevaluationsLogic().createFoodevaluation(foodevaluation);
			//"添加成功"
			
			return new BaseRes(ErrorCode.OK,"成功");
			
		}catch (Exception e) {
			LoggerManager.def.error("sortDownloadWords errors:",e);
			return new BaseRes(ErrorCode.SYSTEM_ERROR);
		}
		
	}
	
	@Override
	public BaseRes getFoodevaluationListCartenoByCondition(Map<String, Object> condition) {
		try {
			List<Foodevaluation> fooddevaList = LogicFactory.getFoodevaluationsLogic().
					getFoodevaluationListCartenoByCondition(condition);
			
			List<FoodevaluationRes> fooddevaResList = new ArrayList<FoodevaluationRes>();
			
			for (Foodevaluation fooddeva : fooddevaList) {
				FoodevaluationRes FoodevaluationRes = new FoodevaluationRes(
						fooddeva.getId(), fooddeva.getCarteno(), fooddeva.getGuuser(),
						fooddeva.getCartename(), fooddeva.getCarteping());
				fooddevaResList.add(FoodevaluationRes);
			}
			return new BaseRes(ErrorCode.OK, fooddevaResList);
		} catch (Exception e) {
			LoggerManager.def.error("sortDownloadWords errors:",e);
			return new BaseRes(ErrorCode.SYSTEM_ERROR);
		}
		
	}


	@Override
	public BaseRes deleteFoodevaluations(String carteno, String guuser) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public BaseRes updateFoodevaluations(FoodevaluationRes foodevaluationRes) {
		// TODO Auto-generated method stub
		return null;
	}

	
}
