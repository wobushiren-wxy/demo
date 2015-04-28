package com.xx.demo.dao;

import java.util.List;
import java.util.Map;

import com.xx.demo.model.pojo.Appdownload;

//###########################客户信息管理表############################
public interface AppdownloadsDao {
	Long countAppdownloadsByCondition(Map<String, Object> condition);

	public List<Appdownload> getAppdownloadListByCondition(
			Map<String, Object> condition);
	
	public List<Appdownload> getAllAppdownloads();
	
	Appdownload getAppdownloadById(Long id);

}
