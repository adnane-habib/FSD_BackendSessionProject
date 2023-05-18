package com.ecommerce.servlets;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

import com.ecommerce.entities.Product;

/**
 * Servlet implementation class DataUpdate
 */
public class DataUpdate extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DataUpdate() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		
		PrintWriter out = response.getWriter();
        out.println("<html><body>");
        
        String name = request.getParameter("name");
        String priceString = request.getParameter("price");
        
        try 
        {       
        	float price=Float.parseFloat(priceString);
        	out.println("Name = " + name + "<br>Price = " + price);
        	ServletContext servletContext = getServletContext();
 
        	servletContext.setAttribute("productName", name);
        	servletContext.setAttribute("productPrice", priceString);
        	response.sendRedirect("InsertElement");
        	
        	
        	
        	
        }catch (Exception e)
        {
        	out.println("Incorrect value of price " + priceString);
        }
		out.println("<br><br><a href = index.html>Back Home</a>");
}

	}


