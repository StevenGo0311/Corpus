<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>addclass</title> 
<link rel="stylesheet" type="text/css" href="../css/addCategory.css"/>
</head>

<body>
<div id="nav">
    <div id="header">
      <p><!--得到姓名-->
      <p>${user.uNickname },欢迎您</p>
    </div>
   <div id="left">
     <ul>
       <li><a href="${pageContext.request.contextPath }/servlet/ManageInfoUIServlet">个人信息</a></li>
       <li>单词管理 
          <ul>
               <li><a href="${pageContext.request.contextPath }/servlet/ManageSearchUIServlet"">查询单词</a></li>
               <li><a href="${pageContext.request.contextPath }/servlet/ManageAddUIServlet">添加单词</a></li>
               <li><a href="${pageContext.request.contextPath }/servlet/HighFrequency">高频单词</a></li>
               <li><a href="${pageContext.request.contextPath }/servlet/AddCategoryUIServlet">添加分类</a></li>
          </ul>
       </li>
      </ul>
  </div>
   <div id="right">
   <form action="${pageContext.request.contextPath }/servlet/AddCategoryServlet" method="post">
    <input type="text"  name="category">
    <button class="but" type="submit">添加</button><p>${category }</p>
    </form>
  </div>
 </div>
</body>
</html>
