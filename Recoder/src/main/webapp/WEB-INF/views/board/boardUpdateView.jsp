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

#inputform input, #inputform textarea{
/*    border-bottom: 1px solid #eee; */
border: 1px solid #198556;
border-radius: 5px;
outline: none;
}


a {
	text-decoration: none;
	color: #198556;

}

#textLength{
   color: grey;
}
</style>
<script type="text/javascript"
   src="http://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js">
</script>
<script type="text/javascript">
	
	$(document).ready(function(){
// 		function delFnc(){
// 			$("#imgDiv").remove();
// 		}
		
		$("#outFormDel").click(function(){
			$("#imgDiv").remove();
			var del = 'delete';
			$("updl").val(del);
		})
		
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
		
	})
	

</script>
</head>




<body>
   <jsp:include page="../common/header.jsp"></jsp:include>


   <form id="inputform" action="../board/updateCtr.do" method="post" enctype="multipart/form-data">
      <input type="hidden" name="boardNo"value="${selectedBoard.boardNo}">
      <input type="hidden" name="updl" id="updl" value="update">
      <table>  
         <tr>
            <td><input style="width: 100%" type="text" name="boardTitle" value="${selectedBoard.boardTitle}"></td>
         </tr>
         
         <tr style="text-align: left;">
            <td>${selectedBoard.name}</td>
         </tr>
         
         <tr>
            <td><textarea style="width: 100%;" rows="20" cols="100" name="boardContent" id="boardContent">${selectedBoard.boardContent}</textarea>
<%--             <input type="text" name="boardContent" value="${selectedBoard.boardContent}"> --%>
            </td>
         </tr>
         <tr>
         	<td>
         		<input type="file" name="file" value='/img/${row.STORED_FILE_NAME}'>
         	</td>
         </tr>
         
         <tr>
            <td style="text-align: right;">
               <input type="submit" value="수정">
               <td><a id="textLength">2000</a></td>
<!--                <input type="button" id="outFormDel" value="전송 버튼"> -->
<!-- 				버튼을 이렇게 만들어 놓으면 click function 이벤트 수행 시 submit되지 않음? -->
            </td>
         </tr>
      </table>
   </form>
   <table>
   <tr>
<!--    	<td> -->
<!-- 		파일 &nbsp; -->
<!--    	</td> -->
   	<td>
   		<a style="color: red;">사진은 한장만 선택 가능합니다</a><br>
         	 <c:choose> 
			<c:when test="${empty fileList}"><!-- 배열은 반드시 반복문과 힘을 합쳐야 제 기능을 함! -->
<!-- 				<a>첨부파일이 없습니다.</a> -->
							<!-- 왼만해선 if도 안들어감 -->
			</c:when>
			<c:otherwise>
				<div id="imgDiv">
					<c:forEach var="row" items="${fileList}">
					<a>${row.ORIGINAL_FILE_NAME}</a><br>
					<img alt="image not found" height="70px" width="100px"  
					src="<c:url value='/img/${row.STORED_FILE_NAME}'/>"/><br>
					</c:forEach>										<!-- 난수화되어 저장된 파일 -->
				</div>
			</c:otherwise>
		</c:choose>
		<button id="outFormDel">삭제</button>
   	</td>
   </tr>
   
	</table>
</body>
</html>