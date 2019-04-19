<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<form action="addOne.do">
		<input type="text" name="name">
		<input type="text" name="boardTitle">
		<input type="hidden" name="name" value="${login_memberVo.memberName}">
		<input type="text" name="boardContent">
		
	
	</form>


</body>
</html>