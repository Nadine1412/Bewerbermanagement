<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
	<head>
    	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>E-Mail versenden</title>
        <style type="text/css">
            #sendEmailBtn {
                float: left;
                margin-top: 22px;
            }
            body{
                color: rgba(255, 255, 255, 0.16);
                position: relative;
                background: #f5f5f5 ;
                background-size:cover;     
            }
        </style>
	</head>
	
	<body>
 		<center>
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
        </center>
    </body>
</html>