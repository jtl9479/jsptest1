package com.site.ex0726_01.Service;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.site.ex0726_01.Dao.BoardDao;
import com.site.ex0726_01.Vo.BVo;

public class Servicelist implements boardService {

	@Override
	public void excute(HttpServletRequest request, HttpServletResponse response) {

		BoardDao boarddao = new BoardDao();
		ArrayList<BVo> list = new ArrayList<BVo>();
		list = boarddao.list();
		
		request.setAttribute("list", list);
	}

}
