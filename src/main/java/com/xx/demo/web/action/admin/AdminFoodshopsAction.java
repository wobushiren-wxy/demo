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
import com.xx.demo.model.pojo.Foodshop;
import com.xx.demo.web.action.base.AdminAction;

/**
 * 餐饮店分类管理Action
 * 
 * @author chlingm
 * 
 */
public class AdminFoodshopsAction extends AdminAction {

	private static final long serialVersionUID = 2820359414533485571L;

	private List<Foodshop> foodshopList;

	private Long id;

	private Long[] ids;

	private Foodshop foodshop;

	private Page page;

	/**
	 * 列表显示
	 * 
	 * @return
	 */
	public String list() {
		// 获取分页信息
		Map<String, Object> condition = new HashMap<String, Object>();
		orderField = StringUtils.isBlank(orderField) ? "fstime" : orderField;
		orderDirection = StringUtils.isBlank(orderDirection) ? "desc" : orderDirection;
		condition.put("orderField", orderField);
		condition.put("orderDirection", orderDirection);
		if (foodshop != null) {
			if (StringUtils.isNotBlank(foodshop.getFsname())) {
				condition.put("fsname", foodshop.getFsname());
			}
		}
		page = this.fetchPageParams();
		long totalCount = LogicFactory.getFoodshopsLogic()
				.countFoodshopsByCondition(condition);
		page.setTotalCount(totalCount);

		int start = (page.getPageNum() - 1) * page.getNumPerPage();

		condition.put("start", start);
		condition.put("num", page.getNumPerPage());
		foodshopList = LogicFactory.getFoodshopsLogic()
				.getFoodshopListByCondition(
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
			if (StringUtils.isEmpty(foodshop.getFsname())) {
				return this.ajaxDoneError("###名称为必填项###");
			}
			Map<String, Object> condition = new HashMap<String, Object>();
			condition.put("fsname", foodshop.getFsname());
			Long count = LogicFactory.getFoodshopsLogic()
					.countFoodshopsByCondition(condition);
			if (count > 0) {
				return this.ajaxDoneError("###名称已存在，请更换姓名###");
			}
			foodshop.setFstime(new Date());
			LogicFactory.getFoodshopsLogic().createFoodshop(foodshop);
			return this.ajaxDoneSuccess("添加成功");
		} catch (Exception e) {
			LoggerManager.def.error("Foodshop insert errors:", e);
			e.printStackTrace();
			return this.ajaxDoneError("添加失败");
		}
	}

	public String edit() {
		foodshop = LogicFactory.getFoodshopsLogic().getFoodshopById(id);
		return "edit";
	}

	public String update() {
		try {
			if (StringUtils.isEmpty(foodshop.getFsname())) {
				return this.ajaxDoneError("###名称为必填项###");
			}
			LogicFactory.getFoodshopsLogic().updateFoodshop(foodshop);
			this.print(AjaxObject.newOk("修改成功！").toString());
		} catch (Exception e) {
			LoggerManager.def.error("foodshop update errors:", e);
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
			LogicFactory.getFoodshopsLogic().deleteFoodshopById(ids);
			return this.ajaxDoneSuccess("删除成功");
		} catch (Exception e) {
			LoggerManager.def.error("Foodshop delete errors:", e);
			return this.ajaxDoneError("删除失败：" + e.getMessage());
		}
	}

	public List<Foodshop> getFoodshopList() {
		return foodshopList;
	}

	public void setFoodshopList(List<Foodshop> foodshopList) {
		this.foodshopList = foodshopList;
	}

	public Foodshop getFoodshop() {
		return foodshop;
	}

	public void setFoodshop(Foodshop foodshop) {
		this.foodshop = foodshop;
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