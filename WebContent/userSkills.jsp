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
   <form action="skills" method="post" class="skills-form">
       	<select name="sklz">
           <option value="Java">Java</option>
           <option value="JavaScript">JavaScript</option>   
       </select>
     <button type="submit" name="submit" value="">Auswählen</button>
     <p class="message">${msg}</p>
     </form>
${msg}
</body>
</html>