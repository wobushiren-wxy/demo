package com.xx.demo.web.action;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

import com.alonew.core.commons.tuple.TwoTuple;
import com.alonew.core.web.annotation.PostCheck;
import com.xx.demo.common.utils.HttpUtil;

public class CartesActionTest {
	@Test
	@PostCheck
	public void testGetCartesByCondition() {
        Map<String, String> params = new HashMap<String, String>();
        params.put("start", "0");	//从第0个开始
        params.put("retNums", "10");	//0号开始后面10个。
        params.put("orderField", "carteno");
        params.put("orderDirection", "asc");
        TwoTuple<Integer, String> result = HttpUtil.sendHTTPByPost(
                "http://127.0.0.1:8080/demo/cartes/getCartesByCondition", params, null);
        System.out.println(result.getSecond());
    }
}
