package com.xx.demo.web.action;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

import com.alonew.core.commons.tuple.TwoTuple;
import com.alonew.core.web.annotation.PostCheck;
import com.xx.demo.common.utils.HttpUtil;

public class createGuinformationsActionTest {
	@Test
	@PostCheck
	public void testGetGuinformationsByCondition() {
        Map<String, String> params = new HashMap<String, String>();
        params.put("guuser", "yuydfafduyyq23");
        params.put("gupwd", "43sfda2sd");
        params.put("guname", "0ssf0fs2");
        params.put("guphone", "f0sad02");
        
        
        TwoTuple<Integer, String> result = HttpUtil.sendHTTPByPost(
                "http://127.0.0.1:8080/demo/guinformations/getcreateGuinformationsByCondition", params, null);
        System.out.println(result.getSecond());
    //如果收到信息中没有guuser和gupwd表示账号不存在或者密码为空
	}
}
