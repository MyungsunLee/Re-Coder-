<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<div>
	<form action="../diet/update.do" method="post">
		<input type="hidden" name="dietNo" value="${dietNo }">
		<input type="radio" name="dietType" value="P" checked="checked">단백질 <input type="radio" name="dietType" value="C">탄수화물<br>
		<input type="text" name="dietName" class="" placeholder="식단이름"><br>
		<input type="text" name="dietCal" class="" placeholder="식단칼로리"><br>
		<input type="submit" value="식단수정" class="submit-btn">
	</form>
</div>

</body>
</html>