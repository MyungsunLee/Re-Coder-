<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<style>
/* #slider_ad { */
/* position: absolute; */
/* left: 0; */
/* top: 0; */
/* width: 100px; */
/* }  */

#wrap {
	position: absolute;
	top: 0;
	left: 128px;
	width: 100px;
	height: 100px;
	border: 1px solid black;
	overflow: hidden;
}

#slider {
	position: absolute;
	top: 0;
	left: 0;
	width: 600px;
}

#slider img{
	width: 100px;
	height: 100px;
}

#control {
position: absolute;
top: 100px;
left: 100px;
text-align: center;

}

#control a {
color: #198556;
font-family: 'Noto Sans KR', sans-serif;
}

</style>


<script>
//자동슬라이드 3초마다
//다음/이전버튼 구현

$(document).ready(function() {
 
	var currentPosition = 0;
	
	setInterval(function() {
	    currentPosition++;
	    if (currentPosition > 5) {
	      currentPosition = 0;
	    }
	    $('#slider').animate({ left: -100 * currentPosition });
	  }, 3000);

  $('#buttons a').click(function() {
    var index = $(this).index();
    currentPosition = index;
    $('#slider').animate({ left: -100 * currentPosition });
    return false;
  });

  $('#left').click(function() {
    currentPosition--;
    if (currentPosition < 0) {
      currentPosition = 5;
    }
    $('#slider').animate({ left: -100 * currentPosition });

    return false;
  });

  $('#right').click(function() {
    currentPosition++;
    if (currentPosition > 5) {
      currentPosition = 0;
    }
    $('#slider').animate({ left: -100 * currentPosition });

    return false;
  });
  
});	
</script>


<!-- 	<div id="slider_ad"> -->
		<div id="wrap">
			<span id="slider">
				<img src="/Recoder/resources/images/1.jpg"/><img src="/Recoder/resources/images/2.jpg"/><img src="/Recoder/resources/images/3.jpg"/><img src="/Recoder/resources/images/4.jpg"/><img src="/Recoder/resources/images/5.jpg"/><img src="/Recoder/resources/images/6.jpg"/>
			</span>
		</div>
		<div id="control">
			<a href="#" id="left">이전</a>
			<span id="buttons">
				<a href="#">1</a>
				<a href="#">2</a>
				<a href="#">3</a>
				<a href="#">4</a>
				<a href="#">5</a>
				<a href="#">6</a>
			</span>
			<a href="#" id="right">다음</a>
		</div>
<!-- 	</div> -->



