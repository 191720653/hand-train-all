package com.hand.servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hand.util.ConnectionFactory;

/**
 * Servlet implementation class GetLanguageServlet
 */
public class GetLanguageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public GetLanguageServlet() {
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
		Connection connection = ConnectionFactory.getInstance().makeConnection();
		List<String> list = new ArrayList<String>();
		PreparedStatement preparedStatement;
		try {
			preparedStatement = connection.prepareCall("select * from language");
			ResultSet resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				list.add(resultSet.getString("name"));
			}
			resultSet.close();
			connection.close();
			request.setAttribute("lan", list);
		} catch (Exception e) {
			// TODO: handle exception
		}
		RequestDispatcher requestDispatcher = null;
		requestDispatcher = request.getRequestDispatcher("/addFilm.jsp");
		requestDispatcher.forward(request, response);
	}

}
