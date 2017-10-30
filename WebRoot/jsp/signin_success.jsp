<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html lang="en">  
<head>  
    <meta charset="UTF-8">  
    <title>SignIn</title>  
    <link rel="stylesheet" type="text/css" href="../css/signin_success.css"/>  
</head>  
<body>  

      <div id="nav">
          <br/><br/><br/>
          <form method="post" action="${pageContext.request.contextPath }/servlet/LoginUIServlet">
              <p>注册成功，请点击”确定“按钮跳转界面...</p>
              <button class="but" type="submit">确定</button> 
          </form>
      </div>
 
      
       
</body>  
</html> 

