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
	<c:if test="${classes == null}">
		<form id="editorForm" name="editorForm"
			action="${webContextPath}/admin/classes/insert?navTabId=classesTab&callbackType=closeCurrent"
			method="POST" enctype="multipart/form-data"
			onsubmit="return iframeCallback(this,dialogAjaxDone);">
	</c:if>
	<c:if test="${classes != null}">
		<form id="editorForm" name="editorForm"
			action="${webContextPath}/admin/classes/update?navTabId=classesTabb&callbackType=closeCurrent"
			method="POST" enctype="multipart/form-data"
			onsubmit="return iframeCallback(this,dialogReloadNavTab);">
	</c:if>
	<div class="pageFormContent" layoutH="58">
		<c:if test="${classes != null}">
			<p>
				<label style="width: 140px">NO：</label> <input type="text"
					name="classes.id" id="classes.id" class="required" style="width: 200px"
					value="${classes.id}" readonly />
			</p>
		</c:if>
		<p>
			<label style="width: 140px">类别号：</label> <input type="text"
				name="classes.classesno" id="classes.classesno" class="required"
				style="width: 200px" value="${classes.classesno}" />
		</p>
		<p>
			<label style="width: 140px">类别名：</label> <input type="text"
				name="classes.classesname" id="classes.classesname" class="required"
				style="width: 200px" value="${classes.classesname}" />
		</p>
			
		<p>
			<label style="width: 140px">备注：</label> <input type="text"
				name="classes.classesnote" id="classes.classesnote" class="required"
				style="width: 200px" value="${classes.classesnote}" />
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