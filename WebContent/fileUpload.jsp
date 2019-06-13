<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>File Upload</title>
<style>
		<%@include file="css/navigation.css"%>
		<%@include file="css/backgroundTemplate.css"%>
</style>
<jsp:include page="navBar.jsp"></jsp:include>
</head>
<body>
<h2>Anhänge hochladen</h2>
<form action="fileUpload" method="post" enctype="multipart/form-data">
<input type="file" name="file" multiple/>
<button type="submit">Hochladen</button>
<p class="message">${msg}</p>
</form>
${msg}
</body>
</html>