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
	<c:if test="${diningtable == null}">
		<form id="editorForm" name="editorForm"
			action="${webContextPath}/admin/diningtable/insert?navTabId=diningtableTab&callbackType=closeCurrent"
			method="POST" enctype="multipart/form-data"
			onsubmit="return iframeCallback(this,dialogAjaxDone);">
	</c:if>
	<c:if test="${diningtable != null}">
		<form id="editorForm" name="editorForm"
			action="${webContextPath}/admin/diningtable/update?navTabId=diningtableTabb&callbackType=closeCurrent"
			method="POST" enctype="multipart/form-data"
			onsubmit="return iframeCallback(this,dialogReloadNavTab);">
	</c:if>
	<div class="pageFormContent" layoutH="58">
		<c:if test="${diningtable != null}">
			<p>
				<label style="width: 140px">NO：</label> <input type="text"
					name="diningtable.id" id="diningtable.id" class="required" style="width: 200px"
					value="${diningtable.id}" readonly />
			</p>
		</c:if>
		<p>
			<label style="width: 140px">桌号：</label> <input type="text"
				name="diningtable.dtno" id="diningtable.dtno" class="required"
				style="width: 200px" value="${diningtable.dtno}" />
		</p>
		<p>
			<label style="width: 140px">桌名：</label> <input type="text"
				name="diningtable.dtname" id="diningtable.dtname" class="required"
				style="width: 200px" value="${diningtable.dtname}" />
		</p>
				
		<p>
			<label style="width: 140px">备注：</label> <input type="text"
				name="diningtable.dtnote" id="diningtable.dtnote" class="required"
				style="width: 200px" value="${diningtable.dtnote}" />
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