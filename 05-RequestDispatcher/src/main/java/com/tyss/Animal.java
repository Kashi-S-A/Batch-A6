package com.tyss;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/animal")
public class Animal extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("Welcome to Animal Kingdom");

		resp.getWriter().print("<html><body>"
				+ "<h2>Animal names</h2>"
				+ "<h4>Tiger</h4>"
				+ "<h4>Lion</h4>"
				+ "<h4>Dog</h4>"
				+ "<h4>Cat</h4>"
				+ "</body></html>");
		
		RequestDispatcher rd = req.getRequestDispatcher("test.html");//url of Bird servlet
//		rd.forward(req, resp);
		rd.include(req, resp);
		
	}
}
