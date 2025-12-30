package com.ty.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;

@WebServlet("/page-b")
public class PageB extends GenericServlet {

	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
		System.out.println("PageB is triggered");
		
		//used to provide response --> to print the msg on the browser
		PrintWriter pw = res.getWriter();
		pw.print("<html>"
				+ "<body>"
				+ "<h1> Welcome to PageB Servlet </h1>"
				+ "</body>"
				+ "</html>");
		
	}
}
