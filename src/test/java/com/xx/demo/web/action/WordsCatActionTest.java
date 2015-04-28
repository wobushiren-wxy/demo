package com.xx.demo.web.action;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

import com.alonew.core.commons.tuple.TwoTuple;
import com.alonew.core.web.annotation.PostCheck;
import com.xx.demo.common.utils.HttpUtil;

public class WordsCatActionTest {
	@Test
	@PostCheck
	public void testGetWordsCatByCondition() {
        Map<String, String> params = new HashMap<String, String>();
        params.put("retNums", "2");
        params.put("orderField", "addtime");
        params.put("orderDirection", "asc");
        TwoTuple<Integer, String> result = HttpUtil.sendHTTPByPost(
                "http://127.0.0.1:8080/demo/wordsCat/getWordsCatByCondition", params, null);
        System.out.println(result.getSecond());
    }
}
