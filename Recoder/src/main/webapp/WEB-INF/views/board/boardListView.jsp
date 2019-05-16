<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
table {
	width: 750px;
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
</style>
</head>
<body>
	<jsp:include page="../common/header.jsp"></jsp:include>

	<table>
		<tr>
			<th style="width: 70px;">번호</th>
         <th style="width: 380px;">제목</th>
         <th style="width: 100px;">작성자</th>
         <th style="width: 130px;">작성일</th>
		</tr>
		<c:forEach var="boardVo" items="${boardList}">
			<tr>
				<td style="text-align: center;">${boardVo.boardNo}</td>
				<td><a href="./listOne.do?boardNo=${boardVo.boardNo}">
						${boardVo.boardTitle} <c:if test="${boardVo.commentTotCount != 0}">
           [${boardVo.commentTotCount}]
            </c:if>
				</a></td>
				<td style="text-align: center;">${boardVo.name}</td>
				<td style="text-align: center;"><fmt:formatDate
						value="${boardVo.boardCreDate}" pattern="yyyy-MM-dd"/></td>
			</tr>

		</c:forEach>
	</table>


	<jsp:include page="/WEB-INF/views/common/paging.jsp">
		<jsp:param value="${paging}" name="paging" />
	</jsp:include>


	<form action="./list.do" id="pagingForm" method="post">
		<input type="hidden" id="curPage" name="curPage"
			value="${paging.boardPaging.curPage}"> <input type="hidden"
			name="searchOption" value="${searchOption}"> <input
			type="hidden" name="keyword" value="${keyword}">
	</form>

	<div style="text-align: center; margin-top: 30px;">
		<c:if test="${keyword != ''}">
			<a>${keyword}로 검색한 결과 </a>
		</c:if>
	</div>
	<div id="divTag">
		<table>
			<tr>
				<td style="border-bottom: 1px solid white;"></td>
				<td>
					<form action="list.do" method="post">

						<select name="searchOption" id="searchOption">
							<c:if test="${searchOption == ''}">
								<option value="title" selected="selected">제목</option>
								<option value="content">내용</option>
								<option value="name">작성자</option>
							</c:if>

							<c:if test="${searchOption == 'title'}">
								<option value="title" selected="selected">제목</option>
								<option value="content">내용</option>
								<option value="name">작성자</option>
							</c:if>

							<c:if test="${searchOption == 'content'}">
								<option value="title">제목</option>
								<option value="content" selected="selected">내용</option>
								<option value="name">작성자</option>
							</c:if>
							<c:if test="${searchOption == 'name'}">
								<option value="title">제목</option>
								<option value="content">내용</option>
								<option value="name" selected="selected">작성자</option>
							</c:if>

						</select> <input type="text" name="keyword" value="${keyword}"> <input
							type="submit" value="검색">
					</form>
				</td>
				<td style="border-bottom: 1px solid white;"><c:if
						test="${sessionScope.login_memberVo != null}">
						<button
							onclick="location.href='/Recoder/board/addOne.do?memberNo=${login_memberVo.memberNo}'">글쓰기</button>
					</c:if></td>
				<td><input type="hidden" id="searchOptionVal"
					value="${searchOption}"></td>
			</tr>
		</table>
	</div>
</body>
</html>