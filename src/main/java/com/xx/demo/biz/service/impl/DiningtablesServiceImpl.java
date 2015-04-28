package com.xx.demo.biz.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.xx.demo.biz.logic.LogicFactory;
import com.xx.demo.biz.service.DiningtablesService;
import com.xx.demo.common.utils.LoggerManager;
import com.xx.demo.dao.DaoFactory;
import com.xx.demo.model.enums.ErrorCode;
import com.xx.demo.model.pojo.Diningtable;
import com.xx.demo.model.pojo.ManagerInf;
import com.xx.demo.model.resp.BaseRes;
import com.xx.demo.model.resp.DiningtableRes;


public class DiningtablesServiceImpl implements DiningtablesService {

	@Override
	public BaseRes getDiningtablesByCondition(Map<String, Object> condition) {
		try {
			List<Diningtable> dinList = LogicFactory.getDiningtablesLogic().getDiningtableListByCondition(condition);
			List<DiningtableRes> dinResList = new ArrayList<DiningtableRes>();
			for (Diningtable din : dinList) {
				DiningtableRes DiningtableRes = new DiningtableRes(din.getDtno(), din.getDtname());
				dinResList.add(DiningtableRes);
			}
			return new BaseRes(ErrorCode.OK, dinResList);
		} catch (Exception e) {
			LoggerManager.def.error("sortDownloadWords errors:",e);
			return new BaseRes(ErrorCode.SYSTEM_ERROR);
		}
	}

	@Override
	
	public BaseRes updateDiningtables(DiningtableRes diningtableRes) {
		
		try {
			
			Diningtable diningtable = new Diningtable(diningtableRes.getDtno(),
					diningtableRes.getDtname(), diningtableRes.getDtnote()
					);
			
			Map<String, Object> condition = new HashMap<String, Object>();
			condition.put("dtno", diningtableRes.getDtno());
			
			Diningtable diningtablewxy = LogicFactory.getDiningtablesLogic().getDiningtableByCondition(condition);
			
			diningtable.setId(diningtablewxy.getId());
			
			//通过对象进行修改
			LogicFactory.getDiningtablesLogic().updateDiningtable(diningtable);
			return new BaseRes(ErrorCode.OK, "修改成功");
			
		}catch (Exception e) {
			LoggerManager.def.error("sortDownloadWords errors:",e);
			return new BaseRes(ErrorCode.SYSTEM_ERROR);
		}
	}
}
