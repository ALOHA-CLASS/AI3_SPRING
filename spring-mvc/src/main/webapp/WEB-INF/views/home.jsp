<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<%
	String root = request.getContextPath();
	pageContext.setAttribute("root", root);
%>
<html>
<head>
	<title>Home</title>
</head>
<body>
	<h1>Spring MVC</h1>
	<ul>
		<li>
			<a href="${ root }/request/board">/request/board</a>
		</li>
		<li>
			<a href="${ root }/model/person">/model/person</a>
		</li>
	</ul>

</body>
</html>






