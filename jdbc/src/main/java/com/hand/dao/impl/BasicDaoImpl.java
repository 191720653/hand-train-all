package com.hand.dao.impl;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.hand.dao.BasicDao;

public class BasicDaoImpl<T, ID extends Serializable> implements BasicDao<T, ID> {

	public void save(Connection connection, String sql, List<Object> values) throws SQLException {
		// TODO Auto-generated method stub
		PreparedStatement preparedStatement = connection.prepareCall(sql);
		for (int i = 1; i <= values.size(); i++) {
			preparedStatement.setObject(i, values.get(i - 1));
		}
		preparedStatement.execute();
		System.out.println("save end........................");
	}

	public void update(Connection connection, String sql, List<Object> values) throws SQLException {
		// TODO Auto-generated method stub
		PreparedStatement preparedStatement = connection.prepareCall(sql);
		for (int i = 1; i <= values.size(); i++) {
			preparedStatement.setObject(i, values.get(i - 1));
		}
		preparedStatement.executeUpdate();
		System.out.println("update end........................");
	}

	public void delete(Connection connection, String sql, List<Object> values) throws SQLException {
		// TODO Auto-generated method stub
		PreparedStatement preparedStatement = connection.prepareCall(sql);
		for (int i = 1; i <= values.size(); i++) {
			preparedStatement.setObject(i, values.get(i - 1));
		}
		preparedStatement.execute();
		System.out.println("delete end........................");
	}

	// public T queryById(Connection connection, String sql, Integer values)
	// throws SQLException {
	// // TODO Auto-generated method stub
	// PreparedStatement preparedStatement = connection.prepareCall(sql);
	// preparedStatement.setInt(1, values);
	// ResultSet resultSet = preparedStatement.executeQuery();
	// if (resultSet.next()) {
	// preparedStatement.e
	// }
	// return null;
	// }
	//
	// public T queryById(Connection connection, String sql, ID values) throws
	// SQLException {
	// // TODO Auto-generated method stub
	// return null;
	// }
	//
	// public List<T> queryAll(Connection connection, String sql) throws
	// SQLException {
	// // TODO Auto-generated method stub
	// return null;
	// }
	//
	// public List<T> query(Connection connection, String sql, List<Object>
	// values) throws SQLException {
	// // TODO Auto-generated method stub
	// return null;
	// }
}
