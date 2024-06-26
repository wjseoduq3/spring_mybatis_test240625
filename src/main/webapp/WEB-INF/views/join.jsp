<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원가입</title>
</head>
<body>
	<h3>회원가입</h3>
	<hr>
	<table border="1" cellspacing="0" cellpadding="0" size="600">
		<tr>
			<td colspan="2">
				<form action="checkid">
					아이디체크 : <input type="text" name="checkId" size="60">
					<input type="submit" value="아이디중복확인">					
				</form>
			</td>
		</tr>
	<form action="joinOk">
		<tr>
			<td>아이디</td>
			<td>
				<input type="text" name="mid" size="70">
		</tr>
		<tr>
			<td>비밀번호</td>
			<td>
				<input type="text" name="mpw" size="70">
			</td>	
		</tr>
		<tr>
			<td>이름</td>
			<td>
				<input type="text" name="mname" size="70">
			</td>	
		</tr>
		<tr>
			<td>이메일</td>
			<td>
				<input type="text" name="memail" size="70">
			</td>	
		</tr>
		<tr>
			<td colspan="2">
				<input type="submit" value="회원가입">
			</td>
		</tr>
	</form>
	</table>
</body>
</html>