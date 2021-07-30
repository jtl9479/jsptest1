package com.site.web0730.MService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.site.web0730.Dao.MDao;
import com.site.web0730.Vo.MVo;

public class MService_id_Check implements MService {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {

		String id = request.getParameter("id");
		System.out.println(id);
		MDao mdao= new MDao();
		MVo mvo = mdao.id_check(id);
		int result = (mvo.getId()==null) ? 1: 0;
		System.out.println(mvo.getId());
		System.out.println(result);
		request.setAttribute("result", result);
		request.setAttribute("id", id);
		
	}
}
