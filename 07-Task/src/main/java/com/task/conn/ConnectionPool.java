package com.task.conn;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ConnectionPool {

	private static String url = "jdbc:postgresql://localhost:5432/task?user=postgres&password=root";
	private static String driver = "org.postgresql.Driver";
	private static final int POOL_SIZE = 5;
	private static List<Connection> connectionPool = new ArrayList<Connection>();

	static {
		for (int i = 1; i <= POOL_SIZE; i++) {
			connectionPool.add(createConnection());
		}
	}

	private static Connection createConnection() {
		Connection connection = null;
		try {
			Class.forName(driver);

			connection = DriverManager.getConnection(url);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return connection;
	}

	public static Connection giveConnection() {
		if (!connectionPool.isEmpty()) {
			return connectionPool.remove(0);
		} else {
			return createConnection();
		}
	}

	public static void submitConnection(Connection connection) {
		if (connectionPool.size() < POOL_SIZE) {
			connectionPool.add(connection);
		} else {
			try {
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
}