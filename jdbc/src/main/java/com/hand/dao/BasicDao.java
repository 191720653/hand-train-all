package com.hand.dao;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public interface BasicDao<T, ID extends Serializable> {

	public void save(Connection connection, String sql, List<Object> values) throws SQLException;

	public void update(Connection connection, String sql, List<Object> values) throws SQLException;

	public void delete(Connection connection, String sql, List<Object> values) throws SQLException;

//	public T queryById(Connection connection, String sql, ID values) throws SQLException;
//
//	public List<T> queryAll(Connection connection, String sql) throws SQLException;
//
//	public List<T> query(Connection connection, String sql, List<Object> values) throws SQLException;

}
