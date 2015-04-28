package com.xx.demo.common.utils;

import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.httpclient.Cookie;
import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.cookie.CookiePolicy;
import org.apache.commons.httpclient.methods.GetMethod;
import org.apache.commons.httpclient.methods.PostMethod;

import com.alonew.core.commons.tuple.Tuple;
import com.alonew.core.commons.tuple.TwoTuple;
import com.google.gson.Gson;

public class HttpUtil {

    public static TwoTuple<Integer, String> sendHTTPByPost(String url, Map<String, String> params,
                                                           Cookie cookie) {
        HttpClient client = new HttpClient();
        PostMethod postMethod = new UTF8PostMethod(url);
        if (params != null) {
            for (Map.Entry<String, String> entry : params.entrySet()) {
                postMethod.addParameter(entry.getKey(), entry.getValue());
            }
        }

        try {
            int result = client.executeMethod(postMethod);
            return Tuple.tuple(result, postMethod.getResponseBodyAsString());
        } catch (Exception e) {
            LoggerManager.error.error("send by http post exception!", e);
        }
        return null;
    }

    public static TwoTuple<Integer, String> sendHTTPByGet(String url, Map<String, String> params,
                                                          Cookie cookie) {
        HttpClient client = new HttpClient();

        try {
            if (params != null) {
                url += "?";
                for (Map.Entry<String, String> entry : params.entrySet()) {
                    url += entry.getKey() + "=" + URLEncoder.encode(entry.getValue(), "utf-8");
                    url += "&";
                }
                url = url.substring(0, url.length() - 1);
            }
            GetMethod getMethod = new GetMethod(url);
            if (cookie != null) {
                client.getState().setCookiePolicy(CookiePolicy.COMPATIBILITY);
                client.getState().addCookie(cookie);
                //                getMethod.setRequestHeader("Cookie", cookie.toString());
            }

            int result = client.executeMethod(getMethod);
            return Tuple.tuple(result, getMethod.getResponseBodyAsString());
        } catch (Exception e) {
            LoggerManager.error.error("send by http get exception!", e);
        }
        return null;
    }

    public static TwoTuple<Integer, String> sendHTTPByPostBytes(String url, String body) {
        HttpClient client = new HttpClient();
        PostMethod postMethod = new UTF8PostMethod(url);
        postMethod.setRequestBody(body);
        postMethod.setRequestHeader("Content-type", "application/json");

        try {
            int result = client.executeMethod(postMethod);
            return Tuple.tuple(result, postMethod.getResponseBodyAsString());
        } catch (Exception e) {
            LoggerManager.error.error("send by http post exception!", e);
        }
        return null;
    }

    public static TwoTuple<Integer, String> sendHTTPByPostWithHeader(String url,
                                                                     Map<String, String> params,
                                                                     Map<String, String> headerMap) {
        HttpClient client = new HttpClient();
        PostMethod postMethod = new UTF8PostMethod(url);

        if (headerMap != null) {
            for (Map.Entry<String, String> entry : headerMap.entrySet()) {
                postMethod.setRequestHeader(entry.getKey(), entry.getValue());
            }
        }

        if (params != null) {
            for (Map.Entry<String, String> entry : params.entrySet()) {
                postMethod.addParameter(entry.getKey(), entry.getValue());
            }
        }

        try {
            int result = client.executeMethod(postMethod);
            return Tuple.tuple(result, postMethod.getResponseBodyAsString());
        } catch (Exception e) {
            LoggerManager.error.error("send by http post exception!", e);
        }
        return null;
    }

    public static void main(String[] args) {

        Gson gson = new Gson();
        Map<String, String> params = new HashMap<String, String>();

        // 注册

        //        params.put("token", "150e392e4e9c3514de7669a4dbd983cb_1395732916172");

        //        param.put(
        //                "param",
        //                "{'mcategorydata':[{'oringe':'测试分类','modify':'新分类4'}]}");

        //        param.put(
        //                "param",
        //                "{'mcategorydata':[{'oringe':'我的分类','modify':'测试分类'},{'oringe':'','modify':'天上人间'}],'mpnamedata':[{'pn':'com.TravelTogether.android','belong':'休闲娱乐'},{'pn':'com.danqoo.shangwu','belong':'我的分类'}]}");
        //        param.put(
        //                "param",
        //                "{'mpnamedata':[{'pn':'com.TravelTogether.android','belong':'天上人间'},{'pn':'com.danqoo.shangwu','belong':'通讯'}]}");

        //        param.put(
        //                "param",
        //                "{'mpnamedata':[{'pn':'net.xsmile.game','belong':'游戏'},{'pn':'com.xianle.traffic_hefei','belong':'测试分类'}]}");

        //        params.put("param", "{'context':'水果大亨'}");

        //        param.put("param", "{'mcategory':'通讯'}");

        //        String json = "{'username':'test_user2','pw':'test_pw2','accounttype':'1','versionCode':'1','deviceId':'863336020186601'}";
        //        String json = "{'os':'1','devicevendor':'lenovo','devicemodel':'Lenovo S860','lang':'zh-CN','osversion':'4.2.2','osdkVersion':'17','resolution':'720*1280','density':'2.0','devicebrand':'lenovo','deviceId':'863336020186601','dpi':'320'}";

        //        TwoTuple<Integer, String> result = HttpUtil.sendHTTPByPostBytes(
        //                "http://127.0.0.1:8080/desktop/user/reportClientInfo", json);
        //        params.put("context", "水果大亨");
        //        params.put("packgename", "com.kh.headgps.android");
        TwoTuple<Integer, String> result = HttpUtil.sendHTTPByPostBytes(
                "http://127.0.0.1:8080/desktop/default/getClassficationInfo", gson.toJson(params));
        System.out.println(result.getSecond());

    }
}
