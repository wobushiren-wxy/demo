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
import com.xx.demo.model.pojo.Diningtable;
import com.xx.demo.web.action.base.AdminAction;

/**
 * 系統簽字分类管理Action
 * 
 * @author chlingm
 * 
 */
public class AdminDiningtablesAction extends AdminAction {

	private static final long serialVersionUID = 2820359414533485571L;

	private List<Diningtable> diningtableList;

	private Long id;

	private Long[] ids;

	private Diningtable diningtable;

	private Page page;

	/**
	 * 列表显示
	 * 
	 * @return
	 */
	public String list() {
		// 获取分页信息
		Map<String, Object> condition = new HashMap<String, Object>();
		orderField = StringUtils.isBlank(orderField) ? "dttime" : orderField;
		orderDirection = StringUtils.isBlank(orderDirection) ? "desc" : orderDirection;
		condition.put("orderField", orderField);
		condition.put("orderDirection", orderDirection);
		if (diningtable != null) {
			if (StringUtils.isNotBlank(diningtable.getDtname())) {
				condition.put("dtname", diningtable.getDtname());
			}
		}
		page = this.fetchPageParams();
		long totalCount = LogicFactory.getDiningtablesLogic()
				.countDiningtablesByCondition(condition);
		page.setTotalCount(totalCount);

		int start = (page.getPageNum() - 1) * page.getNumPerPage();

		condition.put("start", start);
		condition.put("num", page.getNumPerPage());
		diningtableList = LogicFactory.getDiningtablesLogic()
				.getDiningtableListByCondition(
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
			if (StringUtils.isEmpty(diningtable.getDtname())) {
				return this.ajaxDoneError("###名称为必填项###");
			}
			Map<String, Object> condition = new HashMap<String, Object>();
			condition.put("dtname", diningtable.getDtname());
			Long count = LogicFactory.getDiningtablesLogic()
					.countDiningtablesByCondition(condition);
			if (count > 0) {
				return this.ajaxDoneError("###名称已存在，请更换姓名###");
			}
			diningtable.setDttime(new Date());
			LogicFactory.getDiningtablesLogic().createDiningtable(diningtable);
			return this.ajaxDoneSuccess("添加成功");
		} catch (Exception e) {
			LoggerManager.def.error("Diningtable insert errors:", e);
			e.printStackTrace();
			return this.ajaxDoneError("添加失败");
		}
	}

	public String edit() {
		diningtable = LogicFactory.getDiningtablesLogic().getDiningtableById(id);
		return "edit";
	}

	public String update() {
		try {
			if (StringUtils.isEmpty(diningtable.getDtname())) {
				return this.ajaxDoneError("###名称为必填项###");
			}
			LogicFactory.getDiningtablesLogic().updateDiningtable(diningtable);
			this.print(AjaxObject.newOk("修改成功！").toString());
		} catch (Exception e) {
			LoggerManager.def.error("diningtable update errors:", e);
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
			LogicFactory.getDiningtablesLogic().deleteDiningtableById(ids);
			return this.ajaxDoneSuccess("删除成功");
		} catch (Exception e) {
			LoggerManager.def.error("Diningtable delete errors:", e);
			return this.ajaxDoneError("删除失败：" + e.getMessage());
		}
	}

	public List<Diningtable> getDiningtableList() {
		return diningtableList;
	}

	public void setDiningtableList(List<Diningtable> diningtableList) {
		this.diningtableList = diningtableList;
	}

	public Diningtable getDiningtable() {
		return diningtable;
	}

	public void setDiningtable(Diningtable diningtable) {
		this.diningtable = diningtable;
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