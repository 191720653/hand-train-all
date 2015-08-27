package com.zehao.action;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionSupport;
import com.zehao.entity.Users;
import com.zehao.service.IUserService;

public class UserAction extends ActionSupport {

	private static final long serialVersionUID = 1L;

	private IUserService iUserService;
	private Users users;

	public void setiUserService(IUserService iUserService) {
		this.iUserService = iUserService;
	}

	public void setUsers(Users users) {
		this.users = users;
	}

	public Users getUsers() {
		return users;
	}

	public String addUsers() {
		int id = 0;
		try {
			id = (Integer) iUserService.add(users);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return Action.ERROR;
		}
//		int i = 8 / 0;
		System.out.println("----------addUsers-success->id: " + id + "----------");
		return Action.SUCCESS;
	}

}
