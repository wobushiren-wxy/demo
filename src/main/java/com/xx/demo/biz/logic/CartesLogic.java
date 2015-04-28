package com.xx.demo.biz.logic;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import com.xx.demo.model.pojo.Carte;


public interface CartesLogic {

	// ##########################菜单表#############################
	Long countCartesByCondition(Map<String, Object> condition);

	Carte getCartesByCondition(Map<String, Object> condition);
	
	List<Carte> getCarteListByCondition(
			Map<String, Object> condition);
	
	List<Carte> getAllCarte();

	void createCarte(Carte carte) throws SQLException;

	Carte getCarteById(Long id);

	void updateCarte(Carte carte) throws SQLException;

	void deleteCarteById(Long[] ids) throws SQLException;

}
