package com.site.web0730.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.site.web0730.BService.BService;
import com.site.web0730.MService.MService;
import com.site.web0730.MService.MService_Login;
import com.site.web0730.MService.MService_id_Check;

@WebServlet("*.do")
public class Controller extends HttpServlet {

	protected void doAction(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String uri = request.getRequestURI();
		String path = request.getContextPath();
		String realpath = uri.substring(path.length());
		
		MService mservice = null;
		BService bservice = null;
		
		RequestDispatcher dispatcher = null;
		
		//로그인 페이지로 이동
		if(realpath.equals("/member/login.do")) {
			dispatcher= request.getRequestDispatcher("./login.jsp");
			
		//로그인 처리 페이지
		}else if(realpath.equals("/member/loginOk.do")) {
			
			mservice = new MService_Login();
			mservice.execute(request,response);
			dispatcher= request.getRequestDispatcher("./loginOk.jsp");
		//회원가입 페이지
		}else if(realpath.equals("/member/register.do")) {
			
			dispatcher= request.getRequestDispatcher("./register.jsp");
			
			//회원가입 페이지
		}else if(realpath.equals("/member/id_check.do")) {
			
			mservice = new MService_id_Check();
			mservice.execute(request,response);
			dispatcher= request.getRequestDispatcher("./id_check.jsp");
			
		}else {
			dispatcher = request.getRequestDispatcher("/404.jsp");
		}
		
		dispatcher.forward(request, response);
		
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doAction(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doAction(request, response);
	}

}
