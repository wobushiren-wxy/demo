package com.xx.demo.web.action.demo;



import com.google.gson.Gson;
import com.xx.demo.biz.service.ServiceFactory;
import com.xx.demo.common.utils.LoggerManager;
import com.xx.demo.model.enums.ErrorCode;
import com.xx.demo.model.resp.BaseRes;
import com.xx.demo.model.resp.IndentRes;
import com.xx.demo.web.action.base.BaseAction;

public class IndentsAction extends BaseAction {

	private static final long serialVersionUID = 1L;

	private String orderField = "indentno";//排序字段	默认排序字段indentno	

	private String orderDirection = "asc";//排序方式	默认升序asc
	
	//private int retNums = 1;如果要用的话记得下面获取客户端参数要写进去	注掉是可以用
	private String indentno = null;
	private String indentstate = null;
	private String dtno = null;
	private String carteno = null;
	private String pricsum = null;
	private String indentnote = null;
	private IndentRes indentRes;

	
	
	public String getcreateIndentsByCondition() {
		LoggerManager.def.info("获取客户端参数：orderField=" + orderField + ",orderDirection=" + orderDirection 
			+ ",indentno=" + indentno +  ",indentstate=" + indentstate + "," + "dtno=" + dtno + "," + "carteno=" + carteno
			 + "," + "pricsum=" + pricsum + "," + "indentnote=" + indentnote);
		Gson gson = new Gson();
		try {
			float floatpricsum ;
			floatpricsum=Float.parseFloat(pricsum);
			//将数据传入IndentRes中
			IndentRes indentRes = new IndentRes(null, indentno, 
					indentstate,dtno,carteno, 
					floatpricsum, indentnote);
			
			/**
			 * 我去，白写了。
			Map<String, Object> indentcondition = new HashMap<String, Object>();
		 	indentcondition.put("indentno", indentno);
			indentcondition.put("indentstate", indentstate);
			indentcondition.put("dtno", dtno);
			indentcondition.put("carteno", carteno);
			indentcondition.put("pricsum", pricsum);
			indentcondition.put("indentnote", indentnote);
			*/
			
			BaseRes baseRes = ServiceFactory.getIndentsService()
				.createIndent(indentRes);
			
			String gsonString = gson.toJson(baseRes);
			LoggerManager.def.info("#####getIndentsByCondition,Gson串 = "
					+ gsonString + "########");
			// 返回json数据给客户端
			this.print(gsonString);
		} catch (Exception e) {
			LoggerManager.def.error("#####getIndentsByCondition errors" + e);
			this.print(gson.toJson(new BaseRes(ErrorCode.SYSTEM_ERROR)));
		}
		return null;
	}
	
	public String getdeleteIndentsByCondition() {
		LoggerManager.def.info("获取客户端参数：orderField=" + orderField + ",orderDirection=" + orderDirection 
				+ ",indentno=" + indentno );
			Gson gson = new Gson();
			
			try {
				BaseRes baseRes = ServiceFactory.getIndentsService().deleteIndent(indentno);
				String gsonString = gson.toJson(baseRes);
				
				LoggerManager.def.info("#####getdeleteIndentsByCondition,Gson串 = "
						+ gsonString + "########");
				// 返回json数据给客户端
				this.print(gsonString);
				
			} catch (Exception e) {
				LoggerManager.def.error("#####getdeleteIndentsByCondition errors" + e);
				this.print(gson.toJson(new BaseRes(ErrorCode.SYSTEM_ERROR)));
			}
			return carteno;
	}

	public String getOrderField() {
		return orderField;
	}

	public void setOrderField(String orderField) {
		this.orderField = orderField;
	}

	public String getOrderDirection() {
		return orderDirection;
	}

	public void setOrderDirection(String orderDirection) {
		this.orderDirection = orderDirection;
	}

	public String getIndentno() {
		return indentno;
	}

	public void setIndentno(String indentno) {
		this.indentno = indentno;
	}

	public String getIndentstate() {
		return indentstate;
	}

	public void setIndentstate(String indentstate) {
		this.indentstate = indentstate;
	}

	public String getDtno() {
		return dtno;
	}

	public void setDtno(String dtno) {
		this.dtno = dtno;
	}

	public String getCarteno() {
		return carteno;
	}

	public void setCarteno(String carteno) {
		this.carteno = carteno;
	}

	public String getPricsum() {
		return pricsum;
	}

	public void setPricsum(String pricsum) {
		this.pricsum = pricsum;
	}

	public String getIndentnote() {
		return indentnote;
	}

	public void setIndentnote(String indentnote) {
		this.indentnote = indentnote;
	}

	public IndentRes getIndentRes() {
		return indentRes;
	}

	public void setIndentRes(IndentRes indentRes) {
		this.indentRes = indentRes;
	}

	
}
