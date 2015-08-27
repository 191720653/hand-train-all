package com.zehao.dao.impl;

import org.hibernate.SessionFactory;

import com.zehao.dao.IUserDao;
import com.zehao.entity.Users;

public class UserDaoImpl extends BaseDaoImpl<Users> implements IUserDao{
	
	/**
	 * 向DAO层注入SessionFactory
	 */
	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
		super.setSessionFactory(sessionFactory);
	}
	
	public void addUser(Users user) {
		// TODO Auto-generated method stub
		this.sessionFactory.getCurrentSession().save(user);
	}

}
