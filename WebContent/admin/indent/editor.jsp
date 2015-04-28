<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="../admin.inc.jsp"%>


<script>
	/* function toSubmit() {
		//document.editorForm.submit();
		//validateCallback($("#editorForm"), dialogReloadNavTab);
	} */
</script>
<div class="pageContent">
	<c:if test="${indent == null}">
		<form id="editorForm" name="editorForm"
			action="${webContextPath}/admin/indent/insert?navTabId=indentTab&callbackType=closeCurrent"
			method="POST" enctype="multipart/form-data"
			onsubmit="return iframeCallback(this,dialogAjaxDone);">
	</c:if>
	<c:if test="${indent != null}">
		<form id="editorForm" name="editorForm"
			action="${webContextPath}/admin/indent/update?navTabId=indentTabb&callbackType=closeCurrent"
			method="POST" enctype="multipart/form-data"
			onsubmit="return iframeCallback(this,dialogReloadNavTab);">
	</c:if>
	<div class="pageFormContent" layoutH="58">
		<c:if test="${indent != null}">
			<p>
				<label style="width: 140px">NO：</label> <input type="text"
					name="indent.id" id="indent.id" class="required" style="width: 200px"
					value="${indent.id}" readonly />
			</p>
		</c:if>
		<p>
			<label style="width: 140px">订单号：</label> <input type="text"
				name="indent.indentno" id="indent.indentno" class="required"
				style="width: 200px" value="${indent.indentno}" />
		</p>
		<p>
			<label style="width: 140px">订单状态：</label> <input type="text"
				name="indent.indentstate" id="indent.indentstate" class="required"
				style="width: 200px" value="${indent.indentstate}" />
		</p>
		<p>
			<label style="width: 140px">桌号:</label> 
			<!-- diningtable下拉列表 -->
			<select name="indent.dtno">
			<c:forEach items="${diningtableList }" var="diningtable">
				<option style="width: 140px" value="${diningtable.dtno }" >${diningtable.dtno}</option>
			</c:forEach>
			</select>
		</p>
		<p>
		 <!--style="width: 140px"  -->
		
			<label style="width: 140px">菜单号：</label> 
			<!-- carte下拉列表 -->
			<select name="indent.carteno">
			<c:forEach items="${carteList }" var="carte">
				<option style="width: 140px" value="${carte.carteno }" >${carte.carteno}</option>
			</c:forEach>
			</select>
		</p>
		<p>
			<label style="width: 140px">总价：</label> <input type="text"
				name="indent.pricsum" id="indent.pricsum" class="required"
				style="width: 200px" value="${indent.pricsum}" />
		</p>
		<p>
			<label style="width: 140px">备注：</label> <input type="text"
				name="indent.indentnote" id="indent.indentnote" class="required"
				style="width: 200px" value="${indent.indentnote}" />
		</p>

	</div>
	<div class="formBar">
		<ul>
			<li>
				<input type="submit" value="确定" />
			</li>
			<li>
				<button type="button" class="close">关闭</button>
			</li>
		</ul>
	</div>
	</form>
	
</div>