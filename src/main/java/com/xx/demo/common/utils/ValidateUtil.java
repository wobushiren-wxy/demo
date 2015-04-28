package com.xx.demo.common.utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.math.NumberUtils;

/**
 * 验证 Util
 * 
 * @author
 * 
 */

public class ValidateUtil {

    /**
     * 3-20个字
     * 
     * @param nickName
     * @return
     */
    public static boolean validateNickName(String nickName) {
        if (StringUtils.isBlank(nickName))
            return false;
        Pattern pattern = Pattern.compile("([\u4e00-\u9fa5]|\\w){3,20}");
        if (!pattern.matcher(nickName).matches())
            return false;
        return true;
    }

    public static boolean validateUserName(String userName) {
        if (StringUtils.isBlank(userName))
            return false;
        Pattern pattern = Pattern.compile("([\u4e00-\u9fa5]|\\w){2,20}");
        if (!pattern.matcher(userName).matches())
            return false;
        return true;
    }

    public static boolean validatePassword(String password) {
        if (StringUtils.isBlank(password))
            return false;
        Pattern pattern = Pattern.compile("\\w{6,20}");
        if (!pattern.matcher(password).matches())
            return false;
        return true;
    }

    /**
     * 是否是整数
     * @param str
     * @return
     */
    public static boolean isIntNum(String str){
    	if (StringUtils.isEmpty(str)) {
			return false;
		}
    	String regex = "[-]?[0-9]+";
    	Pattern pattern = Pattern.compile(regex);
    	Matcher matcher = pattern.matcher(str);
    	return matcher.matches(); //matcher.find();
    }
    
    /**
     * 正整数
     * @param str
     * @return
     */
    public static boolean isPositiveNum(String str){
    	return NumberUtils.isDigits(str);
    }
    
    /**
     * 是否是数字 (可以有小数)
     * @param str
     * @return
     */
    public static boolean isNumber(String str){
    	return NumberUtils.isNumber(str);
    }
    
}
