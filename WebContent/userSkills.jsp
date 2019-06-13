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
<div class="navbar">
			<ul>
				<li><a href="overviewUser.jsp">Übersicht</a></li>
				<li>
					<a href="">Profil</a>
					<ul>
						<li><a href="getProfile">Profil anzeigen</a></li>
						<li><a class="active" href="getOldProfile">Profil bearbeiten</a></li>
						<li><a class="active" href="fileUpload.jsp">Anhänge hochladen</a></li>
					</ul>
				</li>
				<li>
					<a href="">Kommunikation</a>
					<ul>
						<li><a href="emailForm.jsp">Email senden</a></li>
						<li><a href="">Chat</a></li>
					</ul>
				</li>	
				
				<li><a href="decision.jsp">Logout</a></li>
			</ul>
		</div>
<h2>Fähigkeiten angeben</h2>
<p>
        <h3>Programmiersprachen</h3>
    <form name="skills" method="get" action="#">
       <select name="sklz">
           <option>Java</option>
           <option>JavaScript</option>   
           <option>Sql</option>
       </select>
     <input type="submit" name="submit" value="Select Skills"/>
     <h3>EDV-Kenntnisse</h3>
    <form name="skills2" method="get" action="#">
       <select name="sklz">
           <option>Word</option>
           <option>Excel</option>   
           <option>Powerpoint</option>
       </select>
     <input type="submit" name="submit" value="Select Skills"/>
 
    </form>

${msg}
</body>
</html>