<%@ page isELIgnored="false"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>Registration Personaler</title>
		<style>
			<%@include file="css/backgroundTemplate.css"%>
		</style>
	</head>
	<body>
		<div class="page">
			<div class="form">
				<form action="registerRecruiter" method="post" class="register-form">
					<input type="text" placeholder="Vorname" name="userName" />
					<input type="text" placeholder="Nachname" name="userSurname" />
					<input type="text" placeholder="Geburtstag" name="birthday" />
					<input type="text" placeholder="Email" name="email" />
					<input type="text" placeholder="Unternehmen" name="enterprise" />
					<input type="text" placeholder="Position" name="position" />
					<input type="password" placeholder="Passwort" name="password" />
					<button type="submit">registrieren</button>
					<p class="message">${msg}</p>
				</form>	
		</div>
	</div>
</body>
</html>