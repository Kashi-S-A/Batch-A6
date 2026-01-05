package com.tyss;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/s1")
public class S1 extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("s1 got req");

		resp.getWriter().print("<h1>Welcome to S1</h1>");

		req.setAttribute("name", "Penga");
		req.setAttribute("age", 35);

		Student student = new Student("Pengi", 40);

		req.setAttribute("stu", student);

		RequestDispatcher rd = req.getRequestDispatcher("demo.jsp");//pass s2 to forward the request to Servlet S2
		rd.forward(req, resp);
	}
}
