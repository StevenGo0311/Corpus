<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>superUser</title> 
<link rel="stylesheet" type="text/css" href="../css/superUser.css"/>
</head>
<body>
<div id="nav">
    <div id="header">
      <p><!--得到姓名-->
      <p>${user.uNickname },欢迎您</p>
    </div>
  <div id="left">
     <ul>
       <li><a href="${pageContext.request.contextPath }/servlet/SuperUserUIServlet">普通用户</a></li>
       <li><a href="${pageContext.request.contextPath }/servlet/SuperManageUIServlet"">管理员</a> </li>
     </ul>
  </div>
   <div id="right">
     <table width="1280" height="700" border="10" cellspacing="0">
       <tr>
         <th width="100" scope="col">用户名</th>
         <th width="180" scope="col">密码</th>
         <th width="100" scope="col">昵称</th>
         <th width="180" scope="col">手机号</th>
         <th width="180" scope="col">邮箱</th>
       </tr>
       <c:forEach var="commonUser" items="${commonUsers }">
       <tr>
         <td>${commonUser.uName }</td>
         <td>${commonUser.uPassword }</td>
         <td>${commonUser.uNickname }</td>
         <td>${commonUser.uTelNumber }</td>
         <td>${commonUser.uEmail }</td>
       </tr>
       </c:forEach>
     </table>
  </div>
</div>
</body>
</html>
