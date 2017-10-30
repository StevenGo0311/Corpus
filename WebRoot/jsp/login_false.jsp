<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<head>  
    <meta charset="UTF-8">  
    <title>Login</title>  
    <link rel="stylesheet" type="text/css" href="../css/login_false.css"/>  
</head>  
<body>  
    <div id="login">  
        <h1>Login</h1>  
        <form action="${pageContext.request.contextPath }/servlet/LoginServlet"  method="post">  
            <p>${login}</p>
            <input type="text" required="required" placeholder="用户名" name="username"></input>  
            <input type="password" required="required" placeholder="密   码" name="password"></input>  
            <button class="but" type="submit">登录</button> 
        </form>  
        <form method="post" action="${pageContext.request.contextPath }/servlet/SigninUIServlet">
            <button class="but" >注册</button> 
        </form>
    </div>  
</body>  
</html> 