package com.zehao.control;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.zehao.entity.Users;
import com.zehao.service.IUserService;

@Controller
@RequestMapping("/user")
public class UserController {

	private IUserService service;

	public void setService(IUserService service) {
		this.service = service;
	}
	
	@RequestMapping(value = "/index", method = RequestMethod.GET)
	public ModelAndView index() {
		return new ModelAndView("index", "command", new Users());
	}

	@RequestMapping(value="/addUser",method = RequestMethod.POST)
	public String addUser(Users user) {

		System.out.println(user.toString());

		System.out.println("User->id: " + service.add(user));
		
		return "index";

	}

}
