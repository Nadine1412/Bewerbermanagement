<%@ page isELIgnored="false"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<style>
			<%@include file="css/backgroundTemplate.css"%>
			<%@include file="css/navigation.css"%>
		</style>
		<title>Profilübersicht</title>
		</head>
		<body>
			<div class="navbar">
				<ul>
					<li><a href="overviewBewerber.jsp">Übersicht</a></li>
					<li>
						<a href="">Profil</a>
						<ul>
							<li><a class="active" href="getProfile">Profil anzeigen</a></li>
							<li><a href="">Profil bearbeiten</a></li>
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
				<table> 
						<tr> <td class="header">Vorname:</td> <td>${bewerber.userName}</td> </tr> 
						<tr> <td class="header">Nachname:</td> <td>${bewerber.userSurname}</td> </tr>
						<tr> <td class="header">E-Mail:</td> <td>${bewerber.email}</td> </tr>
						<tr> <td class="header">User ID:</td> <td>${bewerber.userId}</td> </tr>
						<tr> <td class="header">Fr.Eintrittsdatum: </td> <td>${bewerber.entryDate}</td> </tr>
						<tr> <td class="header">Fachrichtung: </td> <td>${bewerber.subject}</td> </tr>
						<tr> <td class="header">Vertiefung: </td> <td>${bewerber.specialization}</td> </tr>
						<tr> <td class="header">Gehaltsvorstellung: </td> <td>${bewerber.sallery}</td> </tr>
					</table>
			</div>
			</div>
			<!-- 	<center>	
      				<div class="container">
					<br><br><br><br>
					<table> 
						<tr> <td class="header">Vorname:</td> <td>${bewerber.userName}</td> </tr> 
						<tr> <td class="header">Nachname:</td> <td>${bewerber.userSurname}</td> </tr>
						<tr> <td class="header">E-Mail:</td> <td>${bewerber.email}</td> </tr>
						<tr> <td class="header">User ID:</td> <td>${bewerber.userId}</td> </tr>
						<tr> <td class="header">Fr.Eintrittsdatum: </td> <td>${bewerber.entryDate}</td> </tr>
						<tr> <td class="header">Fachrichtung: </td> <td>${bewerber.subject}</td> </tr>
						<tr> <td class="header">Vertiefung: </td> <td>${bewerber.specialization}</td> </tr>
						<tr> <td class="header">Gehaltsvorstellung: </td> <td>${bewerber.sallery}</td> </tr>
					</table>					
				</div>
			</center> -->
		
	</body>
</html>