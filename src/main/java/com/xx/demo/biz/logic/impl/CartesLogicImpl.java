package com.xx.demo.biz.logic.impl;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;
import com.xx.demo.biz.logic.CartesLogic;
import com.xx.demo.dao.DaoFactory;
import com.xx.demo.model.pojo.Carte;


//##########################菜单表#############################
public class CartesLogicImpl implements CartesLogic {

	@Override
	public Long countCartesByCondition(Map<String, Object> condition) {
		return DaoFactory.getCartesDao().countCartesByCondition(condition);
	}
	
	@Override
	public Carte getCartesByCondition(Map<String, Object> condition) {
		return DaoFactory.getCartesDao().getCartesByCondition(condition);
	}

	@Override
	public List<Carte> getCarteListByCondition(Map<String, Object> condition) {
		return DaoFactory.getCartesDao().getCarteListByCondition(condition);
	}

	@Override
	public void createCarte(Carte carte) throws SQLException {
		DaoFactory.getCommon().insert(carte);
	}

	@Override
	public Carte getCarteById(Long id) {
		return DaoFactory.getCartesDao().getCarteById(id);
	}

	//time我没有写进去
	@Override
	public void updateCarte(Carte carte) throws SQLException {
		DaoFactory.getCommon().updateById(carte, "carteno", "cartename", "material", "synopsis", "classesno", "price", "cartenote");
	}

	@Override
	public void deleteCarteById(Long[] ids) throws SQLException {
		for (long id : ids) {
			 Carte carte = DaoFactory.getCartesDao().getCarteById(id);
			 DaoFactory.getCommon().deleteById(carte);
		}
	}

	@Override
	public List<Carte> getAllCarte() {
		return DaoFactory.getCartesDao().getAllCartes();
	}

}
