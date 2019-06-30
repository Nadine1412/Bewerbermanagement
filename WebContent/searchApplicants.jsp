<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Suche</title>
<style>
		<%@include file="css/navigation.css"%>
		<%@include file="css/backgroundTemplate.css"%>
</style>
</head>
<body>
<jsp:include page="navBar.jsp"></jsp:include>
<p>
<div class="pageSearch">
<table>
<tr>
	<td >
		<div class="formSearch">
			<form action="searchApplicant" method="post">
			<h2>Gewünschte Fähigkeiten angeben: </h2>
			
				<table>
					<tr> <td class="header-skills"> Programmier-Kenntnisse:</td> </tr>
					<tr> <td class="skills"> <input type="checkbox" name="chkJava" value="java"> Java </td> </tr>
					<tr> <td class="skills"> <input type="checkbox" name="chkJavaScript" value="javaScript"> JavaScript </td> </tr>
					<tr> <td class="skills"> <input type="checkbox" name="chkC++" value="cPlusPlus"> C++ <td> </tr>
					<tr> <td class="skills"> <input type="checkbox" name="chkPython" value="python"> Python <td> </tr>
					<tr> <td class="skills"> <input type="checkbox" name="chkHtml" value="html"> HTML/CSS <td> </tr>
			    </table>  
			    <table>
			      	<tr> <td class="header-skills"> Office-Kenntnisse: </td> </tr>
			       	<tr> <td class="skills"> <input type="checkbox" name="chkWord" value="word"> Word </td> </tr>
			       	<tr> <td class="skills"> <input type="checkbox" name="chkExcel" value="excel"> Excel </td> </tr>
					<tr> <td class="skills"> <input type="checkbox" name="chkPowerpoint" value="powerpoint"> PowerPoint <td> </tr>
					<tr> <td class="skills"> <input type="checkbox" name="chkGit" value="git"> GitHub <td> </tr>
					<tr> <td class="skills"> <input type="checkbox" name="chkJira" value="jira"> Jira <td> </tr>
				</table>
				<table>	
					<tr> <td class="header-skills"> Sprach-Kenntnisse: </td> </tr>
			       	<tr> <td class="skills"> <input type="checkbox" name="chkGerman" value="german"> Deutsch </td> </tr>
			       	<tr> <td class="skills"> <input type="checkbox" name="chkEnglish" value="english"> Englisch </td> </tr>
					<tr> <td class="skills"> <input type="checkbox" name="chkSpanish" value="spanish"> Spanisch </td> </tr>
					<tr> <td class="skills"> <input type="checkbox" name="chkFrench" value="french"> Französisch </td> </tr>
					<tr> <td class="skills"> <input type="checkbox" name="chkChinese" value="chinese"> Chinesisch </td> </tr>
				</table>	
					<br>
					<button type="submit"> Bestätigen </button>
			</form>
		</div>
	</td>
	<td valign="top">
		<div class="searchTable">
			<table border="1">
				<tr class="header-change"> 
					<td> Bewerber-ID: </td> 
					<td> Name:  </td> 
					<td> Nachname: </td> 
					<td> Geburtstag: </td> 
					<td> Fr. Eintrittsdatum: </td> 
					<td> Fachrichtung: </td> 
					<td> Vertiefung: </td> 
					<td> Gehaltsvorstellung: </td>	
					<td> Anhänge: </td> 
					<td> Kontaktieren: </td> 
				</tr>
				
	 			<c:forEach items="${applicants}" var= "applicant">
			 		<tr> 
			 			<td> ${applicant.a_id} </td> 
			 			<td> ${applicant.userName} </td> 
			 			<td> ${applicant.userSurname} </td> 
			 			<td> ${applicant.birthday} </td>  
			 			<td> ${applicant.entryDate} </td> 
			 			<td> ${applicant.subject} </td> 
			 			<td> ${applicant.specialization} </td> 
			 			<td> ${applicant.salary} </td> 
			 			<td> <a href="getSearchedFiles?paramAid=${applicant.a_id}" target="_blank"> Anhänge anzeigen </a></td> 
			 			<td> 
			 				<form action="getEmail" method="post" class="register-form" target="_blank">
			 					<button type="submit" name="mailReceiver" value="${applicant.email}"> E-Mail </button>
			 				</form>
			 			</td>
			 		</tr>
	 			</c:forEach>
	 		</table>
	 		<br>
	 		<div class="message">${msg} </div>
		</div>
		
	</td>
</tr>
</table>

		
</div>
</body>
</html>