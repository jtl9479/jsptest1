package com.site.ex0726_01.Service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.site.ex0726_01.Dao.BoardDao;
import com.site.ex0726_01.Vo.BVo;

public class Serviceview implements boardService {

	@Override
	public void excute(HttpServletRequest request, HttpServletResponse response) {

		int bid = Integer.parseInt(request.getParameter("bid"));

		BoardDao boarddao = new BoardDao();
		BVo bvo = new BVo();

		// page 하단 넘버링 관련정보 (list)에만있다.
		int page = 1;// 기본 페이지
		if (request.getParameter("page") != null) {
			int nowPage = Integer.parseInt(request.getParameter("page"));
			page = nowPage;// 현재 페이지
		}

		bvo = boarddao.view(bid);
		System.out.println(bvo.getBname());
		request.setAttribute("bvo", bvo);
		request.setAttribute("page", page);

	}

}
