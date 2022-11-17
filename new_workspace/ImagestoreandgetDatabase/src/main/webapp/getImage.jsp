<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.sql.*" %>
<%@ page import="java.io.OutputStream"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%
int id=1;
try {
Class.forName("oracle.jdbc.driver.OracleDriver");
Connection con = null;
con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:admin","c##scott","tiger");
String sql="select * from image where pid=?";
PreparedStatement pstmt=con.prepareStatement(sql);
pstmt.setInt(1,id);
ResultSet rs=pstmt.executeQuery();
if(rs.next())
{
Blob blob=rs.getBlob("image");
byte arr[]=blob.getBytes(1,(int) blob.length());
response.setContentType("image/gif");
OutputStream os=response.getOutputStream();
os.write(arr);
os.flush();
os.close();
}
}
catch(Exception e)
{
e.printStackTrace();
}

%>



</body>
</html>