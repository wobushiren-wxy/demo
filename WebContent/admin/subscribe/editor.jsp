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
	<c:if test="${subscribe == null}">
		<form id="editorForm" name="editorForm"
			action="${webContextPath}/admin/subscribe/insert?navTabId=subscribeTab&callbackType=closeCurrent"
			method="POST" enctype="multipart/form-data"
			onsubmit="return iframeCallback(this,dialogAjaxDone);">
	</c:if>
	<c:if test="${subscribe != null}">
		<form id="editorForm" name="editorForm"
			action="${webContextPath}/admin/subscribe/update?navTabId=subscribeTabb&callbackType=closeCurrent"
			method="POST" enctype="multipart/form-data"
			onsubmit="return iframeCallback(this,dialogReloadNavTab);">
	</c:if>
	<div class="pageFormContent" layoutH="58">
		<c:if test="${subscribe != null}">
			<p>
				<label style="width: 140px">NO：</label> <input type="text"
					name="subscribe.id" id="subscribe.id" class="required" style="width: 200px"
					value="${subscribe.id}" readonly />
			</p>
		</c:if>
		<p>
			<label style="width: 140px">预约号：</label> <input type="text"
				name="subscribe.subno" id="subscribe.subno" class="required"
				style="width: 200px" value="${subscribe.subno}" />
		</p>
		<p>
			<label style="width: 140px">预约时间：</label> <input type="text"
				name="subscribe.subtime" id="subscribe.subtime" class="required"
				style="width: 200px" value="${subscribe.subtime}" />
		</p>
		
		<p>
			<label style="width: 140px">用户名</label> <input type="text"
				name=subscribe.guuser id="subscribe.guuser" class="required"
				style="width: 200px" value="${subscribe.guuser}" />
		</p>
		<p>
			<label style="width: 140px">人数</label> <input type="text"
				name="subscribe.subnums" id="subscribe.subnums" class="required"
				style="width: 200px" value="${subscribe.subnums}" />
		</p>
		<p>
			<label style="width: 140px">备注：</label> <input type="text"
				name="subscribe.subnote" id="subscribe.subnote" class="required"
				style="width: 200px" value="${subscribe.subnote}" />
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