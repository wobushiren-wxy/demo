<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" trimDirectiveWhitespaces="true"%>
<%@include file="../admin.inc.jsp"%>
<form method="post" id="pagerForm" action="${webContextPath}/admin/foodshop/list" onsubmit="return navTabSearch(this)" >
   
	<input type="hidden" name="pageNum" value="1" /> 
	<input type="hidden" name="numPerPage" value="${page.numPerPage}" />
	<input type="hidden" name="orderField" value="${orderField}"/>  
	<input type="hidden" name="orderDirection" value="${orderDirection}"/> 
</form>
<div class="pageHeader">
	<form onsubmit="return navTabSearch(this);" action="${webContextPath}/admin/foodshop/list"
		method="post">
		<div class="searchBar">
			<table class="searchContent">
				<tr>
					<td>店名名称：<input type="text" name="foodshop.fsname" />
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
            <a class="add" href="${webContextPath}/admin/foodshop/add" target="dialog" mask="true" width="450" height="350" title="添加">
               <span>添加</span>
            </a>
         </li>
          <li>
            <a class="delete" target="selectedTodo" rel="ids" href="${webContextPath}/admin/foodshop/del"
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
               <th width="7%"  orderField="id" class="${orderDirection}" style="color: #D44A0C">NO</th>
               <th width="7%"  orderField="businesslicense" class="${orderDirection}" >营业执照</th>
               <th width="7%"  orderField="fsname" class="${orderDirection}" >店名</th>
               <th width="10%"  orderField="fsphone" class="${orderDirection}" >联系电话</th>
               <th width="7%"  orderField="fsaddress" class="${orderDirection}" >地址</th>
               <th width="10%"  orderField="fstime" class="${orderDirection}" >创建时间</th>  
               <th width="15%"  orderField="fsdescribe" class="${orderDirection}" >描述</th> 
               <th width="7%"  orderField="fsnote" class="${orderDirection}" >备注</th>             
               <th width="7%">编辑</th>
               <th width="7%">删除</th>
            </tr>
         </thead>
         <tbody>
            <c:forEach var="foodshop" items="${foodshopList}" varStatus="s">
               <tr target="headId" rel="${foodshop.id}">
                  <td><input name="ids" value="${foodshop.id}" type="checkbox"></td>
                  <td>${foodshop.id}</td>
                  <td>${foodshop.businesslicense}</td>
                  <td>${foodshop.fsname}</td>
                  <td>${foodshop.fsphone}</td>
                  <td>${foodshop.fsaddress}</td>
                 <td><fmt:formatDate value="${foodshop.fstime}" pattern="yyyy-MM-dd HH:mm:ss" /></td>
                  <td>${foodshop.fsdescribe}</td>
                 <td>${foodshop.fsnote}</td>
                  <td><a title="编辑" href="${webContextPath}/admin/foodshop/edit?id=${foodshop.id}" target="dialog" mask="true" width="450" height="350" class="btnEdit">编辑</a></td>
                  <td><a title="确定要删除该条记录吗?" target="ajaxTodo" href="${webContextPath}/admin/foodshop/del?ids=${foodshop.id}"
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
