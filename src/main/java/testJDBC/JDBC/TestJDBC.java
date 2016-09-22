package testJDBC.JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashSet;
import java.util.Set;

import TestJDBC.Bean.User;
import TestJDBC.Tool.DBTool;

public class TestJDBC {

	static String DB_URL = "jdbc:mysql://localhost:3306/TestServlet?useSSL=false";
	// static String DB_URL =
	// "jdbc:mysql://localhost:3306/TestJDBC?useSSL=false";
	static final String DRIVER = "com.mysql.jdbc.Driver";
	static final String USER = "root";
	// static final String PASSWORD = "Huzh1x1ang";
	static final String PASSWORD = "Pa$$w0rd";

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// Set<String> users = new HashSet<String>();
		// for (int i = 0; i < 10; i++) {
		// users.add("huzhixiang" + i);
		// }
		// inrest(users);
		inrest(new User("ZhangSan", "123456", 100));
		inrest(new User("LiSi", "123456", 0));

		helloworld();
		chaixunfei();

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

	private static void inrest(Set<String> users) {
		// TODO Auto-generated method stub
		Connection connection = null;
		Statement statement = null;

		try {
			Class.forName(DRIVER);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		try {
			connection = DriverManager.getConnection(DB_URL, USER, PASSWORD);
			statement = connection.createStatement();
			for (String user : users) {
				statement.addBatch("insert into user(username) values ('" + user + "')");
			}
			statement.executeBatch();
			statement.clearBatch();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				statement.close();
				connection.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}

	}

	public static void chaixunfei() {
		// TODO Auto-generated method stub
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		try {
			Class.forName(DRIVER);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		DB_URL = DB_URL + "&useCursorFetch=true";
		try {
			connection = DriverManager.getConnection(DB_URL, USER, PASSWORD);
			preparedStatement = connection.prepareStatement("select * from user");
			preparedStatement.setFetchSize(5);
			resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {
				System.out.println("hello " + resultSet.getString("username") + ":" + resultSet.getString("account"));
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

	private static void helloworld() {
		// TODO Auto-generated method stub
		Connection connection = null;
		Statement statement = null;
		ResultSet resultSet = null;

		try {
			Class.forName(DRIVER);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println("类没写对");
			e.printStackTrace();
		}

		try {
			connection = DriverManager.getConnection(DB_URL, USER, PASSWORD);

			statement = connection.createStatement();
			resultSet = statement.executeQuery("select * from user");
			while (resultSet.next()) {
				System.out.println("hello" + resultSet.getString("username"));
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				if (resultSet != null)
					resultSet.close();
				if (statement != null)
					statement.close();
				if (connection != null)
					connection.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}

	}

}
