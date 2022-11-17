<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="com.jobportal.dao.*" %>
<%@ page import="com.jobseeker.bean.*" %>
<%@ page import="javax.servlet.*" %>
<%@ page import="java.util.*" %>
 <%
  JobPortalDAO jcon=new JobPortalDAO();
String search=request.getParameter("search");
JobSeekers j=new JobSeekers();
j.setQul(search);
j.setYop(Integer.parseInt(search));
List<JobSeekers> jlist=jcon.search(j);
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form  method="post">
  <input type="search"  name="search" placeholder="Search "><button type="submit"formaction="home_page.jsp"><i class="bi bi-search"></i>Search</button></
  </form>
 
  <table class="table table-light" border="1px">
				<tr>
					<th>FullName</th>
					<th>Email</th>
					<th>Gender</th>
					<th>MobileNumber</th>
					<th>Qualification</th>
					<th>Year of passing</th>
					<th>Resume</th>
				</tr>
			<%
				if ( jlist!= null) {
					for (JobSeekers js : jlist) {
				%>
				<tr>
					<td><%=js.getFullname()%></td>
					<td><%=js.getEmail()%></td>
					<td><%=js.getGender()%></td>
					<td><%=js.getMobile() %></td>
					<td><%=js.getQul() %></td>
					<td><%=js.getYop() %></td>
					<td><%=js.getResume() %>
				</tr>
				<%
				}}%>
		</table>
  
</body>
</html>