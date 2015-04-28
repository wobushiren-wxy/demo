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
	<c:if test="${foodevaluation == null}">
		<form id="editorForm" name="editorForm"
			action="${webContextPath}/admin/foodevaluation/insert?navTabId=foodevaluationTab&callbackType=closeCurrent"
			method="POST" enctype="multipart/form-data"
			onsubmit="return iframeCallback(this,dialogAjaxDone);">
	</c:if>
	<c:if test="${foodevaluation != null}">
		<form id="editorForm" name="editorForm"
			action="${webContextPath}/admin/foodevaluation/update?navTabId=foodevaluationTabb&callbackType=closeCurrent"
			method="POST" enctype="multipart/form-data"
			onsubmit="return iframeCallback(this,dialogReloadNavTab);">
	</c:if>
	<div class="pageFormContent" layoutH="58">
		<c:if test="${foodevaluation != null}">
			<p>
				<label style="width: 140px">NO：</label> <input type="text"
					name="foodevaluation.id" id="foodevaluation.id" class="required" style="width: 200px"
					value="${foodevaluation.id}" readonly />
			</p>
		</c:if>
	
		<p>
			<label style="width: 140px">菜单号：</label> <input type="text"
				name="foodevaluation.carteno" id="foodevaluation.carteno" class="required"
				style="width: 200px" value="${foodevaluation.carteno}" />
		</p>
		<p>
			<label style="width: 140px">用户名：</label> <input type="text"
				name="foodevaluation.guuser" id="foodevaluation.guuser" class="required"
				style="width: 200px" value="${foodevaluation.guuser}" />
		</p>
		<p>
			<label style="width: 140px">菜名：</label> <input type="text"
				name="foodevaluation.cartename" id="foodevaluation.cartename" class="required"
				style="width: 200px" value="${foodevaluation.cartename}" />
		</p>
		<p>
			<label style="width: 140px">菜评价：</label> <input type="text"
				name="foodevaluation.carteping" id="foodevaluation.carteping" class="required"
				style="width: 200px" value="${foodevaluation.carteping}" />
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