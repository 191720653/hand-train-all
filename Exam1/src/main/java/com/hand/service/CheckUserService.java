package com.hand.service;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.hand.dao.UserDao;
import com.hand.dao.impl.UserDaoImpl;
import com.hand.util.ConnectionFactory;

import net.sf.json.JSONArray;

public class CheckUserService {

	private UserDao userDao = new UserDaoImpl();

	public boolean check(String name) {
		Connection connection = null;
		try {
			connection = ConnectionFactory.getInstance().makeConnection();
			connection.setAutoCommit(false);

			boolean bool = userDao.check(connection, name);

			return bool;
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("INFO-->"+name+"查詢用戶信息失敗");
			try {
				connection.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		} finally {
			try {
				connection.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return false;
	}
	
	
}
