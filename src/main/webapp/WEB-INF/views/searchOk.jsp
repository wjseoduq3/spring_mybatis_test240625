<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원정보조회결과</title>
</head>
<body>
	<h3>회원정보조회결과</h3>
	<hr>
	<h3>${searchFail}</h3>
	<h3>
		아이디 : ${memberDto.mid}<br><br>
		비밀번호 : ${memberDto.mpw}<br><br>
		이름 : ${memberDto.mname}<br><br>
		이메일 : ${memberDto.memail}<br><br>
		가입일 : ${memberDto.mdate}<br><br>	
	</h3>
</body>
</html>