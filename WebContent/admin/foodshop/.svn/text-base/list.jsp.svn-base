<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" trimDirectiveWhitespaces="true"%>
<%@include file="../admin.inc.jsp"%>
<form method="post" id="pagerForm" action="${webContextPath}/admin/managerInf/list" onsubmit="return navTabSearch(this)" >
   
	<input type="hidden" name="pageNum" value="1" /> 
	<input type="hidden" name="numPerPage" value="${page.numPerPage}" />
	<input type="hidden" name="orderField" value="${orderField}"/>  
	<input type="hidden" name="orderDirection" value="${orderDirection}"/> 
</form>
<div class="pageHeader">
	<form onsubmit="return navTabSearch(this);" action="${webContextPath}/admin/managerInf/list"
		method="post">
		<div class="searchBar">
			<table class="searchContent">
				<tr>
					<td>分类名称：<input type="text" name="managerInf.miname" />
					</td>
					<!-- <td>创建日期：<input type="text" name="head.addtime" class="date" readonly="true" />
					</td> -->
				</tr>
			</table>
			<div class="subBar">
				<ul>
					<li><div class="buttonActive">
							<div class="buttonContent">
								<button type="submit">检索</button>
							</div>
						</div></li>
				</ul>
			</div>

		</div>
	</form>
</div>
<div class="pageContent" style="margin-top: -1px;">
   <div class="panelBar">
      <ul class="toolBar">
         <li>
            <a class="add" href="${webContextPath}/admin/managerInf/add" target="dialog" mask="true" width="450" height="350" title="添加">
               <span>添加</span>
            </a>
         </li>
          <li>
            <a class="delete" target="selectedTodo" rel="ids" href="${webContextPath}/admin/managerInf/del"
               title="确定要删除这些记录吗?">
               <span>删除</span>
            </a>
         </li>
      </ul>
   </div>
   <div>
      <table class="table" width="100%" layoutH="138">
         <thead>
            <tr>
               <th width="5%"><input type="checkbox" group="ids" class="checkboxCtrl"></th>
               <th width="10%"  orderField="id" class="${orderDirection}" style="color: #D44A0C">NO</th>
               <th width="10%"  orderField="miuser" class="${orderDirection}" >用户名</th>
               <th width="10%"  orderField="mipwd" class="${orderDirection}" >密码</th>
               <th width="10%"  orderField="jurisdiction" class="${orderDirection}" >权限号</th>
               <th width="10%"  orderField="miname" class="${orderDirection}" >管理员姓名</th>
               <th width="15%"  orderField="mitime" class="${orderDirection}" >创建时间</th>  
               <th width="10%"  orderField="minote" class="${orderDirection}" >备注</th>             
               <th width="10%">编辑</th>
               <th width="10%">删除</th>
            </tr>
         </thead>
         <tbody>
            <c:forEach var="managerInf" items="${managerInfList}" varStatus="s">
               <tr target="headId" rel="${managerInf.id}">
                  <td><input name="ids" value="${managerInf.id}" type="checkbox"></td>
                  <td>${managerInf.id}</td>
                  <td>${managerInf.miuser}</td>
                  <td>${managerInf.mipwd}</td>
                  <td>${managerInf.jurisdiction}</td>
                  <td>${managerInf.miname}</td>
                 <td><fmt:formatDate value="${managerInf.mitime}" pattern="yyyy-MM-dd HH:mm:ss" /></td>
                 <td>${managerInf.minote}</td>
                  <td><a title="编辑" href="${webContextPath}/admin/managerInf/edit?id=${managerInf.id}" target="dialog" mask="true" width="450" height="350" class="btnEdit">编辑</a></td>
                  <td><a title="确定要删除该条记录吗?" target="ajaxTodo" href="${webContextPath}/admin/managerInf/del?ids=${managerInf.id}"
                        class="btnDel" callback="navTabAjaxDone">删除</a></td>
               </tr>
            </c:forEach>
         </tbody>
      </table>
      
		<div class="panelBar">
			<div class="pages">
				<span>每页</span> <select class="combox" name="numPerPage"
					onchange="navTabPageBreak({numPerPage:this.value})">
					<c:forEach begin="5" end="15" step="5" varStatus="s">
						<option value="${s.index}"
							${page.numPerPage eq s.index ? 'selected="selected"' : ''}>${s.index}</option>
					</c:forEach>
				</select> <span>条 共${page.totalCount}条</span>
			</div>
	
			<div class="pagination" targetType="navTab"
				totalCount="${page.totalCount}" numPerPage="${page.numPerPage}"
				pageNumShown="10" currentPage="${page.pageNum}"></div>
		</div>       
      
   </div>
</div>
