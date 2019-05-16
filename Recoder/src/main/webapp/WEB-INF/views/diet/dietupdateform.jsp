<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>식단 수정</title>
<meta charset="UTF-8">
</head>
<body>
<jsp:include page="../common/header.jsp"/>

<div class="regi-form">
	<form action="../diet/update.do" method="post">
		<input type="hidden" name="dietNo" value="${dietNo }">
		<input type="radio" name="dietType" value="P" checked="checked">단백질 <input type="radio" name="dietType" value="C">탄수화물<br>
		<input type="text" name="dietName" class="text-field" placeholder="식단이름"><br>
		<input type="text" name="dietCal" class="text-field" placeholder="식단칼로리"><br>
		<input type="submit" value="식단수정" class="submit-btn">
	</form>
</div>

</body>
</html>