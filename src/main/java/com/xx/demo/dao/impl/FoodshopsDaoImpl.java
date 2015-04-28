package com.xx.demo.dao.impl;

import java.util.List;
import java.util.Map;
import org.apache.ibatis.session.SqlSessionFactory;
import com.alonew.db.dao.AbstractDAO;
import com.xx.demo.dao.FoodshopsDao;
import com.xx.demo.dao.mapper.sessionfactory.DefaultSessionFactory;
import com.xx.demo.model.pojo.Foodshop;


//#############################餐饮店表################################
public class FoodshopsDaoImpl extends AbstractDAO implements FoodshopsDao {

	@Override
	public Long countFoodshopsByCondition(Map<String, Object> condition) {
		return (Long) this.selectOne(
				"com.xx.demo.dao.mapper.foodshops.FoodshopsMapper.countFoodshopsByCondition",
				condition);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Foodshop> getFoodshopListByCondition(Map<String, Object> condition) {
		return (List<Foodshop>) this
				.selectList(
						"com.xx.demo.dao.mapper.foodshops.FoodshopsMapper.getFoodshopListByCondition",
						condition);
	}

	@Override
	public Foodshop getFoodshopById(Long id) {
		return (Foodshop) this.selectOne(
				"com.xx.demo.dao.mapper.foodshops.FoodshopsMapper.getFoodshopById", id);
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Foodshop> getAllFoodshops() {
		return (List<Foodshop>) this
				.selectList("com.xx.demo.dao.mapper.foodshops.FoodshopsMapper.getAllFoodshops");
	}

	// SessionFactory
	@Override
	public SqlSessionFactory sessionFactory() {
		return DefaultSessionFactory.getInstance().getSessionFactory();
	}


}
