<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>게시판</title>
  <link href="https://fonts.googleapis.com/css?family=Noto+Sans+KR:400,500,700,900&display=swap&subset=korean" rel="stylesheet">
  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.12.1/css/all.min.css">
  <link rel="stylesheet" href="css/style.css">
  <link rel="stylesheet" href="css/notice_list.css">
</head>
<body>
<section>
    <h1>NOTICE</h1>
    <div class="wrapper">
      <form action="./search.do" name="search" method="post">
        <select name="category" id="category">
          <option value="all">전체</option>
          <option value="title">제목</option>
          <option value="content">내용</option>
        </select>

        <div class="title">
          <input type="text" name="s_word" size="16">
        </div>
  
        <button type="submit"><i class="fas fa-search"></i></button>
      </form>
    </div>

    <table>
      <colgroup>
        <col width="18%">
        <col width="50%">
        <col width="18%">
        <col width="10%">
      </colgroup>
      <!-- 제목부분 -->
      <tr>
        <th>No.</th>
        <th>제목</th>
        <th>작성일</th>
        <th>조회수</th>
      </tr>
      <!-- 리스트 부분 -->
      <c:forEach items="${list}" var="bVo">
      <tr>
        <td><span class="table-notice">${bVo.bid}</span></td>
        <td class="table-title">
        <a href="./bview.do?bid=${bVo.bid}&page=${page}">${bVo.bname}</a>
        </td>
        <td>${bVo.bdate}</td>
        <td>${bVo.bhit }</td>
      </tr>
      </c:forEach>
    </table>

    <ul class="page-num">
    <!-- 첫번째로 넘기기 -->
    <c:if test="${page !=1 }">
    	<a href="./blist.do?page=${1}">
      		<li class="first"></li>
      	</a>
     </c:if>
     <c:if test="${page ==1 }">
     	<a href="./blist.do?page=${1}">
     		<li class="first"></li>
      	</a>
     </c:if>
    <!-- 이전 페이지로 넘기기 --> 
     <c:if test="${page !=1 }">
     	<a href="./blist.do?page=${page-1}">
      		<li class="prev"></li>
      	</a>
     </c:if>
    <c:if test="${page ==1 }">
      		<li class="prev"></li>
    </c:if>
     
     
    <!-- 넘버링 넘기기 --> 
     <c:forEach var="pageNum" begin="${startPage }" end="${endPage }">
      	<c:if test="${pageNum != page }">
      		<a href="./blist.do?page=${pageNum }"><li class="num"><div>${pageNum }</div></li></a>
      	</c:if>
	    <c:if test="${pageNum == page }">
      		<li class="num" style="background-color: green;"><div>${pageNum }</div></li>
    	</c:if>
      </c:forEach>
      
      
      <!-- 다음 페이지로 넘기기 -->
      <c:if test="${page !=maxPage }"> 
      	<a href="./blist.do?page=${page+1}">
      		<li class="next"></li>
      	</a>
      </c:if>
       <c:if test="${page == maxPage }"> 
      		<li class="next"></li>
      </c:if>
      
      <!-- 맨뒷 페이지로 넘기기 -->
     <c:if test="${page !=maxPage }">  
      <a href="./blist.do?page=${maxPage}">
      	<li class="last"></li>
      	</a>
      </c:if>
       <c:if test="${page ==maxPage }">  
	      	<li class="last"></li>
      </c:if>
      
      
      
    </ul>

    <a href="./bwrite.do"><div class="write">쓰기</div></a>
  </section>

</body>
</html>