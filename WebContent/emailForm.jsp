<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
	<head>
    	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>E-Mail versenden</title>
        <style>
        	<%@include file="css/navigation.css"%>
   			<%@include file="css/backgroundTemplate.css"%>
		</style>
	</head>
	
	<body>
		<div class="navbar">
			<ul>
				<li><a href="overviewBewerber.jsp">Übersicht</a></li>
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
				<form action="sendEmailForm" method="post" class="email-form" enctype="multipart/form-data" >
					<input type="text" placeholder="Empfänger" name="mailReceiver"/>
					<input type="text" placeholder="Betreff" name="mailSubject"/>
					<textarea id="mailMessage" cols="30" rows="10" name="message"></textarea>
					<br><br>
					<input type="file" placeholder="Anhang" name="mailAttachment"/>
					<button type="submit">Email senden</button>
					
				</form>
				<p class="message" color="RED">${msg}</p>
			</div>
		
		</div>
 		
    </body>
</html>