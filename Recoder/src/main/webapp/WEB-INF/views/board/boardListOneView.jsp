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
<style>
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

#subTable {
   margin-top: 30px;
   padding-top: 20px;
   width: 650px;
}

#commentInsert {
   width: 750px;
   border: 1px solid white;
}
</style>
<script type="text/javascript"
   src="/Recoder/resources/js/jquery-3.3.1.js"></script>


<script type="text/javascript">

   
   $(document).ready(function(){
      

      $('#commentdiv .comment .updateBtn').click(function() {
            
         var index= $(this).index('#commentdiv .comment .updateBtn');

       $('#updatediv .update').css({display: 'none'});
       $('#updatediv .update').eq(index).css({display: 'block'});
       return false;
        });
      
      $('.commentform').submit(function(){
      var comments = $('.comments').val();
         if(comments == '') {
            alert('댓글을 입력해주세요.');
            $('.comments').focus();
            return false;
            
         };
   
      
      });
      
//       $('#updateBtn').click(function(){
//          var htmlInStr = $(this).closest('td').html();
         
//          alert(htmlInStr);
         
//       });
      
      
//       function updateBtn(commentNo){
//          alert(commentNo);
//          $("#hiddenDiv"[id*=commentNo]).show();
//       }
      
//    $('#update').click(function(){
      
//       if (condition) {
         
//       }
      
//       $('.hideTag').show();
//       $('#updateForm').show();
//    })
   
   
   });
   

     
     function boardOneUpdate(){
        location.href='./updateOne.do?boardNo=${selectedBoard.boardNo}';
     }
     function boardOneDelete(){
        location.href='./delete.do?boardNo=${selectedBoard.boardNo}';
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
</head>
<body>
   <jsp:include page="../common/header.jsp"></jsp:include>


   <div>
      <table>
         <tr>
            <th style="width: 100px;">${selectedBoard.boardNo }</th>
            <th style="width: 380px;">${selectedBoard.boardTitle}</th>
            <th style="width: 100px;">${selectedBoard.name}</th>
            <th style="width: 170px;"><fmt:formatDate
                  value="${selectedBoard.boardCreDate}"
                  pattern="yyyy-MM-dd HH:mm:ss" /></th>
         </tr>
         <tr>
            <td colspan="4">


               <p style="height: 500px; overflow: auto;">
                  <c:choose>
                     <c:when test="${empty fileList}">
                     </c:when>
                     <c:otherwise>
                        <c:forEach var="row" items="${fileList}">
                           <img alt="image not found"
                              src="<c:url value='/img/${row.STORED_FILE_NAME}'/>" />
                           <br>
                        </c:forEach>
                     </c:otherwise>
                  </c:choose>
                  ${selectedBoard.boardContent}
               </p>
         </tr>
      </table>
   </div>


   <c:if test="${login_memberVo.memberNo == selectedBoard.memberNo }">
   </c:if>

   <div style="text-align: right;">
      <table>
         <tr>

            <td><c:if
                  test="${selectedBoard.memberNo == login_memberVo.memberNo}">
                  <button onclick="boardOneUpdate();">수정</button>
                  <button id="deleteBtn" onclick="boardOneDelete();">삭제</button>
               </c:if> <c:if test="${login_memberVo.memberAuth == 'A'.charAt(0)}">

                  <button id="deleteBtn" onclick="boardOneDelete();">삭제</button>

               </c:if>
               <button onclick="list();">글 목록</button></td>

         </tr>

      </table>
   </div>

   <!--    데이터확인 -->
   <div>
      <%--    <a>작성자 회원번호 : ${selectedBoard.memberNo} </a> --%>
      <%--    <a>로그인 회원번호 : ${login_memberVo.memberNo}</a> --%>
      <%--    <a>게시글 글 번호 : ${selectedBoard.boardNo}</a> --%>
      <!-- 데이터가 미심쩍을때 확인 바로바로 -->
   </div>


   <div style="width: 750px; margin: auto;">
     <span>덧글 [${commentTotCount}]</span>

      <div id="commentdiv">
         <c:forEach var="commentVo" items="${commentList}">
            <div class="comment" style="border-top: 1px solid green;">
               <p style="background: lightgreen;">${commentVo.memberName}</p>
               <p style="width: 750px; word-break: break-all; word-wrap: break-word;">${commentVo.comments}</p>
               <p style="text-align: right;"><fmt:formatDate
                     value="${commentVo.creDate}" pattern="yyyy.M.dd hh:mm:ss" /></p>
              
               <c:if
                  test="${commentVo.memberNo == login_memberVo.memberNo || login_memberVo.memberAuth == 'A'.charAt(0)}">
                <p style="text-align: right;">
               <button class="updateBtn">수정</button>
               <a href="./commentDeleteOne.do?commentNo=${commentVo.commentNo}&boardNo=${selectedBoard.boardNo}">[X]</a>
                </p>
               </c:if>
              
            </div>
            
            
      <div id="updatediv">
<%--          <c:if test="${login_memberVo.memberNo != commentVo.memberNo || }"> --%> 
         
<%--          </c:if> --%>
         
         <div class="update" style="display:none;">
            <form action="commentUpdateOne.do" method="post">
               <input type="hidden" name="boardNo" value="${selectedBoard.boardNo}">
<%--                <input type="hidden" name="memberNo" value="${login_memberVo.memberNo}"> --%>
<%--                <input type="hidden" name="commentMemberVo" value="${comment.memberNo}">    --%>
               <input type="hidden" name="commentNo" value="${commentVo.commentNo}">
                  ㄴ<input style="width:673px; height: 30px;" type="text" name="comments" value="${commentVo.comments}">
               <input type="submit" value="수정">
            </form>
         </div>
      </div>
         </c:forEach>
      </div>
   </div>



<!--    <table> -->
<!--       <tr> -->
<%--          <td>덧글 [${commentTotCount}]</td> --%>
<!--       </tr> -->
<%--       <c:forEach var="commentVo" items="${commentList}"> --%>
<!--          <tr> -->
<%--             <td>${commentVo.memberName}</td> --%>
<%--             <td>${commentVo.comments}</td> --%>
<%--             <td><span><fmt:formatDate value="${commentVo.creDate}" --%>
<%--                      pattern="yyyy.M.dd hh:mm:ss" /> <c:if --%>
<%--                      test="${commentVo.memberNo == login_memberVo.memberNo}"> --%>
<!--                      <a -->
<%--                         href="./commentDeleteOne.do?commentNo=${commentVo.commentNo}&boardNo=${selectedBoard.boardNo}">[X]</a> --%>
<%--                      <button onclick="updateBtn(${commentVo.commentNo});" --%>
<!--                         id="updateBtn">[수정]</button> -->
<%--                   </c:if></span></td> --%>
<!--          </tr> -->
<!--          <tr> -->
<!--             <td colspan="3"> -->
<!--                         [comment update] -->
<!--                <div class="hideTag"> -->
<%--                   <form id="hideForm${commentVo.commentNo}" hidden="hidden" --%>
<!--                      action="" method="post"> -->
<!--                      <input type="hidden" name="boardNo" -->
<%--                         value="${selectedBoard.boardNo}"> <input type="hidden" --%>
<%--                         name="memberNo" value="${login_memberVo.memberNo}"> <input --%>
<!--                         type="text" name="comments"> <input type="button" -->
<!--                         value="수정"> -->
<!--                   </form> -->
<!--                </div> -->
<!--             </td> -->
<!--          </tr> -->
<%--       </c:forEach> --%>

<!--    </table> -->

   <!--    덧글입력테이블 -->

   <c:if test="${login_memberVo != null}">

      <form id="commentform" action="../board/commentInsertOne.do" method="post">
         <table id="commentInsert">
            <tr>
               <td>${login_memberVo.memberName}</td>
            </tr>
            <tr>
               <td><input type="hidden" name="boardNo"
                  value="${selectedBoard.boardNo}"> <input type="hidden"
                  name="memberNo" value="${login_memberVo.memberNo}"> <input style="width:750px; height: 30px;"id="comments"
                  type="text" name="comments" placeholder="덧글을 입력해 주세요"></td>
            </tr>
            <tr style="text-align: right;">
            <td><input type="submit" value="등록"></td>
            </tr>
         </table>
      </form>

   </c:if>
   <c:if test="${login_memberVo == null}">
      <div style="width: 750px; margin: auto;">
         <a>로그인 후 덧글 기능 이용이 가능합니다</a>
      </div>
   </c:if>

   <table style="width: 750px;" id="subTable">
    <tr>
         <td style="width: 100px;">다음 글</td>
         <td style="width: 370px;"><c:if
               test="${prevBoard.boardTitle != ''}">
               <a href="#" onclick="prevBoard();">${prevBoard.boardTitle}</a>
            </c:if> <c:if test="${prevBoard.boardTitle==null}">
               <a>다음 글이 없습니다</a>
            </c:if></td>

         <td style="width: 100px;">${prevBoard.name}</td>
         <td style="width: 80px;"><fmt:formatDate
               value="${prevBoard.boardCreDate}" pattern="yyyy-MM-dd" /></td>
      </tr>
      <tr>
         <td>이전 글</td>
         <td><c:if test="${nextBoard.boardTitle != ''}">
               <a href="#" onclick="nextBoard();">${nextBoard.boardTitle}</a>
            </c:if> <c:if test="${nextBoard.boardTitle==null}">
               <a>이전 글이 없습니다</a>
            </c:if></td>

         <td>${nextBoard.name}</td>
         <td><fmt:formatDate value="${nextBoard.boardCreDate}"
               pattern="yyyy-MM-dd" /></td>
      </tr>
     
   </table>

</body>
</html>