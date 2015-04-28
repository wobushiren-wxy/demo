package com.xx.demo.dao;

import java.util.List;
import java.util.Map;

import com.xx.demo.model.pojo.Carte;

// #########################菜单表###############################
public interface CartesDao {
	Long countCartesByCondition(Map<String, Object> condition);
	
	Carte getCartesByCondition(Map<String, Object> condition);
	public List<Carte> getCarteListByCondition(
			
			Map<String, Object> condition);
	
	public List<Carte> getAllCartes();
	
	Carte getCarteById(Long id);

}
