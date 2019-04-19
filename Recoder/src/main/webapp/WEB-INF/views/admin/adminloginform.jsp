<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<div class="login-form">
    <form action="../admin/login.do" method="post">
      <input type="text" name="memberEmail" class="text-field" placeholder="이메일"><br>
      <input type="password" name="memberPassword" class="text-field" placeholder="비밀번호"><br>
      <input type="submit" value="로그인" class="submit-btn">
    </form>

    <div class="links">
      <a href="#">비밀번호를 잊어버리셨나요?</a>
    </div>
 </div>

</body>
</html>