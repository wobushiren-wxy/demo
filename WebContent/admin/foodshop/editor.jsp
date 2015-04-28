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
	<c:if test="${foodshop == null}">
		<form id="editorForm" name="editorForm"
			action="${webContextPath}/admin/foodshop/insert?navTabId=foodshopTab&callbackType=closeCurrent"
			method="POST" enctype="multipart/form-data"
			onsubmit="return iframeCallback(this,dialogAjaxDone);">
	</c:if>
	<c:if test="${foodshop != null}">
		<form id="editorForm" name="editorForm"
			action="${webContextPath}/admin/foodshop/update?navTabId=foodshopTabb&callbackType=closeCurrent"
			method="POST" enctype="multipart/form-data"
			onsubmit="return iframeCallback(this,dialogReloadNavTab);">
	</c:if>
	<div class="pageFormContent" layoutH="58">
		<c:if test="${foodshop != null}">
			<p>
				<label style="width: 140px">NO：</label> <input type="text"
					name="foodshop.id" id="foodshop.id" class="required" style="width: 200px"
					value="${foodshop.id}" readonly />
			</p>
		</c:if>
		<p>
			<label style="width: 140px">营业执照：</label> <input type="text"
				name="foodshop.businesslicense" id="foodshop.businesslicense" class="required"
				style="width: 200px" value="${foodshop.businesslicense}" />
		</p>
		<p>
			<label style="width: 140px">店名：</label> <input type="text"
				name="foodshop.fsname" id="foodshop.fsname" class="required"
				style="width: 200px" value="${foodshop.fsname}" />
		</p>
				<p>
			<label style="width: 140px">联系电话：</label> <input type="text"
				name="foodshop.fsphone" id="foodshop.fsphone" class="required"
				style="width: 200px" value="${foodshop.fsphone}" />
		</p>
		<p>
			<label style="width: 140px">地址：</label> <input type="text"
				name="foodshop.fsaddress" id="foodshop.fsaddress" class="required"
				style="width: 200px" value="${foodshop.fsaddress}" />
		</p>
		<p>
			<label style="width: 140px">描述：</label> <input type="text"
				name="foodshop.fsdescribe" id="foodshop.fsdescribe" class="required"
				style="width: 200px" value="${foodshop.fsdescribe}" />
		</p>
		<p>
			<label style="width: 140px">备注：</label> <input type="text"
				name="foodshop.fsnote" id="foodshop.fsnote" class="required"
				style="width: 200px" value="${foodshop.fsnote}" />
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