<%@ page isELIgnored="false"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link href="${pageContext.request.contextPath}/bootstrap.css" rel="stylesheet" type="text/css">
<link href="${pageContext.request.contextPath}/login.css" rel="stylesheet" type="text/css">
<title>Bewerbermanagement Login</title>
</head>
<body class="text-centre">


	<!-- 	<form action="login" method="post">
	<pre>
			<strong>Login here | <a href="decision.jsp">Click here to Register</a></strong>
			User Id: <input type="text" name="inputEmail" />
	
			Password: <input type="password" name="inputPassword" />

			<input type="submit" value="login" />
			</form>
		</pre> -->





	<form action="login" method="post">
		<h1 class="h3 mb-3 font-weight-normal">Please sign in</h1>
		Please sign in <label for="inputEmail" class="sr-only">Email
			address</label> <input type="email" id="inputEmail" name="inputEmail"
			class="form-control" required autofocus> <label
			for="inputPassword" class="sr-only">Password</label> <input
			type="password" id="inputPassword" name="inputPassword"
			class="form-control" required>
		<div class="checkbox mb-3"></div>
		<button class="btn btn-lg btn-primary btn-block" type="submit"
			value="login">Sign in</button>
		<p class="mt-5 mb-3 text-muted">© Siebenhaar, Möhrle, Jakob</p>
	</form>
	${msg}
</body>
</html>