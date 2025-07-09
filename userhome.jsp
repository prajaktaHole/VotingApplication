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
</head>
<body>


<%
String utoken =(String)session.getAttribute("utoken");

if(utoken != null)
{
%>

<h1 style="text-align: center;">Voting Section</h1>
<h3>Hello, <%=utoken %></h3>

<a href="ulogout">Logout</a>



<!-- candidate display start -->

<%
ApplicationContext cxt = new ClassPathXmlApplicationContext("config.xml");
CandidatesDao cDao= cxt.getBean("cDao", CandidatesDao.class);
List<Candidate> l= cDao.readAll();
%>

<div style="border: 1px solid black; border-radius: 15px; width:600px;padding:20px; margin: 0px auto;">
	<div style="margin: 0px auto; width: 50%">
		<form action="addvote" method="post">
		<%
		for(Candidate c:l)
		{
			%>
			<p>Candidate Name : <%=c.getCname() %></p>
			<input type="radio" name="cname" value="<%=c.getCname()%>"><br>
			<% 
		}
		%>
		<input type="hidden" name="uname" value="<%=utoken%>">
		<button>Vote</button>
		
	</form>
	</div>
</div>

<!-- candidate display end -->













<% 
}
else
{
	response.sendRedirect("userlogin.jsp");
}
%>


</body>
</html>