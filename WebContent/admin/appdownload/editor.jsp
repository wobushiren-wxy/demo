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
	<c:if test="${appdownload == null}">
		<form id="editorForm" name="editorForm"
			action="${webContextPath}/admin/appdownload/insert?navTabId=appdownloadTab&callbackType=closeCurrent"
			method="POST" enctype="multipart/form-data"
			onsubmit="return iframeCallback(this,dialogAjaxDone);">
	</c:if>
	<c:if test="${appdownload != null}">
		<form id="editorForm" name="editorForm"
			action="${webContextPath}/admin/appdownload/update?navTabId=appdownloadTab&callbackType=closeCurrent"
			method="POST" enctype="multipart/form-data"
			onsubmit="return iframeCallback(this,dialogReloadNavTab);">
	</c:if>
	
	<div class="pageFormContent" layoutH="58">
		<c:if test="${appdownload != null}">
			<p>
				<label style="width: 140px">NO：</label> <input type="text"
					name="appdownload.id" id="appdownload.id" class="required" style="width: 200px"
					value="${appdownload.id}" readonly />
			</p>
		</c:if>
		<p>
			<label style="width: 140px">App版本：</label> <input type="text"
				name="appdownload.appver" id="appdownload.appver" class="required"
				style="width: 200px" value="${appdownload.appver}" />
		</p>
		
		<c:if test="${appdownload == null}">
			<p>
				<label style="width: 140px; align: right;">请选择文件</label> 
				<input type="file" name="appFile" class="required" style="width: 200px" />
			</p>
		</c:if>

		<p>
			<label style="width: 140px">上传管理员：</label> <input type="text"
				name="appdownload.miuser" id="appdownload.miuser" class="required"
				style="width: 200px" value="${appdownload.miuser}" />
		</p>
		<p>
			<label style="width: 140px">备注：</label> <input type="text"
				name="appdownload.appnote" id="appdownload.appnote" class="required"
				style="width: 200px" value="${appdownload.appnote}" />
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