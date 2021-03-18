<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="receiveFile" method="post" enctype="multipart/form-data">
		<input type="file" name="file" id="file">
    	
    	<button type="submit">提交请求</button>
	</form>
</body>
</html>