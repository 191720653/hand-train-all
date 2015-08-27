package com.zehao.control;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.zehao.entity.User;
import com.zehao.service.UserService;

@Controller
@RequestMapping("/user")
public class UserController {

	private UserService service;

	@RequestMapping("/addUser")
	public void addUser() {

		User user = new User();
		user.setAddress("");
		user.setName("");
		user.setPassword("");
		user.setId(0);

		service.addUser(user);

	}

}
