<%@ page isELIgnored="false" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Bewerbermanagement Registration</title>
</head>
<body>
	<form action="register" method="post"> 
		<pre>
			<strong>Register here | <a href="login.jsp">Click here to Login</a></strong>
			Name: <input type="text" name="userName" />
			Nachname: <input type="text" name="userSurname"/>
			E-Mail: <input type="text" name="email" />
			User Id: <input type="text" name="userId" />
			Password: <input type="password" name="password" />
			
			<input type ="submit" value="Register" />
		</pre>
	</form>
	
	${msg}
</body>
</html>