package win.mycorpus.web.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import win.mycorpus.domain.User;
import win.mycorpus.service.BusinessServiceImpl;
import win.mycorpus.web.form.LoginForm;


@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//解决乱码问题
		request.setCharacterEncoding("UTF-8");
		//接收表单数据
		LoginForm loginForm=new LoginForm();
		//公共的服务
		BusinessServiceImpl businessServiceImpl=new BusinessServiceImpl();
		loginForm.setUsername(request.getParameter("username"));
		loginForm.setPassword(request.getParameter("password"));
		//判断用户表单是否有效
		boolean b=loginForm.validate();
		if(!b){
			request.setAttribute("login", loginForm.getErrors().get("username")+loginForm.getErrors().get("password"));
			//页面跳转
			request.getRequestDispatcher("/jsp/login_false.jsp").forward(request, response);
			return;
		}
		//执行登录操作，返回User对象
		User user=businessServiceImpl.login(loginForm.getUsername(), loginForm.getPassword());
		//如果账号密码或密码不正确，返回登录
		if(user==null){
			request.setAttribute("login", "账号或密码错误");
			request.getRequestDispatcher("/jsp/login_false.jsp").forward(request, response);
			return;
		}
		
		HttpSession session=request.getSession();
		session.setAttribute("user", user);
		session.setAttribute("uRole", user.getuRole());
		//request.setAttribute("user", user);
		//登录成功，根据用户身份跳转不同的主页面
		if(user.getuRole().equals("普通用户")){
			request.getRequestDispatcher("/jsp/userInfo.jsp").forward(request, response);	
		}
		else if(user.getuRole().equals("管理员")){
			request.getRequestDispatcher("/jsp/manageInfo.jsp").forward(request, response);
		}
		//超级管理员
		else{
			BusinessServiceImpl buessImpl=new BusinessServiceImpl();
			List<User> commonUsers=buessImpl.SeachUser("普通用户");
			request.setAttribute("commonUsers", commonUsers);
			request.getRequestDispatcher("/jsp/superUser.jsp").forward(request, response);
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
