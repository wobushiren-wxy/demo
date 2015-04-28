package com.xx.demo.dao;

import java.util.List;
import java.util.Map;
import com.xx.demo.model.pojo.Foodshop;


//#############################餐饮店表################################
public interface FoodshopsDao {
	Long countFoodshopsByCondition(Map<String, Object> condition);

	public List<Foodshop> getFoodshopListByCondition(
			Map<String, Object> condition);
	
	public List<Foodshop> getAllFoodshops();
	
	Foodshop getFoodshopById(Long id);

}
