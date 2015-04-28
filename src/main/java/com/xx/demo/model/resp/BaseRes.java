package com.xx.demo.model.resp;

import java.util.List;

import com.xx.demo.model.enums.ErrorCode;

public class BaseRes {

	private int    result;
    private String msg;
    private String bizCode;
    private String staticUrl;
    private Long   timestamp;
    private Object data;
    @SuppressWarnings("rawtypes")
    private List   dataList;

    public BaseRes() {
        super();
    }

    public BaseRes(int result, String msg) {
        super();
        this.result = result;
        this.msg = msg;
    }

    public BaseRes(int result, String msg, String bizCode) {
        super();
        this.result = result;
        this.msg = msg;
        this.bizCode = bizCode;
    }

    public BaseRes(ErrorCode errorCode) {
        super();
        this.result = errorCode.getResult();
        this.msg = errorCode.getMsg();
    }

    public BaseRes(ErrorCode errorCode, String bizCode) {
        super();
        this.result = errorCode.getResult();
        this.msg = errorCode.getMsg();
        this.bizCode = bizCode;
    }

    public BaseRes(ErrorCode errorCode, Object data) {
        super();
        this.result = errorCode.getResult();
        this.msg = errorCode.getMsg();
        this.data = data;
    }

    public BaseRes(ErrorCode errorCode, String bizCode, Object data) {
        super();
        this.result = errorCode.getResult();
        this.msg = errorCode.getMsg();
        this.bizCode = bizCode;
        this.data = data;
    }

    @SuppressWarnings("rawtypes")
    public BaseRes(ErrorCode errorCode, List dataList) {
        super();
        this.result = errorCode.getResult();
        this.msg = errorCode.getMsg();
        this.dataList = dataList;
    }

    @SuppressWarnings("rawtypes")
    public BaseRes(ErrorCode errorCode, String bizCode, List dataList) {
        super();
        this.result = errorCode.getResult();
        this.msg = errorCode.getMsg();
        this.bizCode = bizCode;
        this.dataList = dataList;
    }

    public int getResult() {
        return result;
    }

    public void setResult(int result) {
        this.result = result;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getBizCode() {
        return bizCode;
    }

    public void setBizCode(String bizCode) {
        this.bizCode = bizCode;
    }

    public Object getData() {
        return data;
    }

    public void setDate(Object data) {
        this.data = data;
    }

    @SuppressWarnings("rawtypes")
    public List getDataList() {
        return dataList;
    }

    @SuppressWarnings("rawtypes")
    public void setDataList(List dataList) {
        this.dataList = dataList;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public String getStaticUrl() {
        return staticUrl;
    }

    public void setStaticUrl(String staticUrl) {
        this.staticUrl = staticUrl;
    }

    public Long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Long timestamp) {
        this.timestamp = timestamp;
    }

}
