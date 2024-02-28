

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
 * Servlet implementation class AddProduct
 */
@WebServlet("/AddProduct")
public class AddProduct extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddProduct() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try
		{
		Class.forName("com.mysql.cj.jdbc.Driver");  // exception
		Connection connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/1222", "root", "root");
		Statement statement=connection.createStatement(); // execeute all query
		String name=request.getParameter("n");
		String cost=request.getParameter("cost");
		String desc=request.getParameter("desc");
		String quan=request.getParameter("quan");
		String insertQuery="insert into product(`name`,`cost`,`desc`,`quantity`) values('"+name+"','"+cost+"','"+desc+"','"+quan+"')";
		int flag=0;
		flag=statement.executeUpdate(insertQuery);
		if(flag==1)
		{
			response.sendRedirect("welcome.html");
		}
		else
		{
			response.sendRedirect("error.html");
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
