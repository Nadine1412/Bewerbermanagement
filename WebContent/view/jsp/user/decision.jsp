<%@ page isELIgnored="false"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>Decision</title>
		<style >
			<%@include file="/view/css/backgroundTemplate.css"%>	
		</style>
	</head>
	<body>
		<div class="page">
			<div class="form">
			<p>Registrierung</p>
				<p class="message">Sind Sie ein Bewerber? <a href="view/jsp/user/registrationApplicant.jsp">Bewerber Registration</a></p>
				<p class="message">Sind Sie ein Personaler? <a href="view/jsp/user/registrationRecruiter.jsp">Personaler Registration</a></p>
			<p class="message">Bereits registriert? <a href="view/jsp/user/login.jsp">Login</a></p>
			<div class="message"> ${msg} </div> 
			
			</div>
		</div>
</body>
</html>