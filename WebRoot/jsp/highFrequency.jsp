<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>frequency</title> 
<link rel="stylesheet" type="text/css" href="../css/highFrequency.css"/>
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
               <li><a href="${pageContext.request.contextPath }/servlet/ManageSearchUIServlet"t">查询单词</a></li>
               <li><a href="${pageContext.request.contextPath }/servlet/ManageAddUIServlet">添加单词</a></li>
               <li><a href="${pageContext.request.contextPath }/servlet/HighFrequency">高频单词</a></li>
               <li><a href="${pageContext.request.contextPath }/servlet/AddCategoryUIServlet">添加分类</a></li>
          </ul>
       </li>
     </ul>
  </div>
   <div id="right">
     <form action="${pageContext.request.contextPath }/servlet/ManageHighFrequency" method="post">
     <p> 分类
       <select type="text" name="categoryForm" />
               <option>请选择分类</option>
               <c:forEach var="category" items="${categorys }">
     	           <option>${category }</option>
               </c:forEach>
     </select>
     <button class="but" type="submit">查询</button><nobr>${success }${fail }</nobr></p>        
     </form >
     <div style="overflow:auto"> 
     <table width="1080" height="519" border="10" cellspacing="0">
       <tr>
         <th width="180" scope="col">单词</th>
         <th width="180" scope="col">分类</th>
         <th width="180" scope="col">词性</th>
         <th width="180" scope="col">词义</th>
         <th width="180" scope="col">频次</th>
         <th width="180" scope="col">操作</th>
       </tr>
       <c:forEach var="word" items="${words }"  >
       <form action="${pageContext.request.contextPath }/servlet/AlterHighFrequency">
       <tr>
         <td><input type="text" align="middle" name="word" value="${word.wWord }"  readonly="readonly"></inpout></td>
         <td><select type="text" name="category" />
               <c:forEach var="category" items="${categorys }">
     	           <c:if test="${word.wCategory eq category }"><option selected="selected">${category }</option></c:if>
     	           <c:if test="${word.wCategory ne category }"><option>${category }</option></c:if>
               </c:forEach>
             </select>
         </td>
         <td><select type="text" name="nominal" />
               <c:forEach var="nominal" items="${nominals }">
     	           <c:if test="${word.wNominal eq nominal }"><option selected="selected">${nominal }</option></c:if>
     	           <c:if test="${word.wNominal ne nominal }"><option>${nominal }</option></c:if>
               </c:forEach>
             </select>
         </td>
         <td><input type="text" align="middle" name="mean" value="${word.wMean}"></inpout></td>
         <td><input type="text" align="middle" name="frequency" value="${word.wFrequency}" readonly="readonly"></inpout></td>
         <td> <button type="submit">提交</button></td>
       </tr>
        </form>
       </c:forEach>
     </table>
      </div>
  </div>
</div>
</body>
</html>
