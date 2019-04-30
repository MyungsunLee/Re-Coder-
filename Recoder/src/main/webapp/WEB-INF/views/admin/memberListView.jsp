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
<link href="https://fonts.googleapis.com/css?family=Noto+Sans+KR"
   rel="stylesheet">
<link href="https://fonts.googleapis.com/css?family=Do+Hyeon"
   rel="stylesheet">
</head>
<script type="text/javascript"
   src="http://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js">
   
</script>
<style></style>
</head>
<body>

 <jsp:include page="../common/header.jsp"></jsp:include>
	<table id="memberTable">
		<tr>
			<td>회원번호</td>
			<td>이름</td>
			<td>이메일</td>
			<td>가입일</td>
			<td>삭제</td>
		</tr>
	<c:forEach var="member" items="${memberList}">
	<tr>
		<td>${member.memberNo}</td>
		<td>${member.memberName}</td>
		<td>${member.memberEmail}</td>
		<td><fmt:formatDate
                  value="${member.memberCreDate}" pattern="yyyy/M/dd" /></td>
        <td><a href="../member/deleteCtr.do?memberNo=${member.memberNo}">삭제</a></td>
	</tr>
	</c:forEach>
	</table>

	<form action="../member/list.do" method="post">
		
		 <select name="searchOption" id="searchOption">
                  	<c:if test="${searchOption == ''}">
                     <option value="memberNo"  selected="selected">회원번호</option>
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
          </select>
          
          <input type="text" name="keyword" value="${keyword}">
          <input type="submit" value="검색">
	</form>

	
	
	
</body>
</html>