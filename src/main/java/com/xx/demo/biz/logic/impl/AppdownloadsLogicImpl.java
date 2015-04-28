package com.xx.demo.biz.logic.impl;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;
import com.xx.demo.biz.logic.AppdownloadsLogic;
import com.xx.demo.dao.DaoFactory;
import com.xx.demo.model.pojo.Appdownload;

//###########################客户信息管理表############################
public class AppdownloadsLogicImpl implements AppdownloadsLogic {

	@Override
	public Long countAppdownloadsByCondition(Map<String, Object> condition) {
		return DaoFactory.getAppdownloadsDao().countAppdownloadsByCondition(condition);
	}

	@Override
	public List<Appdownload> getAppdownloadListByCondition(Map<String, Object> condition) {
		return DaoFactory.getAppdownloadsDao().getAppdownloadListByCondition(condition);
	}

	@Override
	public void createAppdownload(Appdownload appdownload) throws SQLException {
		DaoFactory.getCommon().insert(appdownload);
	}

	@Override
	public Appdownload getAppdownloadById(Long id) {
		return DaoFactory.getAppdownloadsDao().getAppdownloadById(id);
	}

	//time我没有写进去
	@Override
	public void updateAppdownload(Appdownload appdownload) throws SQLException {
		DaoFactory.getCommon().updateById(appdownload, "appver", "apppath", "appurl", "miuser", "appnote");
	}

	@Override
	public void deleteAppdownloadById(Long[] ids) throws SQLException {
		for (long id : ids) {
			 Appdownload appdownload = DaoFactory.getAppdownloadsDao().getAppdownloadById(id);
			 DaoFactory.getCommon().deleteById(appdownload);
		}

	}

	@Override
	public List<Appdownload> getAllAppdownload() {
		return DaoFactory.getAppdownloadsDao().getAllAppdownloads();
	}

}
