<%@ page isELIgnored="false"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<link href="bootstrap.css" rel="stylesheet" type="text/css">
   		<style>
   			<%@include file="/login.css"%>
		</style>
    </head>
	<body>

		<form action="login" method="post">
			<h1 class="h3 mb-3 font-weight-normal">Please sign in</h1>
			<label for="inputEmail" class="sr-only">Email address</label> 
			<input type="email" id="inputEmail" name="inputEmail" class="form-control" required autofocus>
			<br> 
			<label for="inputPassword" class="sr-only">Password</label> 
			<input type="password" id="inputPassword" name="inputPassword"
				class="form-control" required>
			<div class="checkbox mb-3"></div>
			<button class="btn btn-lg btn-primary btn-block" type="submit"
				value="login">Sign in</button>
			<p class="mt-5 mb-3 text-muted">© Siebenhaar, Möhrle, Jakob</p>
		</form>
		${msg}
	</body>
</html>