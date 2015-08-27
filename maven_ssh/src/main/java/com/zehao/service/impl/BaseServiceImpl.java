package com.zehao.service.impl;

import java.io.Serializable;
import java.util.List;

import org.springframework.transaction.annotation.Transactional;

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

	@Transactional("txManager")
	public void save(T entity) {
		dao.save(entity);
	}

	@Transactional("txManager")
	public void update(T entity) {
		dao.update(entity);
	}

	@Transactional("txManager")
	public void delete(Serializable id) {
		dao.delete(id);
	}

	public T findById(Serializable id) {
		return dao.findById(id);
	}

	public List<T> findByHQL(String hql, Object... params) {
		return dao.findByHQL(hql, params);
	}

	@Transactional("txManager")
	public Serializable add(T entity) {
		// TODO Auto-generated method stub
		return dao.add(entity);
	}
}
