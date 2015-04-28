package com.xx.demo.biz.service.impl;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import com.xx.demo.biz.logic.LogicFactory;
import com.xx.demo.biz.service.SubscribesService;
import com.xx.demo.common.utils.LoggerManager;
import com.xx.demo.model.enums.ErrorCode;
import com.xx.demo.model.pojo.Subscribe;
import com.xx.demo.model.resp.BaseRes;
import com.xx.demo.model.resp.SubscribeRes;

public class SubscribesServiceImpl implements SubscribesService {

	
	
	@Override
	public BaseRes createSubscribe(SubscribeRes subscribeRes){
		try {	
			//将SubscribeRes的数据导入Subscribe
			Subscribe subscribe = new Subscribe(
					subscribeRes.getSubno(),subscribeRes.getSubtime(),
					subscribeRes.getGuuser(),subscribeRes.getSubnums(), 
					null, null);

			Map<String, Object> condition = new HashMap<String, Object>();
			
			condition.put("subno", subscribeRes.getSubno());
/*			Long count = LogicFactory.getSubscribesLogic()
					.countSubscribesByCondition(condition);
			if (count > 0) {
				//"###订单号已存在，请更改订单号###"
				return new BaseRes(ErrorCode.OK, "添加失败，订单号已存在");
			}*/
			subscribe.setSubcreattime(new Date());
			LogicFactory.getSubscribesLogic().createSubscribe(subscribe);
			//"添加成功"
			
			// TODO Auto-generated method stub
			return new BaseRes(ErrorCode.OK,"成功");
			
			
		} catch (Exception e) {
			LoggerManager.def.error("sortDownloadWords errors:",e);
			return new BaseRes(ErrorCode.SYSTEM_ERROR);
		}
			
	}
	

}
