package com.hand.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hand.service.CheckUserService;

/**
 * Servlet implementation class AddServlet
 */
public class AddServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddServlet() {
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
		System.out.println("INFO-->AddServlet doPost");

		String fname = request.getParameter("first_name");
		String lname = request.getParameter("last_name");
		String emial = request.getParameter("emial");
		String address = request.getParameter("address");

		System.out.println("fname-->" + fname);
		System.out.println("lname-->" + lname);
		System.out.println("emial-->" + emial);
		System.out.println("address-->" + address);

		boolean bool = new CheckUserService().save(fname, lname, emial, address);
		System.out.println("INFO-->增加结束 " + bool);
		RequestDispatcher requestDispatcher = null;
		if (bool) {
			requestDispatcher = request.getRequestDispatcher("/index.jsp");
		} else {
			requestDispatcher = request.getRequestDispatcher("/login.jsp");
		}
		requestDispatcher.forward(request, response);
	}

}
