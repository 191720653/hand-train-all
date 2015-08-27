package com.zehao.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.zehao.entity.User;
import com.zehao.service.CheckUserService;

/**
 * Servlet implementation class CheckServlet
 */
//@WebServlet("/CheckServlet")
public class CheckServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private CheckUserService checkUserService = new CheckUserService();

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public CheckServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		String userName = request.getParameter("uname");
		String password = request.getParameter("upwd");

		String forward = null;
		RequestDispatcher requestDispatcher = null;

		if (userName == null || password == null) {
			request.setAttribute("message", "用户名或密码为空！");
			requestDispatcher = request.getRequestDispatcher("/check/error.jsp");
			requestDispatcher.forward(request, response);
		} else {
			User user = new User();
			user.setName(userName);
			user.setPassword(password);
			boolean sign = checkUserService.check(user);
			if (sign) {
				forward = "/check/check_success.jsp";
			} else {
				request.setAttribute("message", "用户不存在或用户密码错误！");
				forward = "/check/error.jsp";
			}
			requestDispatcher = request.getRequestDispatcher(forward);
			requestDispatcher.forward(request, response);

		}

	}

}
