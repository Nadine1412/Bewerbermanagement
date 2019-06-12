<%@ page isELIgnored="false"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

		<style>
			<%@include file="css/navigation.css"%>
			<%@include file="css/backgroundTemplate.css"%>
		</style>
		<title>Profil �ndern</title>
	</head>
	<body>
		<div class="navbar">
			<ul>
				<li><a href="overviewUser.jsp">�bersicht</a></li>
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
				<form action="updateApplicantProfile" method="post">
					<table>  
						<tr> <td class="header-change"> User ID: </td> 				<td> <input class="profile" type="text" value="${applicant.userId}" 		name="userId" readonly /> </td> </tr>
						<tr> <td class="header-change"> Vorname: </td> 				<td> <input class="profile" type="text" value="${applicant.userName}" 		name="userName" /> </td> </tr> 
						<tr> <td class="header-change"> Nachname: </td> 			<td> <input class="profile" type="text" value="${applicant.userSurname}"	name="userSurname" /> </td> </tr>
						<tr> <td class="header-change"> E-Mail: </td> 				<td> <input class="profile" type="text" value="${applicant.email}" 			name="email" /> </td> </tr>
						<tr> <td class="header-change"> Geburtstag: </td> 			<td> <input class="profile" type="text" value="${applicant.birthday}" 		name="birthday" /> </td> </tr>
						<tr> <td class="header-change"> Fr.Eintrittsdatum: </td> 	<td> <input class="profile" type="text" value="${applicant.entryDate}" 		name="entryDate" /> </td> </tr>
						<tr> <td class="header-change"> Fachrichtung: </td> 		<td> <input class="profile" type="text" value="${applicant.subject}" 		name="subject" /> </td> </tr>
						<tr> <td class="header-change"> Vertiefung: </td> 			<td> <input class="profile" type="text" value="${applicant.specialization}" name="specialization" /> </td> </tr>
						<tr> <td class="header-change"> Gehaltsvorstellung: </td> 	<td> <input class="profile" type="text" value="${applicant.sallery}" 		name="sallery" /> </td> </tr>
						<tr> <td class="header-change"> Passwort: </td> 			<td> <input class="profile" type="password" value="${applicant.password}" 	name="password" /> </td> </tr>
					</table>	
					<button type="submit">�ndern</button>	
				</form>
				<p class="message">${msg}</p>
			</div>
		
		</div>
		
	</body>
</html>