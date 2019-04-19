<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
  <title>칼로리 처방</title>
  <meta charset="utf-8">
  <link rel="stylesheet" type="text/css" href="/Recoder//resources/css/styles.css">
  <link href="https://fonts.googleapis.com/css?family=Noto+Sans+KR" rel="stylesheet">
  <link href="https://fonts.googleapis.com/css?family=Do+Hyeon" rel="stylesheet">
<style type="text/css">
	
	div form pre span{
		color: gray;
	}
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
	.inputBox{
		width: 120px;
		height: 30px;
	}
	table {
		border: 3px solid black;
	}
</style>
</head>
<body>
<jsp:include page="../common/header.jsp"></jsp:include>

  
    <c:if test="${sessionScope.login_memberVo == null }" >
    	<span style="text-align: center;">로그인 후 사용가능합니다.</span>
    </c:if>

	<c:if test="${sessionScope.login_memberVo != null }">
		<div>
		    <form action="memberInfoKcalView.do" method="post" class="kcalForm">
				<h3 style="text-align: center;">처방전</h3>
				<input type="hidden" name="memberNo" value="${login_memberVo.memberNo}">
				이름	${login_memberVo.memberName}
				<table class="text-field">
					<tr>
						<td>기초대사량</td>
						<td> kcal</td>
					</tr>
					<tr>
						<td>하루 유지 칼로리</td>
						<td> kcal</td>
					</tr>
					<tr>
						<td>일주일 칼로리</td>
						<td> kcal</td>
					</tr>
					<tr>
						<td>건강 몸무게</td>
						<td>뀨?</td>
					</tr>
					<tr>
						<td>BMI</td>
						<td></td>
					</tr>
				</table>
				
									
		    </form>
  		</div>
  	</c:if>
<jsp:include page="../common/tail.jsp"></jsp:include>
</body>
</html>