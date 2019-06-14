<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Fähigkeiten</title>
<style>
		<%@include file="css/navigation.css"%>
		<%@include file="css/backgroundTemplate.css"%>
</style>
</head>
<body>
<jsp:include page="navBar.jsp"></jsp:include>
<h2>Fähigkeiten angeben</h2>
<p>
        <h3>Programmiersprachen</h3>
   <form action="skills" method="post">
   <table>
       <tr>
       <td><input type="checkbox" name="chkSelect" value="Java"/>Java<td>
       </tr>
       <tr>
       <td><input type="checkbox" name="chkSelect" value="JavaScript"/>JavaScript<td>
       </tr>
       <tr>
       <td><input type="checkbox" name="chkSelect" value="C++"/>C++<td>
       </tr>
       <tr>
       <td><input type="submit" value="Bestätigen"/><td>
       </tr>
       </table>
     </form>
</body>
</html>