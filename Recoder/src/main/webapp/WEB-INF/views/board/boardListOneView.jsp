<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
  <link rel="stylesheet" type="text/css" href="/Recoder/resources/css/styles.css">
  <link href="https://fonts.googleapis.com/css?family=Noto+Sans+KR" rel="stylesheet">
  <link href="https://fonts.googleapis.com/css?family=Do+Hyeon" rel="stylesheet">

  
  
  <script type="text/javascript">
  	function pageMove(){
  		location.href='./updateOne.do?boardNo=${selectedBoard.boardNo}';
  	}
  </script>
  

  <style>
  	table {
  		width: 980px;
  	}
  
  	table, tr, td {
  		border: 1px solid black;
  		border-collapse: collapse;
  	}
  </style>

</head>
<body>
<jsp:include page="../common/header.jsp"></jsp:include>

<div>   
   <table>
      <tr>
      	<td>${selectedBoard.boardNo }
         <td>${selectedBoard.boardTitle}</td>
         <td>${selectedBoard.name} </td>
         <td>
            <fmt:formatDate value="${selectedBoard.boardCreDate}"
               pattern="yyyy-m-d   H:mm:ss"/>
            
         </td>
      </tr>
      <tr>
         <td colspan="4">${selectedBoard.boardContent}</td>
      </tr>
   </table>
</div>



   <c:if test="${login_memberVo.memberNo == selectedBoard.memberNo }">
 <div style="text-align: right;">
   <a href="../board/delete.do?boardNo=${selectedBoard.boardNo }">삭제</a>
 </div>
   </c:if>
   
<%--    <c:if test="${login_memberVo.memberAuth == 'A'}"> --%>
<!--  <div style="text-align: right;"> -->
<%--    <a href="../board/delete.do?boardNo=${selectedBoard.boardNo }">삭제</a> --%>
<!--  </div> -->
<%--    </c:if> --%>
   
   <table>
   <tr>
   <c:if test="${selectedBoard.memberNo == login_memberVo.memberNo}">
   
   		<td>
   			<button onclick="pageMove();">수정</button>
   		</td>
   		
   </c:if>
   
   </tr>
   
   </table>
   <a>작성자 회원번호 : ${selectedBoard.memberNo} </a>
   <a>로그인 회원번호 : ${login_memberVo.memberNo}</a>
   <a>게시글 글 번호 : ${selectedBoard.boardNo}</a>
</body>
</html>