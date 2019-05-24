<%@ page isELIgnored="false"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<title>Übersicht</title>


</head>
<body>
	<div class="navbar">
		<ul>
			<li><a class="active" href="overviewBewerber.jsp">Übersicht</a></li>
			<li><a href="Profil anzeigen.php">Profil</a>
				<ul>
					<li><a href="showProfil.jsp">Profil anzeigen</a></li>
					<li><a href="changeProfil.jsp">Profil ändern</a></li>
				</ul></li>
			<li><a href="logout.jsp">Logout</a></li>
		</ul>
		<!-- <input type="button" value="Logout" onClick="window.location.href='Anmeldung kaue.html'"> -->
	</div>

	${msg}
</body>
</html>