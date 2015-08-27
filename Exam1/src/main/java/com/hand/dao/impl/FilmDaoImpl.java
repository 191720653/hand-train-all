package com.hand.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.hand.dao.FilmDao;
import com.hand.entity.Film;

public class FilmDaoImpl implements FilmDao {

	public boolean save(Connection connection, Film film) {
		// TODO Auto-generated method stub
		String sql = "INSERT INTO film(title,description,language_id) VALUES(?,?,?)";
		System.out.println(film.toString());
		PreparedStatement preparedStatement;
		try {
			preparedStatement = connection.prepareCall(sql);
			preparedStatement.setString(1, film.getTitle());
			preparedStatement.setString(2, film.getDescription());
			preparedStatement.setInt(3, film.getLan_id());
			preparedStatement.execute();
			return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("INFO-->插入出错！"+film.getTitle());
			return false;
		}
	}

	public boolean update(Connection connection, Film film) {
		// TODO Auto-generated method stub
		String sql = "update film set title=?,description=?,language_id=? where id=?";
		System.out.println(film.toString());
		PreparedStatement preparedStatement;
		try {
			preparedStatement = connection.prepareCall(sql);
			preparedStatement.setString(1, film.getTitle());
			preparedStatement.setString(2, film.getDescription());
			preparedStatement.setInt(3, film.getLan_id());
			preparedStatement.setInt(4, film.getId());
			preparedStatement.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("INFO-->更新出错！---------");
		}
		return false;
	}

	public boolean delete(Connection connection, Film film) {
		// TODO Auto-generated method stub
		String sql = "delete from film_actor where film_id=?";
		System.out.println(film.toString());
		PreparedStatement preparedStatement;
		try {
			preparedStatement = connection.prepareCall(sql);
			preparedStatement.setInt(1, film.getId());
			preparedStatement.execute();
			sql = "delete from film_category where film_id=?";
			preparedStatement = connection.prepareCall(sql);
			preparedStatement.setInt(1, film.getId());
			preparedStatement.execute();
			sql = "delete from rental where inventory_id in (select inventory_id from inventory where film_id=?)";
			preparedStatement = connection.prepareCall(sql);
			preparedStatement.setInt(1, film.getId());
			preparedStatement.execute();
			sql = "delete from inventory where film_id=?";
			preparedStatement = connection.prepareCall(sql);
			preparedStatement.setInt(1, film.getId());
			preparedStatement.execute();
			sql = "delete from film where film_id=?";
			preparedStatement = connection.prepareCall(sql);
			preparedStatement.setInt(1, film.getId());
			preparedStatement.execute();
			return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("INFO-->删除出错！");
			return false;
		}
	}

	public Film get(Connection connection, Film film) {
		// TODO Auto-generated method stub
		String sql = "SELECT film_id,title,description,NAME FROM film,LANGUAGE WHERE film.language_id=language.language_id and film.film_id=?";
		PreparedStatement preparedStatement;
		try {
			preparedStatement = connection.prepareCall(sql);
			preparedStatement.setInt(1, film.getId());
			ResultSet resultSet = preparedStatement.executeQuery();
			Film film2 = new Film();
			
			while(resultSet.next()){
				film2.setId(resultSet.getInt("film_id"));
				film2.setLangusge(resultSet.getString("name"));
				film2.setTitle(resultSet.getString("title"));
				film2.setDescription(resultSet.getString("description"));
			}
			return film2;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("获取film信息失败！");
		}
		return null;
	}

	public List<Film> getAll(Connection connection) {
		// TODO Auto-generated method stub
		String sql = "SELECT film_id,title,description,NAME FROM film,LANGUAGE WHERE film.language_id=language.language_id";
		ResultSet resultSet = null;
		List<Film> list = new ArrayList<Film>();
		try {
			PreparedStatement preparedStatement = connection.prepareCall(sql);
			resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				Film film = new Film();
				film.setId(resultSet.getInt("film_id"));
				film.setTitle(resultSet.getString("title"));
				film.setDescription(resultSet.getString("description"));
				film.setLangusge(resultSet.getString("name"));
				list.add(film);
//				System.out.println("-------------所有Film的信息--------------");
//				System.out.print("id: " + resultSet.getString("film_id") + " | ");
//				System.out.print("name: " + resultSet.getString("title") + " | ");
//				System.out.print("password: " + resultSet.getString("description") + " | ");
//				System.out.println("address: " + resultSet.getString("name"));
			}
			resultSet.close();
			return list;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			try {
				if (resultSet != null) {
					resultSet.close();
					return list;
				}
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			System.out.println("INFO-->获取所有film信息失败！");
			return list;
		}
	}

}
