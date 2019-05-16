<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css"
	href="/Recoder/resources/css/styles.css">
<script src="/Recoder/resources/js/jquery-3.3.1.js"></script>

<style>
table {
	width: 600px;
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

	<jsp:include page="../common/header.jsp"></jsp:include>
	<table id="memberTable">
		<tr>
			<th>회원번호</th>
			<th>이름</th>
			<th>이메일</th>
			<th>가입일</th>
			<th>삭제</th>
		</tr>
		<c:forEach var="member" items="${memberList}">
			<tr>
				<td>${member.memberNo}</td>
				<td>${member.memberName}</td>
				<td>${member.memberEmail}</td>
				<td><fmt:formatDate value="${member.memberCreDate}"
						pattern="yyyy/M/dd" /></td>
				<td><a
					href="../member/deleteCtr.do?memberNo=${member.memberNo}">삭제</a></td>
			</tr>
		</c:forEach>
	</table>
	<jsp:include page="../admin/paging.jsp"></jsp:include>

	<form action="./list.do" id="pagingForm" method="post">
		<input type="hidden" id="curPage" name="curPage"
			value="${paging.boardPaging.curPage}"> <input type="hidden"
			name="searchOption" value="${searchOption}"> <input
			type="hidden" name="keyword" value="${keyword}">
	</form>
	<div style="text-align: center; margin-top: 30px;">
		<form action="../member/list.do" method="post" id="select">

			<select name="searchOption" id="searchOption">
				<c:if test="${searchOption == ''}">
					<option value="memberNo" selected="selected">회원번호</option>
					<option value="memberName">이름</option>
					<option value="memberEmail">이메일</option>
				</c:if>

				<c:if test="${searchOption == 'memberNo'}">
					<option value="memberNo" selected="selected">회원번호</option>
					<option value="memberName">이름</option>
					<option value="memberEmail">이메일</option>
				</c:if>

				<c:if test="${searchOption == 'memberName'}">
					<option value="memberNo">회원번호</option>
					<option value="memberName" selected="selected">이름</option>
					<option value="memberEmail">이메일</option>
				</c:if>
				<c:if test="${searchOption == 'memberEmail'}">
					<option value="memberNo">회원번호</option>
					<option value="memberName">이름</option>
					<option value="memberEmail" selected="selected">이메일</option>
				</c:if>
			</select> <input type="text" name="keyword" value="${keyword}"> <input
				type="submit" value="검색">
		</form>
	</div>




</body>
</html>