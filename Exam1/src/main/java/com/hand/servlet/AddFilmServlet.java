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
 * Servlet implementation class AddFilmServlet
 */
public class AddFilmServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AddFilmServlet() {
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
		System.out.println("INFO-->AddFilmServlet doPost");

		String title = request.getParameter("title");
		String description = request.getParameter("description");
		String language = request.getParameter("language");

		System.out.println("title-->" + title);
		System.out.println("description-->" + description);
		System.out.println("language-->" + language);

		Film film = new Film();
		film.setLangusge(language);
		film.setTitle(title);
		film.setDescription(description);

		boolean bool = new FilmService().save(film);
		System.out.println("INFO-->增加Film结束 " + bool);
		RequestDispatcher requestDispatcher = null;
		if (bool) {
			requestDispatcher = request.getRequestDispatcher("/index.jsp");
		} else {
			requestDispatcher = request.getRequestDispatcher("/error.jsp");
		}
		requestDispatcher.forward(request, response);
	}

}
