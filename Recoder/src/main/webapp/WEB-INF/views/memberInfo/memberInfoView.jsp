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
</style>
</head>
<body>
<jsp:include page="../common/header.jsp"></jsp:include>

  	
    <c:if test="${sessionScope.login_memberVo == null }">
    	<span>로그인 후 사용가능합니다.</span>
    </c:if>

	<c:if test="${sessionScope.login_memberVo != null }">
		<div>
		    <form action="memberInfoInsert.do" method="post" class="kcalForm">
				<pre style="font-size: medium; font-weight: bolder;">
				<input type="hidden" name="memberNo" value="${sessionScope.login_memberVo.memberNo}">
				성별		<input type="radio" name="memberInfoGender" value="M" checked="checked">남자 <input type="radio" name="memberGender" value="F">여자<br>
				나이		<input type="text" name="memberInfoAge" class="text-field" placeholder="숫자만 입력가능"><br>
				신장(cm) 	<input type="text" name="memberInfoHeight" class="text-field" placeholder="숫자, .만 입력가능"><br>
				몸무게(kg)	<input type="text" name="memberInfoWeight" class="text-field" placeholder="숫자, .만 입력가능"><br>
				평소 활동량	<input type="radio" name="memberInfoActivity" value="1" checked="checked">활동안함 <span>(운동을 전혀 안함)</span><br>
						<input type="radio" name="memberInfoActivity" value="2">가벼운 활동 <span>(일주일에 1~3일 운동을 함)</span><br>
						<input type="radio" name="memberInfoActivity" value="3">보통 활동 <span>(일주일에 3~5일 스포츠 또는 적당한 운동을 함)</span><br>
						<input type="radio" name="memberInfoActivity" value="4">많은 활동 <span>(일주일에 6~7일 격렬한 스포츠 또는 힘든 운동을 함)</span><br>
						<input type="radio" name="memberInfoActivity" value="5">격심한 활동 <span>(육체적으로 아주 힘든 일이나 하루 2번 운동을 함)</span><br>

		     			
		     				<input type="submit" value="칼로리 계산" class="submit-btn">
					</pre>
		    </form>
  		</div>
  	</c:if>
<jsp:include page="../common/tail.jsp"></jsp:include>
</body>
</html>