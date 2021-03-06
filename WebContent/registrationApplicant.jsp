<%@ page isELIgnored="false"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Registration Bewerber</title>
<style >
	<%@include file="css/backgroundTemplate.css"%>
</style>
<script>
	function handleClick()
	{
		var checkBoxDSGVO = document.getElementById("checkBoxDSGVO");
		document.getElementById("submitButtonId").disabled= !checkBoxDSGVO.checked;
	
	}
</script>
</head>
<body>
	<div class="page">
		<div class="form">
			<form action="registerApplicant" method="post" class="register-form">
				<table>
					<tr> <td class="header-change"> Vorname: </td> 				<td> <input class="profile" type="text" placeholder="Vorname" name="userName" value="${applicant.userName}"> </td>
					<tr> <td> </td> <td class="errorMsg"> ${errorName} </td> </tr>
					<tr> <td class="header-change"> Nachname: </td> 			<td> <input class="profile" type="text" placeholder="Nachname" name="userSurname" value="${applicant.userSurname}"> </td> 
					<tr> <td> </td> <td class="errorMsg"> ${errorSurname} </td> </tr>
					<tr> <td class="header-change"> Geburtsdatum: </td> 		<td> <input class="profile" type="date" name="birthday" value="${applicant.birthday}"> </td>
					<tr> <td> </td> <td class="errorMsg"> ${errorBirthday} </td> </tr>
					<tr> <td class="header-change"> Eintrittsdatum: </td> 		<td> <input class="profile" type="date" name="entryDate" value="${applicant.entryDate}"> </td> 
					<tr> <td> </td> <td class="errorMsg"> ${errorEntrydate} </td> </tr>
					<tr> <td class="header-change"> Fachrichtung: </td> 		<td> <input class="profile" type="text" placeholder="Fachrichtung" name="subject" value="${applicant.subject}"> </td>
					<tr> <td> </td> <td class="errorMsg"> ${errorSubject} </td> </tr>
					<tr> <td class="header-change"> Vertiefung: </td> 			<td> <input class="profile" type="text" placeholder="Vertiefung" name="specialization" value="${applicant.specialization}"> </td>
					<tr> <td> </td> <td class="errorMsg"> ${errorSpecialization} </td> </tr>
					<tr> <td class="header-change"> Gehaltsvorstellung: </td> 	<td> <input class="profile" type="text" placeholder="Gehaltsvorstellung" name="salary" value="${applicant.salary}"> </td>
					<tr> <td> </td> <td class="errorMsg"> ${errorSalary} </td> </tr>
					<tr> <td class="header-change"> E-Mail: </td> 				<td> <input class="profile" type="text" placeholder="Email" name="email" value="${applicant.email}"> </td>
					<tr> <td> </td> <td class="errorMsg"> ${errorEmail} </td> </tr>
					<tr> <td class="header-change"> Passwort: </td> 			<td> <input class="profile" type="password" placeholder="Passwort" name="password" value="${applicant.password}"> </td> 
					<tr> <td> </td> <td class="errorMsg"> ${errorPassword} </td> </tr>
				</table>	
					<br> Ich stimme der Speicherung meiner Daten entsprechend der  <a href="dsgvo.jsp" target="_blank"> DSGVO</a> zu. <input type="checkbox" id="checkBoxDSGVO" onclick="handleClick(this)" name="DSGVO" value="true">
					<input type="submit"  id="submitButtonId" class="submitButton" value="registrieren" disabled="disabled">
						<p class="message"> Zur�ck zur Auswahl? <a href="decision.jsp"> Zur�ck </a></p>
					<p class="message">${msg}</p>
			</form>
		${msg}
		</div>
	</div>
</body>
</html>