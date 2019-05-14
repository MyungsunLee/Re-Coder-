<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<style type="text/css">
nav>ul {
	list-style-type: none;
	padding: 0px;
	overflow: hidden;
	display: table;
	margin-left: auto;
	margin-right: auto;
}

nav>ul>li {
	float: left;
}

nav>ul>li>a {
	text-align: center;
	padding: 16px;
	text-decoration: none;
}

nav>ul>li>a:hover {
	
}

.active {
	
}
</style>

<script type="text/javascript"
	src="/Recoder/resources/js/jquery-3.3.1.js"></script>

<script type="text/javascript">
   $(document).ready(function(){
      
      var curPageDoc = $('#curPage');
      var id = '#pageButton' + curPageDoc.val();
      
      $(id).addClass('active');
   });
   
   function goPage(pageNumber){
      var curPage = $("#curPage");

      curPage.val(pageNumber);

      $("#pagingForm").submit();
      
      
   }
   
   window.onload = function(){

      var curPageDoc = $('#curPage');
      var id = '#pageButton' + curPageDoc.val();
      
      $(id).addClass('active');
   }
</script>

<nav>
	<ul>
		<!--ㄷ 한자 적용  -->
		<li><c:if test="${paging.memberPaging.prevPage == paging.memberPaging.curPage}">
		<a href="#" >
				<span>≪</span>
		</a>
		
		</c:if>
		<c:if test="${paging.memberPaging.prevPage != paging.memberPaging.curPage}">
		<a href="#" onclick="goPage(${paging.memberPaging.prevPage});">
				<span>≪</span>
		</a>
		</c:if>
		
		</li>

		<c:forEach var="num" begin="${paging.memberPaging.blockBegin}"
			end="${paging.memberPaging.blockEnd}">

			<li id="pageButton${num}"><a href="#" onclick="goPage(${num});">
					<c:out value="${num}" />
			</a></li>
			

		</c:forEach>

		<li><c:if
				test="${paging.memberPaging.nextPage == paging.memberPaging.curPage}">
				<a href="#"> <span>≫</span></a>
			</c:if> <c:if test="${paging.memberPaging.nextPage != paging.memberPaging.curPage}">
				<a href="#" onclick="goPage(${paging.memberPaging.nextPage});"> <span>≫</span></a>
			</c:if>
		</li>
	</ul>
</nav>