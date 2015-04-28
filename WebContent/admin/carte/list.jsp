<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" trimDirectiveWhitespaces="true"%>
<%@include file="../admin.inc.jsp"%>
<form method="post" id="pagerForm" action="${webContextPath}/admin/carte/list" onsubmit="return navTabSearch(this)" >
   
	<input type="hidden" name="pageNum" value="1" /> 
	<input type="hidden" name="numPerPage" value="${page.numPerPage}" />
	<input type="hidden" name="orderField" value="${orderField}"/>  
	<input type="hidden" name="orderDirection" value="${orderDirection}"/> 
</form>
<div class="pageHeader">
	<form onsubmit="return navTabSearch(this);" action="${webContextPath}/admin/carte/list"
		method="post">
		<div class="searchBar">
			<table class="searchContent">
				<tr>
					<td>分类名称：<input type="text" name="carte.cartename" />
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
            <a class="add" href="${webContextPath}/admin/carte/add" target="dialog" mask="true" width="450" height="350" title="添加">
               <span>添加</span>
            </a>
         </li>
          <li>
            <a class="delete" target="selectedTodo" rel="ids" href="${webContextPath}/admin/carte/del"
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
               <th width="7%"  orderField="carteno" class="${orderDirection}" >菜名编号</th>
               <th width="7%"  orderField="cartename" class="${orderDirection}" >菜名</th>
               <th width="7%"  orderField="material" class="${orderDirection}" >材料</th>
               <th width="7%"  orderField="synopsis" class="${orderDirection}" >简介</th>
               <th width="7%"  orderField="classesno" class="${orderDirection}" >类别编号</th>  
               <th width="7%"  orderField="price" class="${orderDirection}" >价格</th>
               <th width="10%"  orderField="cartetime" class="${orderDirection}" >创建时间</th> 
               <th width="10%"  orderField="cartenote" class="${orderDirection}" >备注</th> 
               <th width="7%">编辑</th>
               <th width="7%">删除</th>
            </tr>
         </thead>
         <tbody>
            <c:forEach var="carte" items="${carteList}" varStatus="s">
               <tr target="headId" rel="${carte.id}">
                  <td><input name="ids" value="${carte.id}" type="checkbox"></td>
                  <td>${carte.id}</td>
                  <td>${carte.carteno}</td>
                  <td>${carte.cartename}</td>
                  <td>${carte.material}</td>
                  <td>${carte.synopsis}</td>
                  <td>${carte.classesno}</td>
                  <td>${carte.price}</td>
                 <td><fmt:formatDate value="${carte.cartetime}" pattern="yyyy-MM-dd HH:mm:ss" /></td>
                 <td>${carte.cartenote}</td>
                  <td><a title="编辑" href="${webContextPath}/admin/carte/edit?id=${carte.id}" target="dialog" mask="true" width="450" height="350" class="btnEdit">编辑</a></td>
                  <td><a title="确定要删除该条记录吗?" target="ajaxTodo" href="${webContextPath}/admin/carte/del?ids=${carte.id}"
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
