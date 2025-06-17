<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String root = request.getContextPath();
	pageContext.setAttribute("root", root);
%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>메인 화면</title>
</head>
<body>
	<h1>Spring x MyBatis</h1>
	<h3>게시판 프로젝트</h3>
	<a href="${ root }/board/list">게시판</a>  <br>
	<a href="${ root }/join">회원가입</a>
	
</body>
</html>






