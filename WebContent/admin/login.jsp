<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ include file="admin.inc.jsp"%>
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		<title>用户登录</title>
		<c:set value="${contextPath}" var="preUrl"></c:set>
		<script type="text/javascript" src="${preUrl}/js/jquery-1.10.2.min.js"></script>
		<link href="${preUrl}/css/login.css" rel="stylesheet" type="text/css" />
		<script>
			function getQueryString(miuser) {
			    var reg = new RegExp("(^|&)" + miuser + "=([^&]*)(&|$)", "i");
			    var r = window.location.search.substr(1).match(reg);
			    if (r != null) return unescape(r[2]); return null;
		    }		
			function clearAll(){
				$("#miuser")[0].value = "";
				$("#mipwd")[0].value = "";
				//document.getElementById("username").value = "";
				//document.getElementById("userpassword").value = "";
			}
			function submitLogin(){
				$("#to_url")[0].value = getQueryString("to_url");
				$("#loginForm")[0].submit();
			}
			document.onkeydown=keyListener; 
			function keyListener(e){ 
			    e = e ? e : event;
			    if(e.keyCode == 13){ 
			    	submitLogin(); 
			    } 
			} 
		</script>
	</head>
	<body>
	
	    <div id="login">
		
		     <div id="top" class="abc">
			      <div id="top_left"><img src="${preUrl}/images/login_03.gif" /></div>
				  <div id="top_center"></div>
			 </div>
			 
			 <div id="center">
			      <div id="center_left"></div>
				  <div id="center_middle">
				       <form action="${webContextPath}/admin/login/submit" method="post" id="loginForm">
				       <input type="hidden" name="to_url" id="to_url" />
				       <div id="error"><font color="red">${error}</font></div>
				       <div id="user">用 户
				         <input type="text" name="miuser" id="miuser" value=""/>
				       </div>
					   <div id="password">密   码
					     <input type="password" name="mipwd" id="mipwd" value="" />
					   </div>
					   <div id="btn"><a href="#nogo;" onclick="submitLogin()">登录</a><a onclick="clearAll()" href="#nogo;">清空</a></div>
				       </form>
				  </div>
				  <div id="center_right"></div>		 
			 </div>
			 <div id="down">
			      <div id="down_left">
				      <div id="inf">
	                       <span class="inf_text">版本信息</span>
						   <span class="copyright">开放平台后台管理系统</span>
				      </div>
				  </div>
				  <div id="down_center"></div>		 
			 </div>
	
		</div>
	</body>
</html>
