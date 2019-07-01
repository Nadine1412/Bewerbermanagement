<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>File Upload</title>
<style>
		<%@include file="/view/css/navigation.css"%>
		<%@include file="/view/css/backgroundTemplate.css"%>
</style>
</head>
<body>
<jsp:include page="/view/jsp/navigation/navBar.jsp"></jsp:include>
	<div class="page">
		<div class="form">
			<form action="uploadFile" method="POST" enctype="multipart/form-data">
				<input type="text" name="name" placeholder="Name"/>
				<textarea id="description" cols="30" rows="10" name="description"></textarea>
				<br><br>
				<input type="file" name="file" />
				<button type="submit">upload</button>
			</form>
			<p class="message" color="RED">${msg}</p>
		</div>
	</div>
</body>
</html>