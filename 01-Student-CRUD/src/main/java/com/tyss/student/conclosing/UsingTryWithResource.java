package com.tyss.student.conclosing;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class UsingTryWithResource {

	public static void main(String[] args) {
		String driver = "org.postgresql.Driver";

		String url = "jdbc:postgresql://localhost:5432/demo_db?user=postgres&password=root";

		try {
			Class.forName(driver);
			System.out.println("driver loaded");

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

		try (Connection con = DriverManager.getConnection(url);)// Resource
		{
			Statement stm = con.createStatement();

			String fetch = "SECT * FROM student";

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
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
