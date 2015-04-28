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
import com.xx.demo.model.pojo.Classes;
import com.xx.demo.web.action.base.AdminAction;

/**
 * 系統簽字分类管理Action
 * 
 * @author chlingm
 * 
 */
public class AdminClassessAction extends AdminAction {

	private static final long serialVersionUID = 2820359414533485571L;

	private List<Classes> classesList;

	private Long id;

	private Long[] ids;

	private Classes classes;

	private Page page;

	/**
	 * 列表显示
	 * 
	 * @return
	 */
	public String list() {
		// 获取分页信息
		Map<String, Object> condition = new HashMap<String, Object>();
		orderField = StringUtils.isBlank(orderField) ? "classestime" : orderField;
		orderDirection = StringUtils.isBlank(orderDirection) ? "desc" : orderDirection;
		condition.put("orderField", orderField);
		condition.put("orderDirection", orderDirection);
		if (classes != null) {
			if (StringUtils.isNotBlank(classes.getClassesname())) {
				condition.put("classesname", classes.getClassesname());
			}
		}
		page = this.fetchPageParams();
		long totalCount = LogicFactory.getClassessLogic()
				.countClassessByCondition(condition);
		page.setTotalCount(totalCount);

		int start = (page.getPageNum() - 1) * page.getNumPerPage();

		condition.put("start", start);
		condition.put("num", page.getNumPerPage());
		classesList = LogicFactory.getClassessLogic()
				.getClassesListByCondition(
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
			if (StringUtils.isEmpty(classes.getClassesname())) {
				return this.ajaxDoneError("###名称为必填项###");
			}
			Map<String, Object> condition = new HashMap<String, Object>();
			condition.put("classesname", classes.getClassesname());
			Long count = LogicFactory.getClassessLogic()
					.countClassessByCondition(condition);
			if (count > 0) {
				return this.ajaxDoneError("###名称已存在，请更换姓名###");
			}
			classes.setClassestime(new Date());
			LogicFactory.getClassessLogic().createClasses(classes);
			return this.ajaxDoneSuccess("添加成功");
		} catch (Exception e) {
			LoggerManager.def.error("Classes insert errors:", e);
			e.printStackTrace();
			return this.ajaxDoneError("添加失败");
		}
	}

	public String edit() {
		classes = LogicFactory.getClassessLogic().getClassesById(id);
		return "edit";
	}

	public String update() {
		try {
			if (StringUtils.isEmpty(classes.getClassesname())) {
				return this.ajaxDoneError("###名称为必填项###");
			}
			LogicFactory.getClassessLogic().updateClasses(classes);
			this.print(AjaxObject.newOk("修改成功！").toString());
		} catch (Exception e) {
			LoggerManager.def.error("classes update errors:", e);
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
			LogicFactory.getClassessLogic().deleteClassesById(ids);
			return this.ajaxDoneSuccess("删除成功");
		} catch (Exception e) {
			LoggerManager.def.error("Classes delete errors:", e);
			return this.ajaxDoneError("删除失败：" + e.getMessage());
		}
	}
	 
	
	public long selectnum(){
		long num = 0;
		
		return num;
	}

	public List<Classes> getClassesList() {
		return classesList;
	}

	public void setClassesList(List<Classes> classesList) {
		this.classesList = classesList;
	}

	public Classes getClasses() {
		return classes;
	}

	public void setClasses(Classes classes) {
		this.classes = classes;
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