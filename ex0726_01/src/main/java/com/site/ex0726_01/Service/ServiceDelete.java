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
		
		request.setAttribute("result", result);
	}

}
