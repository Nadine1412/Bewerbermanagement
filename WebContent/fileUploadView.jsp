<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Uploaded File</title>
<style>
		<%@include file="css/navigation.css"%>
		<%@include file="css/backgroundTemplate.css"%>
</style>
<jsp:include page="navBar.jsp"></jsp:include>
</head>

<body>
<h2>Submitted File</h2>
<table>
    <tr>
        <td>Original File Name:</td>
        <td>${file.originalFilename}</td>
    </tr>
    <tr>
        <td>Type:</td>
        <td>${file.contentType}</td>
    </tr>
</table>
</body>
</html>