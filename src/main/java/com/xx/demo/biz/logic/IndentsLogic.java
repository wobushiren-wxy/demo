package com.xx.demo.biz.logic;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import com.xx.demo.model.pojo.Indent;


public interface IndentsLogic {

	// ##########################订单信息表#############################
	Long countIndentsByCondition(Map<String, Object> condition);

	List<Indent> getIndentListByCondition(
			Map<String, Object> condition);
	
	List<Indent> getAllIndent();

	void createIndent(Indent indent) throws SQLException;

	Indent getIndentById(Long id);

	void updateIndent(Indent indent) throws SQLException;

	void deleteIndentById(Long[] ids) throws SQLException;
	
	void deleteIndentByIndentNo(String indentno) throws SQLException;

}
