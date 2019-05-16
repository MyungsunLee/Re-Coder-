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
<script src="/Recoder/resources/js/jquery-3.3.1.js"></script>
<script type="text/javascript">
	
	$(document).ready(function(){
// 		function delFnc(){
// 			$("#imgDiv").remove();
// 		}
		
// 		var updl = $("#updl").html();
		$("#outFormDel").click(function(){
			$("#imgDiv").remove();
			var del = 'delete';
			$("#updl").val(del);
			
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
	      })
	      
	      
		
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
            <td><textarea style="width: 100%; resize: none" rows="20" cols="100" name="boardContent" id="boardContent" >${selectedBoard.boardContent}</textarea>
            </td>
         </tr>
         <tr>
         	<td>
         		<input type="file" name="file" id="file">
         	</td>
         </tr>
         
         <tr>
            <td style="text-align: right;">
               <input type="submit" value="수정">
             </td>
               <td><a id="textLength">2000</a></td>
            
         </tr>
      </table>
   </form>
   <table>
   <tr>
   	<td>
   		<a style="color: red;">사진은 한장만 선택 가능합니다</a><br>
         	 <c:choose> 
			<c:when test="${empty fileList}">
			</c:when>
			<c:otherwise>
				<div id="imgDiv">
					<c:forEach var="row" items="${fileList}">
					<a>${row.ORIGINAL_FILE_NAME}</a><br>
					<img alt="image not found" height="70px" width="100px"  
					src="<c:url value='/img/${row.STORED_FILE_NAME}'/>"/><br>
					</c:forEach>
				</div>
			</c:otherwise>
		</c:choose>
		<button id="outFormDel">삭제</button>
   	</td>
   </tr>
   
	</table>
</body>
</html>