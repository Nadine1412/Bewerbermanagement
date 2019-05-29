<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
	<head>
    	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>E-Mail versenden</title>
        <style>
        	<%@include file="css/navigation.css"%>
   			<%@include file="css/email.css"%>
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
					<h1>Email versenden</h1> 
					 <table id="emailFormBeanTable" border="0" width="80%">
                    <tr>
                        <td>Empfänger: </td>
                        <td><input id="receiverMail" type="text" name="mailTo" size="65" /></td>
                    </tr>
                    <tr>
                        <td>Betreff: </td>
                        <td><input id="mailSubject" type="text" name="subject" size="65" /></td>
                    </tr>
                    <tr>
                        <td>Nachricht: </td>
                        <td><textarea id="mailMessage" cols="50" rows="10" name="message"></textarea></td>
                    </tr>
                    <tr>
                        <td>Anhänge: </td>
                        <td><input id="mailAttachment" type="file" name="attachFileObj" size="60" /></td>
                    </tr>
                    <tr>
                        <td colspan="2" align="center">
                        	<button type="submit">Email senden</button>
                        </td>
                    </tr>
                </table>
				</form>
				<p class="message" color="RED">${msg}</p>
			</div>
		
		</div>
		<!-- <center>
            <h2>E-Mail versenden</h2>
            <form id="sendEmailForm" method="post" action="sendEmail" enctype="multipart/form-data">
                <table id="emailFormBeanTable" border="0" width="80%">
                    <tr>
                        <td>Email To: </td>
                        <td><input id="receiverMail" type="text" name="mailTo" size="65" /></td>
                    </tr>
                    <tr>
                        <td>Betreff: </td>
                        <td><input id="mailSubject" type="text" name="subject" size="65" /></td>
                    </tr>
                    <tr>
                        <td>Nachricht: </td>
                        <td><textarea id="mailMessage" cols="50" rows="10" name="message"></textarea></td>
                    </tr>
                    <tr>
                        <td>Anhänge: </td>
                        <td><input id="mailAttachment" type="file" name="attachFileObj" size="60" /></td>
                    </tr>
                    <tr>
                        <td colspan="2" align="center"><input id="sendEmailBtn" type="submit" value="Send Email" /></td>
                    </tr>
                </table>
            </form>
        </center> -->
 		
    </body>
</html>