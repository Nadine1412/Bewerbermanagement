<%@ page isELIgnored="false"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<style type="text/css">
 			body{
                color: rgba(255, 255, 255, 0.16);
                position: relative;
                background: #f5f5f5 ;
                background-size:cover;     
            }
			.navbar{
	            width: 100%;
	            background-color:#717374;
	            z-index: 10;
        	}
 			ul{
	            text-align: left;
	            display: inline;
	            margin: 0;
	            padding: 0;
	            list-style: none;
        	}

        	ul li{
	            font: bold 12px/18px sans-serif;
	            display: inline-block;
	            position:relative;
	            padding: 25px 20px;
	            background: #555758;
        	}
        	ul li a{
	            text-decoration: none;
	            padding: 25px 20px;
	            color:white;
	            font-size: 18px;
        	}          
        	ul li:hover{
            	background: #afb2b3;
            	color:white;
        	}
        	ul li ul{
	            padding: 0;
	            position: absolute;
	            top: 70px;
	            left:0;
	            width:250px;
	            display:none;
	            visibility:hidden;
        	}

        	ul li ul li{
            	background: #9fa1a1;
            	display: block;
        	}
        	ul li ul li:hover{
            	background: #c4cbcc;

	        }
	        ul li:hover ul{
	            display: block;
	            opacity: 1;
	            visibility: visible;
	        }
	        ul ul ul li{
	            display: none;
	        }
	        ul ul li:hover li{
	            display: block;
	        }
	        ul ul ul{
	            left:100;
	        }
	        .container{            
                color: black;
                z-index: 1;
            }              
}
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
							<li><a href="">Profil anzeigen</a></li>
							<li><a href="">Profil bearbeiten</a></li>
						</ul>
					</li>
					<li>
						<a href="">Kommunikation</a>
						<ul>
							<li><a href="emailForm.jsp">Email senden</a></li>
							<li><a href="">Chat</a></li>
						</ul>
					<li>	
					
					<li><a href="decision.jsp">Logout</a></li>
				</ul>
				<!-- <input type="button" value="Logout" onClick="window.location.href='Anmeldung kaue.html'"> -->
			</div>
			<center>	
      				<div class="container">
					<br><br><br><br>
					<p>${msg}</p>
				</div>
			</center>
	</body>
</html>