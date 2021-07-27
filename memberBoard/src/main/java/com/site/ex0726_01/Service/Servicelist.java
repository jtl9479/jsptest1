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
		//총 게시글 수
		int listcount = boarddao.boardCountSelect(); 
		
		//페이징 처리
		//page 하단 넘버링 관련정보 (list)에만있다.
		int page = 1;//기본 페이지
		if(request.getParameter("page")!=null) {
			int nowPage = Integer.parseInt(request.getParameter("page"));
			page= nowPage;//현재 페이지
		}
		int limit = 10; //리스트 게시글수 10,15,20 어느것으로 할건지 정한다.
		int maxPage=(int)((double)listcount/limit+0.99);//listcount 총 게시글 수
		int startPage = ((int)((double)page/limit+0.99)-1)*limit+1;// 스타트 페이지 무조건값 1이 나온다.
		int endPage = startPage+10-1;
		if(endPage>maxPage) endPage=maxPage;
		//페이지 세팅 완료
		
		
		request.setAttribute("page", page);
		request.setAttribute("maxPage", maxPage);
		request.setAttribute("startPage", startPage);
		request.setAttribute("endPage", endPage);
		//하단 넘버링할때 필요한 정보들이다.
		
		//가지고올 10개 데이터 범위
		int startrow = (page-1)*limit +1;
		int endrow= startrow+limit-1;
		
		
		//board 10개 리스트 가져오기. arraylist
		list = boarddao.list(startrow,endrow);
		request.setAttribute("list", list);
		
	}

}
