<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<title>회원가입</title>
<meta charset="utf-8">
<script src="/Recoder/resources/js/jquery-3.3.1.js"></script>
<script>
	// var idck = 0;
	$(function() {
		



		$('#membercheck-form').submit(function() {
			var email = $('#email').val();
			if (email == '') {
				alert('이메일을 입력해주세요.');
				$('#email').focus();
				return false;
			}
			$('#emailcheck').val(email);
			
		});
		

		// $('#membercheck').attr('href', '../member/membercheck.do?memberEmail='email)

		$('#reg-form').submit(function() {
			var email = $('#email').val();
			var name = $('#name').val();
			var password = $('#password').val();
			var passwordConfirm = $('#passwordConfirm').val();

			if (email == '') {
				alert('이메일을 입력해주세요.');
				$('#email').focus();
				return false;
			}

			if (name == '') {
				alert('이름을 입력해주세요.');
				$('#name').focus();
				return false;
			}

			if (password == '') {
				alert('비밀번호를 입력해주세요.');
				$('#password').focus();
				return false;
			}

			if (passwordConfirm == '') {
				alert('비밀번호 확인을 입력해주세요.');
				$('#passwordConfirm').focus();
				return false;
			}

			if (password != passwordConfirm) {
				alert('비밀번호와 비밀번호 확인이 일치하지 않습니다.');
				$('#passwordConfirm').focus();
				return false;
			}
		});


	});
</script>
</head>
<body>
	<jsp:include page="../common/header.jsp"></jsp:include>



	<div class="regi-form">
		<form id="reg-form" name="reg-form" action="../member/add.do"
			method="post">

			<input type="text" id="email" name="memberEmail" class="text-field"
				placeholder="이메일" value="${memberEmail}">
			
	
			<br> <input type="text" id="name" name="memberName"
				class="text-field" placeholder="이름"> <br> <input
				type="password" id="password" name="memberPassword"
				class="text-field" placeholder="비밀번호"> <br> <input
				type="password" id="passwordConfirm" name="memberPasswordConfirm"
				class="text-field" placeholder="비밀번호 확인"> <br> <a
				href="#"> <input type="submit" value="회원가입" class="submit-btn">
			</a>
		</form>
				<form id="membercheck-form"
					action="../member/membercheck.do" method="post">
					<input id="emailcheck" name="memberEmail" type="hidden" value="">
					<input type="submit" value="중복체크">
				</form>
<!-- 		<button type="button" id="emailCheck">이메일 확인</button> -->

	</div>
	
</body>
</html>