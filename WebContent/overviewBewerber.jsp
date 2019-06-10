<%@ page isELIgnored="false"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<style>
   			<%@include file="css/navigation.css"%>
   			<%@include file="css/backgroundTemplate.css"%>
		</style>

		<title>Übersicht</title>
		</head>
		<body>
			<div class="navbar">
				<ul>
					<li><a class="active" href="overviewBewerber.jsp">Übersicht</a></li>
					<li>
						<a href="">Profil</a>
						<ul>
							<li><a href="getProfile">Profil anzeigen</a></li>
							<li><a href="getOldProfile"> Profil bearbeiten</a></li>
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
					<p>${msg}</p>
				</div>
			</div>
	</body>
</html>