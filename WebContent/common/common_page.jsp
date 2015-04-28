<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>

<div class="panelBar" >
   <div class="pages">
	 <span>显示</span>
	 <select name="numPerPage"  onchange="navTabPageBreak({numPerPage:this.value})" class="combox">
		<c:forEach begin="10" end="10" step="10" varStatus="s">
			<option value="${s.index}" ${pageInfo.pageSize eq s.index ? "selected='selected'":""}>${s.index}</option>
		</c:forEach>
	 </select> 
	
	 <span>条，共${pageInfo.recordCount}条</span>
   </div>
   <div class="pagination" targetType="navTab" totalCount="${pageInfo.recordCount}" numPerPage="${pageInfo.pageSize}" pageNumShown="10" currentPage="${pageInfo.pageIndex}"></div>
</div>