package com.productApp.web.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;


import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.productApp.model.persistence.Product;
import com.productApp.model.service.ProductService;
import com.productApp.model.service.ProductServiceImpl;


public class ProductController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private ProductService productService = new ProductServiceImpl();
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		try (PrintWriter out = response.getWriter()) {
			String name=request.getParameter("pname");
			Double price=Double.parseDouble(request.getParameter("price"));
			int quantity=Integer.parseInt(request.getParameter("quantity"));
			Date mfDate = Date.valueOf(request.getParameter("manufactured"));
			Date inspDate = Date.valueOf(request.getParameter("inspected"));
			
			Product product = new Product(name,price,quantity,mfDate,inspDate);
		
			Product savedProduct = productService.addProduct(product);
			
			HttpSession httpSession=request.getSession();
			
			httpSession.setAttribute("product", savedProduct);			
			response.sendRedirect("resultPage.jsp");
		}
	}

}
