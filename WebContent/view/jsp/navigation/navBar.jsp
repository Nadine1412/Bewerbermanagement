<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div class="navbar">
		<c:if test="${sessionScope.isApplicant == true}">
			<ul>
				<li><a href="overviewUser.jsp">Startseite</a></li>
				<li><a href="">Profil</a>
					<ul>
						<li><a href="getProfile">Profil anzeigen</a></li>
						<li><a href="getOldProfile">Profil bearbeiten</a></li>
						<li><a href="fileUpload.jsp">Anhänge hochladen</a></li>
						<li><a href="getFiles">Anhänge anzeigen</a></li>
						<li><a href="userSkills.jsp">Fähigkeiten hinzufügen</a></li>
					</ul></li>
				<li><a href="">Kommunikation</a>
					<ul>
						<li><a href="emailForm.jsp">Email senden</a></li>
					</ul></li>

				<li><a href="logout">Logout</a></li>
			</ul>
		</c:if>

		<c:if test="${sessionScope.isApplicant == false}">
			<ul>
				<li><a href="overviewUser.jsp">Startseite</a></li>
				<li><a href="">Profil</a>
					<ul>
						<li><a href="getProfile">Profil anzeigen</a></li>
						<li><a href="getOldProfile">Profil bearbeiten</a></li>

					</ul></li>
				<li><a href="">Kommunikation</a>
					<ul>
						<li><a href="emailForm.jsp">Email senden</a></li>
					</ul></li>
				<li><a href="searchApplicants.jsp">Bewerber suchen</a></li>
				<li><a href="logout">Logout</a></li>
			</ul>
		</c:if>
	</div>
</body>
</html>