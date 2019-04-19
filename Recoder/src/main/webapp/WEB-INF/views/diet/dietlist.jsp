<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
table, th, tr, td{
	border: 1px solid black;
	border-collapse: collapse;
}
</style>
</head>
<body>
<div>
	<table>
		<tr>
			<th>식단번호</th>
			<th>식단유형</th>
			<th>식단이름</th>
			<th>식단칼로리</th>
			<th>수정</th>
			<th>삭제</th>
		</tr>
		<c:forEach var="dietVo" items="${dietList}">
		<tr>
			<td>${dietVo.dietNo }</td>
			<td>${dietVo.dietType }</td>
			<td>${dietVo.dietName }</td>
			<td>${dietVo.dietCal }</td>
			<td><a href="../diet/update.do?dietNo=${dietVo.dietNo }">수정</a></td>
			<td><a href="../diet/delete.do?dietNo=${dietVo.dietNo }">삭제</a></td>
		</tr>
		</c:forEach>
	</table>
</div>

<div>
	<form action="../diet/add.do" method="post">
		 <input type="radio" name="dietType" value="P" checked="checked">단백질 <input type="radio" name="dietType" value="C">탄수화물<br>
		 <input type="text" name="dietName" class="" placeholder="식단이름"><br>
		 <input type="text" name="dietCal" class="" placeholder="식단칼로리"><br>
		 <input type="submit" value="식단추가" class="submit-btn">
	</form>
</div>

</body>
</html>