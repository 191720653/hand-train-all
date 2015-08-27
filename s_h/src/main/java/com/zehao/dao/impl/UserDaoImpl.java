package com.zehao.dao.impl;

import org.hibernate.SessionFactory;

import com.zehao.dao.IUserDao;
import com.zehao.entity.User;

public class UserDaoImpl implements IUserDao{
	
	private SessionFactory sessionFactory;  
	  
	public void setSessionFactory(SessionFactory sessionFactory) {  
	    this.sessionFactory = sessionFactory;  
	}  
	
	public void addUser(User user) {
		// TODO Auto-generated method stub
		sessionFactory.getCurrentSession().save(user);
	}

}
