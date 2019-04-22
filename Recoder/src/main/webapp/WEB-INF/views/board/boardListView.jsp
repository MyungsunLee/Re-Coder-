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
   href="/Recoder//resources/css/styles.css">
<link href="https://fonts.googleapis.com/css?family=Noto+Sans+KR"
   rel="stylesheet">
<link href="https://fonts.googleapis.com/css?family=Do+Hyeon"
   rel="stylesheet">


<style type="text/css">
table {
   width: 700px;
   margin: auto;
}

.topTd {
   text-align: center;
   background-color: #EEEFF1;
}

td {
   border-bottom: 1px solid #EEEFF1;
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
   <div>
      <c:if test="${keyword} != ''">
         <a>${searchOption} ${keyword}로 검색한 결과 </a>
      </c:if>
   </div>
   <table>
      <tr>
         <td class="topTd" style="width: 50px;">번호</td>
         <td class="topTd">제목</td>
         <td class="topTd">작성자</td>
         <td class="topTd" style="width: 100px;">작성일</td>
      </tr>
      <c:forEach var="boardVo" items="${boardList}">
         <tr>
            <td style="text-align: center;">${boardVo.boardNo}</td>
            <td><a href="./listOne.do?boardNo=${boardVo.boardNo}">${boardVo.boardTitle}</a></td>
            <td style="text-align: center;">${boardVo.name}</td>
            <td style="text-align: center;"><fmt:formatDate
                  value="${boardVo.boardCreDate}" pattern="M/dd" /></td>
         </tr>

      </c:forEach>
   </table>


<jsp:include page="/WEB-INF/views/common/paging.jsp">
      <jsp:param value="${paging}" name="paging"/>
   </jsp:include>
   
   
<form action="./list.do" id="pagingForm" method="post">
      <input type="hidden" id="curPage" name="curPage" 
         value="${paging.boardPaging.curPage}">
   </form>


   <div id="divTag">
      <table>
         <tr>
            <td style="border-bottom: 1px solid white;"></td>
            <td>
               <form action="list.do" method="post">

                  <select name="searchOption">
                     <option value="title">제목</option>
                     <option value="content">내용</option>
                     <option value="name">작성자</option>
                  </select> <input type="text" name="keyword" value="${keyword}"> 
                  <input type="submit" value="검색">
               </form>
            </td>
            <td style="border-bottom: 1px solid white;">
                <c:if test="${sessionScope.login_memberVo != null}"> 
                   <button onclick="location.href='/Recoder/board/addOne.do?memberNo=${login_memberVo.memberNo}'">글쓰기</button>
                </c:if> 
               
            </td>
            
         </tr>
      </table>
   </div>
</body>
</html>