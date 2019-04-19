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
</head>
<body>
<jsp:include page="../common/header.jsp"></jsp:include>
   
   <table>
      <tr>
         <td>${selectedBoard.boardTitle}</td>
         <td>${selectedBoard.name} </td>
         <td>
            <fmt:formatDate value="${selectedBoard.boardCreDate}"
               pattern="yyyy-m-d   H:mm:ss"/>
            
         </td>
      </tr>
      <tr>
         <td>${selectedBoard.boardContent}</td>
      </tr>
   </table>
   
   
   
</body>
</html>