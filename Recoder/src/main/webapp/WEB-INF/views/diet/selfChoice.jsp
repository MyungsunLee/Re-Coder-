<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" type="text/css"
	href="/Recoder/resources/css/styles.css">
<link href="https://fonts.googleapis.com/css?family=Noto+Sans+KR"
	rel="stylesheet">
<link href="https://fonts.googleapis.com/css?family=Do+Hyeon"
	rel="stylesheet">
<script type="text/javascript"
	src="http://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js">
	
</script>
<style type="text/css">
a {
	text-decoration: none;
	color: #198556;
}

th {
	background-color: #59d393;
	color: black;
}

table {
	margin: auto;
	padding: 15px;
}

#div {
	padding-top: 30px;
	margin: auto;
	text-align: center;
	background-color: #EEEFF1;
}

#protein tr td, #carbohydrate tr td, #fat tr td {
/* 	border: 3px solid grey; */
}

#protein, #carbohydrate, #fat{
	border: 3px solid green;
	border-collapse: collapse;
	width: 150px;
}
</style>
<script type="text/javascript">
	var pkcalSum = 0; //각각 선택한 식품군 합친 총 칼로리
	var pkcalNeed = 0; //and 사용자가 하루동안 섭취해야 할 총 칼로리

	//의 반복 탄/단/지
	var ckcalSum = 0;
	var ckcalNeed = 0;

	var fkcalSum = 0;
	var fkcalNeed = 0;

	var pName = "<tr><th>단백질</th></tr>";
	var cName = "<tr><th>탄수화물</th></tr>";
	var fName = "<tr><th>지방</th></tr>";

	$(document).ready(
			function() {

				var myKcal = $('.myKcal').html();
				var addKcal = myKcal + " kcal";
				$('.myKcal').html(addKcal);

				var pkcalSumString = pkcalSum + " / "
						+ Math.round(myKcal * 0.3);
				var ckcalSumString = ckcalSum + " / "
						+ Math.round(myKcal * 0.5);
				var fkcalSumString = fkcalSum + " / "
						+ Math.round(myKcal * 0.2);

				$('#pSum').html(pkcalSumString);
				$('#cSum').html(ckcalSumString);
				$('#fSum').html(fkcalSumString);

				//단백질부분
				$('.pkcal').click(
						function() {

							var kcal = $(this).html();
							if (Math.round(myKcal * 0.3) > pkcalSum) {

								pkcalSum = parseInt(pkcalSum) + parseInt(kcal);

								if (Math.round(myKcal * 0.3) == pkcalSum) {
									$('#pSum').css('color', 'red');
									pkcalSumString = pkcalSum + " / "
									+ Math.round(myKcal * 0.3);

							$('#pSum').html(pkcalSumString);
									alert('더 이상 추가할 수 없습니다.')

									
									return false;
								}
								
								if (Math.round(myKcal * 0.3) < pkcalSum) {
									$('#pSum').css('color', 'red');
									alert('더 이상 추가할 수 없습니다.')

									pkcalSum = parseInt(pkcalSum)
											- parseInt(kcal);
									return false;
								}
								
								$('#pSum').css('color', 'green');
								pkcalSumString = pkcalSum + " / "
										+ Math.round(myKcal * 0.3);

								$('#pSum').html(pkcalSumString);

								var name = "<tr><td>"
										+ $(this).closest('tr').children('td')
												.html() + "</td></tr>";

								pName = pName + name;

								$('#protein').html(pName);
							}
							return false;
						})

				//탄수화물부분
				$('.ckcal').click(
						function() {

							var kcal = $(this).html();

							if (Math.round(myKcal * 0.5) > ckcalSum) {
								ckcalSum = parseInt(ckcalSum) + parseInt(kcal);

								if (Math.round(myKcal * 0.5) == ckcalSum) {
									$('#cSum').css('color', 'red');

									ckcalSumString = ckcalSum + " / "
											+ Math.round(myKcal * 0.5);

									$('#cSum').html(ckcalSumString);
									alert('더 이상 추가할 수 없습니다.');

									return false;
								}

								if (Math.round(myKcal * 0.5) < ckcalSum) {
									$('#cSum').css('color', 'red');
									alert('더 이상 추가할 수 없습니다.');

									ckcalSum = parseInt(ckcalSum)
											- parseInt(kcal);

									return false;
								}

								$('#cSum').css('color', 'green');

								ckcalSumString = ckcalSum + " / "
										+ Math.round(myKcal * 0.5);

								$('#cSum').html(ckcalSumString);

								var name = "<tr><td>"
										+ $(this).closest('tr').children('td')
												.html() + "</td></tr>";

								cName = cName + name;

								$('#carbohydrate').html(cName);

							}

							return false;
						})
				//지방부분
				$('.fkcal').click(
						function() {

							var kcal = $(this).html();

							if (Math.round(myKcal * 0.2) > fkcalSum) {
								fkcalSum = parseInt(fkcalSum) + parseInt(kcal);

								if (Math.round(myKcal * 0.2) == fkcalSum) {
									$('#fSum').css('color', 'red');
									
									fkcalSumString = fkcalSum + " / "
									+ Math.round(myKcal * 0.2);

							$('#fSum').html(fkcalSumString);
							
									alert('더 이상 추가할 수 없습니다.');

									return false;
								}
								
								if (Math.round(myKcal * 0.2) < fkcalSum) {
									$('#fSum').css('color', 'red');
									alert('더 이상 추가할 수 없습니다.');

									fkcalSum = parseInt(fkcalSum)
											- parseInt(kcal);

									return false;
								}

								$('#fSum').css('color', 'green');
								fkcalSumString = fkcalSum + " / "
										+ Math.round(myKcal * 0.2);

								$('#fSum').html(fkcalSumString);

								var name = "<tr><td>"
										+ $(this).closest('tr').children('td')
												.html() + "</td></tr>";

								fName = fName + name;

								$('#fat').html(fName);

							}

							return false;

						})

			})
</script>

<title>식단 고르기</title>
</head>
<body>

	<jsp:include page="../common/header.jsp" />
	<div id="div">
		<table>
			<tr>
				<td>
					<table>
						<tr>
							<th>단백질</th>
						</tr>
						<c:forEach var="pList" items="${pList}">
							<tr>

								<td>${pList.dietName}</td>
								<td style="text-align: right;"><a href="#" class="pkcal">${pList.dietCal}</a>
									kcal</td>


							</tr>
						</c:forEach>
					</table>
				</td>
				<td>
					<table>
						<tr>
							<th>탄수화물</th>
						</tr>
						<c:forEach var="cList" items="${cList}">
							<tr>
								<td>${cList.dietName}</td>
								<td style="text-align: right;"><a href="#" class="ckcal">${cList.dietCal}</a>
									kcal</td>
							</tr>
						</c:forEach>
					</table>
				</td>
				<td>
					<table>
						<tr>
							<th>지방</th>
						</tr>
						<c:forEach var="fList" items="${fList}">
							<tr>
								<td>${fList.dietName}</td>
								<td style="text-align: right;"><a href="#" class="fkcal">${fList.dietCal}</a>
									kcal</td>

							</tr>
						</c:forEach>
					</table>
				</td>
			</tr>
		</table>
		<div>
			<a>단백질 칼로리 : </a> <a id="pSum">0</a> kcal<br>
		</div>
		<div>
			<a>탄수화물 칼로리 : </a> <a id="cSum">0</a> kcal<br>
		</div>
		<div>
			<a>지방 칼로리 : </a> <a id="fSum">0</a> kcal<br>
		</div>

		<div>
			<c:set var="_memberInfoActivity"
				value="${_memberInfoVo.memberInfoActivity}" />
			<!-- 기초대사량 -->
			<c:set var="_memberInfoCal" value="${_memberInfoVo.memberInfoCal}" />

			<table>
				<tr>
					<th>식단 처방 칼로리</th>
					<c:choose>
						<c:when test="${_memberInfoActivity == 1}">
							<td class="myKcal"><fmt:formatNumber
									value="${_memberInfoCal*1.2-500}" pattern="0" /></td>
						</c:when>
						<c:when test="${_memberInfoActivity == 2}">
							<td class="myKcal"><fmt:formatNumber
									value="${_memberInfoCal*1.375-500}" pattern="0" /></td>
						</c:when>
						<c:when test="${_memberInfoActivity == 3}">
							<td class="myKcal"><fmt:formatNumber
									value="${_memberInfoCal*1.55-500}" pattern="0" /></td>
						</c:when>
						<c:when test="${_memberInfoActivity == 4}">
							<td class="myKcal"><fmt:formatNumber
									value="${_memberInfoCal*1.725-500}" pattern="0" /></td>
						</c:when>
						<c:when test="${_memberInfoActivity == 5}">
							<td class="myKcal"><fmt:formatNumber
									value="${_memberInfoCal*1.9-500}" pattern="0" /></td>
						</c:when>
					</c:choose>
				</tr>
			</table>
			<c:set var="dietTypeC" value="C" />
			<c:set var="dietTypeP" value="P" />



		</div>


		<table>
			<tr>
				<td>
					<table id="protein">
						<tr>
							<th>단백질</th>
						</tr>
					</table>
				</td>
				<td>
					<table id="carbohydrate">
						<tr>
							<th>탄수화물</th>
						</tr>
					</table>
				</td>
				<td>
					<table id="fat">
						<tr>
							<th>지방</th>
						</tr>
					</table>
				</td>
			</tr>
		</table>

		<a href="../diet/selfChoice.do" id="setZero" class="submit-btn">초기화</a>

	</div>

</body>
</html>