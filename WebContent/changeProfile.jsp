<%@ page isELIgnored="false"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

		<style>
			<%@include file="css/navigation.css"%>
			<%@include file="css/backgroundTemplate.css"%>
		</style>
		<title>Profil ändern</title>
	</head>
	<body>
		<div class="navbar">
			<ul>
				<li><a href="overviewApplicant.jsp">Übersicht</a></li>
				<li>
					<a href="">Profil</a>
					<ul>
						<li><a href="getProfile">Profil anzeigen</a></li>
						<li><a class="active" href="getOldProfile">Profil bearbeiten</a></li>
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
		
		<div class="page">
			<div class="form">
				<form action="updateProfile" method="post">
					<table> 
				 
				<tr> <td class="header"> User ID: </td> 
				<td> <input type="text" value="${applicant.userId}" name="userId" readonly /> </td>
				</tr>
				<tr> 
					<td class="header"> Vorname: </td> 
					<td> <input type="text" value="${applicant.userName}" name="userName" /> </td> 
				</tr> 
				<tr> 
					<td class="header"> Nachname: </td> 
					<td> <input type="text" value="${applicant.userSurname}" name="userSurname" /> </td> 
				</tr>
				<tr> 
					<td class="header"> E-Mail: </td> <td> 
					<input type="text" value="${applicant.email}" name="email" /> </td> 
				</tr>
				<tr> 
					<td class="header"> Fr.Eintrittsdatum: </td> 
					<td> <input type="text" value="${applicant.entryDate}" name="entryDate" /> </td> 
				</tr>
				<tr> 
					<td class="header"> Fachrichtung: </td> 
					<td> <input type="text" value="${applicant.subject}" name="subject" /> </td> 
				</tr>
				<tr> 
					<td class="header"> Vertiefung: </td> 
					<td> <input type="text" value="${applicant.specialization}" name="specialization" /> </td> 
				</tr>
				<tr> 
					<td class="header"> Gehaltsvorstellung: </td> 
					<td> <input type="text" value="${applicant.sallery}" name="sallery" /> </td> 
				</tr>
				<tr> 
					<td class="header"> Passwort: </td> 
					<td> <input type="password" value="${applicant.password}" name="password" /> </td> 
				</tr>
			</table>	
			<button type="submit">Ändern</button>	
				</form>
				<p class="message">${msg}</p>
			</div>
		
		</div>
		
	</body>
</html>