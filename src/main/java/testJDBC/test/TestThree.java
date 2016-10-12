package testJDBC.test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.commons.dbcp2.BasicDataSource;

public class TestThree {
	static String DB_URL = "jdbc:mysql://localhost:3306/TestJDBC?useSSL=false";
	static String DRIVER = "com.mysql.jdbc.Driver";
	static String USER = "root";
	static String PASSWORD = "Pa$$w0rd";

	private static Connection connection = null;
	private static PreparedStatement preparedStatement = null;
	private static ResultSet resultSet = null;

	public static void main(String[] args) {
		// 因为我前边有?useSSL=false，所以再加参数的话是加&，而不是？
		BasicDataSource basicDataSource = new BasicDataSource();
		basicDataSource.setUrl(DB_URL);
		basicDataSource.setPassword(PASSWORD);
		basicDataSource.setDriverClassName(DRIVER);
		basicDataSource.setUsername(USER);
		try {
			connection = basicDataSource.getConnection();
			preparedStatement = connection
					.prepareStatement(" SELECT `CourseName` FROM `Course` WHERE `UserName` = ?");
			preparedStatement.setString(1, "ZhangSan");
			resultSet = preparedStatement.executeQuery();
			
			while(resultSet.next()){
				System.out.println(resultSet.getString("CourseName"));
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
