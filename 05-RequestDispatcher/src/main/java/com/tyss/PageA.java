package com.tyss;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/page-a")
public class PageA extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("PageA servlet triggered");

		String msg = req.getParameter("src");

		resp.getWriter().print("<h1>This is PageA</h1>");

		if (msg.equalsIgnoreCase("Animal")) {
			resp.sendRedirect("animal");// url of Animal servlet
		} else if (msg.equalsIgnoreCase("Bird")) {
			resp.sendRedirect("bird");// url of Birds Servlet
		} else {
			resp.sendRedirect("https://www.wikipedia.org/");
		}
	}
}
