<%@ page isELIgnored="false"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<style><%@include file="showProfile.css"%></style>
		<title>Profil�bersicht</title>
	</head>
		<body>
			<div class="navbar">
				<ul>
					<li><a href="overviewBewerber.jsp">�bersicht</a></li>
					<li>
						<a href="">Profil</a>
						<ul>
							<li><a class="active" href="getProfile">Profil anzeigen</a></li>
							<li><a href="getOldProfile">Profil bearbeiten</a></li>
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
				<!-- <input type="button" value="Logout" onClick="window.location.href='Anmeldung kaue.html'"> -->
			</div>
			<center>	
      				<div class="container">
					<br><br><br><br>
					<table> 
						<tr> 
							<td class="header"> User ID: </td> 
							<td> ${bewerber.userId} </td> 
						</tr>
						<tr> 
							<td class="header"> Vorname: </td>
							<td> ${bewerber.userName} </td> 
						</tr> 
						<tr> 
							<td class="header"> Nachname: </td>
							<td> ${bewerber.userSurname} </td> 
						</tr>
						<tr> 
							<td class="header"> E-Mail: </td> 
							<td>${bewerber.email}</td> 
						</tr>
						<tr> 
							<td class="header"> Fr.Eintrittsdatum: </td> 
							<td> ${bewerber.entryDate} </td> 
						</tr>
						<tr> 
							<td class="header"> Fachrichtung: </td> 
							<td> ${bewerber.subject} </td> 
						</tr>
						<tr> 
							<td class="header"> Vertiefung: </td> 
							<td> ${bewerber.specialization} </td> 
						</tr>
						<tr> 
							<td class="header"> Gehaltsvorstellung: </td> 
							<td> ${bewerber.sallery} </td> 
						</tr>
					</table>					
				</div>
			</center>
	</body>
</html>