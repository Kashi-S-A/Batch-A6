package com.tyss.student;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Update {

	public static void main(String[] args) {

		String url = "jdbc:postgresql://localhost:5432/demo_db";
		String user = "postgres";
		String password = "root";

		try {
			Class.forName("org.postgresql.Driver");

			Connection con = DriverManager.getConnection(url, user, password);

			Statement stm = con.createStatement();

			String update = "UPDATE student SET phone=998877 WHERE sid=1";

			boolean res = stm.execute(update);

			System.out.println(res);

			con.close();

			System.out.println("record update and con is closed");

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
