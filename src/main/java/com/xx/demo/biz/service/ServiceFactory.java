package com.xx.demo.biz.service;

import com.xx.demo.biz.service.impl.CartesServiceImpl;
import com.xx.demo.biz.service.impl.DiningtablesServiceImpl;
import com.xx.demo.biz.service.impl.FoodevaluationsServiceImpl;
import com.xx.demo.biz.service.impl.GuinformationsServiceImpl;
import com.xx.demo.biz.service.impl.IndentsServiceImpl;
import com.xx.demo.biz.service.impl.SubscribesServiceImpl;


public class ServiceFactory {

    private static volatile GuinformationsService guinformationsService;

    public static GuinformationsService getGuinformationsService() {
        if (guinformationsService == null) {
            synchronized (GuinformationsServiceImpl.class) {
                if (guinformationsService == null) {
                	guinformationsService = new GuinformationsServiceImpl();
                }
            }
        }
        return guinformationsService;
    }
    
    private static volatile CartesService cartesService;

    public static CartesService getCartesService() {
        if (cartesService == null) {
            synchronized (CartesServiceImpl.class) {
                if (cartesService == null) {
                	cartesService = new CartesServiceImpl();
                }
            }
        }
        return cartesService;
    }
    
    private static volatile FoodevaluationsService foodevaluationsService;

    public static FoodevaluationsService getFoodevaluationsService() {
        if (foodevaluationsService == null) {
            synchronized (FoodevaluationsServiceImpl.class) {
                if (foodevaluationsService == null) {
                	foodevaluationsService = new FoodevaluationsServiceImpl();
                }
            }
        }
        return foodevaluationsService;
    }
    
    private static volatile DiningtablesService diningtablesService;

    public static DiningtablesService getDiningtablesService() {
        if (diningtablesService == null) {
            synchronized (DiningtablesServiceImpl.class) {
                if (diningtablesService == null) {
                	diningtablesService = new DiningtablesServiceImpl();
                }
            }
        }
        return diningtablesService;
    }
    
    
    
    private static volatile IndentsService indentsService;

    public static IndentsService getIndentsService() {
        if (indentsService == null) {
            synchronized (IndentsServiceImpl.class) {
                if (indentsService == null) {
                	indentsService = new IndentsServiceImpl();
                }
            }
        }
        return indentsService;
    }

    private static volatile SubscribesService subscribesService;

    public static SubscribesService getSubscribesService() {
        if (subscribesService == null) {
            synchronized (SubscribesServiceImpl.class) {
                if (subscribesService == null) {
                	subscribesService = new SubscribesServiceImpl();
                }
            }
        }
        return subscribesService;
    }
}
