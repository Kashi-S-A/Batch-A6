package com.task.controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.task.conn.ConnectionPool;

@WebServlet("/login")
public class Login extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String email = req.getParameter("email");
		String pwd = req.getParameter("password");

		Connection con = ConnectionPool.giveConnection();

		try {
			String fetch = "SELECT * FROM users WHERE email=? AND pwd=?";

			PreparedStatement pstm = con.prepareStatement(fetch);
			pstm.setString(1, email);
			pstm.setString(2, pwd);

			ResultSet rs = pstm.executeQuery();

			if (rs.next()) {
				// login succ -> home page
				RequestDispatcher rd = req.getRequestDispatcher("home.jsp");
				rd.forward(req, resp);
			} else {
				// error -> login
				RequestDispatcher rd = req.getRequestDispatcher("login.jsp");
				req.setAttribute("error", "Invalid Credentials");
				rd.forward(req, resp);
			}

		} catch (SQLException e) {
			e.printStackTrace();
			RequestDispatcher rd = req.getRequestDispatcher("login.jsp");
			req.setAttribute("error", "Invalid Credentials");
			rd.forward(req, resp);
		}

	}
}
