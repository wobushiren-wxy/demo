package com.xx.demo.biz.logic.impl;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;
import com.xx.demo.biz.logic.GuinformationsLogic;
import com.xx.demo.dao.DaoFactory;
import com.xx.demo.model.pojo.Guinformation;


//###########################客户信息管理表############################
public class GuinformationsLogicImpl implements GuinformationsLogic {

	/**
	 * Atguuser
	 */
	@Override
	public Long countGuinformationsByConditionAtguuser(
			Map<String, Object> condition) {
		return DaoFactory.getGuinformationsDao().countGuinformationsByConditionAtguuser(condition);
	}

	@Override
	public List<Guinformation> getGuinformationListByConditionAtguuser(
			Map<String, Object> condition) {
		return DaoFactory.getGuinformationsDao().getGuinformationListByConditionAtguuser(condition);
	}
	
	@Override
	public Long countGuinformationsByCondition(Map<String, Object> condition) {
		return DaoFactory.getGuinformationsDao().countGuinformationsByCondition(condition);
	}

	@Override
	public List<Guinformation> getGuinformationListByCondition(Map<String, Object> condition) {
		return DaoFactory.getGuinformationsDao().getGuinformationListByCondition(condition);
	}

	@Override
	public void createGuinformation(Guinformation guinformation) throws SQLException {
		DaoFactory.getCommon().insert(guinformation);
	}

	@Override
	public Guinformation getGuinformationById(Long id) {
		return DaoFactory.getGuinformationsDao().getGuinformationById(id);
	}

	//time我没有写进去
	@Override
	public void updateGuinformation(Guinformation guinformation) throws SQLException {
		DaoFactory.getCommon().updateById(guinformation, "guuser", "gupwd", "guname", "guphone", "gumail", "gusex", "gunote");
	}

	@Override
	public void deleteGuinformationById(Long[] ids) throws SQLException {
		for (long id : ids) {
			 Guinformation guinformation = DaoFactory.getGuinformationsDao().getGuinformationById(id);
			 DaoFactory.getCommon().deleteById(guinformation);
		}

	}

	@Override
	public List<Guinformation> getAllGuinformation() {
		return DaoFactory.getGuinformationsDao().getAllGuinformations();
	}

	

}
