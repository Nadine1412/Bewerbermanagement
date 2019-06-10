<%@ page isELIgnored="false"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<!-- <link href="bootstrap.css" rel="stylesheet" type="text/css">  -->
   		<style>
   			<%@include file="css/backgroundTemplate.css"%>
		</style>
    </head>
	<body>
		<div class="page">
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