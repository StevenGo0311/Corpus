package win.mycorpus.web.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import win.mycorpus.dao.WordDao;
import win.mycorpus.daoImpl.WordDaoImpl;
import win.mycorpus.domain.Word;


public class SearchWordServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String wordForm=request.getParameter("word").trim();
		WordDao wordDao=new WordDaoImpl();
		Word word=null;
		
		HttpSession user=request.getSession();
		String role=(String)user.getAttribute("uRole");
//		System.out.println("跳转测试："+role);
		if(wordForm.equals("")){
			request.setAttribute("word", "查找单词不能为空格");
			if(role.equals("普通用户")){
				request.getRequestDispatcher("/servlet/UserSearchUIServlet").forward(request, response);	
			}
			else{
				request.getRequestDispatcher("/servlet/ManageSearchUIServlet").forward(request, response);	
			}
			return;
		}
		word=wordDao.find(wordForm);
		if(word==null){
			request.setAttribute("word", "未查到相关单词");
			if(role.equals("普通用户")){
				request.getRequestDispatcher("/servlet/UserSearchUIServlet").forward(request, response);	
			}
			else{
				request.getRequestDispatcher("/servlet/ManageSearchUIServlet").forward(request, response);	
			}
			return;	
		}
		wordDao.process(wordForm);
		request.setAttribute("wordSuccess", word);
		if(role.equals("普通用户")){
			request.getRequestDispatcher("/servlet/UserSearchUIServlet").forward(request, response);	
		}
		else{
			request.getRequestDispatcher("/servlet/ManageSearchUIServlet").forward(request, response);	
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
