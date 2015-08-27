package com.zehao.dao;

import java.sql.Connection;
import java.sql.ResultSet;

import com.zehao.entity.User;

public interface UserDao {

	public void save(Connection connection, User user);

	public void update(Connection connection, User user);

	public void delete(Connection connection, User user);
	
	public ResultSet get(Connection connection, User user);
	
	public void getAll(Connection connection);

}
