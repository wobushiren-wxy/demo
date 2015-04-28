package com.xx.demo.biz.logic.impl;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;
import com.xx.demo.biz.logic.DiningtablesLogic;
import com.xx.demo.dao.DaoFactory;
import com.xx.demo.model.pojo.Diningtable;


// ##############################桌面表################################
public class DiningtablesLogicImpl implements DiningtablesLogic {

	@Override
	public Long countDiningtablesByCondition(Map<String, Object> condition) {
		return DaoFactory.getDiningtablesDao().countDiningtablesByCondition(condition);
	}

	@Override
	public List<Diningtable> getDiningtableListByCondition(Map<String, Object> condition) {
		return DaoFactory.getDiningtablesDao().getDiningtableListByCondition(condition);
	}

	@Override
	public void createDiningtable(Diningtable diningtable) throws SQLException {
		DaoFactory.getCommon().insert(diningtable);
	}

	@Override
	public Diningtable getDiningtableById(Long id) {
		return DaoFactory.getDiningtablesDao().getDiningtableById(id);
	}

	//time我没有写进去
	@Override
	public void updateDiningtable(Diningtable diningtable) throws SQLException {
		DaoFactory.getCommon().updateById(diningtable, "dtno", "dtname", "dtnote");
	}

	@Override
	public void deleteDiningtableById(Long[] ids) throws SQLException {
		for (long id : ids) {
			 Diningtable diningtable = DaoFactory.getDiningtablesDao().getDiningtableById(id);
			 DaoFactory.getCommon().deleteById(diningtable);
		}

	}
	
	@Override
	public Diningtable getDiningtableByCondition(Map<String, Object> condition) {
		return DaoFactory.getDiningtablesDao().getDiningtableByCondition(condition);
	}

	@Override
	public List<Diningtable> getAllDiningtable() {
		return DaoFactory.getDiningtablesDao().getAllDiningtables();
	}

	

}
