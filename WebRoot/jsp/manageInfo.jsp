<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>manage</title> 
<link rel="stylesheet" type="text/css" href="../css/manageInfo.css"/>
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
     <p>用 户 名:${user.uName }</p>
     <p>昵  称:${user.uNickname }</p>
     <p>用户身份:${user.uRole }</p>
     <p>手机号码:${user.uTelNumber }</p>
     <p>电子邮箱:${user.uEmail }</p>
  </div>
 </div>
</body>
</html>
