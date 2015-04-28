package com.xx.demo.biz.logic.impl;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;
import com.xx.demo.biz.logic.FoodshopsLogic;
import com.xx.demo.dao.DaoFactory;
import com.xx.demo.model.pojo.Foodshop;


//#############################餐饮店表################################
public class FoodshopsLogicImpl implements FoodshopsLogic {

	@Override
	public Long countFoodshopsByCondition(Map<String, Object> condition) {
		return DaoFactory.getFoodshopsDao().countFoodshopsByCondition(condition);
	}

	@Override
	public List<Foodshop> getFoodshopListByCondition(Map<String, Object> condition) {
		return DaoFactory.getFoodshopsDao().getFoodshopListByCondition(condition);
	}

	@Override
	public void createFoodshop(Foodshop foodshop) throws SQLException {
		DaoFactory.getCommon().insert(foodshop);
	}

	@Override
	public Foodshop getFoodshopById(Long id) {
		return DaoFactory.getFoodshopsDao().getFoodshopById(id);
	}

	//time我没有写进去
	@Override
	public void updateFoodshop(Foodshop foodshop) throws SQLException {
		DaoFactory.getCommon().updateById(foodshop, "businesslicense", "fsname", "fsphone", "fsaddress", "fsdescribe","fsnote");
	}

	@Override
	public void deleteFoodshopById(Long[] ids) throws SQLException {
		for (long id : ids) {
			 Foodshop foodshop = DaoFactory.getFoodshopsDao().getFoodshopById(id);
			 DaoFactory.getCommon().deleteById(foodshop);
		}

	}

	@Override
	public List<Foodshop> getAllFoodshop() {
		return DaoFactory.getFoodshopsDao().getAllFoodshops();
	}

}
