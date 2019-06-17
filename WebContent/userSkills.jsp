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
<p>
<div class="page">
	<div class="form">
		<form action="userSkills" method="post">
		<h2>Fähigkeiten angeben: </h2>
			<table>
				<tr> <td class="header-skills"> Programmier-Kenntnisse:</td> </tr>
				<tr> <td class="skills"> <input type="checkbox" name="chkProgramming" value="Java"> Java </td> </tr>
				<tr> <td class="skills"> <input type="checkbox" name="chkProgramming" value="JavaScript"> JavaScript </td> </tr>
				<tr> <td class="skills"> <input type="checkbox" name="chkProgramming" value="C++"> C++ <td> </tr>
				<tr> <td class="skills"> <input type="checkbox" name="chkProgramming" value="Python"> Python <td> </tr>
				<tr> <td class="skills"> <input type="checkbox" name="chkProgramming" value="HTML/CSS"> HTML/CSS <td> </tr>
		    </table>  
		    <table>
		      	<tr> <td class="header-skills"> Office-Kenntnisse: </td> </tr>
		       	<tr> <td class="skills"> <input type="checkbox" name="chkOffice" value="Word"> Word </td> </tr>
		       	<tr> <td class="skills"> <input type="checkbox" name="chkOffice" value="Excel"> Excel </td> </tr>
				<tr> <td class="skills"> <input type="checkbox" name="chkOffice" value="Powerpoint"> PowerPoint <td> </tr>
				<tr> <td class="skills"> <input type="checkbox" name="chkOffice" value="GitHub"> GitHub <td> </tr>
				<tr> <td class="skills"> <input type="checkbox" name="chkOffice" value="Jira"> Jira <td> </tr>
			</table>
			<table>	
				<tr> <td class="header-skills"> Sprach-Kenntnisse: </td> </tr>
		       	<tr> <td class="skills"> <input type="checkbox" name="chkLanguage" value="Deutsch"> Deutsch </td> </tr>
		       	<tr> <td class="skills"> <input type="checkbox" name="chkLanguage" value="Englisch"> Englisch </td> </tr>
				<tr> <td class="skills"> <input type="checkbox" name="chkLanguage" value="Spanisch"> Spanisch <td> </tr>
				<tr> <td class="skills"> <input type="checkbox" name="chkLanguage" value="Franzoesisch"> Französisch <td> </tr>
				<tr> <td class="skills"> <input type="checkbox" name="chkLanguage" value="Chinesisch"> Chinesisch <td> </tr>
			</table>	
				<br>
				<button type="submit"> Bestätigen </button>
		</form>
		
		<h3>Ausgewählte Fähigkeiten:</h3>
		<div>Programmiersprache: ${ programming }</div>
		<div>Office: ${ office }</div>
		<div>Sprach-Kenntnisse: ${ language }</div>
		
		${msg}
	</div>
</div>
</body>
</html>