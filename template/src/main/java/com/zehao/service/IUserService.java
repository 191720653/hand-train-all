package com.zehao.service;

import com.zehao.entity.Users;

public interface IUserService extends IBaseService<Users> {
	void addUser(Users user);
}
