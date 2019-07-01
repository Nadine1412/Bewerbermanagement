<%@ page isELIgnored="false"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Registration Personaler</title>
<style>
	<%@include file="/view/css/backgroundTemplate.css"%>
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
			<form action="registerRecruiter" method="post" class="register-form">
				<table>
					<tr> <td class="header-change"> Vorname: </td> 		<td> <input class="profile" type="text" placeholder="Vorname" name="userName" value="${recruiter.userName}"> </td> </tr>
					<tr> <td> </td> <td class="errorMsg"> ${errorName} </td> </tr>
					<tr> <td class="header-change"> Nachname: </td> 	<td> <input class="profile" type="text" placeholder="Nachname" name="userSurname" value="${recruiter.userSurname}"> </td> </tr> 
					<tr> <td> </td> <td class="errorMsg"> ${errorSurname} </td> </tr>
					<tr> <td class="header-change"> Geburtsdatum: </td> <td> <input class="profile" type="date" name="birthday" value="${recruiter.birthday}"> </td> </tr>
					<tr> <td> </td> <td class="errorMsg"> ${errorBirthday} </td> </tr>
					<tr> <td class="header-change"> Unternehmen: </td> 	<td> <input class="profile" type="text" placeholder="Unternehmen" name="enterprise" value="${recruiter.enterprise}"> </td> </tr>
					<tr> <td> </td> <td class="errorMsg"> ${errorEnterprise} </td> </tr>
					<tr> <td class="header-change"> Position: </td> 	<td> <input class="profile" type="text" placeholder="Position" name="position" value="${recruiter.position}"> </td> </tr>
					<tr> <td> </td> <td class="errorMsg"> ${errorPosition} </td> </tr>
					<tr> <td class="header-change"> E-Mail: </td> 		<td> <input class="profile" type="text" placeholder="Email" name="email" value="${recruiter.email}"> </td> </tr>
					<tr> <td> </td> <td class="errorMsg"> ${errorEmail} </td> </tr>
					<tr> <td class="header-change"> Passwort: </td> 	<td> <input class="profile" type="password" placeholder="Passwort" name="password" value="${recruiter.password}"> </td> </tr> 
					<tr> <td> </td> <td class="errorMsg"> ${errorPassword} </td> </tr>
				</table>
				<br> Ich stimme der Speicherung meiner Daten entsprechend der  <a href="dsgvo.jsp" target="_blank"> DSGVO</a> zu: <input type="checkbox" id="checkBoxDSGVO" onclick="handleClick(this)" name="DSGVO" value="true">
				<input type="submit"  id="submitButtonId" class="submitButton" value="registrieren" disabled="disabled">
				<p class="message"> Zurück zur Auswahl? <a href="decision.jsp"> Zurück </a></p>
				<p class="message">${msg}</p>
			</form>	
		</div>
	</div>
</body>
</html>