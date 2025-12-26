package com.tyss.student.conclosing;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class UsingFinally {

	public static void main(String[] args) {
		String driver = "org.postgresql.Driver";

		String url = "jdbc:postgresql://localhost:5432/demo_db?user=postgres&password=roo";

		Connection con = null;
		try {
			Class.forName(driver);
			System.out.println("driver loaded");

			con = DriverManager.getConnection(url);
			System.out.println("connection created");

			Statement stm = con.createStatement();
			System.out.println("statement is created");

			String fetch = "SECT * FROM student";

//			stm.executeUpdate(fetch);//Exception

			ResultSet rs = stm.executeQuery(fetch);

			System.out.println("----------Students--------------");

			while (rs.next()) {
				System.out.println("Sid : " + rs.getInt("sid"));// column label
				System.out.println("Name : " + rs.getString(2));// column index
				System.out.println("Email : " + rs.getString(3));
				System.out.println("Phone : " + rs.getLong(4));
				System.out.println("====================");
			}

			System.out.println("record fetched successfully");

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (con != null) {
					con.close();
					System.out.println("connection is  closed");
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
}
