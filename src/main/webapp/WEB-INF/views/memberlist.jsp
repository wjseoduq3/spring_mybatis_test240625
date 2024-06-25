<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원리스트</title>
</head>
<body>
	<h3>회원리스트</h3>
	<hr>
	<table border="1" cellspacing="0" cellpadding="0" width="600">
		<tr>
			<th>아이디</th>
			<th>이름</th>
			<th>이메일</th>
			<th>가입일</th>
		</tr>
	
		<c:forEach items="${memberlist}" var="member" varStatus="number" >
		<tr>
			<th>${number.count}</th>
			<th>${member.mid}</th>
			<th>${member.mname}</th>
			<th>${member.memail}</th>
			<th>${member.mdate}</th>
		</tr>
		</c:forEach>
		<br>
		<hr>
		<hr>
		총회원수 : ${total}명
	</table>
</body>
</html>