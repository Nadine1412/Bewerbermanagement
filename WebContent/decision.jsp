<%@ page isELIgnored="false"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Decision</title>
<style type="text/css">
html, body {
				height: 100%;
			}

			body {
				display: -ms-flexbox;
				display: -webkit-box;
				display: flex;
				-ms-flex-align: center;
				-ms-flex-pack: center;
				-webkit-box-align: center;
				align-items: center;
				-webkit-box-pack: center;
				justify-content: center;
				padding-top: 40px;
				padding-bottom: 40px;
				background-color: #f5f5f5;
			}
</style>
</head>
<body>
	<form action="login" method="post">
		<pre>
		<strong>Registrieren Sie sich beim Bewerbermanagement.
		Sind Sie ein Bewerber oder ein Personaler?</strong>
			<a href="registrationBewerber.jsp">Bewerber klick hier</a>
			<a href="registration.jsp">Personaler klick hier</a>
			
			<strong>Bereits angemeldet? 
			-direkt zum Login
			<a href="login.jsp">Click here to Login</a>
			</strong>
		</pre>
	</form>
</body>
</html>