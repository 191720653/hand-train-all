package com.hand.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.hand.dao.FilmDao;
import com.hand.dao.impl.FilmDaoImpl;
import com.hand.entity.Film;
import com.hand.util.ConnectionFactory;

public class FilmService {
	
	FilmDao filmDao = new FilmDaoImpl();
	
	public List<Film> getAllFilms() {
		Connection connection = null;
		try {
			connection = ConnectionFactory.getInstance().makeConnection();
			connection.setAutoCommit(false);

			List<Film> list = filmDao.getAll(connection);

			return list;
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("INFO-->获取Films数据出错");
			try {
				connection.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		} finally {
			try {
				connection.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return new ArrayList<Film>();
	}
	
	public boolean save(Film film) {
		Connection connection = null;
		boolean bool = false;
		try {
			connection = ConnectionFactory.getInstance().makeConnection();
			connection.setAutoCommit(false);
			PreparedStatement preparedStatement = connection.prepareStatement("select * from language where name=?");
			preparedStatement.setString(1, film.getLangusge());
			ResultSet resultSet = preparedStatement.executeQuery();
			resultSet.next();
			
			int lan_id = resultSet.getInt("language_id");
			film.setLan_id(lan_id);
			
			resultSet.close();

			bool = filmDao.save(connection, film);

			return bool;
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("INFO-->获取Films数据出错");
			try {
				connection.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		} finally {
			try {
				connection.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return bool;
	}
	
	public boolean update(Film film) {
		Connection connection = null;
		boolean bool = false;
		try {
			connection = ConnectionFactory.getInstance().makeConnection();
			connection.setAutoCommit(false);
			PreparedStatement preparedStatement = connection.prepareStatement("select * from language where name=?");
			preparedStatement.setString(1, film.getLangusge());
			ResultSet resultSet = preparedStatement.executeQuery();
			resultSet.next();
			
			int lan_id = resultSet.getInt("language_id");
			film.setLan_id(lan_id);
			
			resultSet.close();

			bool = filmDao.save(connection, film);

			return bool;
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("INFO-->获取Films数据出错");
			try {
				connection.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		} finally {
			try {
				connection.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return bool;
	}
	
	public boolean delete(Film film) {
		Connection connection = null;
		boolean bool = false;
		try {
			connection = ConnectionFactory.getInstance().makeConnection();
			connection.setAutoCommit(false);

			bool = filmDao.delete(connection, film);

			return bool;
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("INFO-->删除Film数据出错");
			try {
				connection.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		} finally {
			try {
				connection.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return bool;
	}
	
	public Film get(Film film) {
		Connection connection = null;
		Film film2 = null;
		try {
			connection = ConnectionFactory.getInstance().makeConnection();
			connection.setAutoCommit(false);

			film2 = filmDao.get(connection, film);

			return film2;
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("INFO-->獲取Film数据出错");
			try {
				connection.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		} finally {
			try {
				connection.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return null;
	}

}
