<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<title></title>
<meta charset="UTF-8">
<script type="text/javascript"
   src="/Recoder/resources/js/jquery-3.3.1.js"></script>

<script type="text/javascript">

		$(document).ready(function(){
			alert("사용 가능한 이메일 입니다");
			location.href='add.do?memberEmail=${memberVo1.memberEmail}';
		})

</script>
</head>


<body>

</body>
</html>