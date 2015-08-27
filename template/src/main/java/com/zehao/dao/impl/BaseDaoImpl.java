package com.zehao.dao.impl;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.zehao.dao.IBaseDao;

public class BaseDaoImpl<T> implements IBaseDao<T> {
	private Class<T> clazz;

	/**
	 * 通过构造方法指定DAO的具体实现类
	 */
	@SuppressWarnings("unchecked")
	public BaseDaoImpl() {
		ParameterizedType type = (ParameterizedType) this.getClass().getGenericSuperclass();
		clazz = (Class<T>) type.getActualTypeArguments()[0];
		System.out.println("DAO的真实实现类是：" + this.clazz.getName());
	}

	/**
	 * 向DAO层注入SessionFactory
	 */
	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	/**
	 * 获取当前工作的Session
	 */
	protected Session getSession() {
		return this.sessionFactory.getCurrentSession();
	}

	public void save(T entity) {
		this.getSession().save(entity);
	}

	public void update(T entity) {
		this.getSession().update(entity);
	}

	public void delete(Serializable id) {
		this.getSession().delete(this.findById(id));
	}

	@SuppressWarnings("unchecked")
	public T findById(Serializable id) {
		return (T) this.getSession().get(this.clazz, id);
	}

	@SuppressWarnings("unchecked")
	public List<T> findByHQL(String hql, Object... params) {
		Query query = this.getSession().createQuery(hql);
		for (int i = 0; params != null && i < params.length; i++) {
			query.setParameter(i, params);
		}
		return (List<T>) query.list();
	}

	public Serializable add(T entity) {
		// TODO Auto-generated method stub
		return this.getSession().save(entity);
	}
}
