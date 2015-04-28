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
	<c:if test="${imgtransmission == null}">
		<form id="editorForm" name="editorForm"
			action="${webContextPath}/admin/imgtransmission/insert?navTabId=imgtransmissionTab&callbackType=closeCurrent"
			method="POST" enctype="multipart/form-data"
			onsubmit="return iframeCallback(this,dialogAjaxDone);">
	</c:if>
	<c:if test="${imgtransmission != null}">
		<form id="editorForm" name="editorForm"
			action="${webContextPath}/admin/imgtransmission/update?navTabId=imgtransmissionTab&callbackType=closeCurrent"
			method="POST" enctype="multipart/form-data"
			onsubmit="return iframeCallback(this,dialogReloadNavTab);">
	</c:if>
	
	<div class="pageFormContent" layoutH="58">
		<c:if test="${imgtransmission != null}">
			<p>
				<label style="width: 140px">NO：</label> <input type="text"
					name="imgtransmission.id" id="imgtransmission.id" class="required" style="width: 200px"
					value="${imgtransmission.id}" readonly />
			</p>
		</c:if>
		<p>
			<label style="width: 140px">图片姓名：</label> <input type="text"
				name="imgtransmission.imgname" id="imgtransmission.imgname" class="required"
				style="width: 200px" value="${imgtransmission.imgname}" />
		</p>
		
		<c:if test="${imgtransmission == null}">
			<p>
				<label style="width: 140px; align: right;">请选择图片文件</label> 
				<input type="file" name="imgFile" class="required" style="width: 200px" />
			</p>
		</c:if>

		<p>
			<label style="width: 140px">上传管理员：</label> <input type="text"
				name="imgtransmission.miuser" id="imgtransmission.miuser" class="required"
				style="width: 200px" value="${imgtransmission.miuser}" />
		</p>
		<p>
			<label style="width: 140px">备注：</label> <input type="text"
				name="imgtransmission.imgnote" id="imgtransmission.imgnote" class="required"
				style="width: 200px" value="${imgtransmission.imgnote}" />
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