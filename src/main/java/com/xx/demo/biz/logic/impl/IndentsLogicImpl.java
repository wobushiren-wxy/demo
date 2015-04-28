package com.xx.demo.biz.logic.impl;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;
import com.xx.demo.biz.logic.IndentsLogic;
import com.xx.demo.dao.DaoFactory;
import com.xx.demo.model.pojo.Indent;


//############################订单信息表###############################
public class IndentsLogicImpl implements IndentsLogic {

	@Override
	public Long countIndentsByCondition(Map<String, Object> condition) {
		return DaoFactory.getIndentsDao().countIndentsByCondition(condition);
	}

	@Override
	public List<Indent> getIndentListByCondition(Map<String, Object> condition) {
		return DaoFactory.getIndentsDao().getIndentListByCondition(condition);
	}

	@Override
	public void createIndent(Indent indent) throws SQLException {
		DaoFactory.getCommon().insert(indent);
	}

	@Override
	public Indent getIndentById(Long id) {
		return DaoFactory.getIndentsDao().getIndentById(id);
	}

	//time我没有写进去
	@Override
	public void updateIndent(Indent indent) throws SQLException {
		DaoFactory.getCommon().updateById(indent, "indentno", "indentstate", "dtno", "carteno", "pricsum", "indentnote");
	}

	@Override
	public void deleteIndentById(Long[] ids) throws SQLException {
		for (long id : ids) {
			 Indent indent = DaoFactory.getIndentsDao().getIndentById(id);
			 DaoFactory.getCommon().deleteById(indent);
		}

	}
	
	@Override
	public void deleteIndentByIndentNo(String indentno) throws SQLException {
		
		Indent indent = DaoFactory.getIndentsDao().getIndentByIndentNo(indentno);
		 DaoFactory.getCommon().deleteById(indent);
	}

	@Override
	public List<Indent> getAllIndent() {
		return DaoFactory.getIndentsDao().getAllIndents();
	}



}
