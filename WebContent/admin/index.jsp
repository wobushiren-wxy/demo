<%@ page language="java" contentType="text/html; charset=UTF-8" trimDirectiveWhitespaces="true" pageEncoding="UTF-8"%>
<%@ page import="java.util.Date"%>
<%@ include file="admin.inc.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>后台管理</title>
<link href="${contextPath}/styles/dwz/themes/default/style.css" rel="stylesheet" type="text/css" media="screen" />
<link href="${contextPath}/styles/dwz/themes/css/core.css" rel="stylesheet" type="text/css" media="screen" />
<link href="${contextPath}/styles/dwz/themes/css/print.css" rel="stylesheet" type="text/css" media="print" />
<link href="${contextPath}/styles/validationEngine/css/validationEngine.jquery.css" rel="stylesheet" type="text/css"
   media="screen" />
<link href="${contextPath}/styles/ztree/css/zTreeStyle.css" rel="stylesheet" type="text/css" media="screen" />
<link href="${contextPath}/styles/uploadify/css/uploadify.css" rel="stylesheet" type="text/css" media="screen" />
<link href="${contextPath}/styles/dwz/themes/css/override.css" rel="stylesheet" type="text/css" media="screen" />
<link href="${contextPath}/styles/dwz/themes/css/new.css" rel="stylesheet" type="text/css" media="screen" />
<!-- add -->
<link href="${contextPath}/css/custom.css" rel="stylesheet" type="text/css" media="screen" />

<!--[if IE]>
<link href="${contextPath}/styles/dwz/themes/css/ieHack.css" rel="stylesheet" type="text/css" media="screen"/>
<![endif]-->
<!--[if lte IE 9]>
<script src="${contextPath}/styles/dwz/js/speedup.js" type="text/javascript"></script>
<![endif]-->
<script src="${contextPath}/styles/jquery/jquery-1.7.2.min.js" type="text/javascript"></script>
<script src="${contextPath}/styles/dwz/js/jquery.bgiframe.js" type="text/javascript"></script>
<%-- Form验证 --%>
<script src="${contextPath}/styles/validationEngine/js/languages/jquery.validationEngine-zh_CN.js"
   type="text/javascript" charset="utf-8"></script>
<script src="${contextPath}/styles/validationEngine/js/jquery.validationEngine-2.6.4.js" type="text/javascript"
   charset="utf-8"></script>
<script src="${contextPath}/styles/dwz/js/dwz.min.js" type="text/javascript"></script>
<script src="${contextPath}/styles/dwz/js/dwz.regional.zh.js" type="text/javascript"></script>
<%-- 自定义JS --%>
<script src="${contextPath}/styles/dwz/js/customer.js" type="text/javascript"></script>
<%-- upload --%>
<script src="${contextPath}/styles/uploadify/scripts/jquery.uploadify.min.js" type="text/javascript"></script>
<%-- zTree --%>
<script src="${contextPath}/styles/ztree/js/jquery.ztree.all-3.5.min.js" type="text/javascript"></script>
<%-- my97datepicker --%>
<script src="${contextPath}/js/my97datepicker/WdatePicker.js" type="text/javascript"></script>
<script type="text/javascript">
<!--
	$(function() {
		// 通过服务器访问来初始化
		DWZ.init("${contextPath}/styles/dwz/dwz.frag.xml", {
			loginUrl : "${contextPath}/login/timeout",
			loginTitle : "登录", // 弹出登录对话框
			debug : false, // 调试模式 【true|false】
			callback : function() {
				initEnv();
				$("#themeList").theme({
					themeBase : "${contextPath}/styles/dwz/themes"
				});
			}
		});
	});
//-->
</script>
</head>
<body scroll="no">
   <div id="layout">
      <div id="header">
         <div class="headerNav">
            <!-- <a class="logo" href="${webContextPath}/management/index">Logo</a> -->
            <ul class="nav">
               <%-- 				<li><a href="${contextPath}/index">主页</a></li> --%>
               <%-- 				<li><a href="${contextPath}/management/index/updateBase" target="dialog" mask="true" width="550" height="250">修改用户信息</a></li> --%>
               <%-- 				<li><a href="${contextPath}/management/index/updatePwd" target="dialog" mask="true" width="500" height="200">修改密码</a></li> --%>
               <li>
                  <a href="${webContextPath}/admin/logout">退出</a>
               </li>
            </ul>
         </div>
      </div>
      <div id="leftside">
         <div id="sidebar_s">
            <div class="collapse">
               <div class="toggleCollapse">
                  <div></div>
               </div>
            </div>
         </div>
         <div id="sidebar">
				<div class="toggleCollapse"><h2>主菜单</h2><div>收缩</div></div>

				<div class="accordion" fillSpace="sidebar">
					<div class="accordionHeader">
						<h2><span>Folder</span>管理模块</h2>
					</div>
					<div class="accordionContent">
						<ul class="tree treeFolder expand">
							
							<li><a href="#">管理员权限管理</a>
								<ul>
									<li><a href="${webContextPath}/admin/managerInf/list" target="navTab" rel="managerInfTab">权限管理列表</a></li>
								</ul>	
							</li>
							
							<li><a href="#">客户信息管理</a>
								<ul>
									<li><a href="${webContextPath}/admin/guinformation/list" target="navTab" rel="guinformationTab">客户信息列表</a></li>
								</ul>	
							</li>
								<li><a href="#">类别管理</a>
								<ul>
									<li><a href="${webContextPath}/admin/classes/list" target="navTab" rel="classesTab">类别信息列表</a></li>
								</ul>
							</li>
							</li>
								<li><a href="#">订单管理</a>
								<ul>
									<li><a href="${webContextPath}/admin/indent/list" target="navTab" rel="indentTab">订单信息列表</a></li>
								</ul>	
							</li>
							<li><a href="#">菜单管理</a>
								<ul>
									<li><a href="${webContextPath}/admin/carte/list" target="navTab" rel="carteTab">菜单列表</a></li>
								</ul>	
							</li>
							
							<li><a href="#">桌面管理</a>
								<ul>
									<li><a href="${webContextPath}/admin/diningtable/list" target="navTab" rel="diningtableTab">桌面列表</a></li>
								</ul>	
							</li>
								<li><a href="#">餐饮店管理</a>
								<ul>
									<li><a href="${webContextPath}/admin/foodshop/list" target="navTab" rel="foodshopTab">餐饮店列表</a></li>
								</ul>	
							</li>
							
							<li><a href="#">菜评管理</a>
								<ul>
									<li><a href="${webContextPath}/admin/foodevaluation/list" target="navTab" rel="foodevaluationTab">菜评列表</a></li>
								</ul>	
							</li>
							
							<li><a href="#">App管理</a>
								<ul>
									<li><a href="${webContextPath}/admin/appdownload/list" target="navTab" rel="appdownloadTab">App管理</a></li>
								</ul>	
							</li>
							
							<li><a href="#">图片管理</a>
								<ul>
									<li><a href="${webContextPath}/admin/imgtransmission/list" target="navTab" rel="imgtransmissionTab">图片管理</a></li>
								</ul>	
							</li>
							
							<li><a href="#">预约信息管理</a>
								<ul>
									<li><a href="${webContextPath}/admin/subscribe/list" target="navTab" rel="subscribeTab">预约信息管理</a></li>
								</ul>	
							</li>
							
						</ul>
							
					</div>
					
					
				</div>
			</div>
      </div>
      <div id="container">
         <div id="navTab" class="tabsPage">
            <div class="tabsPageHeader">
               <div class="tabsPageHeaderContent">
                  <!-- 显示左右控制时添加 class="tabsPageHeaderMargin" -->
                  <ul class="navTab-tab">
                     <li tabid="main" class="main">
                        <a href="javascript:void(0)">
                           <span><span class="home_icon">主页</span></span>
                        </a>
                     </li>
                  </ul>
               </div>
               <div class="tabsLeft">left</div>
               <!-- 禁用只需要添加一个样式 class="tabsLeft tabsLeftDisabled" -->
               <div class="tabsRight">right</div>
               <!-- 禁用只需要添加一个样式 class="tabsRight tabsRightDisabled" -->
               <div class="tabsMore">more</div>
            </div>
            <ul class="tabsMoreList">
               <li>
                  <a href="javascript:void(0)">主页</a>
               </li>
            </ul>
            <div class="navTab-panel tabsPageContent layoutBox">
               <div class="page unitBox">
                  <div class="accountInfo">
                     <div class="right">
                        <p>
                           <fmt:formatDate value="<%=new Date()%>" pattern="yyyy-MM-dd EEEE" />
                        </p>
                     </div>
                     <p>
                     <!-- 这里看看.. -->
                        <span>欢迎,chlingm.
                        </span>
                     </p>
                  </div>
                  <div class="pageFormContent" layouth="80">
                     <fieldset>
                        <legend>基本信息</legend>
                        <dl>
                           <dt>登录名称：</dt>
                           <dd>
                              <span class="unit">chlingm</span>
                           </dd>
                        </dl>
                        <dl>
                           <dt>真实名字：</dt>
                           <dd>
                              <span class="unit">chlingm</span>
                           </dd>
                        </dl>
                     </fieldset>
                  </div>
               </div>
            </div>
         </div>
      </div>
   </div>
   <div id="footer"></div>
</body>
</html>