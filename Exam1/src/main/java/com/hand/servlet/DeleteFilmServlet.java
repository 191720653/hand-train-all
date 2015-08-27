package com.hand.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hand.entity.Film;
import com.hand.service.FilmService;

/**
 * Servlet implementation class DeleteFilmServlet
 */
public class DeleteFilmServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public DeleteFilmServlet() {
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
		System.out.println("INFO-->DeleteFilmServlet doPost");

		int id = Integer.parseInt(request.getParameter("id"));

		System.out.println("film_id-->" + id);

		Film film = new Film();
		film.setId(id);

		boolean bool = new FilmService().delete(film);
		System.out.println("INFO-->删除Film结束 " + bool);
		RequestDispatcher requestDispatcher = null;
		if (bool) {
			requestDispatcher = request.getRequestDispatcher("/index.jsp");
		} else {
			requestDispatcher = request.getRequestDispatcher("/error.jsp");
		}
		requestDispatcher.forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
