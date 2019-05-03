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
    <form action="../member/info.do" method="post">
    	<input type="hidden" name="memberNo" value=" ${login_memberVo.memberNo }">
    	<p class="text-field"> [이메일]   ${login_memberVo.memberEmail }</p>
        <p class="text-field">[회원 이름]  ${sessionScope.login_memberVo.memberName }</p>
        <a href="#"><input type="submit" value="수정하기" class="submit-btn"></a>
    </form>
  </div>
</body>
</html>