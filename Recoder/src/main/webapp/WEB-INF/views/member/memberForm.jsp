<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>


	<table>
		<tr>
			<td>이름</td>
			<td><input type="text" name='name'></td>
		</tr>
		<tr>
			<td>이메일</td>
			<td><input type="text" name="email"></td>
		</tr>
		<tr>
			<td>비밀번호</td>
			<td><input type="password" name='password'></td>
		</tr>
		<tr>
			<td>비밀번호 확인</td>
			<td><input type="password" name='password'></td>
		</tr>
		
		<tr>
			<td><input type="submit" value="추가"></td>
			<td><input type="reset" value="취소"></td>
		</tr>
	</table>
	
<!-- 	<form action="./addCtr.do" method="post" 
		enctype="multipart/form-data">
		이름: <input type="text" name='name'><br>
		이메일: <input type="text" name="email"><br>
		암호: <input type="password" name='password'><br>
		파일: <input type="file" name="file"><br><br>
		<input type="submit" value="추가">
		<input type="reset" value="취소">
	</form> -->
	
	
</body>
</html>