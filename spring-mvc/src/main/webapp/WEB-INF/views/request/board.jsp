<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>/request/board</title>
</head>
<body>
	<h1>/request/board</h1>
	
	<hr>
	<h3>POST 요청</h3>
	<form action="<%= request.getContextPath() %>/request/board" method="post">
		<input type="text" name="no" placeholder="번호 입력" />
		<button type="submit">등록</button>
	</form>
</body>
</html>









