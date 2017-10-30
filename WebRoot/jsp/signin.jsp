<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html lang="en">  
<head>  
    <meta charset="UTF-8">  
    <title>SignIn</title>  
    <link rel="stylesheet" type="text/css" href="../css/signin.css"/>  
</head>  
<body>  
    <div id="login">  
        <h1>SignIn</h1>  
        <form action="${pageContext.request.contextPath }/servlet/SigninServlet" method="post" >  
        <input type="text" required="required" placeholder="用户名" name="username"></input>  
            <input type="text" required="required" placeholder="昵称" name="nickname"></input> 
            <input type="password" required="required" placeholder="密   码" name="password"></input>  
            <input type="password" required="required" placeholder="确认密码" name="surepassword"></input>
            <select type="text" required="required" placeholder="用户身份" name="rule" >
            <option>用户身份</option>
            <option>普通用户</option>
            <option>管理员</option>
            </select>
            
        <input type="text" required="required" placeholder="手机号码" name="phone"></input> 
        <input type="text" required="required" placeholder="电子邮箱" name="eMail"></input> 
        <input type="text" required="required" placeholder="密保问题" name="question"></input> 
        <input type="text" required="required" placeholder="密保答案" name="answer"></input> 
        <button class="but" type="submit">提交</button> 
        <button class="but" type="reset">重置</button> 
        </form> 
        <br/> <br/>
    </div>  
</body>  
</html> 