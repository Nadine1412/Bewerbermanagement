<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
	<head>
    	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>E-Mail konfigurieren</title>
        <style>
        	<%@include file="css/navigation.css"%>
   			<%@include file="css/email.css"%>
		</style>
	</head>
	
	<body>
		<div class="navbar">
			<ul>
				<li><a href="overviewBewerber.jsp">�bersicht</a></li>
				<li>
					<a href="">Profil</a>
					<ul>
						<li><a class="active" href="getProfile">Profil anzeigen</a></li>
						<li><a href="">Profil bearbeiten</a></li>
					</ul>
				</li>
				<li>
					<a href="">Kommunikation</a>
					<ul>
						<li><a href="emailForm.jsp">Email senden</a></li>
						<li><a href="">Chat</a></li>
					</ul>
				</li>	
				<li><a href="decision.jsp">Logout</a></li>
			</ul>
		</div>
		
		<div class="page">
			<div class="form">
				<form action="mailConfig" method="post" class="email-form" enctype="multipart/form-data" >
					<input type="text" placeholder="SMTP Host" name="smtpHost"/>
					<input type="text" placeholder="SMTP Port" name="smtpPort"/>
					<button type="submit">Speichern</button>
				</form>
				<p class="message" color="RED">${msg}</p>
			</div>
		</div>
 		
    </body>
</html>