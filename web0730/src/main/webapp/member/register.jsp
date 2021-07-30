<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>   
<!DOCTYPE html>
<html lang="en" dir="ltr">
  <head>
    <meta charset="utf-8">
    <title>회원가입</title>

    <link rel="stylesheet" href="./css/register.css">
    <script  src="http://code.jquery.com/jquery-latest.min.js"></script>
    <script type="text/javascript">
    	
    function id_check() {
    	
    	var id = $('#id').val();
     	location.href="./id_check.do?id="+id;
		
	}
    
    </script>
	
  </head>
  <body>
  <c:set var="id" value="" />
    <div id="body_div">

        <h1>회원가입</h1>
          <form class="" action="./registerOk.do" method="post">
              <div class="">
                <label for="">아이디</label>
                <span>
                <input type="text" class="input_form" name="id" id="id" value="<%=request.getParameter("id") %>" required>
              <input type="button" onclick="id_check()" value="아이디 중복검사"></a>
                </span>
              </div>
              <div class="">
                <label for="">비밀번호</label>
                <span>
                <input type="password" class="input_form" name="pw" required>
                </span>
              </div>

              <div class="">
                <label for="">이름</label>
                <span>
                <input type="text" class="input_form" name="name" >
                </span>
              </div>

              <div class="">
                <label for="">닉네임</label>
                <span>
                <input type="text" class="input_form" name="nickname" >
                </span>
              </div>

              <div class="">
                <label for="">나이</label>
                <span>
                <input type="text" class="input_form" name="age" >
                </span>
              </div>

              <div class="">
                  <label for="">성별</label>
                  <span>
                <input type="radio" name="gender" value="N">해당없음
                <input type="radio" name="gender" value="F">여자
                <input type="radio" name="gender" value="M">남자
                </span>
              </div>

              <div class="">
                <label for="">핸드폰 번호</label>
                <span>
                <input type="text" class="input_form" name="phone" >
                </span>
              </div>

              <div class="">
                <label for="">주소</label>
                <span>
                <input type="text" class="input_form" name="address">
                </span>
              </div>


              <div class="">
                <label for="">한마디</label>
                <span>
                <input type="text" class="input_form" name="coment" >
                </span>
              </div>
              <input type="submit" name="" value="전송">
          </form>
    </div>
  </body>
</html>
