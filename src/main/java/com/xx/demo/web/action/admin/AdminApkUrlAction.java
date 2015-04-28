/*package com.lenovo.card.web.action.admin;

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
import com.lenovo.card.biz.logic.LogicFactory;
import com.lenovo.card.common.model.card.ApkUrl;
import com.lenovo.card.common.util.Constants;
import com.lenovo.card.common.util.KeyGen;
import com.lenovo.card.common.util.LoggerManager;
import com.lenovo.card.web.action.base.AdminAction;

*//**
 * Apk地址Action
 * 
 * @author chlingm
 * 
 *//*
public class AdminApkUrlAction extends AdminAction {

	private static final long serialVersionUID = 2820359414533485571L;

	private List<ApkUrl> apkUrlList;

	private Long id;

	private Long[] ids;

	private ApkUrl apkUrl;

	private Page page;
	
	private File apkFile;
	
	private String apkFileFileName; // 文件名称

	private String apkFileContentType; // 文件类型

	*//**
	 * 列表显示
	 * 
	 * @return
	 *//*
	public String list() {
		// 获取分页信息
		Map<String, Object> condition = new HashMap<String, Object>();
		orderField = StringUtils.isBlank(orderField) ? "addtime" : orderField;
		orderDirection = StringUtils.isBlank(orderDirection) ? "desc" : orderDirection;
		condition.put("orderField", orderField);
		condition.put("orderDirection", orderDirection);
		if (apkUrl != null) {
			if (StringUtils.isNotBlank(apkUrl.getName())) {
				condition.put("name", apkUrl.getName());
			}
		}
		page = this.fetchPageParams();
		long totalCount = LogicFactory.getApkUrlLogic()
				.countApkUrlByCondition(condition);
		page.setTotalCount(totalCount);

		int start = (page.getPageNum() - 1) * page.getNumPerPage();

		apkUrlList = LogicFactory.getApkUrlLogic()
				.getApkUrlListByCondition(start, page.getNumPerPage(),
						condition);
		return "list";
	}

	public String add() {
		return "add";
	}

	*//**
	 * 新增
	 * 
	 * @return
	 *//*
	public String insert() {
		try {
			//校验
			if (StringUtils.isEmpty(apkUrl.getName())) {
				return this.ajaxDoneError("###名称为必填项###");
			}
			if (apkFile == null) {
				return this.ajaxDoneError("###请上传文件###");
			}
			if (StringUtils.isNotBlank(LogicFactory.getApkUrlLogic().getByName(
					apkUrl.getName()))) {
				return this.ajaxDoneError("###名称已存在，请换个大名###");
			}
			if (!apkFileFileName.endsWith(".apk")) {
				return this.ajaxDoneError("###只允许上传apk文件###");
			}
			if (StringUtils.equals(apkUrl.getStatus(), "1")) {
				ApkUrl tmp = LogicFactory.getApkUrlLogic().getLatestApkUrl();
				if (tmp != null) {
					return this.ajaxDoneError("###只能启用一个Apk Url 下载地址###");
				}
			}  
			
			
			
			String dateStr = TimeUtil.format("yyyyMM", new Date());
		    String relativeDir = Constants.APK_RELATIVE_DIR + dateStr + "/" +  KeyGen.getShortKey() + "/" + getApkFileFileName();
		    File savefile = new File(Constants.STATIC_PATH, relativeDir);
		    
			if (!savefile.getParentFile().exists())
				savefile.getParentFile().mkdirs();
			CommonUtil.copyFile(apkFile, savefile);
			apkUrl.setUrl(relativeDir);
			apkUrl.setAddtime(new Date());
			LogicFactory.getApkUrlLogic().createApkUrl(apkUrl);
			return this.ajaxDoneSuccess("添加成功");
		} catch (Exception e) {
			LoggerManager.def.error("ApkUrl insert errors:", e);
			e.printStackTrace();
			return this.ajaxDoneError("添加失败");
		}
	}

	public String edit() {
		apkUrl = LogicFactory.getApkUrlLogic().getApkUrlById(id);
		return "edit";
	}

	public String update() {
		try {
			if (StringUtils.isEmpty(apkUrl.getUrl())) {
				return this.ajaxDoneError("###URL为必填项###");
			}
			if (StringUtils.equals(apkUrl.getStatus(), "1")) {
				ApkUrl tmp = LogicFactory.getApkUrlLogic().getLatestApkUrl();
				if (tmp != null) {
					return this.ajaxDoneError("###只能启用一个Apk Url 下载地址###");
				}
			}
			LogicFactory.getApkUrlLogic().updateApkUrl(apkUrl);
			this.print(AjaxObject.newOk("修改成功！").toString());
		} catch (Exception e) {
			LoggerManager.def.error("ApkUrl update errors:", e);
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
			LogicFactory.getApkUrlLogic().deleteApkUrlById(ids);
			return this.ajaxDoneSuccess("删除成功");
		} catch (Exception e) {
			LoggerManager.def.error("ApkUrl delete errors:", e);
			return this.ajaxDoneError("删除失败：" + e.getMessage());
		}
	}

	public List<ApkUrl> getApkUrlList() {
		return apkUrlList;
	}

	public void setApkUrlList(List<ApkUrl> apkUrlList) {
		this.apkUrlList = apkUrlList;
	}

	public ApkUrl getApkUrl() {
		return apkUrl;
	}

	public void setApkUrl(ApkUrl apkUrl) {
		this.apkUrl = apkUrl;
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

	public String getApkFileFileName() {
		return apkFileFileName;
	}

	public void setApkFileFileName(String apkFileFileName) {
		this.apkFileFileName = apkFileFileName;
	}

	public String getApkFileContentType() {
		return apkFileContentType;
	}

	public void setApkFileContentType(String apkFileContentType) {
		this.apkFileContentType = apkFileContentType;
	}

	public File getApkFile() {
		return apkFile;
	}

	public void setApkFile(File apkFile) {
		this.apkFile = apkFile;
	}
	

}*/