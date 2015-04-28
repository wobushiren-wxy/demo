package com.xx.demo.web.action.admin;

import java.io.File;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;

import com.alonew.core.commons.page.AjaxObject;
import com.alonew.core.commons.page.Page;
import com.alonew.core.commons.util.CommonUtil;
import com.alonew.core.commons.util.TimeUtil;
import com.xx.demo.biz.logic.LogicFactory;
import com.xx.demo.common.utils.Constants;
import com.xx.demo.common.utils.FileUtil;
import com.xx.demo.common.utils.LoggerManager;
import com.xx.demo.model.pojo.Imgtransmission;
import com.xx.demo.web.action.base.AdminAction;

/**
 * 系統簽字分类管理Action
 * 
 * 
 */
public class AdminImgtransmissionsAction extends AdminAction {

	private static final long serialVersionUID = 2820359414533485571L;

	private List<Imgtransmission> imgtransmissionList;

	private Long id;

	private Long[] ids;

	private Imgtransmission imgtransmission;

	private Page page;
	
	private File imgFile;
	
	private String imgFileFileName;

	/**
	 * 列表显示
	 * --
	 * @return
	 */
	public String list() {
		// 获取分页信息
		Map<String, Object> condition = new HashMap<String, Object>();
		orderField = StringUtils.isBlank(orderField) ? "imgtime" : orderField;
		orderDirection = StringUtils.isBlank(orderDirection) ? "desc" : orderDirection;
		condition.put("orderField", orderField);
		condition.put("orderDirection", orderDirection);
		if (imgtransmission != null) {
			if (StringUtils.isNotBlank(imgtransmission.getImgname())) {
				condition.put("imgname", imgtransmission.getImgname());
			}
		}
		page = this.fetchPageParams();
		long totalCount = LogicFactory.getImgtransmissionsLogic()
				.countImgtransmissionsByCondition(condition);
		page.setTotalCount(totalCount);

		int start = (page.getPageNum() - 1) * page.getNumPerPage();

		condition.put("start", start);
		condition.put("num", page.getNumPerPage());
		imgtransmissionList = LogicFactory.getImgtransmissionsLogic()
				.getImgtransmissionListByCondition(
						condition);
		return "list";
	}

	public String add() {
		return "add";
	}

	/**
	 * 新增
	 * 
	 */
	public String insert() {
		try {
			//校验
			if (StringUtils.isEmpty(imgtransmission.getImgname())) {
				return this.ajaxDoneError("###名称为必填项###");
			}
			Map<String, Object> condition = new HashMap<String, Object>();
			condition.put("imgname", imgtransmission.getImgname());
			Long count = LogicFactory.getImgtransmissionsLogic()
					.countImgtransmissionsByCondition(condition);
			if (count > 0) {
				return this.ajaxDoneError("###名称已存在，请更换姓名###");
			}
			
			//newimgname用来组合名字与后缀
			String newimgname = imgtransmission.getImgname() + FileUtil.getFilePostfix(getImgFileFileName());
			String relativeDir = Constants.STATIC_PATH + "/" + newimgname;
		    File savefile = new File(Constants.STATIC_PATH, newimgname);
		    
			
		    if (!savefile.getParentFile().exists())
				savefile.getParentFile().mkdirs();
			CommonUtil.copyFile(imgFile, savefile);
			
			imgtransmission.setImgpath(relativeDir);
			imgtransmission.setImgtime(new Date());
		    
			LogicFactory.getImgtransmissionsLogic().createImgtransmission(imgtransmission);
			return this.ajaxDoneSuccess("添加成功");
			
		} catch (Exception e) {
			LoggerManager.def.error("Imgtransmission insert errors:", e);
			e.printStackTrace();
			return this.ajaxDoneError("添加失败");
		}
	}

	public String edit() {
		imgtransmission = LogicFactory.getImgtransmissionsLogic().getImgtransmissionById(id);
		return "edit";
	}

	public String update() {
		try {
			if (StringUtils.isEmpty(imgtransmission.getImgname())) {
				return this.ajaxDoneError("###名称为必填项###");
			}
			LogicFactory.getImgtransmissionsLogic().updateImgtransmission(imgtransmission);
			this.print(AjaxObject.newOk("修改成功！").toString());
		} catch (Exception e) {
			LoggerManager.def.error("imgtransmission update errors:", e);
			this.print(AjaxObject.newError(e.getMessage()).setCallbackType("")
					.toString());
		}
		return "list";
	}

	public String del() {
		if (ids == null || ids.length == 0) {
			return this.ajaxDoneError("###未选择对象###");
		}

		try {
			LogicFactory.getImgtransmissionsLogic().deleteImgtransmissionById(ids);
			return this.ajaxDoneSuccess("删除成功");
		} catch (Exception e) {
			LoggerManager.def.error("Imgtransmission delete errors:", e);
			return this.ajaxDoneError("删除失败：" + e.getMessage());
		}
	}

	public List<Imgtransmission> getImgtransmissionList() {
		return imgtransmissionList;
	}

	public void setImgtransmissionList(List<Imgtransmission> imgtransmissionList) {
		this.imgtransmissionList = imgtransmissionList;
	}

	public Imgtransmission getImgtransmission() {
		return imgtransmission;
	}

	public void setImgtransmission(Imgtransmission imgtransmission) {
		this.imgtransmission = imgtransmission;
	}

	public Page getPage() {
		return page;
	}

	public void setPage(Page page) {
		this.page = page;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long[] getIds() {
		return ids;
	}

	public void setIds(Long[] ids) {
		this.ids = ids;
	}

	public File getImgFile() {
		return imgFile;
	}

	public void setImgFile(File imgFile) {
		this.imgFile = imgFile;
	}

	public String getImgFileFileName() {
		return imgFileFileName;
	}

	public void setImgFileFileName(String imgFileFileName) {
		this.imgFileFileName = imgFileFileName;
	}

	
}