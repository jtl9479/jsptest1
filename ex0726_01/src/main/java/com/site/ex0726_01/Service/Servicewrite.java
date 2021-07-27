package com.site.ex0726_01.Service;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;
import com.site.ex0726_01.Dao.BoardDao;
import com.site.ex0726_01.Vo.BVo;

public class Servicewrite implements boardService {

	@Override
	public void excute(HttpServletRequest request, HttpServletResponse response) {
		
		BoardDao boarddao = new BoardDao();
		
		String path="c:/upload";
		int size = 10*1024*1024;
		
		
		
		MultipartRequest mutl;
		try {
			mutl = new MultipartRequest(request,path,size,"utf-8",new DefaultFileRenamePolicy());
		String bname = mutl.getParameter("bname");
		String btitle = mutl.getParameter("btitle");
		String bcontent = mutl.getParameter("bcontent");
		String file = mutl.getFilesystemName("file");
		
		System.out.println(bname);

		int result = boarddao.write(bname,btitle,bcontent,file); 
		
		request.setAttribute("result", result);
		
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
