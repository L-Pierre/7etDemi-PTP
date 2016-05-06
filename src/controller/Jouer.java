package controller;

import java.io.IOException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Jouer
 */

public class Jouer extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Context initContext;
	private Context webContext;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Jouer() {
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
		request.getRequestDispatcher("jouer.jsp").forward(request, response);
	}

	@Override
	public void init(ServletConfig config) throws ServletException {
		try {
			this.initContext = new InitialContext();
			this.webContext = (Context) initContext.lookup("java:/comp/env");
		} catch (NamingException e) {
			e.printStackTrace();
		}
	}
}
