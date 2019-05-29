<%@ page isELIgnored="false"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<!-- <link href="bootstrap.css" rel="stylesheet" type="text/css">  -->
   		<style>
   			<%@include file="css/login.css"%>
		</style>
    </head>
	<body>
		
		<!-- <form action="login" method="post" class="register-form">
			<h1 class="h3 mb-3 font-weight-normal">Bitte einloggen!</h1>
			<label for="inputEmail" class="sr-only">Email Adresse:</label> 
			<input type="email" id="inputEmail" name="inputEmail" class="form-control" required autofocus>
			<br> 
			<label for="inputPassword" class="sr-only">Passwort:</label>
			<input type="password" id="inputPassword" name="inputPassword" class="form-control" required>
			<div class="checkbox mb-3"></div>
			<button class="btn btn-lg btn-primary btn-block" type="submit" value="login">Sign in</button>
			<p class="mt-5 mb-3 text-muted">© Siebenhaar, Möhrle, Jakob</p>
		</form> -->
		<div class="login-page">
  			<div class="form">
   				<form action="login" method="post" class="login-form">
      				<input type="text" placeholder="Email" name="inputEmail"/>
      				<input type="password" placeholder="Passwort" name="inputPassword"/>
      				<button type="submit">login</button>
      				<p class="message">Noch nicht registriert? <a href="decision.jsp">Account erstellen</a></p>
    			</form>
    			<br>
    			<p class="message" color="RED">${msg}</p>

  			</div>
		</div>
	</body>
</html>