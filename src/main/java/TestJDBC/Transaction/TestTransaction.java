package TestJDBC.Transaction;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import TestJDBC.Tool.DBTool;

public class TestTransaction {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public static void transferAccount() {
		Connection connection = DBTool.openConn();
		try {
			PreparedStatement preparedStatement = connection
					.prepareStatement("update user set account = ? where username = ?");
			
			preparedStatement.setInt(1,0);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
