<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
  <title>회원정보수정</title>
  <meta charset="utf-8">
  <link rel="stylesheet" type="text/css" href="../resources/css/styles.css">
  <link href="https://fonts.googleapis.com/css?family=Noto+Sans+KR" rel="stylesheet">
  <link href="https://fonts.googleapis.com/css?family=Do+Hyeon" rel="stylesheet">
  <script src="https://code.jquery.com/jquery-3.4.0.min.js"></script>
    <script>
      $(function() {
        $('#reg-form').submit(function() {
          var name = $('#name').val();
          var password = $('#password').val();
          var passwordConfirm = $('#passwordConfirm').val();
          
          if (name == '') {
            alert('이름을 입력해주세요.');
            $('#name').focus();
            return false;
          }

          
          if (password == '') {
            alert('비밀번호를 입력해주세요.');
            $('#password').focus();
            return false;
          }
          
          
          if (passwordConfirm == '') {
              alert('비밀번호 확인을 입력해주세요.');
              $('#passwordConfirm').focus();
              return false;
            }
          
          if (password != passwordConfirm) {
        	  	alert('비밀번호와 비밀번호 확인이 일치하지 않습니다.');
              $('#passwordConfirm').focus();
              return false;
          }
        });
      });
      </script>
</head>
<body>
<jsp:include page="../common/header.jsp"></jsp:include>

  <div class="regi-form">
    <form id="reg-form" action="../member/updateCtr.do" method="post">
      <input type="hidden" name="memberNo" value=" ${sessionScope.login_memberVo.memberNo }">
      <input type="hidden" name="memberEmail" value="${sessionScope.login_memberVo.memberEmail}">
      <input id="name" type="text" name="memberName" class="text-field" placeholder="이름"><br>
      <input id="password" type="password" name="memberPassword" class="text-field" placeholder="비밀번호"><br>
      <input id="passwordConfirm" type="password" name="memberPasswordConfirm" class="text-field" placeholder="비밀번호 확인"><br>
      <a href="#"><input type="submit" value="이름, 비밀번호 수정하기" class="submit-btn"></a>
    </form>
  </div>
</body>
</html>