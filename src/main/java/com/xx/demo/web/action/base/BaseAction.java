package com.xx.demo.web.action.base;

import com.alonew.core.web.action.base.Struts2Action;

public abstract class BaseAction extends Struts2Action {

    private static final long serialVersionUID = 5993034141136072936L;

    protected String          sign;

    protected Boolean         isDebug;

    public String getSign() {
        return sign;
    }

    public void setSign(String sign) {
        this.sign = sign;
    }

    public Boolean getIsDebug() {
        return isDebug;
    }

    public void setIsDebug(Boolean isDebug) {
        this.isDebug = isDebug;
    }

}
