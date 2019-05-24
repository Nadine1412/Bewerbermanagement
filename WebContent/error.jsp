<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Spring MVC Email Example</title>
        <style type="text/css">
            #errorMessage {
                text-align: center; 
                font-size: 25px; 
                padding-top: 17px;
            }
             
            #errorMessage span {
                color: red;
            }
        </style>
    </head>
 
    <body>
        <center>
            <h2>Spring MVC Email Example</h2>
        </center>
        <br /> <br />
        <div id="errorMessage">
            <strong>Sorry, The Email Was Not Sent Because Of The Following Error!</strong>
            <span id="exceptionTrace">${exception.message}</span>
        </div>
    </body>

</html>