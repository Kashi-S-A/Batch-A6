package com.tyss.student;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class CallProcedure {
	public static void main(String[] args) {
		String driver = "org.postgresql.Driver";

		String url = "jdbc:postgresql://localhost:5432/demo_db?user=postgres&password=root";

		try {
			Class.forName(driver);

			Connection con = DriverManager.getConnection(url);

			String sql = "call student_proc(?,?,?,?)";// command to call procedures and functions

			CallableStatement cstm = con.prepareCall(sql);
			cstm.setInt(1, 222);
			cstm.setString(2, "Pengi");
			cstm.setString(3, "pengi@gmail.com");
			cstm.setLong(4, 98765456);

			cstm.execute();

			con.close();

			System.out.println("procedure executed and con closed");

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
