<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" trimDirectiveWhitespaces="true"%>
<%@include file="../admin.inc.jsp"%>
<form method="post" id="pagerForm" action="${webContextPath}/admin/indent/list" onsubmit="return navTabSearch(this)" >
   
	<input type="hidden" name="pageNum" value="1" /> 
	<input type="hidden" name="numPerPage" value="${page.numPerPage}" />
	<input type="hidden" name="orderField" value="${orderField}"/>  
	<input type="hidden" name="orderDirection" value="${orderDirection}"/> 
</form>
<div class="pageHeader">
	<form onsubmit="return navTabSearch(this);" action="${webContextPath}/admin/indent/list"
		method="post">
		<div class="searchBar">
			<table class="searchContent">
				<tr>
					<td>订单号查询：<input type="text" name="indent.indentno" />
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
            <a class="add" href="${webContextPath}/admin/indent/add" target="dialog" mask="true" width="450" height="350" title="添加">
               <span>添加</span>
            </a>
         </li>
          <li>
            <a class="delete" target="selectedTodo" rel="ids" href="${webContextPath}/admin/indent/del"
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
               <th width="7%"  orderField=indentno class="${orderDirection}" >订单号</th>
               <th width="7%"  orderField="indentstate" class="${orderDirection}" >订单状态</th>
               <th width="7%"  orderField="dtno" class="${orderDirection}" >桌号</th>
               <th width="7%"  orderField="carteno" class="${orderDirection}" >菜单号</th>
               <th width="7%"  orderField="pricsum" class="${orderDirection}" >总价</th>
               <th width="10%"  orderField="indenttime" class="${orderDirection}" >创建时间</th>  
               <th width="7%"  orderField="indentnote" class="${orderDirection}" >备注</th>             
               <th width="7%">编辑</th>
               <th width="7%">删除</th>
            </tr>
         </thead>
         <tbody>
            <c:forEach var="indent" items="${indentList}" varStatus="s">
               <tr target="headId" rel="${indent.id}">
                  <td><input name="ids" value="${indent.id}" type="checkbox"></td>
                  <td>${indent.id}</td>
                  <td>${indent.indentno}</td>
                  <td>${indent.indentstate}</td>
                  <td>${indent.dtno}</td>
                  <td>${indent.carteno}</td>
                  <td>${indent.pricsum}</td>
                 <td><fmt:formatDate value="${indent.indenttime}" pattern="yyyy-MM-dd HH:mm:ss" /></td>
                 <td>${indent.indentnote}</td>
                  <td><a title="编辑" href="${webContextPath}/admin/indent/edit?id=${indent.id}" target="dialog" mask="true" width="450" height="350" class="btnEdit">编辑</a></td>
                  <td><a title="确定要删除该条记录吗?" target="ajaxTodo" href="${webContextPath}/admin/indent/del?ids=${indent.id}"
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
