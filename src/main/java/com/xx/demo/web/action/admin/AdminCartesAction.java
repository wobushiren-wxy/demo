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
import com.xx.demo.model.pojo.Carte;
import com.xx.demo.model.pojo.Classes;
import com.xx.demo.web.action.base.AdminAction;

/**
 * 系統簽字分类管理Action
 * 
 * @author chlingm
 * 
 */
// #########################菜单表###############################
public class AdminCartesAction extends AdminAction {

	private static final long serialVersionUID = 2820359414533485571L;

	private List<Carte> carteList;

	private Long id;

	private Long[] ids;

	private Carte carte;

	private Page page;
	
	//下拉列表classesList用的
	private List<Classes> classesList;
	
	

	/**
	 * 列表显示
	 * 
	 * @return
	 */
	public String list() {
		// 获取分页信息
		Map<String, Object> condition = new HashMap<String, Object>();
		orderField = StringUtils.isBlank(orderField) ? "cartetime" : orderField;
		orderDirection = StringUtils.isBlank(orderDirection) ? "desc" : orderDirection;
		condition.put("orderField", orderField);
		condition.put("orderDirection", orderDirection);
		if (carte != null) {
			if (StringUtils.isNotBlank(carte.getCartename())) {
				condition.put("cartename", carte.getCartename());
			}
		}
		page = this.fetchPageParams();
		long totalCount = LogicFactory.getCartesLogic()
				.countCartesByCondition(condition);
		page.setTotalCount(totalCount);

		int start = (page.getPageNum() - 1) * page.getNumPerPage();

		condition.put("start", start);
		condition.put("num", page.getNumPerPage());
		carteList = LogicFactory.getCartesLogic()
				.getCarteListByCondition(
						condition);
		return "list";
	}

	public String add() {
		//下拉列表classesList用
		classesList=LogicFactory.getClassessLogic().getAllClasses();
		
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
			if (StringUtils.isEmpty(carte.getCartename())) {
				return this.ajaxDoneError("###名称为必填项###");
			}
			Map<String, Object> condition = new HashMap<String, Object>();
			condition.put("cartename", carte.getCartename());
			Long count = LogicFactory.getCartesLogic()
					.countCartesByCondition(condition);
			if (count > 0) {
				return this.ajaxDoneError("###名称已存在，请更换姓名###");
			}
			carte.setCartetime(new Date());
			LogicFactory.getCartesLogic().createCarte(carte);
			return this.ajaxDoneSuccess("添加成功");
		} catch (Exception e) {
			LoggerManager.def.error("Carte insert errors:", e);
			e.printStackTrace();
			return this.ajaxDoneError("添加失败");
		}
	}

	public String edit() {
		//下拉列表classesList用
		classesList=LogicFactory.getClassessLogic().getAllClasses();
		
		carte = LogicFactory.getCartesLogic().getCarteById(id);
		return "edit";
	}

	public String update() {
		try {
			if (StringUtils.isEmpty(carte.getCartename())) {
				return this.ajaxDoneError("###名称为必填项###");
			}
			LogicFactory.getCartesLogic().updateCarte(carte);
			this.print(AjaxObject.newOk("修改成功！").toString());
		} catch (Exception e) {
			LoggerManager.def.error("carte update errors:", e);
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
			LogicFactory.getCartesLogic().deleteCarteById(ids);
			return this.ajaxDoneSuccess("删除成功");
		} catch (Exception e) {
			LoggerManager.def.error("Carte delete errors:", e);
			return this.ajaxDoneError("删除失败：" + e.getMessage());
		}
	}

	public List<Carte> getCarteList() {
		return carteList;
	}

	public void setCarteList(List<Carte> carteList) {
		this.carteList = carteList;
	}

	public Carte getCarte() {
		return carte;
	}

	public void setCarte(Carte carte) {
		this.carte = carte;
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

	public List<Classes> getClassesList() {
		return classesList;
	}

	public void setClassesList(List<Classes> classesList) {
		this.classesList = classesList;
	}
	

}