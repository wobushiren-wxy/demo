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
	<c:if test="${guinformation == null}">
		<form id="editorForm" name="editorForm"
			action="${webContextPath}/admin/guinformation/insert?navTabId=guinformationTab&callbackType=closeCurrent"
			method="POST" enctype="multipart/form-data"
			onsubmit="return iframeCallback(this,dialogAjaxDone);">
	</c:if>
	<c:if test="${guinformation != null}">
		<form id="editorForm" name="editorForm"
			action="${webContextPath}/admin/guinformation/update?navTabId=guinformationTabb&callbackType=closeCurrent"
			method="POST" enctype="multipart/form-data"
			onsubmit="return iframeCallback(this,dialogReloadNavTab);">
	</c:if>
	<div class="pageFormContent" layoutH="58">
		<c:if test="${guinformation != null}">
			<p>
				<label style="width: 140px">NO：</label> <input type="text"
					name="guinformation.id" id="guinformation.id" class="required" style="width: 200px"
					value="${guinformation.id}" readonly />
			</p>
		</c:if>
		<p>
			<label style="width: 140px">用户名：</label> <input type="text"
				name="guinformation.guuser" id="guinformation.guuser" class="required"
				style="width: 200px" value="${guinformation.guuser}" />
		</p>
		<p>
			<label style="width: 140px">密码：</label> <input type="text"
				name="guinformation.gupwd" id="guinformation.gupwd" class="required"
				style="width: 200px" value="${guinformation.gupwd}" />
		</p>
		<p>
			<label style="width: 140px">客户姓名:</label> <input type="text"
				name="guinformation.guname" id="guinformation.guname" class="required"
				style="width: 200px" value="${guinformation.guname}" />
		</p>
		<p>
			<label style="width: 140px">客户电话：</label> <input type="text"
				name="guinformation.guphone" id="guinformation.guphone" class="required"
				style="width: 200px" value="${guinformation.guphone}" />
		</p>
		<p>
			<label style="width: 140px">邮箱：</label> <input type="text"
				name="guinformation.gumail" id="guinformation.gumail" class="required"
				style="width: 200px" value="${guinformation.gumail}" />
		</p>
		<p>
			<label style="width: 140px">性别：</label> <input type="text"
				name="guinformation.gusex" id="guinformation.gusex" class="required"
				style="width: 200px" value="${guinformation.gusex}" />
		</p>
		<p>
			<label style="width: 140px">生日：</label> <input type="text"
				name="guinformation.gubirthday" id="guinformation.gubirthday" class="required"
				style="width: 200px" value="${guinformation.gubirthday}" />
		</p>
		<p>
			<label style="width: 140px">备注：</label> <input type="text"
				name="guinformation.gunote" id="guinformation.gunote" class="required"
				style="width: 200px" value="${guinformation.gunote}" />
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