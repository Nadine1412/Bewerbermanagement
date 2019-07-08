<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
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
		<c:if test="${paramEmail == null}">
		<jsp:include page="navBar.jsp"></jsp:include>
		</c:if>
		<div class="page">
			<div class="form">
				<form action="sendEmailForm" method="post" class="email-form" enctype="multipart/form-data" >
					<input type="text" placeholder="Empfänger" name="mailReceiver" value="${paramEmail}"/>
					<input type="text" placeholder="Betreff" name="mailSubject"/>
					<textarea id="mailMessage" cols="30" rows="10" name="message"></textarea>
					<br><br>
					<!-- <input type="file" placeholder="Anhang" name="mailAttachment"/> -->
					<button type="submit">Email senden</button>
				</form>
				<p class="message" color="RED">${msg}</p>
			</div>
		
		</div>
 		
    </body>
</html>