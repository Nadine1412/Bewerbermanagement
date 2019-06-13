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
<form action="uploadFile" method="POST" enctype="multipart/form-data">
    <table>
        <tr>
            <td><form:label path="file">Select a file to upload</form:label></td>
            <td><input type="file" name="file" /></td>
        </tr>
        <tr>
            <td><input type="submit" value="Submit" /></td>
        </tr>
    </table>
</form>

</body>
</html>