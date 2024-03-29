<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>뷰페이지</title>
  <link href="https://fonts.googleapis.com/css?family=Noto+Sans+KR:400,500,700,900&display=swap&subset=korean" rel="stylesheet">
  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.12.1/css/all.min.css">
  <link rel="stylesheet" href="css/style.css">
  <link rel="stylesheet" href="css/read.css">
  
 <c:set value="${bvo}" var="bvo"  />
</head>
<body>
<section>
    <h1>NOTICE</h1>

    <table>
      <colgroup>
        <col width="80%">
        <col width="10%">
        <col width="10%">
        
      </colgroup>
      <tr>
        <th colspan="3">제목</th>
      </tr>
      <tr>
        <td colspan="3"><strong>${bvo.btitle }</strong></td>
      </tr>
      <tr>
        <td>${bvo.bname}</td>
        <td>조회수</td>
        <td>${bvo.bhit}</td>
      </tr>
      <tr>
        <td colspan="3" class="article">${bvo.bcontent}</td>
      </tr>
      <tr>
		 <td><img src="../upload/${bvo.bupload}" /></td>
      </tr>
      <tr>
		 <td><a href="../upload/${bvo.bupload}" download>다운</a></td>
      </tr>
     <tr>
        <td colspan="3"><strong>다음글</strong> <span class="separator">|</span> [키즈잼] 2월 프로그램 안내</td>
      </tr>
      <tr>
        <td colspan="3"><strong>이전글</strong> <span class="separator">|</span> [키즈잼] 2020년 1분기 정기 휴관일 안내</td>
      </tr>
    </table>

    <a href="./blist.do"><div class="list">목록</div></a>
    <a href="./bdelete.do?bid=${bvo.bid }" onclick="btn()"><div class="list">삭제</div></a>
    <a href="./modify.do"><div class="list">수정</div></a>
    <a href=""><div class="list">답변달기</div></a>
  </section>
  <script type="text/javascript">
  function btn() {
	  alert("삭제를 진행합니다");
	
}
  
  </script>
</body>
</html>