<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>

	<!-- 로그인 성공 -->
	<c:if test="${session_flag == 'success' }">
		<script type="text/javascript">
			alert("로그인에 성공하셨습니다");
			location.href="../index.jsp";
		</script>
	
	</c:if>
	<!-- 로그인 실패 -->
	<c:if test="${session_flag == 'fail' }">
	<script type="text/javascript">
			alert("로그인에 실패하셨습니다");
			location.href="./login.do";
		</script>
	</c:if>
<body>
</body>
</html>