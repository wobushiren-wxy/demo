package com.xx.demo.biz.service;

import java.util.Map;

import com.xx.demo.model.resp.BaseRes;
import com.xx.demo.model.resp.FoodevaluationRes;


/**
 * 签名类别服务接口
 * 
 * @author chlingm
 * 
 */
public interface FoodevaluationsService {


	/**
	 * 按条件下载签名
	 * 
	 * @param retNums
	 *            个数
	 * @param sort
	 *            asc-升序；desc-降序
	 * 
	 * @return BaseRes 签名结果集
	 */
	BaseRes getFoodevaluationListCartenoByCondition(Map<String, Object> condition);

	BaseRes createFoodevaluations(FoodevaluationRes foodevaluationRes);
	
	BaseRes deleteFoodevaluations(String carteno , String guuser);
	
	BaseRes updateFoodevaluations(FoodevaluationRes foodevaluationRes);
}
