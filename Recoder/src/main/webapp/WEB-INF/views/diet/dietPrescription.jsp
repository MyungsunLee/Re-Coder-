<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
<head>
<title>식단 처방</title>
<meta charset="UTF-8">
<link rel="stylesheet" type="text/css" href="/Recoder/resources/css/styles.css">
<link href="https://fonts.googleapis.com/css?family=Noto+Sans+KR" rel="stylesheet">
<link href="https://fonts.googleapis.com/css?family=Do+Hyeon" rel="stylesheet">
<style>

.kcalForm{
		margin-top: 80px;
	    width: 800px;
	    padding: 20px;
	    margin-left: auto;
	    margin-right: auto;
	
	    background-color: #EEEFF1;
	    border-radius: 5px;
	    border: 0;
	}
table {
	margin-left: auto;
	margin-right: auto;
}
table, th, tr, td{
	
	border: 1px solid black;
	border-collapse: collapse;
}
</style>
<script type="text/javascript">

	function selfFnc() {
		
	}

	function randomFnc() {
		
	}
</script>
</head>
<body>
<jsp:include page="../common/header.jsp"/>
<c:set var="_memberInfoActivity" value="${_memberInfoVo.memberInfoActivity}"/><!-- 기초대사량 -->
<c:set var="_memberInfoCal" value="${_memberInfoVo.memberInfoCal}"/>
<div class="kcalForm">
	<table>
		<tr>
			<th>유지 칼로리</th>
			<c:choose>
				<c:when test="${_memberInfoActivity == 1}">
					<td><fmt:formatNumber value="${_memberInfoCal*1.2}" pattern="0"/> kcal</td>
				</c:when>
				<c:when test="${_memberInfoActivity == 2}">
					<td><fmt:formatNumber value="${_memberInfoCal*1.375}" pattern="0"/> kcal</td>
				</c:when>
				<c:when test="${_memberInfoActivity == 3}">
					<td><fmt:formatNumber value="${_memberInfoCal*1.55}" pattern="0"/> kcal</td>
				</c:when>
				<c:when test="${_memberInfoActivity == 4}">
					<td><fmt:formatNumber value="${_memberInfoCal*1.725}" pattern="0"/> kcal</td>
				</c:when>
				<c:when test="${_memberInfoActivity == 5}">
					<td><fmt:formatNumber value="${_memberInfoCal*1.9}" pattern="0"/> kcal</td>
				</c:when>
			</c:choose>
			<th>식단 처방 칼로리</th>
			<c:choose>
				<c:when test="${_memberInfoActivity == 1}">
					<td><fmt:formatNumber value="${_memberInfoCal*1.2-500}" pattern="0"/> kcal</td>
				</c:when>
				<c:when test="${_memberInfoActivity == 2}">
					<td><fmt:formatNumber value="${_memberInfoCal*1.375-500}" pattern="0"/> kcal</td>
				</c:when>
				<c:when test="${_memberInfoActivity == 3}">
					<td><fmt:formatNumber value="${_memberInfoCal*1.55-500}" pattern="0"/> kcal</td>
				</c:when>
				<c:when test="${_memberInfoActivity == 4}">
					<td><fmt:formatNumber value="${_memberInfoCal*1.725-500}" pattern="0"/> kcal</td>
				</c:when>
				<c:when test="${_memberInfoActivity == 5}">
					<td><fmt:formatNumber value="${_memberInfoCal*1.9-500}" pattern="0"/> kcal</td>
				</c:when>
			</c:choose>
		</tr>
		<c:forEach var="dietVo" items="${dietList}">
		<tr>
			<th>식품명</th>
			<td colspan="3" style="text-align: center;">${dietVo.dietName } ${dietVo.dietCal } kcal</td>
		</tr>
		</c:forEach>
	</table>
	<input type="button" value="직접 선택" class="submit-btn" onclick="selfFnc();">
	<input type="button" value="랜덤 선택" class="submit-btn" onclick="randomFnc();">
</div>


</body>
</html>