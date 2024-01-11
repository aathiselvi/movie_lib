<%@page import="dto.Movie"%>
<%@page import="java.util.Base64"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>


	<% Movie m = (Movie)request.getAttribute("movie"); %>
	
	<form action="updatemovie"  method="post" enctype="multipart/form-data">
	Movie id       :  <input type="number" name="mid" value="<%=m.getMovieid()%>" readonly ><br><br>
	Movie name     :  <input type="text" name="mname"  value="<%=m.getMoviename()%>"> <br><br>
	Movie price    :  <input type="number" name="mprice" value="<%=m.getMovieprice()%>"><br><br>
	Movie rating   :  <input type="number" name="mrating" value="<%=m.getMovierating()%>"><br><br>
	Movie genre    :  <input type="text" name="mgenre"  value="<%=m.getMoviegenre()%>"><br><br>
	Movie language :  <input type="text" name="mlanguage" value="<%=m.getMovielanguage()%>"><br><br>
	Movie image    :  <input type="file" name="mimage" ><br><br>
					  <input type="submit">
					  
	<%String base64image = new String(Base64.getEncoder().encode(m.getMovieimage())); %>
	<img alt="loading" src="data:image/jpeg:base64, <%= base64image %>" height="150px" width="100px">
	</form>

</body>
</html>