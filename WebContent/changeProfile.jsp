<%@ page isELIgnored="false"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<style><%@include file="changeProfile.css"%></style>
		<title>Profil ändern</title>
	</head>
	<body>
		<div class="navbar">
			<ul>
				<li><a href="overviewBewerber.jsp">Übersicht</a></li>
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
			<!-- <input type="button" value="Logout" onClick="window.location.href='Anmeldung kaue.html'"> -->
		</div>
			
		<form action="updateProfile" method="post">		
			<center>	
	    	<div class="container">
			<br><br><br><br>
			<table> 
				<tr> 
				<td class="header"> User ID: </td> 
				<td> <input type="text" value="${bewerber.userId}" name="userId" readonly /> </td>
				</tr>
				<tr> 
					<td class="header"> Vorname: </td> 
					<td> <input type="text" value="${bewerber.userName}" name="userName" /> </td> 
				</tr> 
				<tr> 
					<td class="header"> Nachname: </td> 
					<td> <input type="text" value="${bewerber.userSurname}" name="userSurname" /> </td> 
				</tr>
				<tr> 
					<td class="header"> E-Mail: </td> <td> 
					<input type="text" value="${bewerber.email}" name="email" /> </td> 
				</tr>
				<tr> 
					<td class="header"> Fr.Eintrittsdatum: </td> 
					<td> <input type="text" value="${bewerber.entryDate}" name="entryDate" /> </td> 
				</tr>
				<tr> 
					<td class="header"> Fachrichtung: </td> 
					<td> <input type="text" value="${bewerber.subject}" name="subject" /> </td> 
				</tr>
				<tr> 
					<td class="header"> Vertiefung: </td> 
					<td> <input type="text" value="${bewerber.specialization}" name="specialization" /> </td> 
				</tr>
				<tr> 
					<td class="header"> Gehaltsvorstellung: </td> 
					<td> <input type="text" value="${bewerber.sallery}" name="sallery" /> </td> 
				</tr>
				<tr> 
					<td class="header"> Passwort: </td> 
					<td> <input type="password" value="${bewerber.password}" name="password" /> </td> 
				</tr>
				<tr> 
					<td class="header"> <input type="submit" value="Ändern" /> </td> 
					<td> ${msg} </td>
				</tr>
			</table>					
			</div>
							
			</center>	
		</form> 
		
		
	</body>
</html>