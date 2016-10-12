package testJDBC.Transaction.test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Main {
	static final String DB_URL = "jdbc:mysql://localhost:3306/TestJDBC?useSSL=false";
	static final String DRIVER = "com.mysql.jdbc.Driver";
	static final String USER = "root";
	static final String PASSWORD = "Pa$$w0rd";

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;

		
		//数据
		String buyer = "XiaoMing";
		String productName = "bag";
		int inventory = 0;

		try {
			Class.forName(DRIVER);
		} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		try {
			connection = DriverManager.getConnection(DB_URL, USER, PASSWORD);
			//开启事务
			connection.setAutoCommit(false);
			//添加订单
			preparedStatement = connection
					.prepareStatement("INSERT INTO `Order` ( `buyer`, `ProductName`) VALUES (?,?)");
			preparedStatement.setString(1, buyer);
			preparedStatement.setString(2, productName);
			preparedStatement.executeUpdate();
			preparedStatement.close();

			//获取库存
			preparedStatement = connection.prepareStatement(
					" SELECT `Inventory` FROM `Inventory` WHERE `ProductName` = ?");
			preparedStatement.setString(1, productName);
			resultSet = preparedStatement.executeQuery();
			resultSet.next();
			inventory = resultSet.getInt("Inventory");
			preparedStatement.close();

			//减库存
			preparedStatement = connection.prepareStatement(
					"UPDATE `Inventory` SET `Inventory`=? WHERE `ProductName` = ?");
			preparedStatement.setInt(1, inventory - 1);
			preparedStatement.setString(2, productName);
			preparedStatement.executeUpdate();

			//提交事务
			connection.commit();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			try {
				connection.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
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
