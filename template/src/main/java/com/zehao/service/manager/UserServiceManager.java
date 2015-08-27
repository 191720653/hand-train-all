package com.zehao.service.manager;

import com.zehao.dao.IUserDao;
import com.zehao.entity.Users;
import com.zehao.service.IUserService;

public class UserServiceManager extends BaseServiceManager<Users> implements IUserService {

	private IUserDao userDao;

	public void setUserDao(IUserDao userDao) {
		this.userDao = userDao;
		super.setDao(userDao);
	}

	public void addUser(Users user) {
		userDao.addUser(user);
	}

}