package com.hand.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.util.List;

import com.hand.entity.Film;

public interface FilmDao {

	public boolean save(Connection connection, Film film);

	public boolean update(Connection connection, Film film);

	public boolean delete(Connection connection, Film film);
	
	public Film get(Connection connection, Film film);
	
	public List<Film> getAll(Connection connection);

}
