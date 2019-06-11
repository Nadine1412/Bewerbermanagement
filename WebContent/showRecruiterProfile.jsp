<%@ page isELIgnored="false"%>
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
			<div class="navbar">
				<ul>
					<li><a href="overviewUser.jsp">Übersicht</a></li>
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
			</div>
			<div class="page">
				<div class="form">
					<br><br><br><br>
					<table> 
						<tr> <td class="header">User ID:</td> <td>${recruiter.userId}</td> </tr>
						<tr> <td class="header">Vorname:</td> <td>${recruiter.userName}</td> </tr> 
						<tr> <td class="header">Nachname:</td> <td>${recruiter.userSurname}</td> </tr>
						<tr> <td class="header">Geburtstag:</td> <td>${recruiter.birthday}</td> </tr>
						<tr> <td class="header">E-Mail:</td> <td>${recruiter.email}</td> </tr>
						<tr> <td class="header">Unternehmen: </td> <td>${recruiter.enterprise}</td> </tr>
						<tr> <td class="header">Position: </td> <td>${recruiter.position}</td> </tr>
					</table>
				</div>
			</div>
		
			
	</body>
</html>