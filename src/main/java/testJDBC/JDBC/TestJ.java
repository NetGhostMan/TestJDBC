package testJDBC.JDBC;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Set;

import org.apache.commons.dbcp2.BasicDataSource;

//import com.chesstop.edison.DoAddPassword;

import testJDBC.Bean.User;
import testJDBC.Tool.DBTool;

public class TestJ {

	static String DB_URL = "jdbc:mysql://localhost:3306/TestJDBC?useSSL=false";
	static String DRIVER = "com.mysql.jdbc.Driver";
	static String USER = "root";
	static String PASSWORD = "Pa$$w0rd";

	private Connection connection;
	private PreparedStatement preparedStatement;
	private ResultSet resultSet;
	private Statement statement;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TestJ j = new TestJ();
		// Set<String> users = new HashSet<String>();
		// users.add("Zhaowu");
		//
		// users.add("Shaowu");
		// users.add("Gaowu");
		// j.intobatch(users);

		// j.seclct();
//		j.test1();
		
		User user = new User("edison","Zhunxiao",12);
		
		j.seclct();
		
	}

	private void addUser(User user) {
		String sql = "insert into user(username,password) values(?,?)";
		connection = DBTool.openConn();
		try {
			preparedStatement = connection.prepareStatement(sql);
			System.out.println("获取conn");
			String username = user.getUsername();
			preparedStatement.setString(1, username);
			System.out.println("设置String");
			String password = user.getPassword();
			//DoAddPassword addPassword = new DoAddPassword();
			//password = addPassword.setPssword(password);
			preparedStatement.setString(2, password);
			System.out.println("设置密码");
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("这里出错");
		} finally {
			try {
				if (statement != null)
					preparedStatement.close();
				if (connection != null)
					connection.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	private void intobatch(Set<String> users) {

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
				statement.addBatch("insert into user(username) values('" + user + "')");
			}

			statement.executeBatch();

			statement.clearBatch();

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

	private void test1() {
		BasicDataSource basicDataSource = new BasicDataSource();
		basicDataSource.setDriverClassName(DRIVER);
		basicDataSource.setUrl(DB_URL);
		basicDataSource.setUsername(USER);
		basicDataSource.setPassword(PASSWORD);

		String sql = " select * from Product where Id = ?";
		try {
			Class.forName(DRIVER);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			connection = basicDataSource.getConnection();
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, 1);
			resultSet = preparedStatement.executeQuery();
			resultSet.next();
			String productName = resultSet.getString("ProductName");
			Integer inventory = resultSet.getInt("Inventory");

			System.out.println("ProductName : " + productName);
			System.out.println("Inventory : " + inventory);

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

	private void seclct() {
		DB_URL += "&useCursorFetch=true";

		String sql = " select * from user where username = ?";

		try {
			Class.forName(DRIVER);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		try {
			connection = DriverManager.getConnection(DB_URL, USER, PASSWORD);
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, "edison");
			preparedStatement.setFetchSize(1);
			resultSet = preparedStatement.executeQuery();

			File f = new File("src/main/resource/stream.txt");

			System.out.println(f.getAbsolutePath());
			InputStream inputStream = null;
			OutputStream outputStream = new FileOutputStream(f, true);
			while (resultSet.next()) {
				inputStream = resultSet.getBinaryStream("username");
				int i = 0;
				while ((i = inputStream.read()) != -1) {
					outputStream.write(i);
				}
				String string = resultSet.getString("username");
				String password = resultSet.getString("password");
				//DoAddPassword addPassword = new DoAddPassword();
				//password = addPassword.getPassword(password);
				System.out.println("username : " + string);
				System.out.println("password : " + password);
			}
			if (inputStream != null)
				inputStream.close();
			if (outputStream != null)
				outputStream.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
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
