package com.qdu.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * @author lidcha
 * @createDate ：2019年7月23日
 */

public class DBConnection {
	private static String driverClass = "com.mysql.jdbc.Driver";
	private static String url = "jdbc:mysql://localhost:3306/employee_info";
	private static String username = "root";
	private static String password = "2015";
	static {
		try {
			Class.forName(driverClass);
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("链接失败");
		}
	}

	public static Connection getConnection() throws SQLException {
		Connection conn = DriverManager.getConnection(url, username, password);
		return conn;
	}

	public static boolean close(Connection conn, ResultSet res, Statement stmt) {
		try {
			if (conn != null)
				conn.close();
			if (res != null)
				res.close();
			if (stmt != null)
				stmt.close();
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}
}
