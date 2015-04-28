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
import com.xx.demo.common.utils.LoggerManager;
import com.xx.demo.model.pojo.Appdownload;
import com.xx.demo.web.action.base.AdminAction;

/**
 * 系統簽字分类管理Action
 * 
 * @author chlingm
 */
public class AdminAppdownloadsAction extends AdminAction {

	private static final long serialVersionUID = 2820359414533485571L;

	private List<Appdownload> appdownloadList;

	private Long id;

	private Long[] ids;

	private Appdownload appdownload;

	private Page page;
	
	private File appFile;

	private String appFileFileName; // 文件名称
	
	
	public File getAppFile() {
		return appFile;
	}

	public void setAppFile(File appFile) {
		this.appFile = appFile;
	}
	

	public String getAppFileFileName() {
		return appFileFileName;
	}

	public void setAppFileFileName(String appFileFileName) {
		this.appFileFileName = appFileFileName;
	}

	
	/**
	 * 列表显示
	 * 
	 * @return
	 */
	public String list() {
		// 获取分页信息
		Map<String, Object> condition = new HashMap<String, Object>();
		orderField = StringUtils.isBlank(orderField) ? "apptime" : orderField;
		orderDirection = StringUtils.isBlank(orderDirection) ? "desc" : orderDirection;
		condition.put("orderField", orderField);
		condition.put("orderDirection", orderDirection);
		if (appdownload != null) {
			if (StringUtils.isNotBlank(appdownload.getAppver())) {
				condition.put("appver", appdownload.getAppver());
			}
		}
		page = this.fetchPageParams();
		long totalCount = LogicFactory.getAppdownloadsLogic()
				.countAppdownloadsByCondition(condition);
		page.setTotalCount(totalCount);

		int start = (page.getPageNum() - 1) * page.getNumPerPage();

		condition.put("start", start);
		condition.put("num", page.getNumPerPage());
		appdownloadList = LogicFactory.getAppdownloadsLogic()
				.getAppdownloadListByCondition(
						condition);
		return "list";
	}

	public String add() {
		return "add";
	}

	/**
	 * 新增
	 * 
	 * @return
	 */
	public String insert() {
		try {
			//校验
			if (StringUtils.isEmpty(appdownload.getAppver())) {
				return this.ajaxDoneError("###名称为必填项###");
			}
			Map<String, Object> condition = new HashMap<String, Object>();
			condition.put("appver", appdownload.getAppver());
			Long count = LogicFactory.getAppdownloadsLogic()
					.countAppdownloadsByCondition(condition);
			if (count > 0) {
				return this.ajaxDoneError("###名称已存在，请更换姓名###");
			}
			//限制后缀
			if (!appFileFileName.endsWith(".apk")) {
				return this.ajaxDoneError("###只允许上传apk文件###");
			}
			
			String dateStr = TimeUtil.format("yyyyMM", new Date());
			//  		KeyGen.getShortKey() + "/" + 	
			String relativeDir = Constants.STATIC_PATH + dateStr + "/" +getAppFileFileName();
		    File savefile = new File(Constants.STATIC_PATH, getAppFileFileName());
		    
		    if (!savefile.getParentFile().exists())
				savefile.getParentFile().mkdirs();
			CommonUtil.copyFile(appFile, savefile);
			
			appdownload.setApppath(relativeDir);
			appdownload.setApptime(new Date());
			LogicFactory.getAppdownloadsLogic().createAppdownload(appdownload);
			return this.ajaxDoneSuccess("添加成功");
			
		} catch (Exception e) {
			LoggerManager.def.error("Appdownload insert errors:", e);
			e.printStackTrace();
			return this.ajaxDoneError("添加失败");
		}
	}

	public String edit() {
		appdownload = LogicFactory.getAppdownloadsLogic().getAppdownloadById(id);
		return "edit";
	}

	public String update() {
		try {
			if (StringUtils.isEmpty(appdownload.getAppver())) {
				return this.ajaxDoneError("###App版本为必填###");
			}
			
			LogicFactory.getAppdownloadsLogic().updateAppdownload(appdownload);
			this.print(AjaxObject.newOk("修改成功！").toString());
		} catch (Exception e) {
			LoggerManager.def.error("appdownload update errors:", e);
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
			LogicFactory.getAppdownloadsLogic().deleteAppdownloadById(ids);
			return this.ajaxDoneSuccess("删除成功");
		} catch (Exception e) {
			LoggerManager.def.error("Appdownload delete errors:", e);
			return this.ajaxDoneError("删除失败：" + e.getMessage());
		}
	}

	public List<Appdownload> getAppdownloadList() {
		return appdownloadList;
	}

	public void setAppdownloadList(List<Appdownload> appdownloadList) {
		this.appdownloadList = appdownloadList;
	}

	public Appdownload getAppdownload() {
		return appdownload;
	}

	public void setAppdownload(Appdownload appdownload) {
		this.appdownload = appdownload;
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

}