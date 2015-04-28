package com.xx.demo.web.action.admin;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;

import com.alonew.core.commons.page.AjaxObject;
import com.alonew.core.commons.page.Page;
import com.xx.demo.biz.logic.LogicFactory;
import com.xx.demo.common.utils.LoggerManager;
import com.xx.demo.model.pojo.ManagerInf;
import com.xx.demo.web.action.base.AdminAction;

/**
 * 系統簽字分类管理Action
 * 
 * @author chlingm
 * 
 */
public class AdminManagersInfAction extends AdminAction {

	private static final long serialVersionUID = 2820359414533485571L;

	private List<ManagerInf> managerInfList;

	private Long id;

	private Long[] ids;

	private ManagerInf managerInf;

	private Page page;

	/**
	 * 列表显示
	 * 
	 * @return
	 */
	public String list() {
		// 获取分页信息
		Map<String, Object> condition = new HashMap<String, Object>();
		orderField = StringUtils.isBlank(orderField) ? "mitime" : orderField;
		orderDirection = StringUtils.isBlank(orderDirection) ? "desc" : orderDirection;
		condition.put("orderField", orderField);
		condition.put("orderDirection", orderDirection);
		if (managerInf != null) {
			if (StringUtils.isNotBlank(managerInf.getMiname())) {
				condition.put("miname", managerInf.getMiname());
			}
		}
		page = this.fetchPageParams();
		long totalCount = LogicFactory.getManagersInfLogic()
				.countManagersInfByCondition(condition);
		page.setTotalCount(totalCount);

		int start = (page.getPageNum() - 1) * page.getNumPerPage();

		condition.put("start", start);
		condition.put("num", page.getNumPerPage());
		managerInfList = LogicFactory.getManagersInfLogic()
				.getManagerInfListByCondition(
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
			if (StringUtils.isEmpty(managerInf.getMiname())) {
				return this.ajaxDoneError("###名称为必填项###");
			}
			Map<String, Object> condition = new HashMap<String, Object>();
			condition.put("miname", managerInf.getMiname());
			Long count = LogicFactory.getManagersInfLogic()
					.countManagersInfByCondition(condition);
			if (count > 0) {
				return this.ajaxDoneError("###名称已存在，请更换姓名###");
			}
			managerInf.setMitime(new Date());
			LogicFactory.getManagersInfLogic().createManagerInf(managerInf);
			return this.ajaxDoneSuccess("添加成功");
		} catch (Exception e) {
			LoggerManager.def.error("ManagerInf insert errors:", e);
			e.printStackTrace();
			return this.ajaxDoneError("添加失败");
		}
	}

	public String edit() {
		managerInf = LogicFactory.getManagersInfLogic().getManagerInfById(id);
		return "edit";
	}

	public String update() {
		try {
			if (StringUtils.isEmpty(managerInf.getMiname())) {
				return this.ajaxDoneError("###名称为必填项###");
			}
			LogicFactory.getManagersInfLogic().updateManagerInf(managerInf);
			this.print(AjaxObject.newOk("修改成功！").toString());
		} catch (Exception e) {
			LoggerManager.def.error("managerInf update errors:", e);
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
			LogicFactory.getManagersInfLogic().deleteManagerInfById(ids);
			return this.ajaxDoneSuccess("删除成功");
		} catch (Exception e) {
			LoggerManager.def.error("ManagerInf delete errors:", e);
			return this.ajaxDoneError("删除失败：" + e.getMessage());
		}
	}

	public List<ManagerInf> getManagerInfList() {
		return managerInfList;
	}

	public void setManagerInfList(List<ManagerInf> managerInfList) {
		this.managerInfList = managerInfList;
	}

	public ManagerInf getManagerInf() {
		return managerInf;
	}

	public void setManagerInf(ManagerInf managerInf) {
		this.managerInf = managerInf;
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