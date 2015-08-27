package com.zehao.action;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionSupport;
import com.zehao.mysql.ConnectionFactory;

public class LoginAction extends ActionSupport {

	private String user;
	private String password;
	private String name;

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public String execute() throws Exception {
		// TODO Auto-generated method stub
		Connection connection = null;
		String sign = Action.ERROR;
		System.out.println(user+"/"+password);
		try {
			connection = ConnectionFactory.getInstance().makeConnection();

			String sql = "select * from login where user=? and password=?";
			PreparedStatement preparedStatement = connection.prepareCall(sql);
			preparedStatement.setString(1, user);
			preparedStatement.setString(2, password);
			ResultSet resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {
				name = resultSet.getString("name");
				sign = Action.SUCCESS;
			}

		} catch (Exception e) {
			// TODO: handle exception
			sign = Action.ERROR;
		} finally {
			try {
				if (connection != null) {
					connection.close();
				}
			} catch (Exception e2) {
				// TODO: handle exception
			}
		}
		return sign;
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public void validate() {
		// TODO Auto-generated method stub
		System.out.println(user+"//"+password);
		if (user == null || user.trim().equals("")) {
			addFieldError("user", "The user is required");
		}
		if (password == null || password.trim().equals("")) {
			addFieldError("password", "password is required");
		}
	}

}
