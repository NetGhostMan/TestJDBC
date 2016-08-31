package TestJDBC.Tool;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBTool {
	static String DB_URL = "jdbc:mysql://localhost:3306/TestServlet?useSSL=false";
//	static String DB_URL = "jdbc:mysql://localhost:3306/TestJDBC?useSSL=false";
	static final String DRIVER = "com.mysql.jdbc.Driver"; 
	static final String USER = "root"; 
//	static final String PASSWORD = "Huzh1x1ang";
	static final String PASSWORD = "Pa$$w0rd";
	
	static public Connection openConn() {
		// TODO Auto-generated method stub
		Connection connection = null;
		try {
			Class.forName(DRIVER);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			connection = DriverManager.getConnection(DB_URL,USER,PASSWORD);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return connection;
	}
	static public void closeConn(Connection connection) throws SQLException{
		connection.close();
	}
}
