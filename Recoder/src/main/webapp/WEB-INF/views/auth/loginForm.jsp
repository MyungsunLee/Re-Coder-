<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
  <title>로그인</title>
  <meta charset="utf-8">
  <link href="https://fonts.googleapis.com/earlyaccess/notosanskr.css" rel="stylesheet">
  <style type="text/css">
    * {
    box-sizing: border-box;
    font-family: 'Noto Sans KR', sans-serif;
    border-radius: 5px;
    border: 0;
  }

  .login-form {
    width: 300px;
    padding: 20px;
    margin-left: auto;
    margin-right: auto;
    background-color: #EEEFF1;
  }

  .text-field {
    width: 260px;
    margin-bottom: 10px;
    padding: 10px;
    font-size: 14px;
    color: #198556;
  }

  .submit-btn {
    width: 260px;
    margin-bottom: 30px;
    padding: 10px;
    background-color: #59d393;
    font-size: 14px;
    color: #FFFFFF;
  }

  .links {
    text-align: center;
  }

  .links a {
    font-size: 12px;
    color: #9B9B9B;
  }
  </style>
</head>
<body>
  <div class="login-form">
    <form>
      <input type="text" name="email" class="text-field" placeholder="이메일"><br>
      <input type="password" name="password" class="text-field" placeholder="비밀번호"><br>
      <input type="submit" value="로그인" class="submit-btn">
    </form>

    <div class="links">
      <a href="#">비밀번호를 잊어버리셨나요?</a>
    </div>
  </div>
</body>
</html>