package com.xx.demo.web.action;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

import com.alonew.core.commons.tuple.TwoTuple;
import com.alonew.core.web.annotation.PostCheck;
import com.xx.demo.common.utils.HttpUtil;

public class createIndentsActionTest {
	@Test
	@PostCheck
	public void testIndentsByCondition() {
        Map<String, String> params = new HashMap<String, String>();
        params.put("orderField", "indentno");
        params.put("orderDirection", "asc");//升序asc	降序desc
        
        params.put("indentno", "003");
        params.put("indentstate", "003");
        params.put("dtno", "003");
        params.put("carteno", "carteno003");
        params.put("pricsum","3212");
        params.put("indentnote","我不要菜");
        
        TwoTuple<Integer, String> result = HttpUtil.sendHTTPByPost(
                "http://127.0.0.1:8080/demo/indents/getcreateIndentsByCondition", params, null);
        System.out.println(result.getSecond());
        
    //如果收到信息中没有guuser和gupwd表示账号不存在或者密码为空
	}
	
	
}
