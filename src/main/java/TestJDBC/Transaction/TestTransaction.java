package TestJDBC.Transaction;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Savepoint;

import TestJDBC.Tool.DBTool;
import testJDBC.JDBC.TestJDBC; 

public class TestTransaction {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		transferAccount();
		TestJDBC.chaixunfei();

	}

	public static void transferAccount() {
		Connection connection = DBTool.openConn();
		PreparedStatement preparedStatement = null;
		Savepoint savepoint = null;
		try {
			connection.setAutoCommit(false);
			preparedStatement = connection.prepareStatement("update user set account = ? where username = ?");

			preparedStatement.setInt(1, 0);
			preparedStatement.setString(2, "ZhangSan");
			preparedStatement.execute();
			savepoint = connection.setSavepoint();
			preparedStatement.setInt(1, 100);
			preparedStatement.setString(2, "LiSi");
			preparedStatement.execute();
			throw new SQLException();
		} catch (SQLException e) {
			if (connection != null) {
				try {
					connection.rollback(savepoint);
					preparedStatement.setInt(1, 100);
					preparedStatement.setString(2, "ZhaoWu");
					preparedStatement.execute();
					connection.commit();
					
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
		} finally {
			try {
				if (preparedStatement != null) {
					preparedStatement.close();
				}
				DBTool.closeConn(connection);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
