<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<style>
body{
		
		background-image: url("https://t3.ftcdn.net/jpg/02/13/13/00/360_F_213130051_knV3mChBRQuJzzOuq5NLpVONsrR1NW9y.jpg");
		background-size: cover;
		background-repeat: no-repeat;
		background-size: cover;
		text-align: center;
		padding-bottom: 5%%;

		
	}
	.sign{
		text-align:center;
		display: flex;
		flex-direction: column;
		height:400px;
		width: 400px;
		padding-left: 35%;
		padding-right:35%;
		padding-top: 5%;
		background-position: center;;
		margin-bottom: 25%;
		
	
	}
		
</style>
</head>
<body>
<div class="sign">
	<h1> AdminSignup </h1>
	<form action="adminsignup" method="post">
	
	Admin id : <input type="number" name="adminid"><br><br>
	Admin name : <input type="text" name="adminname"><br><br>
	Admin contact : <input type="number" name="admincontact"><br><br>
	Admin mail : <input type="text" name="adminmail"><br><br>
	Admin password : <input type="text" name="adminpassword"><br><br>
	<input type="submit">
	</form>
	</div>
</body>
</html>