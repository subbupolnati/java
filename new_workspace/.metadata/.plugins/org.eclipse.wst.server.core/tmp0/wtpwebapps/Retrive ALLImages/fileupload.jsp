<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form action="UploadImage" method="post" enctype="multipart/form-data">
Enter pid:<input type="text" name="id"><br>
upload image:<input type="file" name="image" required="required"/><br><br>

<input type="submit">



</form>
</body>
</html>