<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<title>식단 추가(관리자)</title>
<meta charset="UTF-8">
<link rel="stylesheet" type="text/css" href="/Recoder/resources/css/styles.css">
<link href="https://fonts.googleapis.com/css?family=Noto+Sans+KR" rel="stylesheet">
<link href="https://fonts.googleapis.com/css?family=Do+Hyeon" rel="stylesheet">
<style>
table {
	width: 550px;
	margin: auto;
	color: #198556;
}

th {
	background-color: #59d393;
	color: black;
}

td {
	border-bottom: 1px solid #eee;
}

a {
	text-decoration: none;
	color: #198556;
}
</style>
</head>
<body>
<jsp:include page="../common/header.jsp"/>
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
			<td style="text-align: right;">${dietVo.dietCal } kcal</td>
			<td><a href="../diet/update.do?dietNo=${dietVo.dietNo }">수정</a></td>
			<td><a href="../diet/delete.do?dietNo=${dietVo.dietNo }">삭제</a></td>
		</tr>
		</c:forEach>
	</table>
</div>

	<div class="regi-form">
		<form action="../diet/add.do" method="post">
			 <input type="radio" name="dietType" value="P" checked="checked">단백질 <input type="radio" name="dietType" value="C">탄수화물
			 <input type="radio" name="dietType" value="F">지방<br>
			 <input type="text" name="dietName" class="text-field" placeholder="식단이름" ><br>
			 <input type="text" name="dietCal" class="text-field" placeholder="식단칼로리" ><br>
			 <input type="submit" value="식단추가" class="submit-btn">
		</form>
	</div>

</body>
</html>