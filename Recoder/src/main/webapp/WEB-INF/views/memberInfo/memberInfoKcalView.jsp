<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
<head>
<title>칼로리 처방</title>
<meta charset="utf-8">
<link rel="stylesheet" type="text/css"
	href="/Recoder//resources/css/styles.css">
<link href="https://fonts.googleapis.com/css?family=Noto+Sans+KR"
	rel="stylesheet">
<link href="https://fonts.googleapis.com/css?family=Do+Hyeon"
	rel="stylesheet">
<style type="text/css">
	table{
		border: 2px solid black;
	}
</style>
</head>
<body>
	<jsp:include page="../common/header.jsp"></jsp:include>


	<c:if test="${sessionScope.login_memberVo == null }">
		<span style="text-align: center;">로그인 후 사용가능합니다.</span>
	</c:if>

	<c:if test="${sessionScope.login_memberVo != null }">
	
	<c:set var="_memberInfoActivity" value="${_memberInfoVo.memberInfoActivity}"/><!-- 기초대사량 -->
	<c:set var="_memberInfoCal" value="${_memberInfoVo.memberInfoCal}"/>
		<div>
			<h3 style="text-align: center;">처방전</h3>
			<input type="hidden" name="memberNo" value="${login_memberVo.memberNo}"> 
			이름 ${sessionScope.login_memberVo.memberName}
			
			<table>
				<tr>
					<td>기초대사량</td>
					<td><fmt:formatNumber value="${_memberInfoVo.memberInfoCal}" pattern="0"/>kcal</td>
				</tr>
				<tr>
					<td>하루 유지 칼로리</td>
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
				</tr>
				<tr>
					<td>일주일 유지 칼로리</td>
					<c:choose>
							<c:when test="${_memberInfoActivity == 1}">
								<td><fmt:formatNumber value="${_memberInfoCal*1.2*7}" pattern="0"/> kcal</td>
							</c:when>
							<c:when test="${_memberInfoActivity == 2}">
								<td><fmt:formatNumber value="${_memberInfoCal*1.375*7}" pattern="0"/> kcal</td>
							</c:when>
							<c:when test="${_memberInfoActivity == 3}">
								<td><fmt:formatNumber value="${_memberInfoCal*1.55*7}" pattern="0"/> kcal</td>
							</c:when>
							<c:when test="${_memberInfoActivity == 4}">
								<td><fmt:formatNumber value="${_memberInfoCal*1.725*7}" pattern="0"/> kcal</td>
							</c:when>
							<c:when test="${_memberInfoActivity == 5}">
								<td><fmt:formatNumber value="${_memberInfoCal*1.9*7}" pattern="0"/> kcal</td>
							</c:when>
						</c:choose>
				</tr>
				
				<c:set var="BMI" value="${_memberInfoVo.memberInfoWeight/((_memberInfoVo.memberInfoHeight*0.01)*(_memberInfoVo.memberInfoHeight*0.01))}"/>
				<tr>
					<td>BMI</td>
					<td><fmt:formatNumber value="${BMI}" pattern=".0"/></td>
				</tr>
				<tr>
					<td colspan="2">
						<c:choose>
							<c:when test="${BMI >= 30.0}">
							${sessionScope.login_memberVo.memberName}님은
							<fmt:formatNumber value="${BMI}" pattern=".0"/>(으)로 비만입니다.
							</c:when>
							<c:when test="${BMI >= 25}">
							${sessionScope.login_memberVo.memberName}님은
							<fmt:formatNumber value="${BMI}" pattern=".0"/>(으)로 과체중입니다.
							</c:when>
							<c:when test="${BMI > 18.5}">
							${sessionScope.login_memberVo.memberName}님은
							<fmt:formatNumber value="${BMI}" pattern=".0"/>(으)로 정상입니다.
							</c:when>
							<c:otherwise>
							${sessionScope.login_memberVo.memberName}님은
							<fmt:formatNumber value="${BMI}" pattern=".0"/>(으)로 저체중입니다.
							</c:otherwise>
						</c:choose>
					</td>
				</tr>
			</table>


		</div>
	</c:if>
	<jsp:include page="../common/tail.jsp"></jsp:include>
</body>
</html>