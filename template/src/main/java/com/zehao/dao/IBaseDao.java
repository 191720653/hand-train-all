package com.zehao.dao;

import java.io.Serializable;
import java.util.List;

public interface IBaseDao<T> {

	public void save(T entity);
	
	public Serializable add(T entity);

	public void update(T entity);

	public void delete(Serializable id);

	public T findById(Serializable id);

	public List<T> findByHQL(String hql, Object... params);

}
