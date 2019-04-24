<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<title>인덱스</title>
<meta charset="utf-8">
<link rel="stylesheet" type="text/css"
	href="/Recoder/resources/css/styles.css">
<style>
#wrap {
	position: relative;
	width: 500px;
	height: 500px;
	margin: auto;
	overflow: hidden;
}

#slider {
	position: absolute;
	top: 0;
	left: 0;
	width: 3000px;
}

#slider ul {
	margin: 0;
	padding: 0;
	height: 500px;
	list-style: none;
}

#slider ul li {
	display: block;
	float: left;
	margin: 0;
	padding: 0;
}

#slider ul li a img {
	width: 500px;
	height: 500px;
}

/* #control { */
/* 	text-align: center; */
/* } */
</style>
<link href="https://fonts.googleapis.com/css?family=Noto+Sans+KR"
	rel="stylesheet">
<link href="https://fonts.googleapis.com/css?family=Do+Hyeon"
	rel="stylesheet">
<script src="https://code.jquery.com/jquery-3.4.0.min.js"></script>
<script>
$(document).ready(function () {


// $('#buttons a').click(function () {
// 	var index = $(this).index();
// 	$('#slider').animate({ left: -600 * index });
// 	return false;
// });

// function moveLeft() {
//      $('#slider').animate({left: + 600}, function () {
//        $('#slider ul li:last-child').prependTo('#slider ul');
//        $('#slider').css('left', '');
//        return false;
//      });
// 	return false;
//    };

function moveRight() {
     $('#slider').animate({left: - 600}, function () {
       $('#slider ul li:first-child').appendTo('#slider ul');
       $('#slider').css('left', '');
       return false;
     });
	return false;
   };

// $('#prev').click(function () {
//      moveLeft();
// 	return false;
//    });

// $('#next').click(function () {
//      moveRight();
// 	return false;
//    });

setInterval(function () {
     moveRight();
     return false;
   }, 3000);


});




</script>
</head>
<body>

<jsp:include page="../common/header.jsp"/>

<!-- // 	<div id="contents"> -->
<!-- // 		<img src="http://img.phinf.pholar.net/20170510_58/1494396627388NNM5o_JPEG/p"> -->
<!-- // 	</div> -->

<div id="wrap">
<div id="slider">
<ul>
<li><a href="#"><img src="/Recoder/resources/images/1.jpg"></a></li>
<li><a href="#"><img src="/Recoder/resources/images/2.jpg"></a></li>
<li><a href="#"><img src="/Recoder/resources/images/3.jpg"></a></li>
<li><a href="#"><img src="/Recoder/resources/images/4.jpg"></a></li>
<li><a href="#"><img src="/Recoder/resources/images/5.jpg"></a></li>
<li><a href="#"><img src="/Recoder/resources/images/6.jpg"></a></li>
</ul>
</div>
</div>

<!-- //       <div id="control"> -->
<!-- //         <a href="#" id="prev">이전</a> -->
<!-- //         <div id="buttons"> -->
<!-- //           <a href="#">1</a> -->
<!-- //           <a href="#">2</a> -->
<!-- //           <a href="#">3</a> -->
<!-- //         </div> -->
<!-- //         <a href="#" id="next">다음</a> -->
<!-- //       </div> -->

<jsp:include page="../common/tail.jsp"/>

</body>
</html>
		