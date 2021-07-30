<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
		<c:if test="${result == '1'}">
		<script type="text/javascript">
				alert("아이디를 사용할수 있습니다");
				location.href="./register.jsp?id=${id}";
		</script>
		</c:if>
		<c:if test="${result == '0'}">
		<script type="text/javascript">
				alert("아이디를 사용할수 없습니다");
				location.href="./register.jsp";
		</script>
		</c:if>
	
</body>
</html>