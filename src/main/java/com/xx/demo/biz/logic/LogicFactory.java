package com.xx.demo.biz.logic;

import com.xx.demo.biz.logic.impl.AppdownloadsLogicImpl;
import com.xx.demo.biz.logic.impl.CartesLogicImpl;
import com.xx.demo.biz.logic.impl.ClassessLogicImpl;
import com.xx.demo.biz.logic.impl.DiningtablesLogicImpl;
import com.xx.demo.biz.logic.impl.FoodevaluationsLogicImpl;
import com.xx.demo.biz.logic.impl.FoodshopsLogicImpl;
import com.xx.demo.biz.logic.impl.GuinformationsLogicImpl;
import com.xx.demo.biz.logic.impl.ImgtransmissionsLogicImpl;
import com.xx.demo.biz.logic.impl.IndentsLogicImpl;
import com.xx.demo.biz.logic.impl.ManagersInfLogicImpl;
import com.xx.demo.biz.logic.impl.SubscribesLogicImpl;
public class LogicFactory {

// ###########################管理员信息表#############################
    private static volatile ManagersInfLogic managersInfLogic;

    public static ManagersInfLogic getManagersInfLogic() {
        if (managersInfLogic == null) {
        	//synchronized用加锁，同一时刻最多只有一个线程执行这个段代码
            synchronized (ManagersInfLogicImpl.class) {
                if (managersInfLogic == null) {
                	managersInfLogic = new ManagersInfLogicImpl();
                }
            }
        }
        return managersInfLogic;
    }
    
// ###########################客户信息管理表############################
    private static volatile GuinformationsLogic guinformationsLogic;

    public static GuinformationsLogic getGuinformationsLogic() {
        if (guinformationsLogic == null) {
        	//synchronized用加锁，同一时刻最多只有一个线程执行这个段代码
            synchronized (GuinformationsLogicImpl.class) {
                if (guinformationsLogic == null) {
                	guinformationsLogic = new GuinformationsLogicImpl();
                }
            }
        }
        return guinformationsLogic;
    }
    
// ############################订单信息表###############################
    private static volatile IndentsLogic indentsLogic;

    public static IndentsLogic getIndentsLogic() {
        if (indentsLogic == null) {
        	//synchronized用加锁，同一时刻最多只有一个线程执行这个段代码
            synchronized (IndentsLogicImpl.class) {
                if (indentsLogic == null) {
                	indentsLogic = new IndentsLogicImpl();
                }
            }
        }
        return indentsLogic;
    }
    
 // ############################订单信息表###############################
    private static volatile SubscribesLogic subscribesLogic;

    public static SubscribesLogic getSubscribesLogic() {
        if (subscribesLogic == null) {
        	//synchronized用加锁，同一时刻最多只有一个线程执行这个段代码
            synchronized (SubscribesLogicImpl.class) {
                if (subscribesLogic == null) {
                	subscribesLogic = new SubscribesLogicImpl();
                }
            }
        }
        return subscribesLogic;
    }
    
// #############################类别表##################################
    private static volatile ClassessLogic classessLogic;

    public static ClassessLogic getClassessLogic() {
        if (classessLogic == null) {
        	//synchronized用加锁，同一时刻最多只有一个线程执行这个段代码
            synchronized (ClassessLogicImpl.class) {
                if (classessLogic == null) {
                	classessLogic = new ClassessLogicImpl();
                }
            }
        }
        return classessLogic;
    }
    
 // ##############################桌面表################################
    private static volatile DiningtablesLogic diningtablesLogic;

    public static DiningtablesLogic getDiningtablesLogic() {
        if (diningtablesLogic == null) {
        	//synchronized用加锁，同一时刻最多只有一个线程执行这个段代码
            synchronized (DiningtablesLogicImpl.class) {
                if (diningtablesLogic == null) {
                	diningtablesLogic = new DiningtablesLogicImpl();
                }
            }
        }
        return diningtablesLogic;
    }
    
// #############################菜单表###################################
    private static volatile CartesLogic cartesLogic;

    public static CartesLogic getCartesLogic() {
        if (cartesLogic == null) {
        	//synchronized用加锁，同一时刻最多只有一个线程执行这个段代码
            synchronized (CartesLogicImpl.class) {
                if (cartesLogic == null) {
                	cartesLogic = new CartesLogicImpl();
                }
            }
        }
        return cartesLogic;
    }
    
 // #############################餐饮店表################################
    private static volatile FoodshopsLogic foodshopsLogic;

    public static FoodshopsLogic getFoodshopsLogic() {
        if (foodshopsLogic == null) {
        	//synchronized用加锁，同一时刻最多只有一个线程执行这个段代码
            synchronized (FoodshopsLogicImpl.class) {
                if (foodshopsLogic == null) {
                	foodshopsLogic = new FoodshopsLogicImpl();
                }
            }
        }
        return foodshopsLogic;
    }
    
 // ###########################菜评管理############################
    private static volatile FoodevaluationsLogic foodevaluationsLogic;

    public static FoodevaluationsLogic getFoodevaluationsLogic() {
        if (foodevaluationsLogic == null) {
        	//synchronized用加锁，同一时刻最多只有一个线程执行这个段代码
            synchronized (FoodevaluationsLogicImpl.class) {
                if (foodevaluationsLogic == null) {
                	foodevaluationsLogic = new FoodevaluationsLogicImpl();
                }
            }
        }
        return foodevaluationsLogic;
    }
    
 // ###########################App上传下载管理############################
    private static volatile AppdownloadsLogic appdownloadsLogic;

    public static AppdownloadsLogic getAppdownloadsLogic() {
        if (appdownloadsLogic == null) {
        	//synchronized用加锁，同一时刻最多只有一个线程执行这个段代码
            synchronized (AppdownloadsLogicImpl.class) {
                if (appdownloadsLogic == null) {
                	appdownloadsLogic = new AppdownloadsLogicImpl();
                }
            }
        }
        return appdownloadsLogic;
    }
    
 // ###########################	图片管理表############################
    private static volatile ImgtransmissionsLogic imgtransmissionsLogic;

    public static ImgtransmissionsLogic getImgtransmissionsLogic() {
        if (imgtransmissionsLogic == null) {
        	//synchronized用加锁，同一时刻最多只有一个线程执行这个段代码
            synchronized (ImgtransmissionsLogicImpl.class) {
                if (imgtransmissionsLogic == null) {
                	imgtransmissionsLogic = new ImgtransmissionsLogicImpl();
                }
            }
        }
        return imgtransmissionsLogic;
    }
    
}
