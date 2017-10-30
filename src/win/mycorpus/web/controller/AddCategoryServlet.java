package win.mycorpus.web.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import win.mycorpus.exception.CategoryExistException;
import win.mycorpus.service.BusinessServiceImpl;

/**
 * Servlet implementation class AddCategoryServlet
 */
@WebServlet("/AddCategoryServlet")
public class AddCategoryServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		BusinessServiceImpl buImpl=new BusinessServiceImpl();
		String categoryForm=request.getParameter("category").trim();
		System.out.println("前台传过来的分类："+categoryForm);
		if(categoryForm.equals("")){
			request.setAttribute("category", "添加分类不能为空");
			request.getRequestDispatcher("/jsp/addCategory.jsp").forward(request, response);
			return;
		}
		try {
			buImpl.addCategory(categoryForm);
		} catch (CategoryExistException e) {
			request.setAttribute("category", "添加的分类已存在");
			request.getRequestDispatcher("/jsp/addCategory.jsp").forward(request, response);
			return;
		}
		request.setAttribute("category", "添加分类成功");
		request.getRequestDispatcher("/jsp/addCategory.jsp").forward(request, response);
		
		
		
		
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
