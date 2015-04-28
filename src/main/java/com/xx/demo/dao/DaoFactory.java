package com.xx.demo.dao;

import com.alonew.db.dao.CommonDAO;
import com.xx.demo.dao.impl.AppdownloadsDaoImpl;
import com.xx.demo.dao.impl.CartesDaoImpl;
import com.xx.demo.dao.impl.ClassessDaoImpl;
import com.xx.demo.dao.impl.DiningtablesDaoImpl;
import com.xx.demo.dao.impl.FoodevaluationsDaoImpl;
import com.xx.demo.dao.impl.FoodshopsDaoImpl;
import com.xx.demo.dao.impl.GuinformationsDaoImpl;
import com.xx.demo.dao.impl.ImgtransmissionsDaoImpl;
import com.xx.demo.dao.impl.IndentsDaoImpl;
import com.xx.demo.dao.impl.LoginDaoImpl;
import com.xx.demo.dao.impl.ManagersInfDaoImpl;
import com.xx.demo.dao.impl.RedisDAOImpl;
import com.xx.demo.dao.impl.SubscribesDaoImpl;
import com.xx.demo.dao.impl.WordsCatDaoImpl;

public class DaoFactory {

// ##########################CommonDAO###########################	
    private static volatile CommonDAO      common;
    
	public static CommonDAO getCommon() {

        if (common == null) {
            synchronized (SessionCommonDAO.class) {
                if (common == null) {
                    common = new SessionCommonDAO();
                }
            }
        }
        return common;
    }
	
// #########################管理员信息表###########################
    private static volatile ManagersInfDao managersInfDao;

    public static ManagersInfDao getManagersInfDao() {
        if (managersInfDao == null) {
            synchronized (ManagersInfDaoImpl.class) {
                managersInfDao = new ManagersInfDaoImpl();
            }
        }
        return managersInfDao;
    }

 // #########################菜单表###############################
    private static volatile CartesDao cartesDao;
    
    public static CartesDao getCartesDao() {
        if (cartesDao == null) {
            synchronized (CartesDaoImpl.class) {
            	cartesDao = new CartesDaoImpl();
            }
        }
        return cartesDao;
    }
    
 // ##############################桌面表################################
    private static volatile DiningtablesDao diningtablesDao;
    
    public static DiningtablesDao getDiningtablesDao() {
        if (diningtablesDao == null) {
            synchronized (DiningtablesDaoImpl.class) {
            	diningtablesDao = new DiningtablesDaoImpl();
            }
        }
        return diningtablesDao;
    }
    
 // ###########################客户信息管理表############################
    private static volatile GuinformationsDao guinformationsDao;

    public static GuinformationsDao getGuinformationsDao() {
        if (guinformationsDao == null) {
            synchronized (GuinformationsDaoImpl.class) {
                guinformationsDao = new GuinformationsDaoImpl();
            }
        }
        return guinformationsDao;
    }
    
 // ############################订单信息表###############################
    private static volatile IndentsDao indentsDao;

    public static IndentsDao getIndentsDao() {
        if (indentsDao == null) {
            synchronized (IndentsDaoImpl.class) {
                indentsDao = new IndentsDaoImpl();
            }
        }
        return indentsDao;
    }
    
    // ############################订单信息表###############################
    private static volatile SubscribesDao subscribesDao;

    public static SubscribesDao getSubscribesDao() {
        if (subscribesDao == null) {
            synchronized (SubscribesDaoImpl.class) {
                subscribesDao = new SubscribesDaoImpl();
            }
        }
        return subscribesDao;
    }
    
    
 // ############################登陆Dao###############################
    private static volatile LoginDao loginDao;

    public static LoginDao getLoginDao() {
        if (loginDao == null) {
            synchronized (LoginDaoImpl.class) {
                loginDao = new LoginDaoImpl();
            }
        }
        return loginDao;
    }

 // ##########################系统签名分类表###########################    
    private static volatile WordsCatDao wordsCatDao;

    public static WordsCatDao getWordsCatDao() {
        if (wordsCatDao == null) {
            synchronized (WordsCatDaoImpl.class) {
                wordsCatDao = new WordsCatDaoImpl();
            }
        }
        return wordsCatDao;
    }
    
 // ############################RedisDAO###############################       
    private static volatile RedisDAO redisDAO;
    
   	public static RedisDAO getRedisDAO() {
   		if (redisDAO == null){
   			synchronized (RedisDAO.class) {
   				if (redisDAO == null) {
   					redisDAO = new RedisDAOImpl();
   				}
   			}
   		}
   		return redisDAO;
   	}
   	
 // #############################类别表##################################
    private static volatile ClassessDao classessDao;

    public static ClassessDao getClassessDao() {
        if (classessDao == null) {
            synchronized (ClassessDaoImpl.class) {
                classessDao = new ClassessDaoImpl();
            }
        }
        return classessDao;
    }
    
 // #############################餐饮店表################################
    private static volatile FoodshopsDao foodshopsDao;

    public static FoodshopsDao getFoodshopsDao() {
        if (foodshopsDao == null) {
            synchronized (FoodshopsDaoImpl.class) {
                foodshopsDao = new FoodshopsDaoImpl();
            }
        }
        return foodshopsDao;
    }

 // ###########################客户信息管理表############################
    private static volatile FoodevaluationsDao foodevaluationsDao;

    public static FoodevaluationsDao getFoodevaluationsDao() {
        if (foodevaluationsDao == null) {
            synchronized (FoodevaluationsDaoImpl.class) {
                foodevaluationsDao = new FoodevaluationsDaoImpl();
            }
        }
        return foodevaluationsDao;
    }
    
 // ###########################Appdownload管理表############################
    private static volatile AppdownloadsDao appdownloadsDao;

    public static AppdownloadsDao getAppdownloadsDao() {
        if (appdownloadsDao == null) {
            synchronized (AppdownloadsDaoImpl.class) {
                appdownloadsDao = new AppdownloadsDaoImpl();
            }
        }
        return appdownloadsDao;
    }
    
 // ###########################图片管理表############################
    private static volatile ImgtransmissionsDao imgtransmissionsDao;

    public static ImgtransmissionsDao getImgtransmissionsDao() {
        if (imgtransmissionsDao == null) {
            synchronized (ImgtransmissionsDaoImpl.class) {
                imgtransmissionsDao = new ImgtransmissionsDaoImpl();
            }
        }
        return imgtransmissionsDao;
    }
    
}
