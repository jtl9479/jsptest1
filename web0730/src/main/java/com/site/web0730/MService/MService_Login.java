package com.site.web0730.MService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.site.web0730.Dao.MDao;
import com.site.web0730.Vo.MVo;

public class MService_Login implements MService {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {

		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		
		HttpSession session = request.getSession();
		
		MVo mvo = new MVo();
		MDao mdao = new MDao();
		mvo = mdao.login(id,pw);
		
		
		if(mvo.getId() != null) {
		
			session.setAttribute("session_id", mvo.getId());
			session.setAttribute("session_nickname", mvo.getNickname());
			session.setAttribute("session_flag", "success");
		}else {
			session.setAttribute("session_flag", "fail");
		}
				
		
		
		
	}

}
