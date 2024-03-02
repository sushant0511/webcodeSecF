

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Buy
 */
@WebServlet("/Buy")
public class Buy extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Buy() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out=response.getWriter();
		String idd=request.getParameter("pid");
		int id=Integer.parseInt(idd);
		String quan=request.getParameter("quan");
		int bquan=Integer.parseInt(quan);
		List<Product> list=new ArrayList<>();
		String un="user";
		try
		{
		Class.forName("com.mysql.cj.jdbc.Driver");  // exception
		System.out.println("Driver found");
		Connection connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/1222", "root", "root");
		System.out.println("Connection Success");
		Statement statement=connection.createStatement(); // execeute all query
		ResultSet set=statement.executeQuery("SELECT * FROM product");
		int flag=0;
		float bill=0.0f;
		Statement statement1=connection.createStatement();
		ResultSet set1=statement1.executeQuery("select * from customer where `username`='"+un+"'");
		while(set1.next())
		{
		bill=set1.getFloat(4);	
		}
		
		while(set.next())
		{
		Product  product=new Product();
		product.setId(set.getInt(1));
		product.setCost(set.getFloat(3));
		list.add(product);
		
		
		for(Product p:list)
		{
			if(id==p.getId())
			{
				bill= bill+ p.getCost()*bquan;
				statement.executeUpdate("UPDATE `1222`.`customer` SET `bill` = '"+bill+"' WHERE (`username` = '"+un+"')");
			}
		}
		if(bill>0)
		{
			out.print("Bill Generated="+bill);
		}
		else
		{
			response.sendRedirect("index.html");
		}
		}
		System.out.println(bill);
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
