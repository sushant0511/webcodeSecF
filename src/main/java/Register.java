

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Register
 */
@WebServlet("/Register")
public class Register extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Register() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String un=request.getParameter("t1");
		String pass=request.getParameter("t2");
		String cpass=request.getParameter("t3");
		if(pass.equals(cpass))
		{
			
			
			try
			{
			Class.forName("com.mysql.cj.jdbc.Driver");  // exception
			System.out.println("Driver found");
			Connection connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/1222", "root", "root");
			System.out.println("Connection Success");
			Statement statement=connection.createStatement(); // execeute all query
			String query="insert into admin(`username`,`password`) values('"+un+"','"+pass+"')";
			int i=0;
			i=statement.executeUpdate(query);
			if(i==0)
			{
			response.sendRedirect("index.html");
			}
			else
			{
			
			}
			
			
			}
			
			catch (Exception ee) {
				System.out.println("Error is = "+ee);
			}
			response.sendRedirect("index.html");
		}
		else
		{
			response.sendRedirect("reg.html");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
