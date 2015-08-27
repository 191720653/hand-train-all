package com.hand.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hand.dao.FilmDao;
import com.hand.dao.impl.FilmDaoImpl;
import com.hand.entity.Film;
import com.hand.service.FilmService;

/**
 * Servlet implementation class ShowFilmsServlet
 */
public class ShowFilmsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ShowFilmsServlet() {
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
		System.out.println("INFO-->ShowFilmsServlet doPost");
		List<Film> list = new FilmService().getAllFilms();
		request.setAttribute("list", list);
		System.out.println("INFO-->获取Film列表结束 "+list.size());
		RequestDispatcher requestDispatcher = request.getRequestDispatcher("/showFilms.jsp");
		requestDispatcher.forward(request, response);
	}

}
