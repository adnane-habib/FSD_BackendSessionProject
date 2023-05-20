package com.ecommerce.servlets;

import jakarta.servlet.ServletException;
//import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.ecommerce.entities.Product;
import com.ecommerce.util.HibernateUtil;

/**
 * Servlet implementation class ProductsList
 */
public class ProductsList extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProductsList() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		
		PrintWriter out = response.getWriter();
		out.println("<html><body>");
		SessionFactory factory = HibernateUtil.getSessionFactory();
		
		//open a connection to DB
		Session session = factory.openSession();
		
		// Hibernate commands to get all the product from the DB
		out.println("PRODUCT LIST<br><br>");
		out.println("<table border=1><th>ID<th>NAME<th>LINE<th>DESCRIPTION</th>");
		List<Product> productList = session.createQuery("from Product").list();
		for(Product product : productList) {
			out.println(
					"<tr><td>"+product.getId()+
					"<td>"+product.getName()+
					"<td>"+product.getPrice()+
					"<td>"+product.getDateAdded()+
					"</tr>");
		}
		
		
		session.close();
		out.println("</table><br><br>");
		out.println("<a href = index.jsp>Back Home</a>");
		
		out.println("</body></html>");	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
	}

}
