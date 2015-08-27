package com.zehao.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	// @Override
	// public void service(ServletRequest arg0, ServletResponse arg1) throws
	// ServletException, IOException {
	// // TODO Auto-generated method stub
	//
	// String userName = arg0.getParameter("userName");
	// String password = arg0.getParameter("password");
	//
	// System.out.println("UserName-->" + userName);
	// System.out.println("Password-->" + password);
	// }

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("----------doGet---------");
		doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub

		System.out.println("----------doPost---------");

		String userName = req.getParameter("userName");
		String password = req.getParameter("password");

		System.out.println("UserName-->" + userName);
		System.out.println("Password-->" + password);

		if (userName.equals("zehao") && password.equals("123")) {
			System.out.println("--------登录成功！---------");
			// 请求重定向
			// resp.sendRedirect(req.getContextPath() +
			// "/login/login_success.jsp");
			// 请求转发
			RequestDispatcher requestDispatcher = req.getRequestDispatcher("/login/login_success.jsp");
			requestDispatcher.forward(req, resp);
		} else {
			System.out.println("-----------登录失败！------------");
			// 请求重定向
			// resp.sendRedirect(req.getContextPath() +
			// "/login/login_error.jsp");
			// 请求转发
			RequestDispatcher requestDispatcher = req.getRequestDispatcher("/login/login_error.jsp");
			requestDispatcher.forward(req, resp);
		}

	}

}
