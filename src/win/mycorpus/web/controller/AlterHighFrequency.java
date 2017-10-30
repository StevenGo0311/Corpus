package win.mycorpus.web.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import win.mycorpus.domain.Word;
import win.mycorpus.service.BusinessServiceImpl;

public class AlterHighFrequency extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		Word wordForm=new Word();
		BusinessServiceImpl buinessImpl=new BusinessServiceImpl();
		wordForm.setwWord(request.getParameter("word"));
		wordForm.setwCategory(request.getParameter("category"));
		wordForm.setwNominal(request.getParameter("nominal"));
		wordForm.setwMean(request.getParameter("mean").trim());
		wordForm.setwFrequency(request.getParameter("frequency"));
		
		
		//����
//		System.out.println(wordForm.getwWord());
//		System.out.println(wordForm.getwCategory());
//		System.out.println(wordForm.getwNominal());
//		System.out.println(wordForm.getwMean());
//		System.out.println(wordForm.getwFrequency());
		
		if(wordForm.getwMean().equals("")){
			request.setAttribute("fail", "����Ϊ��");
			request.getRequestDispatcher("/servlet/ManageHighFrequency").forward(request, response);
			return;
		}
		boolean b=buinessImpl.AlterHigh(wordForm);
		if(!b){
			request.setAttribute("fail", "δ֪�쳣");
			request.getRequestDispatcher("/servlet/ManageHighFrequency").forward(request, response);
			return;
		}
		request.setAttribute("success", "�޸ĳɹ�");
		request.getRequestDispatcher("/servlet/ManageHighFrequency").forward(request, response);
		
		
		
		
		
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
