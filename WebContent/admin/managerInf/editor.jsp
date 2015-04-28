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
	<c:if test="${managerInf == null}">
		<form id="editorForm" name="editorForm"
			action="${webContextPath}/admin/managerInf/insert?navTabId=managerInfTab&callbackType=closeCurrent"
			method="POST" enctype="multipart/form-data"
			onsubmit="return iframeCallback(this,dialogAjaxDone);">
	</c:if>
	<c:if test="${managerInf != null}">
		<form id="editorForm" name="editorForm"
			action="${webContextPath}/admin/managerInf/update?navTabId=managerInfTabb&callbackType=closeCurrent"
			method="POST" enctype="multipart/form-data"
			onsubmit="return iframeCallback(this,dialogReloadNavTab);">
	</c:if>
	<div class="pageFormContent" layoutH="58">
		<c:if test="${managerInf != null}">
			<p>
				<label style="width: 140px">NO：</label> <input type="text"
					name="managerInf.id" id="managerInf.id" class="required" style="width: 200px"
					value="${managerInf.id}" readonly />
			</p>
		</c:if>
		<p>
			<label style="width: 140px">用户名：</label> <input type="text"
				name="managerInf.miuser" id="managerInf.miuser" class="required"
				style="width: 200px" value="${managerInf.miuser}" />
		</p>
		<p>
			<label style="width: 140px">密码：</label> <input type="text"
				name="managerInf.mipwd" id="managerInf.mipwd" class="required"
				style="width: 200px" value="${managerInf.mipwd}" />
		</p>
				<p>
			<label style="width: 140px">权限号：</label> <input type="text"
				name="managerInf.jurisdiction" id="managerInf.jurisdiction" class="required"
				style="width: 200px" value="${managerInf.jurisdiction}" />
		</p>
		<p>
			<label style="width: 140px">管理员姓名：</label> <input type="text"
				name="managerInf.miname" id="managerInf.miname" class="required"
				style="width: 200px" value="${managerInf.miname}" />
		</p>
		<p>
			<label style="width: 140px">备注：</label> <input type="text"
				name="managerInf.minote" id="managerInf.minote" class="required"
				style="width: 200px" value="${managerInf.minote}" />
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