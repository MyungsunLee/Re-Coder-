<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<title></title>
<meta charset="UTF-8">
  <link href="https://fonts.googleapis.com/css?family=Noto+Sans+KR" rel="stylesheet">
  <link href="https://fonts.googleapis.com/css?family=Do+Hyeon" rel="stylesheet">
  <script src="https://code.jquery.com/jquery-3.4.0.min.js"></script>
  <script>
  $(function(){
	  alert($('#emailcheckinfo'));
	  
  })
  </script>
</head>
<body>


  <div id="emailcheckinfo" class="login-form">

    <div style="text-align: left;" class="links">
      입력하신 이메일 ${memberVo1.memberEmail }은 사용할 수 있습니다
    </div>
  </div>
</body>
</html>