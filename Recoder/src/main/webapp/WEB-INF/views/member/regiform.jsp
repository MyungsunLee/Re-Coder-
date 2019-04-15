<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
  <title>회원가입</title>
  <meta charset="utf-8">
  <link rel="stylesheet" type="text/css" href="../resources/css/styles.css">
  <link href="https://fonts.googleapis.com/css?family=Noto+Sans+KR" rel="stylesheet">
  <link href="https://fonts.googleapis.com/css?family=Do+Hyeon" rel="stylesheet">
</head>
<body>
<jsp:include page="../common/header.jsp"></jsp:include>

  <div class="regi-form">
    <form action="../member/add.do" method="post">
      <input type="text" name="memberEmail" class="text-field" placeholder="이메일"><br>
      <input type="text" name="memberName" class="text-field" placeholder="이름"><br>
      <input type="password" name="memberPassword" class="text-field" placeholder="비밀번호"><br>
      <input type="password" name="memberPasswordConfirm" class="text-field" placeholder="비밀번호 확인"><br>
      <input type="submit" value="회원가입" class="submit-btn">
    </form>
  </div>
</body>
</html>