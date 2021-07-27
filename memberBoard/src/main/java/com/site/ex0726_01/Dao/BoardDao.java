package com.site.ex0726_01.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import com.site.ex0726_01.Vo.BVo;

public class BoardDao {

	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	DataSource ds = null;
	BVo bVo = null;
	
	String btitle, bcontent, bname, bupload;
	int bid, bgroup, bstep, bindent, bhit;
	Timestamp bdate;
	
	public Connection getConnection() throws Exception{
		
		Context context = new InitialContext();
		
		ds = (DataSource) context.lookup("java:comp/env/jdbc/Oracle11g");
		
		return ds.getConnection();
	}
	
	
	
	public ArrayList<BVo> list(int startrow, int endrow){
		
		ArrayList<BVo> list = new ArrayList<BVo>();
		
		try {
			conn = getConnection();
			String sql = "SELECT * FROM (SELECT ROWNUM AS RNUM,B.* FROM  (SELECT * FROM BOARD5 ORDER BY BGROUP DESC,BSTEP ASC) B)WHERE RNUM>=? AND RNUM<=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, startrow);
			pstmt.setInt(2, endrow);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				
				bid = rs.getInt("bid");
				btitle = rs.getString("btitle");
				bcontent = rs.getString("bcontent");
				bname = rs.getString("bname");
				bgroup = rs.getInt("bgroup");
				bstep = rs.getInt("bstep");
				bindent = rs.getInt("bindent");
				bdate = rs.getTimestamp("bdate");
				bupload = rs.getString("bupload");
				bhit = rs.getInt("bhit");
				bVo = new BVo(bid, btitle, bcontent, bname, bgroup, bstep, bindent, bdate, bupload, bhit);
				list.add(bVo);
				System.out.println(bid);
			}
			
		} catch (Exception e) {
				e.printStackTrace();
		}finally {
			try {
				if(rs != null) rs.close();
				if(pstmt != null) pstmt.close();
				if(conn != null) conn.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		
		
		
		return list;
	}


//쓰기
	public int write(String bname,String btitle,String bcontent,String file) {

		int result = 0;
		
		try {
			conn = getConnection();
			System.out.println("서버 연결");
			String sql = "insert into board5 values(BOARD_SEQ.nextval,?,?,?,BOARD_SEQ.currval,0,0,sysdate,?,0)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, btitle);
			pstmt.setString(2, bcontent);
			pstmt.setString(3, bname);
			pstmt.setString(4, file);
			result = pstmt.executeUpdate();
			
		} catch (Exception e) {
				e.printStackTrace();
		}finally {
			try {
				if(pstmt != null) pstmt.close();
				if(conn != null) conn.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		
		return result;
	}


	//view
	public BVo view(int bid) {
		
		BVo bvo = new BVo();
		
		try {
			conn = getConnection();
			String sql = "select * from board5 where bid=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, bid);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				
				bvo.setBid(rs.getInt("bid"));
				bvo.setBname(rs.getString("bname"));
				bvo.setBtitle(rs.getString("btitle"));
				bvo.setBcontent(rs.getString("bcontent"));
				bvo.setBupload(rs.getString("bupload"));
				bvo.setBhit(rs.getInt("bhit"));
			}
			
		} catch (Exception e) {
				e.printStackTrace();
		}finally {
			try {
				if(rs != null) rs.close();
				if(pstmt != null) pstmt.close();
				if(conn != null) conn.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return bvo;
	}


//--------------------------------------------------------------------
	public int delete(int bid) {
		int result = 0;
		
		try {
			conn = getConnection();
			System.out.println("서버 연결");
			String sql = "delete board5 where bid = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, bid);
			result = pstmt.executeUpdate();
			
		} catch (Exception e) {
				e.printStackTrace();
		}finally {
			try {
				if(pstmt != null) pstmt.close();
				if(conn != null) conn.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		
		return result;
	}


//----------------------------------------------------------------------------
//페이징 처리
//총 개시글 추
	public int boardCountSelect() {

		int listCount = 0;
		
		try {
			conn = getConnection();
			String sql = "select count(*) count from board5";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				
				listCount = rs.getInt("count");
				System.out.println("총갯수"+listCount);
			}
			
		} catch (Exception e) {
				e.printStackTrace();
		}finally {
			try {
				if(rs != null) rs.close();
				if(pstmt != null) pstmt.close();
				if(conn != null) conn.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return listCount;
	}
//-----------------------------------------------------------------------------------------------


//----------------------------------------------------------------
	// boatd 검색 10개
	public ArrayList<BVo> listSearch(int startrow, int endrow,String category,String s_word){
		
		ArrayList<BVo> list = new ArrayList<BVo>();
		
		try {
			conn = getConnection();
			String sql = "SELECT * FROM (SELECT ROWNUM AS RNUM,B.* FROM  (SELECT * FROM BOARD ORDER BY BGROUP DESC,BSTEP ASC) B where btitle like '%?%')WHERE RNUM>=? AND RNUM<=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, startrow);
			pstmt.setInt(2, endrow);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				
				bid = rs.getInt("bid");
				btitle = rs.getString("btitle");
				bcontent = rs.getString("bcontent");
				bname = rs.getString("bname");
				bgroup = rs.getInt("bgroup");
				bstep = rs.getInt("bstep");
				bindent = rs.getInt("bindent");
				bdate = rs.getTimestamp("bdate");
				bupload = rs.getString("bupload");
				bhit = rs.getInt("bhit");
				bVo = new BVo(bid, btitle, bcontent, bname, bgroup, bstep, bindent, bdate, bupload, bhit);
				list.add(bVo);
				System.out.println(bid);
			}
			
		} catch (Exception e) {
				e.printStackTrace();
		}finally {
			try {
				if(rs != null) rs.close();
				if(pstmt != null) pstmt.close();
				if(conn != null) conn.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		
		
		
		return list;
	}
}
