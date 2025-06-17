<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%
	String root = request.getContextPath();
	pageContext.setAttribute("root", root);
%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>게시글 목록</title>
</head>
<body>
	<h1>게시글 목록</h1>
	
	<a href="${ root }/board/insert">글쓰기</a>
	
	<table border="1">
		<tr>
			<th>번호</th>
			<th>제목</th>
			<th>작성자</th>
			<th>등록일자</th>
			<th>수정일자</th>
		</tr>
		<c:forEach var="board" items="${ list }">
			<tr>
				<td align="center">${ board.no }</td>
				<td width="300">
					<a href="${ root }/board/read?no=${ board.no}">
						${ board.title }
					</a>
				</td>
				<td align="center">${ board.writer }</td>
				<td align="center">
					<fmt:formatDate value="${ board.createdAt }"
						 			pattern="yyyy-MM-dd HH:mm:ss"/>
				</td>
				<td align="center">
					<fmt:formatDate value="${ board.updatedAt }"
						 			pattern="yyyy-MM-dd HH:mm:ss"/>
				</td>
			</tr>
		</c:forEach>
		<c:if test="${ empty list }">
			<tr>
				<td colspan="5" align="center">조회된 데이터가 없습니다.</td>
			</tr>
		</c:if>
	</table>
</body>
</html>








