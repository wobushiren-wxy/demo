package com.xx.demo.biz.service;

import java.util.Map;

import com.xx.demo.model.resp.BaseRes;
import com.xx.demo.model.resp.DiningtableRes;


public interface DiningtablesService {


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
	BaseRes getDiningtablesByCondition(Map<String, Object> condition);
	
	BaseRes updateDiningtables(DiningtableRes diningtableRes);

}
