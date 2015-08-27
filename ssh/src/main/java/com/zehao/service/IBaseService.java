package com.zehao.service;

import java.io.Serializable;
import java.util.List;
/**
 * 基本Service接口
 * @author zehao
 *
 * @param <T>
 */
public interface IBaseService<T> {

	/**
	 * 保存实体
	 * @param entity
	 */
	public void save(T entity);
	
	/**
	 * 保存实体，并返回实体的主键
	 * @param entity
	 * @return id
	 */
	public Serializable add(T entity);

	/**
	 * 更新实体
	 * @param entity
	 */
	public void update(T entity);

	/**
	 * 删除实体
	 * @param id
	 */
	public void delete(Serializable id);

	/**
	 * 根据主键查找实体
	 * @param id
	 * @return T
	 */
	public T findById(Serializable id);

	/**
	 * 根据传入的sql语句查找实体
	 * @param hql
	 * @param params
	 * @return List<T>
	 */
	public List<T> findByHQL(String hql, Object... params);

}
