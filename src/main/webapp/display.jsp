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
<h2>Buy Here</h2>
<table border="2">
<thead>
<tr>
<th>Id</th>
<th>Name</th>
<th>Cost</th>
<th>Desc</th>
<th>Quantity</th>

</tr>
</thead>
<tbody>
<%

try
{
Class.forName("com.mysql.cj.jdbc.Driver");  // exception
Connection connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/1222", "root", "root");
Statement statement=connection.createStatement(); // execeute all query
ResultSet set=statement.executeQuery("select * from product");
while(set.next())
{
	%>
	
<tr>
<td><%out.println(set.getInt(1)); %></td>
<td><%out.println(set.getString(2)); %></td>
<td><%out.println(set.getFloat(3)); %></td>
<td><%out.println(set.getString(4)); %></td>
<td><%out.println(set.getInt(5)); %></td>
</tr>
	
<%}

}
catch (Exception e) {
	System.out.println(e);
}
%>


</tbody>
</table>
<form action="">
Enter Product Id <input type="text" name="pid"><br>
quantity <input type="text" name="quan"><br>
<input type="submit" value="Buy">  
</form>
</body>
</html>











