<%@ page isELIgnored="false"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Bewerbermanagement Registration</title>
<style >
	<%@include file="css/backgroundTemplate.css"%>
</style>
</head>
<body>
	<div class="page">
		<div class="form">
			<form action="register" method="post" class="register-form">
				<input type="text" placeholder="Vorname" name="userName" />
				<input type="text" placeholder="Nachname" name="userSurname" />
				<input type="text" placeholder="Fr. Eintrittsdatum" name="entryDate" />
				<input type="text" placeholder="Fachrichtung" name="subject" />
				<input type="text" placeholder="Vertiefung" name="specialization" />
				<input type="text" placeholder="Gehaltsvorstellung" name="sallery" />
				<input type="text" placeholder="Email" name="email" />
				<input type="password" placeholder="Passwort" name="password" />
				<button type="submit">registrieren</button>
				<p class="message">${msg}</p>
				</form>
				<!-- <form action="register" method="post">
		<pre>
			Name: <input type="text" name="userName" />
			Nachname: <input type="text" name="userSurname" />
			Fr.Eintrittsdatum: <input type="text" name="entryDate" />
			Fachrichtung: <input type="text" name="subject" />
			Vertiefung: <input type="text" name="specialization" />
			Gehaltsvorstellung: <input type="text" name="sallery" />
			E-Mail: <input type="text" name="email" />
			Password: <input type="password" name="password" />
			<input type="submit" value="Register" />
		</pre>
	</form> -->
	

	${msg}
</body>
</html>