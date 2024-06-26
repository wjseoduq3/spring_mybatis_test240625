<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원탈퇴</title>
</head>
<body>
	<h3>회원탈퇴</h3>
	<hr>
	<h3>${delaelFail}</h3>
	<form action="deleteOk">
		 아이디 : <input type="text" name="mid">
		 <input type="submit" value="회원탈퇴">
	</form>

</body>
</html>