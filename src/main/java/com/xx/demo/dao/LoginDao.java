package com.xx.demo.dao;

import java.util.Map;
import com.xx.demo.model.pojo.Guinformation;
import com.xx.demo.model.pojo.ManagerInf;


// ############################登陆Dao###############################
public interface LoginDao {
	//后台登陆
	public ManagerInf getManagerInfByMiuser(Map<String, Object> condition);
	
	//客户端登陆
	public Guinformation getGuinformationByMiuser(Map<String, Object> condition);
}
