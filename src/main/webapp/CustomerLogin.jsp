<%@page import="java.sql.*"%>
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

String u=request.getParameter("t1");
String pwd=request.getParameter("t2");
session.setAttribute("uname", u);
try
{
Class.forName("com.mysql.cj.jdbc.Driver");  // exception
System.out.println("Driver found");
Connection connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/1222", "root", "root");
System.out.println("Connection Success");
Statement statement=connection.createStatement(); // execeute all query
ResultSet set=statement.executeQuery("SELECT * FROM customer");
int flag=0;
while(set.next())
{
if(u.equals(set.getString(1)) && pwd.equals(set.getString(3)) )
{
	
	flag=1;
	break;
}
}
if(flag==1)
{
	response.sendRedirect("display.jsp");
}
else
{
	response.sendRedirect("index.html");
}
}
catch (Exception e) {
	System.out.println(e);
}

%>
</body>
</html>