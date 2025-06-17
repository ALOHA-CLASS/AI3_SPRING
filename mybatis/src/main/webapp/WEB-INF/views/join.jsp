<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
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
	<title>회원가입</title>
	<style>
		.error { color: red; }
	</style>
</head>
<body>
	<h2>회원가입</h2>
	<!-- modelAttribute="User" : 모델 객체 바인딩 -->
	<form:form modelAttribute="user" method="post" action="${ root }/join">
		<%--  <form:input>  : <input type="text"> --%> 
	    아이디: <form:input path="username" />
<%-- 		<input type="text" name="username" value="${ user.username }" /> --%>
	    <form:errors path="username" cssClass="error" /><br/>
	    
		<%-- <form:password>  : <input type="password"> --%> 
	    비밀번호: <form:password path="password" />
	    <form:errors path="password" cssClass="error" /><br/>
	
	    이름: <form:input path="name" />
	    <form:errors path="name" cssClass="error" /><br/>
	
	    이메일: <form:input path="email" />
	    <form:errors path="email" cssClass="error" /><br/>
	
	    <button type="submit">회원가입</button>
	</form:form>
</body>
</html>