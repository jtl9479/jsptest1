package com.site.ex0726_01.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.site.ex0726_01.Service.ServiceDelete;
import com.site.ex0726_01.Service.ServiceSearch;
import com.site.ex0726_01.Service.Servicelist;
import com.site.ex0726_01.Service.Serviceview;
import com.site.ex0726_01.Service.Servicewrite;
import com.site.ex0726_01.Service.boardService;


@WebServlet("*.do")
public class BoardController extends HttpServlet {

	

	protected void doAction(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String uri = request.getRequestURI();
		String path = request.getContextPath();
		String cpath = uri.substring(path.length());
		System.out.println(cpath);
		RequestDispatcher dispatcher = null;
		
		
		if(cpath.equals("/board/blist.do")) {
			boardService service = new Servicelist();
			service.excute(request, response);
			dispatcher = request.getRequestDispatcher("./blist.jsp")
					;
		}else if(cpath.equals("/board/bwrite.do")) {
			dispatcher = request.getRequestDispatcher("./bwrite.jsp");
			
		}else if(cpath.equals("/board/bwriteOk.do")) {
			boardService service = new Servicewrite();
			service.excute(request, response);
			dispatcher = request.getRequestDispatcher("./reset.jsp");
			
		}else if(cpath.equals("/board/bview.do")) {
			boardService service = new Serviceview();
			service.excute(request, response);
			dispatcher = request.getRequestDispatcher("./bview.jsp");
		}else if(cpath.equals("/board/bdelete.do")) {
			boardService service = new ServiceDelete();
			service.excute(request, response);
			dispatcher = request.getRequestDispatcher("./reset.jsp");
		}else if(cpath.equals("/board/search.do")) {
			boardService service = new ServiceSearch();//검색
			service.excute(request, response);
			dispatcher = request.getRequestDispatcher("./blist.jsp");
			
		}else {
			dispatcher = request.getRequestDispatcher("./index.jsp");
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
