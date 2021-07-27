package com.site.ex0726_01.Service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.site.ex0726_01.Dao.BoardDao;
import com.site.ex0726_01.Vo.BVo;

public class Serviceview implements boardService {

	@Override
	public void excute(HttpServletRequest request, HttpServletResponse response) {

		
		int bid =Integer.parseInt(request.getParameter("bid"));
		
		BoardDao boarddao = new BoardDao();
		BVo bvo = new BVo();
		
		bvo = boarddao.view(bid);
		System.out.println(bvo.getBname());
		request.setAttribute("bvo", bvo);
		
	}

}
