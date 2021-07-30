<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>index</title>
		<style type="text/css">
			li{
				text-decoration: none;
			}
		</style>
		
	</head>
	<body>
	<!-- 로그인 안했을 경우 -->
	  <c:if test="${session_flag != 'success'}">
		  <ul>
		    <h3>로그인을 하시면 더 많은 정보를 볼수 있습니다.</h3>
		    <li><a href="member/login.do">로그인</a></li>
		    <li><a href="member/register.do">회원가입</a></li>
		    <li><a href="#">아이디,비밀번호찾기</a></li>
		    <li><a href="#">게시글 보기</a></li>
		  </ul>
	  </c:if>
	  <!-- 로그인 했을 경우 -->
		  <c:if test="${session_flag == 'success'}">
			  <ul>
			    <h3>${session_nickname} 님 환영합니다.</h3>
			    <li><a href="member/logout.jsp">로그아웃</a></li>
			    <li><a href="board/blist.do">게시판</a></li>
			    <li><a href="#">회원정보수정</a></li>
			    
			<c:if test="${session_id == 'admin'}"><!-- 관리자일때만 -->    
			    <li><a href="#">회원 관리</a></li>
			 </c:if>
			  </ul>
		  </c:if>
	</body>
</html>