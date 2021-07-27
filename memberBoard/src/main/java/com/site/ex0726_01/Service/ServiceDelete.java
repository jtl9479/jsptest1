package com.site.ex0726_01.Service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.site.ex0726_01.Dao.BoardDao;

public class ServiceDelete implements boardService {

	@Override
	public void excute(HttpServletRequest request, HttpServletResponse response) {

		int bid = Integer.parseInt(request.getParameter("bid"));
		
		BoardDao boarddao = new BoardDao();
		int result = boarddao.delete(bid);
		
		int page = 1;//기본 페이지
		if(request.getParameter("page")!=null) {
			int nowPage = Integer.parseInt(request.getParameter("page"));
			page= nowPage;//현재 페이지
		}
		
		
		request.setAttribute("result", result);
		request.setAttribute("page", page);
	}

}
