package win.mycorpus.web.UI;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import win.mycorpus.domain.User;
import win.mycorpus.service.BusinessServiceImpl;

public class SuperManageUIServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		BusinessServiceImpl buessImpl=new BusinessServiceImpl();
		List<User> manages=buessImpl.SeachUser("π‹¿Ì‘±");
		request.setAttribute("manages", manages);
		request.getRequestDispatcher("/jsp/superManage.jsp").forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
