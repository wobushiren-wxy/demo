package com.xx.demo.biz.service;

import java.util.Map;

import com.xx.demo.model.resp.BaseRes;


/**
 * 菜单服务接口
 * 
 * @author chlingm
 * 
 */
public interface CartesService {


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
	BaseRes getCartesByCondition(Map<String, Object> condition);


}
