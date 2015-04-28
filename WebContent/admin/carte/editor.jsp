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
	<c:if test="${carte == null}">
		<form id="editorForm" name="editorForm"
			action="${webContextPath}/admin/carte/insert?navTabId=carteTab&callbackType=closeCurrent"
			method="POST" enctype="multipart/form-data"
			onsubmit="return iframeCallback(this,dialogAjaxDone);">
	</c:if>
	<c:if test="${carte != null}">
		<form id="editorForm" name="editorForm"
			action="${webContextPath}/admin/carte/update?navTabId=carteTabb&callbackType=closeCurrent"
			method="POST" enctype="multipart/form-data"
			onsubmit="return iframeCallback(this,dialogReloadNavTab);">
	</c:if>
	<div class="pageFormContent" layoutH="58">
		<c:if test="${carte != null}">
			<p>
				<label style="width: 140px">NO：</label> <input type="text"
					name="carte.id" id="carte.id" class="required" style="width: 200px"
					value="${carte.id}" readonly />
			</p>
		</c:if>
		<p>
			<label style="width: 140px">菜名编号：</label> <input type="text"
				name="carte.carteno" id="carte.carteno" class="required"
				style="width: 200px" value="${carte.carteno}" />
		</p>
		<p>
			<label style="width: 140px">菜名：</label> <input type="text"
				name="carte.cartename" id="carte.cartename" class="required"
				style="width: 200px" value="${carte.cartename}" />
		</p>
				<p>
			<label style="width: 140px">材料：</label> <input type="text"
				name="carte.material" id="carte.material" class="required"
				style="width: 200px" value="${carte.material}" />
		</p>
		<p>
			<label style="width: 140px">简介：</label> <input type="text"
				name="carte.synopsis" id="carte.synopsis" class="required"
				style="width: 200px" value="${carte.synopsis}" />
		</p>
		<p>
			<label style="width: 140px">类别编号：</label>
			<!-- 这个下拉列表 -->
			<select name="carte.classesno">
			<c:forEach items="${classesList }" var="classes">
				<option value="${classes.classesname }">${classes.classesname}</option>
			</c:forEach>
			</select>
		</p>
		<p>
			<label style="width: 140px">价格：</label> <input type="text"
				name="carte.price" id="carte.price" class="required"
				style="width: 200px" value="${carte.price}" />
		</p>
		<p>
			<label style="width: 140px">备注：</label> <input type="text"
				name="carte.cartenote" id="carte.cartenote" class="required"
				style="width: 200px" value="${carte.cartenote}" />
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