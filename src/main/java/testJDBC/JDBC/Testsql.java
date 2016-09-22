package testJDBC.JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;
import java.sql.PreparedStatement;

public class Testsql {
	private static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
	private static final String DB_URL = "jdbc:mysql://localhost:3306/TestJDBC?useSSL=false";
	private static final String USER = "root";
	private static final String PASS = "Pa$$w0rd";

	public static void getStudent(String name) throws ClassNotFoundException {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			Class.forName(JDBC_DRIVER);
			conn = DriverManager.getConnection(DB_URL, USER, PASS);
			String sql = "select name,number from student where name = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, name);
			rs = pstmt.executeQuery();
			rs.next();
			System.out.println(rs.getString("name") + ":" + rs.getInt("number"));

		} catch (SQLException e) {
			e.fillInStackTrace();
		} finally {
			if (rs != null) {
				try {
					rs.close();
				} catch (Exception e) {
					// ignore
				}

			}
			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (Exception e) {
					// ignoresd
				}
			}
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					// ignore
				}
			}
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		while (true) {
			try {
				getStudent(in.nextLine());
				System.out.println("#########################");
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
