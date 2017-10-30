package win.mycorpus.web.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import win.mycorpus.domain.Word;
import win.mycorpus.service.BusinessServiceImpl;


public class ManageHighFrequency extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String cateForm=request.getParameter("categoryForm");
		//System.out.println(cateForm);
		BusinessServiceImpl businessServiceImpl=new BusinessServiceImpl();
		List<Word> words=businessServiceImpl.SearchCategory(cateForm);
//		for(int i=0;i<words.size();i++){
//			System.out.println(words.get(i).getwWord());
//		}
		if(words.size()==0){
			request.setAttribute("emptyWord", "未找到该分类下的单词");
			request.getRequestDispatcher("/servlet/HighFrequency").forward(request, response);
			return;
		}
		request.setAttribute("words", words);
		request.getRequestDispatcher("/servlet/HighFrequency").forward(request, response);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
