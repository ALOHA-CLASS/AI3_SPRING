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
	
	
	<hr>
	
	<h3>POST - checkbox 요청</h3>
	<form action="<%= request.getContextPath() %>/request/check" 
		  method="post">
		  
		<input type="checkbox" name="hobby" id="movie" value="movie" />
		<label for="movie">영화감상</label>
		  
		<input type="checkbox" name="hobby" id="music" value="music" />
		<label for="music">음악감상</label>
		  
		<input type="checkbox" name="hobby" id="book" value="book" />
		<label for="book">독서</label>
		
		<input type="submit" value="등록">
	</form>
	
	<hr>
	
	<h3>POST - person + checkbox 요청</h3>
	<form action="<%= request.getContextPath() %>/request/check/person" 
		  method="post">
		
		<div>
			<label>이름 : </label>
			<input type="text" name="name" />
		</div>  
		<div>
			<label>나이 : </label>
			<input type="number" name="age" />
		</div>  
		  
		<input type="checkbox" name="hobby" id="movie2" value="movie" />
		<label for="movie2">영화감상</label>
		<input type="checkbox" name="hobby" id="music2" value="music" />
		<label for="music2">음악감상</label>
		<input type="checkbox" name="hobby" id="book2" value="book" />
		<label for="book2">독서</label>
		
		<input type="submit" value="등록">
	</form>
	
	<hr>
	
	<h3>POST - person + major + checkbox 요청</h3>
	<form action="<%= request.getContextPath() %>/request/check/personDTO" 
		  method="post">
		
		<div>
			<label>이름 : </label>
			<input type="text" name="person.name" />
		</div>  
		<div>
			<label>나이 : </label>
			<input type="number" name="person.age" />
		</div>  
		<div>
			<label>전공 : </label>
			<input type="text" name="major" />
		</div>  
		  
		<input type="checkbox" name="person.hobby" id="movie3" value="movie" />
		<label for="movie3">영화감상</label>
		<input type="checkbox" name="person.hobby" id="music3" value="music" />
		<label for="music3">음악감상</label>
		<input type="checkbox" name="person.hobby" id="book3" value="book" />
		<label for="book3">독서</label>
		
		<input type="submit" value="등록">
	</form>
	
	<hr>
	<h3>POST - 회원가입</h3>
	<form action="<%= request.getContextPath() %>/request/user" 
		  method="post">
		   
		<label for="id">아이디</label>
		<input type="text" name="id" id="id" placeholder="아이디" />
		<br>
				
		<label for="name">이름</label>
		<input type="text" name="name" id="name" placeholder="이름" />
		<br>
		  
		<input type="checkbox" name="hobby" id="movie4" value="movie" />
		<label for="movie4">영화감상</label>
		  
		<input type="checkbox" name="hobby" id="music4" value="music" />
		<label for="music4">음악감상</label>
		  
		<input type="checkbox" name="hobby" id="book4" value="book" />
		<label for="book4">독서</label>
		<br>
		  
		<label for="birth">생일</label>
		<input type="date" name="birth" id="birth" />
		<br>
		<input type="submit" value="회원가입">
	</form>
	
	<hr>
	<h3>/request/file</h3>
	<form action="${ pageContext.request.contextPath }/request/file" method="POST" 
		  enctype="multipart/form-data">
		<input type="file" name="file" /> <br>
		<input type="submit" value="업로드" />
	</form>
	
	<hr>
	
	<h3>/request/file/multi</h3>
	<form action="${ pageContext.request.contextPath }/request/file/multi" method="POST" 
		  enctype="multipart/form-data">
		<input type="file" name="file" multiple /> <br>
		<input type="submit" value="업로드" />
	</form>
	
	<hr>
	
	<h3>/request/file/board</h3>
	<form action="<%= request.getContextPath() %>/request/file/board" 
		  method="post" enctype="multipart/form-data">
		  
		<input type="text" name="title" placeholder="제목"> <br>
		<input type="text" name="writer" placeholder="작성자"> <br>
		<input type="text" name="content" placeholder="내용"> <br>
		<br>  
		<input type="file" name="fileList" multiple> <br>
		<input type="submit" value="업로드"> <br>
	</form>
	
	
	<div style="height:500px;"></div>
	
</body>
</html>









