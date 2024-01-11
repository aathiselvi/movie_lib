<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<style>
	*{
		margin: 0;
		padding: 0;
		box-sizing: border-box;
	}
		body {
		height: 90vh;
		display: flex;
		align-items: center;
		justify-content: center;
		background-image: url("https://previews.123rf.com/images/ghenadie/ghenadie1702/ghenadie170200101/72206099-open-red-curtains-theater-background-with-glittering-stars-movie-or-other-presentation-design.jpg");
		background-position: center;
		background-repeat: no-repeat;
		background-size: cover;
		margin-top: 5%;
	}
	.container{
		text-align:center;
		display: flex;
		flex-direction: column;
		height:350px;
		width: 300px;
		padding: 15px;
		border-radius: 5px;	
		
	}
	input {
		margin: 5px 0px;
		height: 35px;
		padding: 7px; 
	}
	button{
		height: 35px;
		margin: 5px 0px;
		padding-right:25px;
		padding-left:25px;
		border: none;
		border-radius: 5px;
		color: #333;	
	}
	button:hover {
		background: #7878;
		
	}
	.part1{
		margin-top: 80px;
		margin-bottom: 20%;
	}
		</style>
		</head>
		<body>
		<div class="container">
		<h1 > Login </h1>
		<div class="part1">
		<form action="adminlogin" method="post">
		Admin Email : <input type="text" name="a_mail"><br>
		Admin Password : <input type="text" name="a_pass"> <br>
		<button>sumbit</button>
		</form>
		</div>
		</div>
		<%String message = (String)request.getAttribute("message"); %>
		<%if(message!=null){ %>
		<%= message %>
		<% } %>
</body>
</html>