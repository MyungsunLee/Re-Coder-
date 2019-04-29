<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<script src="https://code.jquery.com/jquery-3.4.0.min.js"></script>
<div id = "header">
	<jsp:include page="../common/slider_ad.jsp"/>
	
	<div id="logo">
		<a href="../common/index.do"><img src="https://upload.wikimedia.org/wikipedia/commons/thumb/3/3c/Diet_Coke_logo.svg/200px-Diet_Coke_logo.svg.png"></a>
	</div>

<c:if test="${sessionScope.login_memberVo == null }">
	<div id="login">
		<a href="../member/add.do"><span>회원가입</span></a>
		<a href="../auth/login.do"><span>로그인</span></a>
	</div>
	
	<div id="menu">
		<a href="../introduce/home.do"><span>소개</span></a>
		<a href="../auth/login.do"><span>칼로리 처방</span></a>
    	<a href="../auth/login.do"><span>식단 처방</span></a>
		<a href="../board/list.do"><span>게시판</span></a>
	</div>
</c:if>

<c:if test="${sessionScope.login_memberVo != null }">
	<input type="hidden" name="memberNo" value="${login_memberVo.memberNo}">
	<div id="login">
		<a href="../member/info.do"><span>${login_memberVo.memberName}</span></a>
		<a href="../auth/logout.do"><span>로그아웃</span></a>
	</div>
	
	<div id="menu">
		<a href="../introduce/home.do"><span>소개</span></a>
		
		<c:choose>
			<c:when test="${login_memberVo.memberNo != null}">
				<a href="../memberInfo/memberInfoView.do?memberNo=${login_memberVo.memberNo}"><span>칼로리 처방</span></a>
			</c:when>
			<c:otherwise>
				<a href="../memberInfo/memberInfoView.do"><span>칼로리 처방</span></a>
			</c:otherwise>
		</c:choose>
		
    	<a href="#"><span>식단 처방</span></a>
		<a href="../board/list.do"><span>게시판</span></a>
	</div>
</c:if>
</div>