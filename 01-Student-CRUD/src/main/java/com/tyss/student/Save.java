package com.tyss.student;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Save {

	public static void main(String[] args) {

		String url = "jdbc:postgresql://localhost:5432/demo_db";
		String user = "postgres";
		String password = "root";

		try {
			// step 1 : Load the driver
			Class.forName("org.postgresql.Driver");
			System.out.println("driver loaded");

			// step 2 : Create connection
			Connection con = DriverManager.getConnection(url, user, password);
			System.out.println("connection created");

			// step 3 : Create Statement
			Statement stm = con.createStatement();
			System.out.println("statement is created");

			String insert = "INSERT INTO student VALUES(1,'Pengi','pengi@gmail.com',8765456)";

			// step 4 : Execute the query
			boolean res = stm.execute(insert);
			System.out.println(res);
			System.out.println("record inserted");

			// step 5 : Close the connection
			con.close();
			System.out.println("connection is closed");

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
