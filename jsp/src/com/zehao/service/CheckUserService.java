package com.zehao.service;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.zehao.dao.UserDao;
import com.zehao.dao.impl.UserDaoImpl;
import com.zehao.entity.User;
import com.zehao.util.ConnectionFactory;

public class CheckUserService {

	private UserDao userDao = new UserDaoImpl();

	public boolean check(User user) {
		Connection connection = null;
		try {
			connection = ConnectionFactory.getInstance().makeConnection();
			connection.setAutoCommit(false);

			ResultSet resultSet = userDao.get(connection, user);

			if (resultSet == null) {
				return false;
			} else {
				while (resultSet.next()) {
					return true;
				}
			}
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("获取用户数据出错！");
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
