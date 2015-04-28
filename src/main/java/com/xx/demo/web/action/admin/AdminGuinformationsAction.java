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
import com.xx.demo.model.pojo.Guinformation;
import com.xx.demo.web.action.base.AdminAction;

/**
 * 系統簽字分类管理Action
 * 
 * 
 */
public class AdminGuinformationsAction extends AdminAction {

	private static final long serialVersionUID = 2820359414533485571L;

	private List<Guinformation> guinformationList;

	private Long id;

	private Long[] ids;

	private Guinformation guinformation;

	private Page page;

	/**
	 * 列表显示
	 * 
	 * @return
	 */
	public String list() {
		// 获取分页信息
		Map<String, Object> condition = new HashMap<String, Object>();
		orderField = StringUtils.isBlank(orderField) ? "gutime" : orderField;
		orderDirection = StringUtils.isBlank(orderDirection) ? "desc" : orderDirection;
		condition.put("orderField", orderField);
		condition.put("orderDirection", orderDirection);
		if (guinformation != null) {
			if (StringUtils.isNotBlank(guinformation.getGuname())) {
				condition.put("guname", guinformation.getGuname());
			}
		}
		page = this.fetchPageParams();
		long totalCount = LogicFactory.getGuinformationsLogic()
				.countGuinformationsByCondition(condition);
		page.setTotalCount(totalCount);

		int start = (page.getPageNum() - 1) * page.getNumPerPage();

		condition.put("start", start);
		condition.put("num", page.getNumPerPage());
		guinformationList = LogicFactory.getGuinformationsLogic()
				.getGuinformationListByCondition(
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
			if (StringUtils.isEmpty(guinformation.getGuname())) {
				return this.ajaxDoneError("###名称为必填项###");
			}
			Map<String, Object> condition = new HashMap<String, Object>();
			condition.put("guname", guinformation.getGuname());
			Long count = LogicFactory.getGuinformationsLogic()
					.countGuinformationsByCondition(condition);
			if (count > 0) {
				return this.ajaxDoneError("###名称已存在，请更换姓名###");
			}
			guinformation.setGutime(new Date());
			LogicFactory.getGuinformationsLogic().createGuinformation(guinformation);
			return this.ajaxDoneSuccess("添加成功");
		} catch (Exception e) {
			LoggerManager.def.error("Guinformation insert errors:", e);
			e.printStackTrace();
			return this.ajaxDoneError("添加失败");
		}
	}

	public String edit() {
		guinformation = LogicFactory.getGuinformationsLogic().getGuinformationById(id);
		return "edit";
	}

	public String update() {
		try {
			if (StringUtils.isEmpty(guinformation.getGuname())) {
				return this.ajaxDoneError("###名称为必填项###");
			}
			LogicFactory.getGuinformationsLogic().updateGuinformation(guinformation);
			this.print(AjaxObject.newOk("修改成功！").toString());
		} catch (Exception e) {
			LoggerManager.def.error("guinformation update errors:", e);
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
			LogicFactory.getGuinformationsLogic().deleteGuinformationById(ids);
			return this.ajaxDoneSuccess("删除成功");
		} catch (Exception e) {
			LoggerManager.def.error("Guinformation delete errors:", e);
			return this.ajaxDoneError("删除失败：" + e.getMessage());
		}
	}

	public List<Guinformation> getGuinformationList() {
		return guinformationList;
	}

	public void setGuinformationList(List<Guinformation> guinformationList) {
		this.guinformationList = guinformationList;
	}

	public Guinformation getGuinformation() {
		return guinformation;
	}

	public void setGuinformation(Guinformation guinformation) {
		this.guinformation = guinformation;
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