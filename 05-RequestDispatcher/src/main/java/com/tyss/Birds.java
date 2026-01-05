package com.tyss;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/bird")
public class Birds extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("Birds Kingdom");

		resp.getWriter().print("<html><body>"
				+ "<h2>Bird names</h2>"
				+ "<h4>Peacock</h4>"
				+ "<h4>Flemingo</h4>"
				+ "<h4>Parrot</h4>"
				+ "<h4>Sparrow</h4>"
				+ "</body></html>");
	}
}
