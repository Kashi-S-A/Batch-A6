package com.task.controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.task.conn.ConnectionPool;

@WebServlet("/register")
public class Register extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// read the data
		String username = req.getParameter("username");
		String email = req.getParameter("email");
		String pwd = req.getParameter("password");

		// get conn
		Connection con = ConnectionPool.giveConnection();

		try {
			// insert query
			String insert = "INSERT INTO users VALUES(?,?,?)";

			PreparedStatement stm = con.prepareStatement(insert);
			stm.setString(1, username);
			stm.setString(2, email);
			stm.setString(3, pwd);

			int res = stm.executeUpdate();

			System.out.println("record inserted : " + res);

			ConnectionPool.submitConnection(con);

			// return the resp to login with succ or error msg

			RequestDispatcher rd = req.getRequestDispatcher("login.jsp");
			req.setAttribute("succ", "Registered Successfully");
			rd.forward(req, resp);

		} catch (SQLException e) {
			e.printStackTrace();
			RequestDispatcher rd = req.getRequestDispatcher("login.jsp");
			req.setAttribute("error", "Already Registered");
			rd.forward(req, resp);
		}

	}
}
