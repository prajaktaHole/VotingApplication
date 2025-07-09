<%@page import="com.Dao.VotesDao"%>
<%@page import="com.Entity.Candidate"%>
<%@page import="java.util.List"%>
<%@page import="com.Dao.CandidatesDao"%>
<%@page import="org.springframework.context.support.ClassPathXmlApplicationContext"%>
<%@page import="org.springframework.context.ApplicationContext"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>


<style type="text/css">
	td,th{
	padding: 20px;
	}
</style>



</head>
<body>

	<%
	String atoken = (String) session.getAttribute("atoken");

	if (atoken != null) 
	{
	%>

<!--  admin logout start --> 
	<h1 style="text-align: center;">Admin Dashboard</h1>
	<a href="adminlogout">Logout</a>
<!--  admin logout end --> 


<!-- add candidate start -->
	
	<div style="margin:20px 0px; border: 1px solid black; border-radius: 15px; padding: 20px;">
		<form action="addcandidate" method="post">
			
				<h3>Add Candidates</h3>
				<p>Enter Candidate Name :</p>
				<input type="text" name="cname">
				
				<button>Add Candidate</button>
			
		</form>
	</div>

<!-- add candidate end -->




<!-- candidate read start -->

<%
ApplicationContext cxt= new ClassPathXmlApplicationContext("config.xml");
CandidatesDao cDao= cxt.getBean("cDao", CandidatesDao.class);
VotesDao vDao= cxt.getBean("vDao", VotesDao.class);

List<Candidate> l= cDao.readAll();

%>

<div style="margin:40px 0px; border: 1px solid black; border-radius: 15px; padding: 20px;">
<table border="1" style="border-collapse: collapse; text-align: center;">
	<caption style="margin: 10px 0px;">
		<h3>Candidate Information</h3>
	</caption>
	<thead>
		<tr>
			<th>Candidate Name</th>
			<th>Delete</th>
			<th>Edit</th>
			<th>Candidate Vote Count</th>
		</tr>
	</thead>
	<tbody>
		<%
		for(Candidate c: l)
		{
			%>
			<tr>
			<td><%=c.getCname() %></td>
			<td>
				<form action="deletecandidate" method="post">
					<input type="hidden" name="cname" value="<%=c.getCname()%>">
					
					<button style="padding: 10px">Remove</button>
				</form>
			</td>
			<td>
				<form action="#" method="post">
					
					<button style="padding: 10px">Edit</button>
				</form>
			</td>
			<td><%=vDao.getVoteCount(c.getCname()) %></td>
			</tr>
			<% 
		}
		if(l.size() == 0)
		{
			%>
			<tr>
				<td colspan="4">No Candidates Available</td>
			</tr>
			<%
		}
		%>
		
	</tbody>
</table>
</div>


<!-- candidate read end -->















	<%
	}
	else
	{
	response.sendRedirect("adminlogin.jsp");
	}
	%>

</body>
</html>