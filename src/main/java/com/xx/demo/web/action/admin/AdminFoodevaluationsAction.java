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
import com.xx.demo.model.pojo.Foodevaluation;
import com.xx.demo.web.action.base.AdminAction;

/**
 * 系統簽字分类管理Action
 * 
 * @author chlingm
 * 
 */
public class AdminFoodevaluationsAction extends AdminAction {

	private static final long serialVersionUID = 2820359414533485571L;

	private List<Foodevaluation> foodevaluationList;

	private Long id;

	private Long[] ids;

	private Foodevaluation foodevaluation;

	private Page page;

	/**
	 * 列表显示
	 * 
	 * @return
	 */
	public String list() {
		// 获取分页信息
		Map<String, Object> condition = new HashMap<String, Object>();
		orderField = StringUtils.isBlank(orderField) ? "cptime" : orderField;
		orderDirection = StringUtils.isBlank(orderDirection) ? "desc" : orderDirection;
		condition.put("orderField", orderField);
		condition.put("orderDirection", orderDirection);
		if (foodevaluation != null) {
			if (StringUtils.isNotBlank(foodevaluation.getCarteno())) {
				condition.put("carteno", foodevaluation.getCarteno());
			}
		}
		page = this.fetchPageParams();
		long totalCount = LogicFactory.getFoodevaluationsLogic()
				.countFoodevaluationsByCondition(condition);
		page.setTotalCount(totalCount);

		int start = (page.getPageNum() - 1) * page.getNumPerPage();

		condition.put("start", start);
		condition.put("num", page.getNumPerPage());
		foodevaluationList = LogicFactory.getFoodevaluationsLogic()
				.getFoodevaluationListByCondition(
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
			
			foodevaluation.setCptime(new Date());
			LogicFactory.getFoodevaluationsLogic().createFoodevaluation(foodevaluation);
			return this.ajaxDoneSuccess("添加成功");
		} catch (Exception e) {
			LoggerManager.def.error("Foodevaluation insert errors:", e);
			e.printStackTrace();
			return this.ajaxDoneError("添加失败");
		}
	}

	public String edit() {
		foodevaluation = LogicFactory.getFoodevaluationsLogic().getFoodevaluationById(id);
		return "edit";
	}

	public String update() {
		try {
			
			LogicFactory.getFoodevaluationsLogic().updateFoodevaluation(foodevaluation);
			this.print(AjaxObject.newOk("修改成功！").toString());
		} catch (Exception e) {
			LoggerManager.def.error("foodevaluation update errors:", e);
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
			LogicFactory.getFoodevaluationsLogic().deleteFoodevaluationById(ids);
			return this.ajaxDoneSuccess("删除成功");
		} catch (Exception e) {
			LoggerManager.def.error("Foodevaluation delete errors:", e);
			return this.ajaxDoneError("删除失败：" + e.getMessage());
		}
	}

	public List<Foodevaluation> getFoodevaluationList() {
		return foodevaluationList;
	}

	public void setFoodevaluationList(List<Foodevaluation> foodevaluationList) {
		this.foodevaluationList = foodevaluationList;
	}

	public Foodevaluation getFoodevaluation() {
		return foodevaluation;
	}

	public void setFoodevaluation(Foodevaluation foodevaluation) {
		this.foodevaluation = foodevaluation;
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