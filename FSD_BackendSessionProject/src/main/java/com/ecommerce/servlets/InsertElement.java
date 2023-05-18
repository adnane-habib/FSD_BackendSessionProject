package com.ecommerce.servlets;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
//import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
//import org.hibernate.Transaction;

import com.ecommerce.util.HibernateUtil;
import com.ecommerce.entities.Product;
/**
 * Servlet implementation class InsertElement
 */
public class InsertElement extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InsertElement() {
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
		
		ServletContext servletContext = getServletContext();
		
		String productName = (String) servletContext.getAttribute("productName");
		String productPriceString = (String) servletContext.getAttribute("productPrice");
		/*
        float price=Float.parseFloat(priceString);
		//Transaction transaction = null;
		Product product = new Product(newComputer, price);
		
		out.println(product);
		*/
		Session session = factory.openSession();
		//out.println("Session Succesfully opened!");
		float price=Float.parseFloat(productPriceString);
		Product product = new Product(productName, price);
		//out.println(product);
		try{
		
		
		
		//transaction = session.beginTransaction();
		session.save(product);
		//out.println("Session Successfully saved!");
		//session.flush();
		session.close();
		out.println("data succesfully added!");
		out.println("<br><br>Model:"+product.getName()+"<br>price +"+product.getPrice());
		//transaction.commit();
		//out.println(transaction);
		
		
		} catch (Exception e) {
			//transaction.rollback();
			out.println("data not added!");
			out.println(e);

		}
		out.println("<br><br><a href = list-products>Product List</a>");
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
	}

}
