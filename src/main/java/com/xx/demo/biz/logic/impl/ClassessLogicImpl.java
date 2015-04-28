package com.xx.demo.biz.logic.impl;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;
import com.xx.demo.biz.logic.ClassessLogic;
import com.xx.demo.dao.DaoFactory;
import com.xx.demo.model.pojo.Classes;


//##############################类别表###################################
public class ClassessLogicImpl implements ClassessLogic {

	@Override
	public Long countClassessByCondition(Map<String, Object> condition) {
		return DaoFactory.getClassessDao().countClassessByCondition(condition);
	}

	@Override
	public List<Classes> getClassesListByCondition(Map<String, Object> condition) {
		return DaoFactory.getClassessDao().getClassesListByCondition(condition);
	}

	@Override
	public void createClasses(Classes classes) throws SQLException {
		DaoFactory.getCommon().insert(classes);
	}

	@Override
	public Classes getClassesById(Long id) {
		return DaoFactory.getClassessDao().getClassesById(id);
	}

	//time我没有写进去
	@Override
	public void updateClasses(Classes classes) throws SQLException {
		DaoFactory.getCommon().updateById(classes, "classesno", "classesname", "classesnote");
	}

	@Override
	public void deleteClassesById(Long[] ids) throws SQLException {
		for (long id : ids) {
			 Classes classes = DaoFactory.getClassessDao().getClassesById(id);
			 DaoFactory.getCommon().deleteById(classes);
		}

	}

	@Override
	public List<Classes> getAllClasses() {
		return DaoFactory.getClassessDao().getAllClassess();
	}

}
