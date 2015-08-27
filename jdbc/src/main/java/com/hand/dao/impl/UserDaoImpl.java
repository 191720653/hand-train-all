package com.hand.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.hand.dao.UserDao;
import com.hand.entity.User;

public class UserDaoImpl extends BasicDaoImpl<User, Integer>implements UserDao {

	public void save(Connection connection, User user) throws SQLException {
		// TODO Auto-generated method stub
		PreparedStatement preparedStatement = connection
				.prepareCall("insert into users(name, password, address) values(?,?,?)");
		preparedStatement.setString(1, user.getName());
		preparedStatement.setString(2, user.getPassword());
		preparedStatement.setString(3, user.getAddredss());
		preparedStatement.execute();

	}

	public void update(Connection connection, Long longId, User user) throws SQLException {
		// TODO Auto-generated method stub

		String sql = "update users set name=?,password=?,address=? where id=?";
		PreparedStatement preparedStatement = connection.prepareCall(sql);
		preparedStatement.setString(1, user.getName());
		preparedStatement.setString(2, user.getPassword());
		preparedStatement.setString(3, user.getAddredss());
		preparedStatement.setLong(4, user.getId());
		preparedStatement.executeUpdate();

	}

	public void delete(Connection connection, User user) throws SQLException {
		// TODO Auto-generated method stub

		String sql = "delete from users where id=?";
		PreparedStatement preparedStatement = connection.prepareCall(sql);
		preparedStatement.setLong(1, user.getId());
		preparedStatement.execute();

	}

	public User queryById(Connection connection, Long longId) throws SQLException {
		// TODO Auto-generated method stub
		String sql = "select * from users where id=?";
		PreparedStatement preparedStatement = connection.prepareCall(sql);
		preparedStatement.setLong(1, longId);
		ResultSet resultSet = preparedStatement.executeQuery();
		User user = new User();
		user.setId(resultSet.getLong("id"));
		user.setName(resultSet.getString("name"));
		user.setPassword(resultSet.getString("password"));
		user.setAddredss(resultSet.getString("address"));
		resultSet.close();
		System.out.println("queryById end................");
		return user;
	}

	public User queryByName(Connection connection, String name) throws SQLException {
		// TODO Auto-generated method stub
		String sql = "select * from users where name=?";
		PreparedStatement preparedStatement = connection.prepareCall(sql);
		preparedStatement.setString(1, name);
		ResultSet resultSet = preparedStatement.executeQuery();
		if (resultSet.next()) {
			User user = new User();
			user.setId(resultSet.getLong("id"));
			user.setName(resultSet.getString("name"));
			user.setPassword(resultSet.getString("password"));
			user.setAddredss(resultSet.getString("address"));
			resultSet.close();
			System.out.println("queryByName end................");
			return user;
		} else {
			resultSet.close();
			System.out.println("queryByName end................");
			return null;
		}

	}

	public User queryAll(Connection connection) throws SQLException {
		// TODO Auto-generated method stub
		String sql = "select * from users";
		PreparedStatement preparedStatement = connection.prepareCall(sql);
		ResultSet resultSet = preparedStatement.executeQuery();
		while (resultSet.next()) {
			System.out.println("--------------------------------------");
			System.out.print("id：" + resultSet.getLong("id"));
			System.out.print("\tname：" + resultSet.getString("name"));
			System.out.print("\tpassword：" + resultSet.getString("password"));
			System.out.println("\taddress：" + resultSet.getString("address"));
		}
		resultSet.close();
		System.out.println("queryall end...............");
		return null;
	}

}
