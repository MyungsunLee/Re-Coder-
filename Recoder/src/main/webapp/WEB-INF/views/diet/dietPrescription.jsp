<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
<head>
<title>식단 처방</title>
<meta charset="UTF-8">
<style type="text/css">
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
	width: 650px;
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

#divTag, #divTag>form {
	padding-top: 30px;
	margin: auto;
	text-align: center;
}

#dietName{
	margin-top: 50px;
	border-collapse: collapse;
	
}

#dietName tr td{
	border: 3px solid lightgrey;
}
</style>
<script type="text/javascript">

	function selfFnc() {
		location.href="../diet/selfChoice.do";
	}

	function randomFnc() {
		location.href="../diet/randomChoice.do?memberNo=${login_memberVo.memberNo}";
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
	</table>


	<table id="dietName" style="width:400px;">
		<tr>
			<th>식품명</th>
			
		</tr>
		<c:forEach var="dietVo" items="${dietList}">
		<tr>
			<td style="text-align: center;">${dietVo.dietName} ${dietVo.dietCal } kcal</td>
		</tr>
		</c:forEach>
	</table>
	
	
	
	<div style="margin: auto; width: 600px; padding-left: 45px; padding-top: 50px;">
	<input type="button"  value="직접 선택" class="submit-btn" onclick="selfFnc();">
	<input type="button" value="랜덤 선택" class="submit-btn" onclick="randomFnc();">
	</div>
</div>


</body>
</html>