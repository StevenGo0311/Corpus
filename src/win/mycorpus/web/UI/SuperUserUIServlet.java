package win.mycorpus.web.UI;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import win.mycorpus.domain.User;
import win.mycorpus.service.BusinessServiceImpl;


public class SuperUserUIServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		BusinessServiceImpl buessImpl=new BusinessServiceImpl();
		List<User> commonUsers=buessImpl.SeachUser("∆’Õ®”√ªß");
		request.setAttribute("commonUsers", commonUsers);
		request.getRequestDispatcher("/jsp/superUser.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
