package testJDBC.test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class TestTwo {
	static String DB_URL = "jdbc:mysql://localhost:3306/TestJDBC?useSSL=false";
	static String DRIVER = "com.mysql.jdbc.Driver";
	static String USER = "root";
	static String PASSWORD = "Pa$$w0rd";

	private static Connection connection = null;
	private static PreparedStatement preparedStatement = null;
	private static ResultSet resultSet = null;

	public static void main(String[] args) {
		// 因为我前边有?useSSL=false，所以再加参数的话是加&，而不是？
		DB_URL = DB_URL + "&useCursorFetch=true";
		try {
			Class.forName(DRIVER);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			connection = DriverManager.getConnection(DB_URL, USER, PASSWORD);
			preparedStatement = connection
					.prepareStatement("SELECT * FROM `Course`");
			preparedStatement.setFetchSize(2);
			resultSet = preparedStatement.executeQuery();
			
			String userName = "";
			String CourseName = "";
			while(resultSet.next()){
				userName = resultSet.getString("UserName");
				CourseName = resultSet.getString("CourseName");
				System.out.println(userName+": "+CourseName);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {

				if (resultSet != null)
					resultSet.close();
				if (preparedStatement != null)
					preparedStatement.close();
				if (connection != null)
					connection.close();

			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
