<%@page import="com.edu.diet.vo.DietVo"%>
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
</head>
<body>
<jsp:include page="../common/header.jsp"/>
<c:set var="_memberInfoActivity" value="${_memberInfoVo.memberInfoActivity}"/><!-- 기초대사량 -->
<c:set var="_memberInfoCal" value="${_memberInfoVo.memberInfoCal}"/>
<input type="hidden" name="memberNo" value="${_memberInfoVo.memberNo}">
<div class="kcalForm">
<form action="../diet/randomChoice.do?memberNo=${_memberInfoVo.memberNo}" method="post">
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
		
		<c:set var="dietTypeC" value="C" />
		<c:set var="dietTypeP" value="P" />
		
		<tr>
			<th>탄수화물</th>
			<c:forEach var="_dietVoC" items="${carbDietVoCntMap}" varStatus="status">
			<td style="text-align: center;">${_dietVoC.key} ${_dietVoC.value}개</td>
			</c:forEach>
		</tr>
		<tr>
			<th>칼로리</th>
			<c:forEach var="_dietVoC" items="${carbDietVoCalMap}" varStatus="status">
			<td style="text-align: center;">${_dietVoC.value} kcal</td>
			</c:forEach>
		</tr>
		
		<tr>
			<th>단백질</th>
			<c:forEach var="_dietVoP" items="${proDietVoCntMap}" varStatus="status">
			<td style="text-align: center;">${_dietVoP.key} ${_dietVoP.value}개</td>
			</c:forEach>
		</tr>
		<tr>
			<th>칼로리</th>
			<c:forEach var="_dietVoP" items="${proDietVoCalMap}" varStatus="status">
			<td style="text-align: center;">${_dietVoP.value} kcal</td>
			</c:forEach>
		</tr>
	</table>
	<input type="submit" value="다시하기" class="submit-btn">
</form>	
</div>
<div>
	<span>ㅎㅇ</span>
	<span>${newDietVoCMap.aaa}</span>
</div>
${newDietVoCMap.dietVo2.getDietName()}

</body>
</html>