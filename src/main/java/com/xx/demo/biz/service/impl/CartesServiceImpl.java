package com.xx.demo.biz.service.impl;

import java.io.File;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import com.alonew.core.commons.util.TimeUtil;
import com.xx.demo.biz.logic.LogicFactory;
import com.xx.demo.biz.service.CartesService;
import com.xx.demo.common.utils.FileUtil;
import com.xx.demo.common.utils.KeyGen;
import com.xx.demo.common.utils.LoggerManager;
import com.xx.demo.model.enums.ErrorCode;
import com.xx.demo.model.pojo.Carte;
import com.xx.demo.model.resp.BaseRes;
import com.xx.demo.model.resp.CarteRes;


public class CartesServiceImpl implements CartesService {

	@Override
	public BaseRes getCartesByCondition(Map<String, Object> condition) {
		try {
			
			
			List<Carte> carList = LogicFactory.getCartesLogic().getCarteListByCondition(condition);
			List<CarteRes> carResList = new ArrayList<CarteRes>();
			for (Carte car : carList) {
				
				/*String dateStr = TimeUtil.format("yyyyMM", new Date());
			    String relativeDir = Constants.APK_RELATIVE_DIR + dateStr + "/" +  KeyGen.getShortKey() + "/" + getApkFileFileName();
			    File savefile = new File(Constants.STATIC_PATH, relativeDir);
				*/
				
			/*	String url = car.getCarteimgurl();\
				FileUtil file = new FileUtil();
				file.getFiles(url , suffix, isdepth);
				file.readBinary(null);*/
				car.getCarteimgurl(); 
				CarteRes CarteRes = new CarteRes(car.getId(), car.getCarteno(),
						car.getCartename(),
						car.getPrice()
						);
				carResList.add(CarteRes);
			}
			return new BaseRes(ErrorCode.OK, carResList);
		} catch (Exception e) {
			LoggerManager.def.error("sortDownloadWords errors:",e);
			return new BaseRes(ErrorCode.SYSTEM_ERROR);
		}
	}
}
