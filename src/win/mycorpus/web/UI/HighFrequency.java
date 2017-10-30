package win.mycorpus.web.UI;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import win.mycorpus.dao.CategoryDao;
import win.mycorpus.dao.NominalDao;
import win.mycorpus.daoImpl.CategoryDaoImpl;
import win.mycorpus.daoImpl.NominalDaoImpl;

/**
 * Servlet implementation class HighFrequency
 */
@WebServlet("/HighFrequency")
public class HighFrequency extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		CategoryDao categoryDao=new CategoryDaoImpl();
	    NominalDao nominalDao=new NominalDaoImpl();
	    List<String> categorys=categoryDao.find();
	    List<String> nominals=nominalDao.find();
	    request.setAttribute("categorys", categorys);
	    request.setAttribute("nominals",nominals );	
	    request.getRequestDispatcher("/jsp/highFrequency.jsp").forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
