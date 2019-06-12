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
				<li><a href="overviewUser.jsp">Übersicht</a></li>
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
				<form action="updateRecruiterProfile" method="post">
					<table>  
						<tr> <td class="header-change"> User ID: </td> 		<td> <input type="text" value="${recruiter.userId}" 		name="userId" readonly /> </td> </tr>
						<tr> <td class="header-change"> Vorname: </td> 		<td> <input type="text" value="${recruiter.userName}" 		name="userName" /> </td> </tr> 
						<tr> <td class="header-change"> Nachname: </td> 	<td> <input type="text" value="${recruiter.userSurname}"	name="userSurname" /> </td> </tr>
						<tr> <td class="header-change"> E-Mail: </td> 		<td> <input type="text" value="${recruiter.email}" 			name="email" /> </td> </tr>
						<tr> <td class="header-change"> Geburtstag: </td> 	<td> <input type="text" value="${recruiter.birthday}" 		name="birthday" /> </td> </tr>
						<tr> <td class="header-change"> Unternehmen: </td> 	<td> <input type="text" value="${recruiter.enterprise}" 	name="enterprise" /> </td> </tr>
						<tr> <td class="header-change"> Position: </td> 	<td> <input type="text" value="${recruiter.position}"		name="position" /> </td> </tr>
						<tr> <td class="header-change"> Passwort: </td> 	<td> <input type="password" value="${recruiter.password}" 	name="password" /> </td> </tr>
					</table>	
					<button type="submit">Ändern</button>	
				</form>
				<p class="message">${msg}</p>
			</div>
		
		</div>
		
	</body>
</html>