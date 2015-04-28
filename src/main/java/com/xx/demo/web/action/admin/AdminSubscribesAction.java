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
import com.xx.demo.model.pojo.Subscribe;
import com.xx.demo.web.action.base.AdminAction;

/**
 * 系統簽字分类管理Action
 * 
 * @author chlingm
 * 
 */
public class AdminSubscribesAction extends AdminAction {

	private static final long serialVersionUID = 2820359414533485571L;

	private List<Subscribe> subscribeList;

	private Long id;

	private Long[] ids;

	private Subscribe subscribe;

	private Page page;

	/**
	 * 列表显示
	 * 
	 * @return
	 */
	public String list() {
		// 获取分页信息
		Map<String, Object> condition = new HashMap<String, Object>();
		orderField = StringUtils.isBlank(orderField) ? "subcreattime" : orderField;
		orderDirection = StringUtils.isBlank(orderDirection) ? "desc" : orderDirection;
		condition.put("orderField", orderField);
		condition.put("orderDirection", orderDirection);
		if (subscribe != null) {
			if (StringUtils.isNotBlank(subscribe.getSubno())) {
				condition.put("subno", subscribe.getSubno());
			}
		}
		page = this.fetchPageParams();
		long totalCount = LogicFactory.getSubscribesLogic()
				.countSubscribesByCondition(condition);
		page.setTotalCount(totalCount);

		int start = (page.getPageNum() - 1) * page.getNumPerPage();

		condition.put("start", start);
		condition.put("num", page.getNumPerPage());
		subscribeList = LogicFactory.getSubscribesLogic()
				.getSubscribeListByCondition(
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
			if (StringUtils.isEmpty(subscribe.getSubno())) {
				return this.ajaxDoneError("###订单号为必填项###");
			}
			Map<String, Object> condition = new HashMap<String, Object>();
			condition.put("subno", subscribe.getSubno());
			/*Long count = LogicFactory.getSubscribesLogic()
					.countSubscribesByCondition(condition);
				if (count > 0) {
				return this.ajaxDoneError("###订单号已存在，请更改订单号###");
			}*/
			subscribe.setSubcreattime(new Date());
			LogicFactory.getSubscribesLogic().createSubscribe(subscribe);
			return this.ajaxDoneSuccess("添加成功");
		} catch (Exception e) {
			LoggerManager.def.error("Subscribe insert errors:", e);
			e.printStackTrace();
			return this.ajaxDoneError("添加失败");
		}
	}

	public String edit() {
	
		
		subscribe = LogicFactory.getSubscribesLogic().getSubscribeById(id);
		return "edit";
	}

	public String update() {
		try {
			if (StringUtils.isEmpty(subscribe.getSubno())) {
				return this.ajaxDoneError("###名称为必填项###");
			}
			LogicFactory.getSubscribesLogic().updateSubscribe(subscribe);
			this.print(AjaxObject.newOk("修改成功！").toString());
		} catch (Exception e) {
			LoggerManager.def.error("subscribe update errors:", e);
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
			LogicFactory.getSubscribesLogic().deleteSubscribeById(ids);
			return this.ajaxDoneSuccess("删除成功");
		} catch (Exception e) {
			LoggerManager.def.error("Subscribe delete errors:", e);
			return this.ajaxDoneError("删除失败：" + e.getMessage());
		}
	}

	
	public List<Subscribe> getSubscribeList() {
		return subscribeList;
	}

	public void setSubscribeList(List<Subscribe> subscribeList) {
		this.subscribeList = subscribeList;
	}

	public Subscribe getSubscribe() {
		return subscribe;
	}

	public void setSubscribe(Subscribe subscribe) {
		this.subscribe = subscribe;
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