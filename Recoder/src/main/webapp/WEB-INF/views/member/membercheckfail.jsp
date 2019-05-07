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
</head>

<script type="text/javascript"
   src="/Recoder/resources/js/jquery-3.3.1.js"></script>

<script type="text/javascript">

		$(document).ready(function(){
			alert("이미 사용중인 이메일 입니다");
			location.href='add.do';
		})

</script>


<body>

  <div class="login-form">

<!--     <div style="text-align: left;" class="links"> -->
<%--      입력하신 이메일 ${memberVo1.memberEmail }은 사용할 수 없습니다 --%>
<!--     </div> -->
    
<%--     <a hidden="hidden">${memberVo1.memberEmail}</a> --%>
  </div>
</body>
</html>