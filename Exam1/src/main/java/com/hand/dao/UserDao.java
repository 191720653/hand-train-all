package com.hand.dao;

import java.sql.Connection;

public interface UserDao {

	public boolean check(Connection connection, String name);

}
