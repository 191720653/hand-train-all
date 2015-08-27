package com.zehao.service.impl;

import java.io.Serializable;
import java.util.List;

import com.zehao.dao.IBaseDao;
import com.zehao.service.IBaseService;

public class BaseServiceImpl<T> implements IBaseService<T> {
	/**
	 * 注入BaseDao
	 */
	protected IBaseDao<T> dao;

	public void setDao(IBaseDao<T> dao) {
		this.dao = dao;
	}

	public void save(T entity) {
		dao.save(entity);
	}

	public void update(T entity) {
		dao.update(entity);
	}

	public void delete(Serializable id) {
		dao.delete(id);
	}

	public T findById(Serializable id) {
		return dao.findById(id);
	}

	public List<T> findByHQL(String hql, Object... params) {
		return dao.findByHQL(hql, params);
	}

	public Serializable add(T entity) {
		// TODO Auto-generated method stub
		return dao.add(entity);
	}
}
