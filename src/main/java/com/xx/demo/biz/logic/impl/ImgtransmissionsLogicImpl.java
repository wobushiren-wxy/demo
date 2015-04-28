package com.xx.demo.biz.logic.impl;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import com.xx.demo.biz.logic.ImgtransmissionsLogic;
import com.xx.demo.common.utils.FileUtil;
import com.xx.demo.dao.DaoFactory;
import com.xx.demo.model.pojo.Imgtransmission;


//###########################客户信息管理表############################
public class ImgtransmissionsLogicImpl implements ImgtransmissionsLogic {

	/**
	 * Atguuser
	 */
	
	@Override
	public Long countImgtransmissionsByCondition(Map<String, Object> condition) {
		return DaoFactory.getImgtransmissionsDao().countImgtransmissionsByCondition(condition);
	}

	@Override
	public List<Imgtransmission> getImgtransmissionListByCondition(Map<String, Object> condition) {
		return DaoFactory.getImgtransmissionsDao().getImgtransmissionListByCondition(condition);
	}

	@Override
	public void createImgtransmission(Imgtransmission guinformation) throws SQLException {
		DaoFactory.getCommon().insert(guinformation);
	}

	@Override
	public Imgtransmission getImgtransmissionById(Long id) {
		return DaoFactory.getImgtransmissionsDao().getImgtransmissionById(id);
	}

	//time我没有写进去
	@Override
	public void updateImgtransmission(Imgtransmission imgtransmission) throws SQLException {
		DaoFactory.getCommon().updateById(imgtransmission, "imgname", "imgpath", "miuser", "imgnote");
	}

	@Override
	public void deleteImgtransmissionById(Long[] ids) throws SQLException {
		for (long id : ids) {

			 Imgtransmission imgtransmission = DaoFactory.getImgtransmissionsDao().getImgtransmissionById(id);

			 /**
			  * 服务器文件操作
			  *	图片地址转换
			  */
			 String num  = null;
			 num = imgtransmission.getImgpath().replaceAll("//","\\\\");
			 FileUtil.DeleteFolder(num);  

			 DaoFactory.getCommon().deleteById(imgtransmission);
		}
	}

	@Override
	public List<Imgtransmission> getAllImgtransmission() {
		return DaoFactory.getImgtransmissionsDao().getAllImgtransmissions();
	}

}
