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
			
	
	}
	.part{
		text-align:center;
		display: flex;
		flex-direction: column;
		height:400px;
		width: 400px;
		padding-left: 35%;
		padding-right:35%;
		padding-top: 5%;
		background-position: center;
		margin-bottom: 20%;
	}
</style>
</head>
<body >
<div class="part">
	<h2>Add Movie</h2>
	<form action="add-movie"  method="post" enctype="multipart/form-data">
	Movie id       :  <input type="number" name="mid"><br><br>
	Movie name     :  <input type="text" name="mname"> <br><br>
	Movie price    :  <input type="number" name="mprice"><br><br>
	Movie rating   :  <input type="number" name="mrating"><br><br>
	Movie genre    :  <input type="text" name="mgenre"><br><br>
	Movie language :  <input type="text" name="mlanguage"><br><br>
	Movie image    :  <input type="file" name="mimage"><br><br>
					  <input type="submit">
	
	
	</form>
	</div> 
	
</body>
</html>