package com.zehao.service.manager;

import com.zehao.dao.IUserDao;
import com.zehao.entity.User;
import com.zehao.service.UserService;

public class UserServiceManager implements UserService {

	private IUserDao userDao;

	public void setUserDao(IUserDao userDao) {
		this.userDao = userDao;
	}

	public void addUser(User user) {
		userDao.addUser(user);
	}

}