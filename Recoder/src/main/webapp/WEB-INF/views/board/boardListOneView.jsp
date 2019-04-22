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



<script type="text/javascript">
     function boardOneUpdate(){
        location.href='./updateOne.do?boardNo=${selectedBoard.boardNo}';
     }
     function boardOneDelete(){
        location.href='./deleteOne.do?boardNo=${selectedBoard.boardNo}';
     }
     function prevBoard(){
        
        location.href='./listOne.do?boardNo=${prevBoard.boardNo}';
     }
   function nextBoard(){
        
        location.href='./listOne.do?boardNo=${nextBoard.boardNo}';
     }
   function list(){
      location.href='./list.do';
      
   }
     
  </script>

<style>
table {
   width: 980px;
}

table, tr, td {
   border: 1px solid #EEEFF1;
   border-collapse: collapse;
}

#subTable {
   margin-top: 30px;
   padding-top: 20px;
   width: 650px;

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
            <td>${selectedBoard.name}</td>
            <td><fmt:formatDate value="${selectedBoard.boardCreDate}"
                  pattern="yyyy-m-d   H:mm:ss" /></td>
         </tr>
         <tr>
            <td colspan="4" style="height: 400px;">${selectedBoard.boardContent}</td>
         </tr>
      </table>
   </div>


   <c:if test="${login_memberVo.memberNo == selectedBoard.memberNo }">
   </c:if>

   <%--    <c:if test="${login_memberVo.memberAuth == 'A'}"> --%>
   <!--  <div style="text-align: right;"> -->
   <%--    <a href="../board/delete.do?boardNo=${selectedBoard.boardNo }">삭제</a> --%>
   <!--  </div> -->
   <%--    </c:if> --%>

   <div style="text-align: right;">
      <table>
         <tr>

            <td><c:if
                  test="${selectedBoard.memberNo == login_memberVo.memberNo}">
                  <button onclick="boardOneUpdate();">수정</button>
                  <button id="deleteBtn" onclick="boardOneDelete();">삭제</button>
               </c:if>
            <button onclick="list();">글 목록</button></td>

         </tr>

      </table>
   </div>
   <%--    <a>작성자 회원번호 : ${selectedBoard.memberNo} </a> --%>
   <%--    <a>로그인 회원번호 : ${login_memberVo.memberNo}</a> --%>
   <%--    <a>게시글 글 번호 : ${selectedBoard.boardNo}</a> --%>
   <!-- 데이터가 미심쩍을때 확인 바로바로 -->

   <table id="subTable">
      <tr>
         <td style="width: 100px;">이전 글</td>
         <td style="width: 370px;"
            onclick="prevBoard();">
            ${prevBoard.boardTitle}</td>

         <td style="width: 100px;">${prevBoard.name}</td>
         <td style="width: 80px;"><fmt:formatDate
               value="${prevBoard.boardCreDate}" pattern="M/dd" /></td>
      </tr>
      <tr>
         <td>다음 글</td>
         <td><a onclick="nextBoard();">
               ${nextBoard.boardTitle}</a></td>

         <td>${nextBoard.name}</td>
         <td><fmt:formatDate value="${nextBoard.boardCreDate}"
               pattern="M/dd" /></td>
      </tr>
   </table>

</body>
</html>