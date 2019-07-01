<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
        <%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Uploaded File</title>
<style>
		<%@include file="/view/css/navigation.css"%>
		<%@include file="/view/css/backgroundTemplate.css"%>
</style>
</head>

<body>
<jsp:include page="/view/jsp/navigation/navBar.jsp"></jsp:include>

<div class="page" style="width:1300px">
	<div class="searchTable">

		<table border="1">
			<tr class="header-change"> <td> Bewerber-ID: </td> <td> Name:  </td> <td> File: </td> <td> Beschreibung: </td> <td> Upload-Datum: </td> </tr>		
 			<c:forEach items="${filesList}" var= "file"> 
 				
 					<tr> 
 						<td> ${file.a_id} </td>
	 					<td> ${file.filename} </td> 
	 					<td> 
	 						<form method="post" action="downloadFile">	
	 							<input type="hidden" name="filename" value="${file.filename}"/> 
	 							<!-- <button class="button downloadButton" type="submit"> Download </button> -->
	 							<button type="submit"> Download </button>
							</form>	
	 					</td> 
	 					<td> ${file.description} </td>
	 					<td> ${file.uploadDate} </td> 	
 					</tr>
 							
 			</c:forEach>	
 		</table>	
 		<div class="message">${msg} </div>
	</div>
</div>

</body>
</html>