package com.hand.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.hand.dao.UserDao;
import com.hand.dao.impl.UserDaoImpl;
import com.hand.entity.User;
import com.hand.util.ConnectionFactory;

/**
 * Hello world!
 *
 */
public class App {
	public static void main(String[] args) {
		System.out.println("Hello World!");

		String query = "select * from users";
		String update = "update users set password='ovo' where id=3";
		// insert into users valses(4, 'zheng', 'zheng', 'Guangzhou');
		String inseert = "insert into users values(5, 'abc', 'abc', 'abc');";
		String delete = "delete from users where name='abc'";
		Connection connection = null;
		Statement statement = null;
		ResultSet resultSet = null;

		try {
			// Class.forName("com.mysql.jdbc.Driver");
			// connection =
			// DriverManager.getConnection("jdbc:mysql://localhost:3306/test",
			// "root", "");

			// 采用ConnectionFactory获取connection
			ConnectionFactory factory = ConnectionFactory.getInstance();
			connection = factory.makeConnection();

			connection.setAutoCommit(false);

			// 采用Dao进行增删改查
			User user = new User();
			user.setName("test");
			user.setPassword("test");
			user.setAddredss("testtest");

			UserDao userDao = new UserDaoImpl();

			List<Object> values = new ArrayList<Object>();
			values.add("test");
			values.add("test");
			values.add("testtest");
			String sql = "insert into users(name, password, address) values(?,?,?);";
			userDao.save(connection, sql, values);
			userDao.queryAll(connection);

			User queryUser = userDao.queryByName(connection, user.getName());

			user.setId(queryUser.getId());
			user.setAddredss("test");
			values.remove(2);
			values.add(2, "Ok!");
			values.add(queryUser.getId());
			// System.out.println(user.getId() + user.getAddredss());
			sql = "update users set name=?,password=?,address=? where id=?";
			userDao.update(connection, sql, values);
			userDao.queryAll(connection);

			values.clear();
			values.add(queryUser.getId());
			sql = "delete from users where id=?";
			userDao.delete(connection, sql, values);
			userDao.queryAll(connection);

			// 普通模式
			statement = connection.createStatement();

			int count = statement.executeUpdate(update);

			System.out.println("更新了" + count + "条记录！");

			count = statement.executeUpdate(inseert);

			System.out.println("插入了" + count + "条记录！");

			count = statement.executeUpdate(delete);

			System.out.println("删除了" + count + "条记录！");

			resultSet = statement.executeQuery(query);
			while (resultSet.next()) {
				System.out.println("------------------------------------------------");
				System.out.print("id：" + resultSet.getInt("id") + "|");
				System.out.print("name：" + resultSet.getString("name") + "|");
				System.out.print("password：" + resultSet.getString("password") + "|");
				System.out.print("address：" + resultSet.getString("address") + "|");
				System.out.println();
			}

			connection.commit();
		}
		// catch (ClassNotFoundException e) {
		// // TODO Auto-generated catch block
		// e.printStackTrace();
		// System.out.println("--------捕获异常--------");
		// try {
		// connection.rollback();
		// System.out.println("--------回滚成功--------");
		// } catch (SQLException e1) {
		// // TODO Auto-generated catch block
		// e1.printStackTrace();
		// }
		// }
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("--------捕获异常--------");
			try {
				connection.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			System.out.println("--------回滚成功--------");
		} finally {
			try {
				resultSet.close();
				statement.close();
				connection.close();
				System.out.println("--------The End--------");
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}

	}
}
