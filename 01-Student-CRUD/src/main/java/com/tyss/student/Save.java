package com.tyss.student;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
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

			String insert = "INSERT INTO student VALUES(?,?,?,?)";

			// step 3 : Create Statement
			PreparedStatement pstm = con.prepareStatement(insert);
			pstm.setInt(1, 111);
			pstm.setString(2, "Penga");
			pstm.setString(3, "penga@gmail.com");
			pstm.setLong(4, 8765434567L);

			// step 4 : Execute the query
			pstm.execute();
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
