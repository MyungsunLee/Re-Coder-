<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
  <link rel="stylesheet" type="text/css" href="/Recoder//resources/css/styles.css">
  <link href="https://fonts.googleapis.com/css?family=Noto+Sans+KR" rel="stylesheet">
  <link href="https://fonts.googleapis.com/css?family=Do+Hyeon" rel="stylesheet">
  
  
  <style type="text/css">
  	table{
  		width: 700px;
  		margin: auto;
  	}
  	
  	.topTd{
  		text-align: center;
  		background-color: #EEEFF1;
  	}
  	td{
  		border-bottom: 1px solid #EEEFF1; 
  	}
  	div, form{
  		margin: auto;
  	}
  	
  	
  	
  </style>
</head>
<body>
<jsp:include page="../common/header.jsp"></jsp:include>

	<table>
	
		<tr>
			<td class="topTd">번호</td>
			<td class="topTd">제목</td>
			<td class="topTd">작성자</td>
			<td class="topTd" style="width:180px;">작성일</td>
		</tr>
		<c:forEach var="boardVo" items="${boardList}">
			<tr>
				<td>${boardVo.boardNo}</td>
				<td><a href="./listOne.do?no=${boardVo.boardNo}">${boardVo.boardTitle}</a></td>
				<td style="text-align: center;">${boardVo.name}</td>
				<td><fmt:formatDate value="${boardVo.boardCreDate}"
					pattern="yyyy-MM-dd hh:mm"/></td>
			</tr>
		
		</c:forEach>
	</table>

	<div>
		<form action="list.do" method="post">
		
			 <select name="searchOption">
				<option value="title">제목</option>
				<option value="content">내용</option>
				<option value="name">작성자</option>
			</select>
			<input type="text" name="keyword">
			<input type="submit" value="검색">
		</form>
	</div>


</body>
</html>