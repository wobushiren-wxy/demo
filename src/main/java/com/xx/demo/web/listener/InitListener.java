package com.xx.demo.web.listener;


import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import com.alonew.core.commons.newstore.StoreManager;
import com.alonew.core.commons.util.CommonUtil;


public class InitListener implements ServletContextListener {

	
	public void contextDestroyed(ServletContextEvent sce) {

	}
    
	
	public void contextInitialized(ServletContextEvent sce) {
		System.out.println("InitListener@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@\t");
//		System.setProperty(StoreManager.PROJECT_NAME, sce.getServletContext().getContextPath());
		CommonUtil.setProperty(StoreManager.PROJECT_NAME, sce.getServletContext().getContextPath());
//		LogicFactory.getWeatherLogic().list();
		System.out.println("InitListener@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@\t");

	}
	

}
