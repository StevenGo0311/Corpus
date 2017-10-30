package win.mycorpus.web.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import win.mycorpus.domain.Word;
import win.mycorpus.exception.WordExistException;
import win.mycorpus.service.BusinessServiceImpl;
import win.mycorpus.web.form.AddWordForm;


public class AddWordServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		AddWordForm addWordForm=new AddWordForm();
		BusinessServiceImpl businessServiceImpl=new BusinessServiceImpl();
		Word word=new Word();
		addWordForm.setWord(request.getParameter("word"));
		addWordForm.setCategory(request.getParameter("category"));
		addWordForm.setMean(request.getParameter("mean"));
		addWordForm.setSentence(request.getParameter("sentence"));
		addWordForm.setNominal(request.getParameter("nominal"));
		boolean b=addWordForm.validate();
		HttpSession user=request.getSession();
		String role=(String)user.getAttribute("uRole");
		if(!b){
			request.setAttribute("addWordForm", addWordForm);
			request.getRequestDispatcher("/servlet/UserAddUIServlet").forward(request, response);
			return;
		}
		word.setwWord(addWordForm.getWord());
		word.setwCategory(addWordForm.getCategory());
		word.setwMean(addWordForm.getMean());
		word.setwSentence(addWordForm.getSentence());
		word.setwNominal(addWordForm.getNominal());
		
//		System.out.println(word.getwWord());
//		System.out.println(word.getwCategory());
//		System.out.println(word.getwMean());
//		System.out.println(word.getwSentence());
//		System.out.println(word.getwNominal());
		try {
			businessServiceImpl.addWord(word);
		} catch (WordExistException e) {
			request.setAttribute("exist", "添加的单词已存在");
			if(role.equals("普通用户")){
				request.getRequestDispatcher("/servlet/UserAddUIServlet").forward(request, response);	
			}
			else{
				request.getRequestDispatcher("/servlet/ManageAddUIServlet").forward(request, response);	
			}
			return;	
		}catch (Exception e) {
			request.setAttribute("exist", "发生未知错误");
			if(role.equals("普通用户")){
				request.getRequestDispatcher("/servlet/UserAddUIServlet").forward(request, response);	
			}
			else{
				request.getRequestDispatcher("/servlet/ManageAddUIServlet").forward(request, response);	
			}
			return;	
		}
		request.setAttribute("success", "单词添加成功");
		
		
		//System.out.println("跳转测试："+role);
		if(role.equals("普通用户")){
			request.getRequestDispatcher("/servlet/UserAddUIServlet").forward(request, response);	
		}
		else{
			request.getRequestDispatcher("/servlet/ManageAddUIServlet").forward(request, response);	
		}
		
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
