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
import com.xx.demo.model.pojo.Diningtable;
import com.xx.demo.model.pojo.Indent;
import com.xx.demo.web.action.base.AdminAction;

/**
 * 系統簽字分类管理Action
 * 
 * @author chlingm
 * 
 */
public class AdminIndentsAction extends AdminAction {

	private static final long serialVersionUID = 2820359414533485571L;

	private List<Indent> indentList;

	private Long id;

	private Long[] ids;

	private Indent indent;

	private Page page;
	
	//下拉列表dtnoList
	private List<Diningtable> diningtableList;
	//下拉列表cartenoList
	private List<Carte> carteList;
	

	/**
	 * 列表显示
	 * 
	 * @return
	 */
	public String list() {
		// 获取分页信息
		Map<String, Object> condition = new HashMap<String, Object>();
		orderField = StringUtils.isBlank(orderField) ? "indenttime" : orderField;
		orderDirection = StringUtils.isBlank(orderDirection) ? "desc" : orderDirection;
		condition.put("orderField", orderField);
		condition.put("orderDirection", orderDirection);
		if (indent != null) {
			if (StringUtils.isNotBlank(indent.getIndentno())) {
				condition.put("indentno", indent.getIndentno());
			}
		}
		page = this.fetchPageParams();
		long totalCount = LogicFactory.getIndentsLogic()
				.countIndentsByCondition(condition);
		page.setTotalCount(totalCount);

		int start = (page.getPageNum() - 1) * page.getNumPerPage();

		condition.put("start", start);
		condition.put("num", page.getNumPerPage());
		indentList = LogicFactory.getIndentsLogic()
				.getIndentListByCondition(
						condition);
		return "list";
	}

	public String add() {
		
		//下拉列表diningtableList用
				diningtableList=LogicFactory.getDiningtablesLogic().getAllDiningtable();
		//下拉列表carteList用
				carteList=LogicFactory.getCartesLogic().getAllCarte();

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
			if (StringUtils.isEmpty(indent.getIndentno())) {
				return this.ajaxDoneError("###订单号为必填项###");
			}
			Map<String, Object> condition = new HashMap<String, Object>();
			condition.put("indentno", indent.getIndentno());
			Long count = LogicFactory.getIndentsLogic()
					.countIndentsByCondition(condition);
			if (count > 0) {
				return this.ajaxDoneError("###订单号已存在，请更改订单号###");
			}
			indent.setIndenttime(new Date());
			LogicFactory.getIndentsLogic().createIndent(indent);
			return this.ajaxDoneSuccess("添加成功");
		} catch (Exception e) {
			LoggerManager.def.error("Indent insert errors:", e);
			e.printStackTrace();
			return this.ajaxDoneError("添加失败");
		}
	}

	public String edit() {
		//下拉列表diningtableList用
			diningtableList=LogicFactory.getDiningtablesLogic().getAllDiningtable();
		//下拉列表carteList用
			carteList=LogicFactory.getCartesLogic().getAllCarte();
		
		indent = LogicFactory.getIndentsLogic().getIndentById(id);
		return "edit";
	}

	public String update() {
		try {
			if (StringUtils.isEmpty(indent.getIndentno())) {
				return this.ajaxDoneError("###名称为必填项###");
			}
			LogicFactory.getIndentsLogic().updateIndent(indent);
			this.print(AjaxObject.newOk("修改成功！").toString());
		} catch (Exception e) {
			LoggerManager.def.error("indent update errors:", e);
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
			LogicFactory.getIndentsLogic().deleteIndentById(ids);
			return this.ajaxDoneSuccess("删除成功");
		} catch (Exception e) {
			LoggerManager.def.error("Indent delete errors:", e);
			return this.ajaxDoneError("删除失败：" + e.getMessage());
		}
	}

	
	public List<Diningtable> getDiningtableList() {
		return diningtableList;
	}

	public void setDiningtableList(List<Diningtable> diningtableList) {
		this.diningtableList = diningtableList;
	}

	public List<Carte> getCarteList() {
		return carteList;
	}

	public void setCarteList(List<Carte> carteList) {
		this.carteList = carteList;
	}
	
	public List<Indent> getIndentList() {
		return indentList;
	}

	public void setIndentList(List<Indent> indentList) {
		this.indentList = indentList;
	}

	public Indent getIndent() {
		return indent;
	}

	public void setIndent(Indent indent) {
		this.indent = indent;
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