<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
table {
   margin: auto;
   text-align: center;
}

#textLength{
   color: grey;
}
</style>
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
<script type="text/javascript">
   $(document).ready(function() {
      $('textarea').keyup(function() {
         var inputLength = $(this).val().length;
         var remain = 2000 - inputLength;
         $('#textLength').html(remain);
         if (remain >= 0) {
            $('#textLength').css('color', 'grey');
         } else {
            $('#textLength').css('color', 'red');
         }
      });
   });
   
//    $('textarea').replace("
//          ", "<br>");
   
   
</script>
<body>
   <jsp:include page="../common/header.jsp"></jsp:include>

   <h2 style="text-align: center;">글쓰기</h2>
   <form action="../board/addOneCtr.do" method="post">
      <table>
         <tr>
            <td><input type="hidden" name="memberNo"
               value="${login_memberVo.memberNo}"></td>
         </tr>
         <tr>
            <td><input style="width: 100%" type="text" name="boardTitle"
               placeholder="제목을 입력해 주세요"></td>
         </tr>

         <tr style="text-align: left;">
            <td><a>${login_memberVo.memberName}</a> </td>
         </tr>

         <tr>
            <td><textarea name="boardContent" rows="20" cols="100"
                  placeholder="내용을 입력해 주세요" ></textarea> <!--                <input type="text" name="boardContent"> -->
               <!--                <textarea name="boardContent" rows="30" cols="50" --> <!--                ></textarea> -->
            </td>
         </tr>
         <tr>
            <td><input type="submit" value="글쓰기"></td>
            <td><a id="textLength">2000</a>
               <button   onclick= "location='../board/listOne.do?boardNo=${selectedBoard.boardNo}'">
                     뒤로가기</button>
            </td>
         </tr>
      </table>
   </form>
</body>
</html>