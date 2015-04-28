package com.xx.demo.dao;

import java.util.List;
import java.util.Map;

import com.xx.demo.model.pojo.Indent;


// ############################订单信息表###############################
public interface IndentsDao {
	Long countIndentsByCondition(Map<String, Object> condition);

	public List<Indent> getIndentListByCondition(
			Map<String, Object> condition);
	
	public List<Indent> getAllIndents();
	
	Indent getIndentById(Long id);
	
	Indent getIndentByIndentNo(String indentno);

}
