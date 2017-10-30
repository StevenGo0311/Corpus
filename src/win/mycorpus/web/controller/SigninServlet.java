package win.mycorpus.web.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import win.mycorpus.dao.UserDao;
import win.mycorpus.daoImpl.UserDaoImpl;
import win.mycorpus.domain.User;
import win.mycorpus.exception.UserExistException;
import win.mycorpus.service.BusinessServiceImpl;
import win.mycorpus.web.form.SigninForm;


@WebServlet("/SigninServlet")
public class SigninServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//1.���ύ���ֶν��кϷ���У��
		SigninForm form=new SigninForm();
		request.setCharacterEncoding("UTF-8");
		//��form����������ݸ�ֵ
		form.setUsername(request.getParameter("username").trim());
		form.setPassword(request.getParameter("password").trim());
		form.setSurepassword(request.getParameter("surepassword").trim());
		form.setNickname(request.getParameter("nickname").trim());
		form.setRule(request.getParameter("rule").trim());
		form.seteMail(request.getParameter("eMail").trim());
		form.setPhone(request.getParameter("phone").trim());
		form.setQuestion(request.getParameter("question").trim());
		form.setAnswer(request.getParameter("answer").trim());
		//����
//		form.setUsername(new String(request.getParameter("username").getBytes("iso-8859-1"), "utf-8"));
//		form.setUsername(new String(request.getParameter("password").getBytes("iso-8859-1"), "utf-8"));
//		form.setUsername(new String(request.getParameter("surepassword").getBytes("iso-8859-1"), "utf-8"));
//		form.setUsername(new String(request.getParameter("nickname").getBytes("iso-8859-1"), "utf-8"));
//		form.setUsername(new String(request.getParameter("rule").getBytes("iso-8859-1"), "utf-8"));
//		form.setUsername(new String(request.getParameter("eMail").getBytes("iso-8859-1"), "utf-8"));
//		form.setUsername(new String(request.getParameter("phone").getBytes("iso-8859-1"), "utf-8"));
//		form.setUsername(new String(request.getParameter("question").getBytes("iso-8859-1"), "utf-8"));
//		form.setUsername(new String(request.getParameter("answer").getBytes("iso-8859-1"), "utf-8"));
		//����
//		System.out.println(form.getUsername());
//		System.out.println(form.getPassword());
//		System.out.println(form.getSurepassword());
//		System.out.println(form.getNickname());
//		System.out.println(form.getRule());
//		System.out.println(form.geteMail());
//		System.out.println(form.getPhone());
//		System.out.println("form:quesion"+form.getQuestion());
//		System.out.println("form:answer"+form.getAnswer());
		
		//2.���У��ʧ�ܣ����ص���ҳ�棬����У��ʧ����Ϣ
		boolean b=form.validata();
		if(!b){
			request.setAttribute("form", form);
			request.getRequestDispatcher("/jsp/signin_false.jsp").forward(request, response);
			return;
		}
				
		//3.�������ɹ��������service����ע������
		BusinessServiceImpl service=new BusinessServiceImpl();
		User user=new User();
		user.setuName(form.getUsername());
		user.setuPassword(form.getPassword());
		user.setuRole(form.getRule());
		user.setuEmail(form.geteMail());
		user.setuTelNumber(form.getPhone());
		user.setuNickname(form.getNickname());
		user.setuPwbQuestion(form.getQuestion());
		user.setuPwbAnswer(form.getAnswer());
		try {
			service.register(user);
		} catch (UserExistException e) {
			//4.���service�����ɹ����û��Ѵ��ڣ������ص�ע��ҳ�棬��ʾע���û��Ѵ���
			request.setAttribute("Message", "ע����û��Ѵ���");
			request.getRequestDispatcher("/jsp/signin_false.jsp").forward(request, response);
			return;
		}catch(Exception e){
			//5.���service�����ɹ�������ԭ������ת��ȫ����Ϣҳ��
			request.setAttribute("Message", "����δ֪����������ע��");
			request.getRequestDispatcher("/jsp/signin_false.jsp").forward(request, response);
			e.printStackTrace();
			return;
		}
		//6.���service����ɹ�����ת����ҳ��
		request.getRequestDispatcher("/jsp/signin_success.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
