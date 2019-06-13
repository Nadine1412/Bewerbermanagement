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
		<jsp:include page="navBar.jsp"></jsp:include>
		<div class="page">
			<div class="form">
				<form action="updateProfile" method="post">
					<table>  
						<tr> <td class="header-change"> User ID: </td> 			<td> <input type="text" value="${applicant.userId}" 	name="userId" readonly /> </td> </tr>
						<tr> <td class="header-change"> Vorname: </td> 			<td> <input type="text" value="${applicant.userName}" 	name="userName" /> </td> </tr> 
						<tr> <td class="header-change"> Nachname: </td> 			<td> <input type="text" value="${applicant.userSurname}" name="userSurname" /> </td> </tr>
						<tr> <td class="header-change"> E-Mail: </td> 				<td> <input type="text" value="${applicant.email}" 		name="email" /> </td> </tr>
						<tr> <td class="header-change"> Fr.Eintrittsdatum: </td> 	<td> <input type="text" value="${applicant.entryDate}" 	name="entryDate" /> </td> </tr>
						<tr> <td class="header-change"> Fachrichtung: </td> 		<td> <input type="text" value="${applicant.subject}" 	name="subject" /> </td> </tr>
						<tr> <td class="header-change"> Vertiefung: </td> 			<td> <input type="text" value="${applicant.specialization}" name="specialization" /> </td> </tr>
						<tr> <td class="header-change"> Gehaltsvorstellung: </td> 	<td> <input type="text" value="${applicant.sallery}" 	name="sallery" /> </td> </tr>
						<tr> <td class="header-change"> Passwort: </td> 			<td> <input type="password" value="${applicant.password}" name="password" /> </td> </tr>
					</table>	
					<button type="submit">�ndern</button>	
				</form>
				<p class="message">${msg}</p>
			</div>
		
		</div>
		
	</body>
</html>