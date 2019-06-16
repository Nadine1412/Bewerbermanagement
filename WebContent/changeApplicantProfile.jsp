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
				<form action="updateApplicantProfile" method="post">
					<table>  
						<tr> <td class="header-change"> User ID: </td> 				<td> <input class="profile" type="text" value="${applicant.userId}" 		name="userId" readonly /> </td> </tr>
						<tr> <td class="header-change"> Vorname: </td> 				<td> <input class="profile" type="text" placeholder="Vorname" name="userName" value="${applicant.userName}"> </td>
						<tr> <td> </td> <td class="errorMsg"> ${errorName} </td> </tr>
					<tr> <td class="header-change"> Nachname: </td> 				<td> <input class="profile" type="text" placeholder="Nachname" name="userSurname" value="${applicant.userSurname}"> </td> 
						<tr> <td> </td> <td class="errorMsg"> ${errorSurname} </td> </tr>
					<tr> <td class="header-change"> Geburtsdatum: </td> 			<td> <input class="profile" type="date" name="birthday" value="${applicant.birthday}"> </td>
						<tr> <td> </td> <td class="errorMsg"> ${errorBirthday} </td> </tr>
					<tr> <td class="header-change"> Eintrittsdatum: </td> 			<td> <input class="profile" type="date" name="entryDate" value="${applicant.entryDate}"> </td> 
						<tr> <td> </td> <td class="errorMsg"> ${errorEntrydate} </td> </tr>
					<tr> <td class="header-change"> Fachrichtung: </td> 			<td> <input class="profile" type="text" placeholder="Fachrichtung" name="subject" value="${applicant.subject}"> </td>
						<tr> <td> </td> <td class="errorMsg"> ${errorSubject} </td> </tr>
					<tr> <td class="header-change"> Vertiefung: </td> 				<td> <input class="profile" type="text" placeholder="Vertiefung" name="specialization" value="${applicant.specialization}"> </td>
						<tr> <td> </td> <td class="errorMsg"> ${errorSpecialization} </td> </tr>
					<tr> <td class="header-change"> Gehaltsvorstellung: </td> 		<td> <input class="profile" type="text" placeholder="Gehaltsvorstellung" name="sallery" value="${applicant.sallery}"> </td>
						<tr> <td> </td> <td class="errorMsg"> ${errorSallery} </td> </tr>
					<tr> <td class="header-change"> E-Mail: </td> 					<td> <input class="profile" type="text" placeholder="Email" name="email" value="${applicant.email}"> </td>
						<tr> <td> </td> <td class="errorMsg"> ${errorEmail} </td> </tr>
					<tr> <td class="header-change"> Passwort: </td> 				<td> <input class="profile" type="password" placeholder="Passwort" name="password" value="${applicant.password}"> </td> 
						<tr> <td> </td> <td class="errorMsg"> ${errorPassword} </td> </tr>
					</table>	
					<button type="submit">Ändern</button>	
				</form>
				<p class="message">${msg}</p>
			</div>
		
		</div>
		
	</body>
</html>