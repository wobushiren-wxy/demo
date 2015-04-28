package com.xx.demo.web.action;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

import com.alonew.core.commons.tuple.TwoTuple;
import com.alonew.core.web.annotation.PostCheck;
import com.xx.demo.common.utils.HttpUtil;

public class updateDiningtablesActionTest {
	@Test
	@PostCheck
	public void testGetGuinformationsByCondition() {
        Map<String, String> params = new HashMap<String, String>();
        
        params.put("orderField", "indentno");
        params.put("orderDirection", "asc");//升序asc	降序desc
        
        params.put("dtno", "002");
        params.put("dtname", "2");

        TwoTuple<Integer, String> result = HttpUtil.sendHTTPByPost(
                "http://127.0.0.1:8080/demo/diningtables/updateDiningtables", params, null);
        System.out.println(result.getSecond());
    //如果收到信息中没有guuser和gupwd表示账号不存在或者密码为空
	}
}
