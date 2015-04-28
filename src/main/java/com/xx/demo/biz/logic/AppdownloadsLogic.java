package com.xx.demo.biz.logic;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import com.xx.demo.model.pojo.Appdownload;


public interface AppdownloadsLogic {

// #################################App上传下载管理###################################
	Long countAppdownloadsByCondition(Map<String, Object> condition);

	List<Appdownload> getAppdownloadListByCondition(
			Map<String, Object> condition);
	
	List<Appdownload> getAllAppdownload();

	void createAppdownload(Appdownload guinformation) throws SQLException;

	Appdownload getAppdownloadById(Long id);

	void updateAppdownload(Appdownload guinformation) throws SQLException;

	void deleteAppdownloadById(Long[] ids) throws SQLException;

}
