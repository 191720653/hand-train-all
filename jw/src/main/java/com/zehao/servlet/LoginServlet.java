package com.zehao.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class LoginServlet
 */
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public LoginServlet() {
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
		String name = request.getParameter("uname");
		String password = request.getParameter("upwd");
		String returnUri = request.getParameter("return_uri");

		System.out.println("uname===>"+name);
		System.out.println("password===>"+password);
		System.out.println("returnUri===>"+returnUri);
		
		RequestDispatcher requestDispatcher = null;
		
		if(name==null||password==null){
			request.setAttribute("msg", "用户名或密码不能为空！");
			requestDispatcher = request.getRequestDispatcher("login.jsp");
			requestDispatcher.forward(request, response);
		}else{
			if(name.equals("zehao")&&password.equals("123")){
				request.getSession().setAttribute("flag", "login_success");
				if(returnUri!=null){
					requestDispatcher = request.getRequestDispatcher(returnUri);
					requestDispatcher.forward(request, response);
				}else{
					requestDispatcher = request.getRequestDispatcher("index.jsp");
					requestDispatcher.forward(request, response);
				}
			}else{
				request.getSession().setAttribute("flag", "login_error");
				request.setAttribute("msg", "用户名或密码输入错误！");
				requestDispatcher = request.getRequestDispatcher("login.jsp");
				requestDispatcher.forward(request, response);
			}
		}
		
	}

}
