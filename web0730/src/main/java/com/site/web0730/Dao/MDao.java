package com.site.web0730.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import com.site.web0730.Vo.MVo;

public class MDao {

	
	Connection conn = null;
	PreparedStatement pstmt = null;
	DataSource ds = null;
	ResultSet rs = null;
	
	public Connection getConnection() throws Exception {
		
		Context context = new InitialContext();
		
		ds = (DataSource)context.lookup("java:comp/env/jdbc/Oracle11g");
		
		return ds.getConnection();
	}
	//-----------------------------------------------------------------------------------------
	public MVo login(String id, String pw) {
		MVo mvo = new MVo();
		
		try {
			conn = getConnection();
			String sql = "select * from usertest where id = ? and pw = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			pstmt.setString(2, pw);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				mvo.setId(rs.getString("id"));
				mvo.setNickname(rs.getString("nickname"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return mvo;
	}
	//-----------------------------------------------------------------------------------------
	
	//
	public MVo id_check(String id) {
		MVo mvo = new MVo();
		try {
			conn = getConnection();
			String sql = "select * from usertest where id = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				mvo.setId(rs.getString("id"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		
		
		return mvo;
	}
	
}
