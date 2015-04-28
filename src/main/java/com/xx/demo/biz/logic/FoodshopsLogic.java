package com.xx.demo.biz.logic;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;
import com.xx.demo.model.pojo.Foodshop;


public interface FoodshopsLogic {

	// ###############################餐饮店表##################################
	Long countFoodshopsByCondition(Map<String, Object> condition);

	List<Foodshop> getFoodshopListByCondition(
			Map<String, Object> condition);
	
	List<Foodshop> getAllFoodshop();

	void createFoodshop(Foodshop foodshop) throws SQLException;

	Foodshop getFoodshopById(Long id);

	void updateFoodshop(Foodshop foodshop) throws SQLException;

	void deleteFoodshopById(Long[] ids) throws SQLException;

}
