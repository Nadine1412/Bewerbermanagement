<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Fähigkeiten</title>
<style>
		<%@include file="/view/css/navigation.css"%>
		<%@include file="/view/css/backgroundTemplate.css"%>
</style>
</head>
<body>
<jsp:include page="/view/jsp/navigation/navBar.jsp"></jsp:include>
<p>
<div class="page">
	<div class="form">

		<form action="userSkills" method="post">
		<h2>Fähigkeiten angeben: </h2>
		
			<table>
				<tr> <td class="header-skills"> Programmier-Kenntnisse:</td> </tr>
				<tr> <td class="skills"> <input type="checkbox" name="chkJava" value="Java"> Java </td> </tr>
				<tr> <td class="skills"> <input type="checkbox" name="chkJavaScript" value="JavaScript"> JavaScript </td> </tr>
				<tr> <td class="skills"> <input type="checkbox" name="chkC++" value="C++"> C++ <td> </tr>
				<tr> <td class="skills"> <input type="checkbox" name="chkPython" value="Python"> Python <td> </tr>
				<tr> <td class="skills"> <input type="checkbox" name="chkHtml" value="HTML"> HTML/CSS <td> </tr>
		    </table>  
		    <table>
		      	<tr> <td class="header-skills"> Office-Kenntnisse: </td> </tr>
		       	<tr> <td class="skills"> <input type="checkbox" name="chkWord" value="Word"> Word </td> </tr>
		       	<tr> <td class="skills"> <input type="checkbox" name="chkExcel" value="Excel"> Excel </td> </tr>
				<tr> <td class="skills"> <input type="checkbox" name="chkPowerpoint" value="Powerpoint"> PowerPoint <td> </tr>
				<tr> <td class="skills"> <input type="checkbox" name="chkGit" value="GitHub"> GitHub <td> </tr>
				<tr> <td class="skills"> <input type="checkbox" name="chkJira" value="Jira"> Jira <td> </tr>
			</table>
			<table>	
				<tr> <td class="header-skills"> Sprach-Kenntnisse: </td> </tr>
		       	<tr> <td class="skills"> <input type="checkbox" name="chkGerman" value="Deutsch"> Deutsch </td> </tr>
		       	<tr> <td class="skills"> <input type="checkbox" name="chkEnglish" value="Englisch"> Englisch </td> </tr>
				<tr> <td class="skills"> <input type="checkbox" name="chkSpanish" value="Spanisch"> Spanisch <td> </tr>
				<tr> <td class="skills"> <input type="checkbox" name="chkFrench" value="Franzoesisch"> Französisch <td> </tr>
				<tr> <td class="skills"> <input type="checkbox" name="chkChinese" value="Chinesisch"> Chinesisch <td> </tr>
			</table>	
				<br>
				<button type="submit"> Bestätigen </button>
		</form>
		
		<h3>Ausgewählte Fähigkeiten:</h3> 
		<div class="header-change"> Programmiersprache: </div> <div> ${ programmingLanguage } </div>
		<div class="header-change"> Office: </div> <div> ${ office } </div>
		<div class="header-change">Sprach-Kenntnisse: </div>  <div> ${ language } </div>
		<br>
		<div class="message"> ${msg} </div> 
	</div>
</div>
</body>
</html>