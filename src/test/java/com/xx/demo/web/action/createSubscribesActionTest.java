package com.xx.demo.web.action;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

import com.alonew.core.commons.tuple.TwoTuple;
import com.alonew.core.web.annotation.PostCheck;
import com.xx.demo.common.utils.HttpUtil;

public class createSubscribesActionTest {
	@Test
	@PostCheck
	public void testSubscribesByCondition() {
        Map<String, String> params = new HashMap<String, String>();
    
        params.put("subno", "003");
        params.put("subtime", "003");
        params.put("guuser", "003");
        params.put("subnums", "3");
        
        TwoTuple<Integer, String> result = HttpUtil.sendHTTPByPost(
                "http://127.0.0.1:8080/demo/subscribes/getcreateSubscribesByCondition", params, null);
        System.out.println(result.getSecond());
        
	}
	
	
}
