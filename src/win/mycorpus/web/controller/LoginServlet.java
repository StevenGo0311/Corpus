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
		//�����������
		request.setCharacterEncoding("UTF-8");
		//���ձ�����
		LoginForm loginForm=new LoginForm();
		//�����ķ���
		BusinessServiceImpl businessServiceImpl=new BusinessServiceImpl();
		loginForm.setUsername(request.getParameter("username"));
		loginForm.setPassword(request.getParameter("password"));
		//�ж��û����Ƿ���Ч
		boolean b=loginForm.validate();
		if(!b){
			request.setAttribute("login", loginForm.getErrors().get("username")+loginForm.getErrors().get("password"));
			//ҳ����ת
			request.getRequestDispatcher("/jsp/login_false.jsp").forward(request, response);
			return;
		}
		//ִ�е�¼����������User����
		User user=businessServiceImpl.login(loginForm.getUsername(), loginForm.getPassword());
		//����˺���������벻��ȷ�����ص�¼
		if(user==null){
			request.setAttribute("login", "�˺Ż��������");
			request.getRequestDispatcher("/jsp/login_false.jsp").forward(request, response);
			return;
		}
		
		HttpSession session=request.getSession();
		session.setAttribute("user", user);
		session.setAttribute("uRole", user.getuRole());
		//request.setAttribute("user", user);
		//��¼�ɹ��������û������ת��ͬ����ҳ��
		if(user.getuRole().equals("��ͨ�û�")){
			request.getRequestDispatcher("/jsp/userInfo.jsp").forward(request, response);	
		}
		else if(user.getuRole().equals("����Ա")){
			request.getRequestDispatcher("/jsp/manageInfo.jsp").forward(request, response);
		}
		//��������Ա
		else{
			BusinessServiceImpl buessImpl=new BusinessServiceImpl();
			List<User> commonUsers=buessImpl.SeachUser("��ͨ�û�");
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
