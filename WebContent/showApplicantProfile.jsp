<%@ page isELIgnored="false"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<style>
			<%@include file="css/navigation.css"%>
			<%@include file="css/backgroundTemplate.css"%>
		</style>
		<title>Profilübersicht</title>
	</head>
		<body>
			<jsp:include page="navBar.jsp"></jsp:include>
			
			<div class="page">
				<div class="form">
					<table> 
						<tr> 
							<td class="header-skills">Ihr Bewerber-Profil:</td> 
						</tr>
						<tr> 
							<td class="header">User ID:</td>
							<td>${applicant.userId}</td> 
						</tr>
						<tr> 
							<td class="header">Vorname:</td>
							<td>${applicant.userName}</td> 
						</tr> 
						<tr> 
							<td class="header">Nachname:</td>
							<td>${applicant.userSurname}</td> 
						</tr>
						<tr> 
							<td class="header">Geburtstag:</td>
							<td>${applicant.birthday}</td> 
						</tr>
						<tr> 
							<td class="header">E-Mail:</td>
							<td>${applicant.email}</td> 
						</tr>
						<tr> 
							<td class="header">Fr.Eintrittsdatum:</td> 	
							<td>${applicant.entryDate}</td> 
						</tr>
						<tr> 
							<td class="header">Fachrichtung: </td>
							<td>${applicant.subject}</td> 
						</tr>
						<tr> 
							<td class="header">Vertiefung: </td>
							<td>${applicant.specialization}</td> 
						</tr>
						<tr> 
							<td class="header">Gehaltsvorstellung:</td>
							<td>${applicant.salary}</td> 
						</tr>
					</table>
					<br><br>
					<c:if test="${programmingLanguage  != null && office != null && language != null}" >
						<table>
							<tr> 
								<td class="header-skills">Ihre Fähigkeiten:</td> 
							</tr>
							<tr> 
								<td class="header">Programmier-Kenntnisse:</td>	
								<td>${programmingLanguage}</td> 
							</tr>
							<tr> 
								<td class="header">Office-Kenntnisse:</td>
								<td>${office}</td> 
							</tr>
							<tr> 
								<td class="header">Sprach-Kenntnisse:</td>
								<td>${language}</td> 
							</tr>
						</table>
					</c:if>
				</div>
			</div>		
	</body>
</html>