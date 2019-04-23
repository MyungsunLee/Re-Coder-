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
<script type="text/javascript">
	function kcalViewFnc(){
		
		location.href="./memberInfoKcalView.do"
		
	}
</script>
</head>
<body>
<jsp:include page="../common/header.jsp"></jsp:include>

  	
    <c:if test="${sessionScope.login_memberVo == null }">
    	<span>로그인 후 사용가능합니다.</span>
    </c:if>

	<c:if test="${sessionScope.login_memberVo != null }">
		<div>
		    <form action="memberInfoUpdateOne.do" method="post" class="kcalForm">
					<pre style="font-size: medium; font-weight: bolder;">
					<input type="hidden" name="memberNo" value="${_memberInfoVo.memberNo}">
					<c:choose>
						<c:when test="${_memberInfoVo.memberInfoGender == 'M'.charAt(0)}">
					성별		<input type="radio" name="memberInfoGender" value="M" checked="checked">남자 
						</c:when> 
						<c:otherwise>
							<input type="radio" name="memberInfoGender" value="F" checked="checked">여자<br>
						</c:otherwise>
					</c:choose>
					나이		<input type="text" name="memberInfoAge" class="text-field" placeholder="${_memberInfoVo.memberInfoAge}" value="${_memberInfoVo.memberInfoAge}" readonly="readonly"><br>
 					신장(cm) 	<input type="text" name="memberInfoHeight" class="text-field" placeholder="${_memberInfoVo.memberInfoHeight}" value="${_memberInfoVo.memberInfoHeight}" readonly="readonly"><br>
					몸무게(kg)	<input type="text" name="memberInfoWeight" class="text-field" placeholder="${_memberInfoVo.memberInfoWeight}" value="${_memberInfoVo.memberInfoWeight}" readonly="readonly"><br>
					<c:choose>
					<c:when test="${_memberInfoVo.memberInfoActivity == 1}">	
					평소 활동량	<input type="radio" name="memberInfoActivity" value="1" checked="checked" >활동안함 <span>(운동을 전혀 안함)</span><br>
					</c:when>
					<c:when test="${_memberInfoVo.memberInfoActivity == 2}">	
							<input type="radio" name="memberInfoActivity" value="2" checked="checked" >가벼운 활동 <span>(일주일에 1~3일 운동을 함)</span><br>
					</c:when>
					<c:when test="${_memberInfoVo.memberInfoActivity == 3}">	
							<input type="radio" name="memberInfoActivity" value="3" checked="checked" >보통 활동 <span>(일주일에 3~5일 스포츠 또는 적당한 운동을 함)</span><br>
					</c:when>
					<c:when test="${_memberInfoVo.memberInfoActivity == 4}">	
							<input type="radio" name="memberInfoActivity" value="4" checked="checked" >많은 활동<span>(일주일에 6~7일 격렬한 스포츠 또는 힘든 운동을 함)</span><br>
					</c:when>
					<c:otherwise>	
							<input type="radio" name="memberInfoActivity" value="5" checked="checked" >격심한 활동 <span>(육체적으로 아주 힘든 일이나 하루 2번 운동을 함)</span><br>
					</c:otherwise>
			     	</c:choose>
			     				<input type="submit" value="수정하기" class="submit-btn">
			     				<input type="button" value="처방전 바로가기" class="submit-btn" onclick="kcalViewFnc();">
					</pre>
		    </form>
  		</div>
  	</c:if>
<jsp:include page="../common/tail.jsp"></jsp:include>
</body>
</html>