<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>search</title> 
<link rel="stylesheet" type="text/css" href="../css/manageSearch.css"/>
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
               <li><a href="${pageContext.request.contextPath }/servlet/ManageSearchUIServlet">查询单词</a></li>
               <li><a href="${pageContext.request.contextPath }/servlet/ManageAddUIServlet">添加单词</a></li>
               <li><a href="${pageContext.request.contextPath }/servlet/HighFrequency">高频单词</a></li>
               <li><a href="${pageContext.request.contextPath }/servlet/AddCategoryUIServlet">添加分类</a></li>
          </ul>
       </li>
      </ul>
  </div>
<div id="right">
    <form action="${pageContext.request.contextPath }/servlet/SearchWordServlet" method="post">
     <p>单词
        <input type="text" name="word" required="required"/>
        <button class="but" type="submit">查询</button>
    </form></p>
     <p>分类：${word}${wordSuccess.wCategory}<!--得到分类--></p>
     <p>词性：${word}${wordSuccess.wNominal}</p>
     <p>词义：${word}${wordSuccess.wMean}</p>
     <p>频次：${word}${wordSuccess.wFrequency}</p>
     <p>例句：${word}${wordSuccess.wSentence}</p>
    
  </div>
 </div>
</body>
</html>
