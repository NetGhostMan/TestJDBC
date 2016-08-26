package TestJDBC.JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashSet;
import java.util.Set;

public class TestJDBC {
	
	static String DB_URL = "jdbc:mysql://localhost:3306/TestJDBC?useSSL=false";
	static final String DRIVER = "com.mysql.jdbc.Driver"; 
	static final String USER = "root"; 
	static final String PASSWORD = "Huzh1x1ang";
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Set<String> users = new HashSet<String>();
		for(int i = 0;i<10; i++){
			users.add("huzhixiang" + i);
		}
		inrest(users);
		helloworld();
		chaixunfei();

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
			for(String user:users){
				statement.addBatch("insert into user(username) values ('"+user+"')");
			}
			statement.executeBatch();
			statement.clearBatch();
			} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				statement.close();
				connection.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
		
	}

	private static void chaixunfei() {
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
			connection = DriverManager.getConnection(DB_URL,USER,PASSWORD);
			preparedStatement = connection.prepareStatement("select * from user");
			preparedStatement.setFetchSize(5);
			resultSet = preparedStatement.executeQuery();
			
			while(resultSet.next()){
				System.out.println("hello"+ resultSet.getString("username"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				resultSet.close();
				preparedStatement.close();
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
			connection = DriverManager.getConnection(DB_URL,USER,PASSWORD);
			
			statement = connection.createStatement();
			resultSet = statement.executeQuery("select * from user");
			while(resultSet.next()){
				System.out.println("hello"+resultSet.getString("username"));
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				resultSet.close();
				statement.close();
				connection.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
		
	}

}
