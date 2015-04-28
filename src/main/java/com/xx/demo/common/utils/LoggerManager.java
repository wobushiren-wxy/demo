package com.xx.demo.common.utils;

import org.apache.log4j.Logger;

public class LoggerManager {
	
	/**
     * 通用设置log
     */
    public static final Logger def  = Logger.getLogger("default");

    /**
     * 用户设置log
     */
    public static final Logger user  = Logger.getLogger("user");

    /**
     * 主题相关log
     */
    public static final Logger theme  = Logger.getLogger("theme");

    /**
     * 查询log
     */
    public static final Logger query = Logger.getLogger("query");

    /**
     * 交易相关log
     */
    public static final Logger trade  = Logger.getLogger("trade");

    /**
     * 钱包账户相关log
     */
    public static final Logger wallet  = Logger.getLogger("wallet");

    /**
     * 错误日志
     */
    public static final Logger error = Logger.getLogger("error");

    /**
     * 统计数 相关日志
     */
    public static final Logger downloadCount = Logger.getLogger("downloadCount");
}
