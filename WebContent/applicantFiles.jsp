<%@ page isELIgnored="false"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Applicant Files</title>
<style>
		<%@include file="css/navigation.css"%>
		<%@include file="css/backgroundTemplate.css"%>
</style>
</head>
<body>
<div class="pageSearch">
	<div class="searchTable">

		<table border="1">
			<tr class="header-change"> <td> Bewerber-ID: </td> <td> Name: </td> <td> File: </td> <td> Beschreibung: </td> <td> Upload-Datum: </td> </tr>		
 				<c:forEach items="${filesList}" var= "file"> 
 				
 					<tr> 
 						<td> ${file.a_id} </td>
	 					<td> ${file.filename} </td> 
	 					<td> 
	 						<form method="post" action="downloadFile">	
	 							<input type="hidden" name="filename" value="${file.filename}"/> <button class="button downloadButton" type="submit"> Download </button>
							</form>	
	 					</td> 
	 					<td> ${file.description} </td>
	 					<td> ${file.uploadDate} </td> 	
 					</tr>
 							
 			</c:forEach>
 		</table>	
 		<br>
 		<div class="message">${msg} </div>
	</div>
</div>

</body>
</html>