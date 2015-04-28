package com.xx.demo.biz.service;

import java.util.Map;

import com.xx.demo.model.resp.BaseRes;
import com.xx.demo.model.resp.IndentRes;


/**
 * 签名类别服务接口
 * 
 * @author chlingm
 * 
 */
public interface IndentsService {

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
	BaseRes getIndentsByCondition(Map<String, Object> condition);

	BaseRes createIndent(IndentRes indentRes);
	
	BaseRes deleteIndent(String indentno);
	
}
