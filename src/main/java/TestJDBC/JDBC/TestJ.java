package TestJDBC.JDBC;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import TestJDBC.Bean.User;
import TestJDBC.Tool.DBTool;

public class TestJ {

	static String DB_URL = "jdbc:mysql://localhost:3306/TestServlet?useSSL=false";
	// static String DB_URL =
	// "jdbc:mysql://localhost:3306/TestJDBC?useSSL=false";
	static final String DRIVER = "com.mysql.jdbc.Driver";
	static final String USER = "root";
	// static final String PASSWORD = "Huzh1x1ang";
	static final String PASSWORD = "Pa$$w0rd";

	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		

	}
	private static void inrest(User user) {
		// TODO Auto-generated method stub
		Connection connection = DBTool.openConn();
		PreparedStatement preparedStatement = null;
		try {
			preparedStatement = connection
					.prepareStatement("INSERT INTO user(username,password,account) VALUES (?,?,?)");
			preparedStatement.setString(1, user.getUsername());
			preparedStatement.setString(2, user.getPassword());
			preparedStatement.setInt(3, user.getAccount());
			preparedStatement.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				preparedStatement.close();
				DBTool.closeConn(connection);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

}
