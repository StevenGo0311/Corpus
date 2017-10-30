<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">


<html>
 <head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>add</title> 
<link rel="stylesheet" type="text/css" href="../css/userAdd.css"/>

</head>

<body>
 
<div id="nav">
    <div id="header">
      <p><!--得到姓名-->
      <p>${user.uNickname },欢迎您</p>
    </div>
   <div id="left">
     <ul>
       <li><a href="${pageContext.request.contextPath }/servlet/UserInfoUIServlet">个人信息</a></li>
       <li>单词管理 
          <ul>
               <li><a href="${pageContext.request.contextPath }/servlet/UserSearchUIServlet">查询单词</a></li>
               <li><a href="${pageContext.request.contextPath }/servlet/UserAddUIServlet">添加单词</a></li>
          </ul>
       </li>
      </ul>
  </div>
<div id="right">
     <form action="${pageContext.request.contextPath }/servlet/AddWordServlet" method="post">
     <p>单词
    <input type="text" name="word" required="required"/></p>
     <p>分类
       <select type="text" id= "category" name="category" />
               <c:forEach var="category" items="${categorys }">
     	           <option>${category }</option>
               </c:forEach>
        
               
     </select></p>
     <p>词性 
   <select type="text" name="nominal"  required="required"/>
   		<c:forEach var="nominal" items="${nominals }">
     	           <option>${nominal }</option>
               </c:forEach>
   </select></p>
   <p>词义
   <input type="text" name="mean"  required="required"/></p>
     <p>例句 
    <input type="text" name="sentence"  required="required"/></p>
   
    <button class="but" type="submit" >提交</button> ${addWordForm.errors.blank }${exist }${success }
    </form>
  </div>
 </div>
</body>
</html>
