package com.xx.demo.web.action;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

import com.alonew.core.commons.tuple.TwoTuple;
import com.alonew.core.web.annotation.PostCheck;
import com.xx.demo.common.utils.HttpUtil;

public class DiningtablesActionTest {
	@Test
	@PostCheck
	public void testGetGuinformationsByCondition() {
        Map<String, String> params = new HashMap<String, String>();
        
        params.put("retNums", "10");
        params.put("orderField", "dtno");
        params.put("orderDirection", "asc");//升序asc	降序desc

        TwoTuple<Integer, String> result = HttpUtil.sendHTTPByPost(
                "http://127.0.0.1:8080/demo/diningtables/getDiningtablesByCondition", params, null);
        System.out.println(result.getSecond());
    //如果收到信息中没有guuser和gupwd表示账号不存在或者密码为空
	}
}
