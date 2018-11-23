package com.hammar.product.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.hammar.product.dto.Product;
import com.hammar.product.bo.ProductBO;;


/**
 * Servlet implementation class CreateProductServlet
 */
public class CreateProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		String name = request.getParameter("name");
		String description = request.getParameter("description");
		int price = Integer.parseInt(request.getParameter("price"));
		
		Product product = new Product();
		
		product.setId(id);
		product.setDescription(description);
		product.setName(name);
		product.setPrice(price);
		
		WebApplicationContext context = WebApplicationContextUtils.getRequiredWebApplicationContext(this.getServletContext());
		ProductBO bo = (ProductBO) context.getBean("productbo");
		
		bo.create(product);
		
		PrintWriter out = response.getWriter();
		out.print("Product Created!");
	}

}
