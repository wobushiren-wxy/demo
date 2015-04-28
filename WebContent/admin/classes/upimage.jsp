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
	
		<c:if test="${checkUrl == null}">
			<p>
				<label style="width: 140px; align: right;">请选择图片</label> <input
					type="file" name="apkFile" class="required" style="width: 200px" />
			</p>
		</c:if>
		<c:if test="${apkUrl != null}">
			<p>
			<label style="width: 140px">URL：</label> <input type="text"
				name="apkUrl.url" id="apkUrl.url"
				style="width: 200px" value="${apkUrl.url}" readonly/>
			</p>
		</c:if>

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