package com.xx.demo.biz.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.xx.demo.biz.logic.LogicFactory;
import com.xx.demo.biz.service.GuinformationsService;
import com.xx.demo.common.utils.LoggerManager;
import com.xx.demo.model.enums.ErrorCode;
import com.xx.demo.model.pojo.Guinformation;
import com.xx.demo.model.resp.BaseRes;
import com.xx.demo.model.resp.GuinformationRes;

public class GuinformationsServiceImpl implements GuinformationsService {

	
	@Override
	public BaseRes createGuinformation(GuinformationRes guinformationRes) {
		try {	
			//将GuinformationRes的数据导入Guinformation
			Guinformation guinformation = new Guinformation(
					guinformationRes.getGuuser(), guinformationRes.getGupwd() ,
					guinformationRes.getGuname() ,guinformationRes.getGuphone(),
					null, null, null, null , null);

			Map<String, Object> condition = new HashMap<String, Object>();
			
			condition.put("guuser", guinformationRes.getGuuser());
			Long count = LogicFactory.getGuinformationsLogic()
					.countGuinformationsByConditionAtguuser(condition);
			if (count > 0) {
				//"###订单号已存在，请更改订单号###"
				return new BaseRes(ErrorCode.OK, "添加失败，用户名已存在");
			}
			guinformation.setGutime(new Date());
			LogicFactory.getGuinformationsLogic().createGuinformation(guinformation);
			//"添加成功"
			
			// TODO Auto-generated method stub
			return new BaseRes(ErrorCode.OK,"成功");
			
		} catch (Exception e) {
			LoggerManager.def.error("sortDownloadWords errors:",e);
			return new BaseRes(ErrorCode.SYSTEM_ERROR);
		}
	}
	
	@Override
	public BaseRes getGuinformationsByCondition(Map<String, Object> condition) {
		try {
			List<Guinformation> guinfoList = LogicFactory.getGuinformationsLogic().
					getGuinformationListByCondition(condition);
			List<GuinformationRes> guinfoResList = new ArrayList<GuinformationRes>();
			for (Guinformation guinfo : guinfoList) {
				GuinformationRes GuinformationRes = new GuinformationRes(guinfo.getId(), 
						guinfo.getGuuser(), guinfo.getGupwd());
				guinfoResList.add(GuinformationRes);
			}
			return new BaseRes(ErrorCode.OK, guinfoResList);
		} catch (Exception e) {
			LoggerManager.def.error("sortDownloadWords errors:",e);
			return new BaseRes(ErrorCode.SYSTEM_ERROR);
		}
	}

	@Override
	public BaseRes getLoginGuinformationsByCondition(Map<String, Object> condition) {
		try{
			List<Guinformation> guinfoList = LogicFactory.getGuinformationsLogic().
					getGuinformationListByCondition(condition);
			List<GuinformationRes> guinfoResList = new ArrayList<GuinformationRes>();
			for (Guinformation guinfo : guinfoList) {
				GuinformationRes GuinformationRes = new GuinformationRes(guinfo.getId(), 
						guinfo.getGuuser(), guinfo.getGupwd());
				//这里应该获取condition 放入要用来验证的user
				if(guinfo.getGuuser().equals(condition.get("guuser"))){
					guinfoResList.add(GuinformationRes);
				}
			}
			return new BaseRes(ErrorCode.OK, guinfoResList);
		} catch (Exception e) {
			LoggerManager.def.error("sortDownloadWords errors:",e);
			return new BaseRes(ErrorCode.SYSTEM_ERROR);
		}
	}

	
}
