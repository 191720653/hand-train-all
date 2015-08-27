package com.zehao.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.sun.org.apache.regexp.internal.recompile;
import com.zehao.dao.UserDao;
import com.zehao.entity.User;

public class UserDaoImpl implements UserDao {

	@Override
	public void save(Connection connection, User user) {
		// TODO Auto-generated method stub
		String sql = "insert into users values(?,?,?)";
		System.out.println(user.toString());
		PreparedStatement preparedStatement;
		try {
			preparedStatement = connection.prepareCall(sql);
			preparedStatement.setString(1, user.getName());
			preparedStatement.setString(2, user.getPassword());
			preparedStatement.setString(3, user.getAddress());
			preparedStatement.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("---------插入出错！---------");
		}
	}

	@Override
	public void update(Connection connection, User user) {
		// TODO Auto-generated method stub
		String sql = "update users set name=?,password=?,address=? where id=?";
		System.out.println(user.toString());
		PreparedStatement preparedStatement;
		try {
			preparedStatement = connection.prepareCall(sql);
			preparedStatement.setString(1, user.getName());
			preparedStatement.setString(2, user.getPassword());
			preparedStatement.setString(3, user.getAddress());
			preparedStatement.setInt(4, user.getId());
			preparedStatement.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("---------更新出错！---------");
		}
	}

	@Override
	public void delete(Connection connection, User user) {
		// TODO Auto-generated method stub
		String sql = "delete from users where id=?";
		System.out.println(user.toString());
		PreparedStatement preparedStatement;
		try {
			preparedStatement = connection.prepareCall(sql);
			preparedStatement.setInt(1, user.getId());
			preparedStatement.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("---------删除出错！---------");
		}
	}

	@Override
	public ResultSet get(Connection connection, User user) {
		// TODO Auto-generated method stub
		String sql = "select * from users where name=? and password=?";
		PreparedStatement preparedStatement;
		try {
			preparedStatement = connection.prepareCall(sql);
			preparedStatement.setString(1, user.getName());
			preparedStatement.setString(2, user.getPassword());
			return preparedStatement.executeQuery();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("获取用户信息失败！");
		}
		return null;
	}

	@Override
	public void getAll(Connection connection) {
		// TODO Auto-generated method stub
		String sql = "select * from users";
		ResultSet resultSet = null;
		try {
			PreparedStatement preparedStatement = connection.prepareCall(sql);
			resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				System.out.println("-------------所有用户的信息--------------");
				System.out.print("id: " + resultSet.getString("id") + " | ");
				System.out.print("name: " + resultSet.getString("name") + " | ");
				System.out.print("password: " + resultSet.getString("password") + " | ");
				System.out.println("address: " + resultSet.getString("address"));
			}
			resultSet.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			try {
				if (resultSet != null) {
					resultSet.close();
				}
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			System.out.println("获取所有用户信息失败！");
		}
	}

}
