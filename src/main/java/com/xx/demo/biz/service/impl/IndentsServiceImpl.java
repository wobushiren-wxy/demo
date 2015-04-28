package com.xx.demo.biz.service.impl;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import com.xx.demo.biz.logic.LogicFactory;
import com.xx.demo.biz.service.IndentsService;
import com.xx.demo.common.utils.LoggerManager;
import com.xx.demo.model.enums.ErrorCode;
import com.xx.demo.model.pojo.Indent;
import com.xx.demo.model.resp.BaseRes;
import com.xx.demo.model.resp.IndentRes;

public class IndentsServiceImpl implements IndentsService {

	
	@Override
	public BaseRes deleteIndent(String indentno) {
		try {	
			
			if (indentno == null) {
				return new BaseRes(ErrorCode.OK,"删除对象不存在");
			}

			LogicFactory.getIndentsLogic().deleteIndentByIndentNo(indentno);
			return new BaseRes(ErrorCode.OK,"删除成功");
			
		} catch (Exception e) {
			LoggerManager.def.error("sortDownloadWords errors:",e);
			return new BaseRes(ErrorCode.SYSTEM_ERROR);
		}
	}
	
	@Override
	public BaseRes createIndent(IndentRes indentRes){
		try {	
			//将IndentRes的数据导入Indent
			Indent indent = new Indent(indentRes.getIndentno(), 
					indentRes.getIndentstate(),indentRes.getDtno(),indentRes.getCarteno(), 
					indentRes.getPricsum(), null, indentRes.getIndentnote());

			Map<String, Object> condition = new HashMap<String, Object>();
			
			condition.put("indentno", indentRes.getIndentno());
			Long count = LogicFactory.getIndentsLogic()
					.countIndentsByCondition(condition);
			if (count > 0) {
				//"###订单号已存在，请更改订单号###"
				return new BaseRes(ErrorCode.OK, "添加失败，订单号已存在");
			}
			indent.setIndenttime(new Date());
			LogicFactory.getIndentsLogic().createIndent(indent);
			//"添加成功"
			
			// TODO Auto-generated method stub
			return new BaseRes(ErrorCode.OK,"成功");
			
			
		} catch (Exception e) {
			LoggerManager.def.error("sortDownloadWords errors:",e);
			return new BaseRes(ErrorCode.SYSTEM_ERROR);
		}
			
	}
	@Override
	public BaseRes getIndentsByCondition(Map<String, Object> condition) {
		/*try {
			
			
			
			Long count = LogicFactory.getIndentsLogic()
					.countIndentsByCondition(condition);
			if (count > 0) {
				//###订单号已存在，请更改订单号###
			}
			
			
			List<Indent> indeList = LogicFactory.getIndentsLogic().
					getIndentListByCondition(condition);
			List<IndentRes> indeResList = new ArrayList<IndentRes>();
			for (Indent inde : indeList) {
					
				IndentRes IndentRes = new IndentRes(inde.getId(), 
						inde.getIndentstate(),inde.getIndentnote(),
						inde.getDtno(),inde.getCarteno(),
						inde.getPricsum(),inde.getIndentno());
				indeResList.add(IndentRes);
				
			}
			return new BaseRes(ErrorCode.OK, indeResList);
		} catch (Exception e) {
			LoggerManager.def.error("sortDownloadWords errors:",e);
			return new BaseRes(ErrorCode.SYSTEM_ERROR);
		}*/
		return null;
	}
	

	

}
