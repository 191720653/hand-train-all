package com.hand.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hand.service.CheckUserService;

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
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("INFO-->loginservlet doPost");

		String name = request.getParameter("uname");
		String returnUri = request.getParameter("return_uri");

		System.out.println("uname==>"+name);
		System.out.println("returnUri==>"+returnUri);
		
		RequestDispatcher requestDispatcher = null;
		
		if(name==null){
			requestDispatcher = request.getRequestDispatcher("login.jsp");
			requestDispatcher.forward(request, response);
		}else{
			boolean bool = new CheckUserService().check(name);
			if(bool){
				System.out.println("INFO-->"+name+"登录成功");
				request.getSession().setAttribute("flag", "success");
				if(returnUri!=null){
//					if(returnUri.indexOf(".")<0){
//						returnUri = request.getContextPath()+returnUri;
//					}
					requestDispatcher = request.getRequestDispatcher(returnUri);
					requestDispatcher.forward(request, response);
				}else{
					requestDispatcher = request.getRequestDispatcher("index.jsp");
					requestDispatcher.forward(request, response);
				}
			}else{
				System.out.println("INFO-->"+name+"登录失败");
				request.getSession().setAttribute("flag", "error");
				requestDispatcher = request.getRequestDispatcher("login.jsp");
				requestDispatcher.forward(request, response);
			}
		}
	}

}
