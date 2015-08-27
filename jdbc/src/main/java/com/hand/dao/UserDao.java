package com.hand.dao;

import java.sql.Connection;
import java.sql.SQLException;

import com.hand.entity.User;

public interface UserDao extends BasicDao<User, Integer>{

//	public void save(Connection connection, User user) throws SQLException;
//
//	public void update(Connection connection, Long longId, User user) throws SQLException;
//
//	public void delete(Connection connection, User user) throws SQLException;

	public User queryByName(Connection connection, String name) throws SQLException;

	public User queryById(Connection connection, Long longId) throws SQLException;
	
	public User queryAll(Connection connection) throws SQLException;

}
