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
				<input type="text" placeholder="Vorname" name="userName" />
				<input type="text" placeholder="Nachname" name="userSurname" />
				<input type="text" placeholder="Geburtsdatum" name="birthday" />
				<input type="text" placeholder="Fr. Eintrittsdatum" name="entryDate" />
				<input type="text" placeholder="Fachrichtung" name="subject" />
				<input type="text" placeholder="Vertiefung" name="specialization" />
				<input type="text" placeholder="Gehaltsvorstellung" name="sallery" />
				<input type="text" placeholder="Email" name="email" />
				<input type="password" placeholder="Passwort" name="password" /> 
				<br> Ich stimme der <a href="dsgvo.jsp" target="_blank"> DSGVO </a>zu: <input type="checkbox" id="checkBoxDSGVO" onclick="handleClick(this)" name="DSGVO" value="true"> <br>
				<input type="submit"  id="submitButtonId" class="submitButton" value="registrieren" disabled="disabled">
				<!-- -  <button type="submit" >registrieren</button> --> 
				<p class="message">${msg}</p>
			</form>
		${msg}
		</div>
	</div>
</body>
</html>