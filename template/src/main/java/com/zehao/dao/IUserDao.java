package com.zehao.dao;

import com.zehao.entity.Users;

public interface IUserDao extends IBaseDao<Users>{
	
	void addUser(Users user);

}
