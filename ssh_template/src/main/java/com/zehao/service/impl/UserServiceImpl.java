package com.zehao.service.impl;

import com.zehao.dao.IUserDao;
import com.zehao.entity.Users;
import com.zehao.service.IUserService;

public class UserServiceImpl extends BaseServiceImpl<Users>implements IUserService {

	private IUserDao userDao;

	public void setUserDao(IUserDao userDao) {
		this.userDao = userDao;
		super.setDao(userDao);
	}
}
