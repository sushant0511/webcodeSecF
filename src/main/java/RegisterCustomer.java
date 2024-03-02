

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class RegisterCustomer
 */
@WebServlet("/RegisterCustomer")
public class RegisterCustomer extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegisterCustomer() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String u=request.getParameter("t1");
		String email=request.getParameter("email");
		String pwd=request.getParameter("t2");
		float bill=0.0f;
		try
		{
		Class.forName("com.mysql.cj.jdbc.Driver");  // exception
		System.out.println("Driver found");
		Connection connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/1222", "root", "root");
		System.out.println("Connection Success");
		Statement statement=connection.createStatement(); // execeute all query
		String insQuery="insert into customer values('"+u+"','"+email+"','"+pwd+"','"+bill+"')";
		int flag=0;
		flag=statement.executeUpdate(insQuery);
		
		if(flag==0)
		{
			response.sendRedirect("csignip.html");
		}
		else
		{
			response.sendRedirect("Customer.html");
		}
		}
		catch (Exception e) {
			System.out.println(e);
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
