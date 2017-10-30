<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html lang="en">  
<head>  
    <meta charset="UTF-8">  
    <title>Login</title>  
    <link rel="stylesheet" type="text/css" href="../css/login.css"/>  
</head>  
<body>  
    <div id="login">  
        <h1>Login</h1>  
        <form action="${pageContext.request.contextPath }/servlet/LoginServlet" method="post">  
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