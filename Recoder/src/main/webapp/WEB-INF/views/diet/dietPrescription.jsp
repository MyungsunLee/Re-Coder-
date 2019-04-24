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
	margin-left: auto;
	margin-right: auto;
}
table, th, tr, td{
	
	border: 1px solid black;
	border-collapse: collapse;
}
</style>
</head>
<body>
<jsp:include page="../common/header.jsp"/>
<div>
	<table>
		<tr>
			<td>유지 칼로리</td><td><input></td>
			<td></td>
			<td></td>
		</tr>
		<tr>
			<th>${dietVo.dietType. }</th>
			<th>식단이름</th>
			<th>식단칼로리</th>
		</tr>
		<c:forEach var="dietVo" items="${dietList}">
		<tr>
		<c:if test="${dietVo.dietType =='C'.charAt(0)}">
			<th>${dietVo.dietType}</th>
		</c:if>		
			<td>${dietVo.dietName}</td>
			<td>${dietVo.dietCal } kcal</td>
		</tr>
		<tr>
		<c:if test="${dietVo.dietType =='P'.charAt(0)}">
			<th>${dietVo.dietType}</th>
		</c:if>
			<td></td>
		</tr>
		</c:forEach>
	</table>
</div>


</body>
</html>