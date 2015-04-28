package com.xx.demo.biz.logic.impl;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import com.xx.demo.biz.logic.ManagersInfLogic;
import com.xx.demo.dao.DaoFactory;
import com.xx.demo.model.pojo.ManagerInf;


//###########################管理员信息表#############################
public class ManagersInfLogicImpl implements ManagersInfLogic {

	@Override
	public Long countManagersInfByCondition(Map<String, Object> condition) {
		return DaoFactory.getManagersInfDao().countManagersInfByCondition(condition);
	}

	@Override
	public List<ManagerInf> getManagerInfListByCondition(Map<String, Object> condition) {
		return DaoFactory.getManagersInfDao().getManagerInfListByCondition(condition);
	}

	@Override
	public void createManagerInf(ManagerInf managerInf) throws SQLException {
		DaoFactory.getCommon().insert(managerInf);
	}

	@Override
	public ManagerInf getManagerInfById(Long id) {
		return DaoFactory.getManagersInfDao().getManagerInfById(id);
	}

	//time我没有写进去
	@Override
	public void updateManagerInf(ManagerInf managerInf) throws SQLException {
		DaoFactory.getCommon().updateById(managerInf, "miuser", "mipwd", "jurisdiction", "miname", "minote");
	}

	@Override
	public void deleteManagerInfById(Long[] ids) throws SQLException {
		for (long id : ids) {
			 ManagerInf managerInf = DaoFactory.getManagersInfDao().getManagerInfById(id);
			 DaoFactory.getCommon().deleteById(managerInf);
		}

	}

	@Override
	public List<ManagerInf> getAllManagerInf() {
		return DaoFactory.getManagersInfDao().getAllManagersInf();
	}

}
