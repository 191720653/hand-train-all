package com.hand.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.hand.dao.UserDao;

public class UserDaoImpl implements UserDao {

	public boolean check(Connection connection, String name) {
		// TODO Auto-generated method stub
		String sql = "select * from customer where first_name=?";
		PreparedStatement preparedStatement;
		try {
			preparedStatement = connection.prepareCall(sql);
			preparedStatement.setString(1, name);
			return preparedStatement.executeQuery().next();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("INFO-->"+name+"查詢用戶信息失敗");
		}
		return false;
	}

}
