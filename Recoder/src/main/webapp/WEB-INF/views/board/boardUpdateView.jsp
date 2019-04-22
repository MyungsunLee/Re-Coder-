<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css"
	href="/Recoder/resources/css/styles.css">
<link href="https://fonts.googleapis.com/css?family=Noto+Sans+KR"
	rel="stylesheet">
<link href="https://fonts.googleapis.com/css?family=Do+Hyeon"
	rel="stylesheet">
</head>
<body>
	<jsp:include page="../common/header.jsp"></jsp:include>


	<form action="../board/updateCtr.do" method="post">
		<input type="hidden" name="boardNo"value="${selectedBoard.boardNo}">
		<table>
			<tr>
				<td>작성자</td>
				<td>${selectedBoard.name}</td>
			</tr>
		
			<tr>
				<td>제목</td>
				<td><input type="text" name="boardTitle"value="${selectedBoard.boardTitle}"></td>
			</tr>
			<tr>
				<td>내용</td>
				<td><input type="text" name="boardContent" value="${selectedBoard.boardContent}"></td>
			</tr>
			
			<tr>
				<td rowspan="2">
					<input type="submit" value="수정">
				</td>
			</tr>
		</table>
	</form>


</body>
</html>