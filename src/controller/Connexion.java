package controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Locale;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.jsp.jstl.core.Config;

import action.CallAuthentification;
import action.CallCreerCompte;
import action.CallListePartie;
import model.Partie;

/**
 * Servlet implementation class Accueil
 */

public class Connexion extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Context initContext;
	private Context webContext;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Connexion() {
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
		HttpSession session = request.getSession(true);
		Locale locale = (Locale) Config.get(session, Config.FMT_LOCALE);
		if (locale == null) {
			locale = request.getLocale();
		}
		if (request.getParameter("language") != null) {
			locale = new Locale(request.getParameter("language"));
		}
		Config.set(session, Config.FMT_LOCALE, locale);
		request.getRequestDispatcher("index.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			ExecutorService execute = Executors.newSingleThreadExecutor();
			HttpSession session = request.getSession(true);
			String action = request.getParameter("action");
			//AUTHENTIFICATION
			if (action.equals("auth")) {
				String login = request.getParameter("login");
				String mdp = request.getParameter("mdp");
				Future<Integer> future = (Future<Integer>) execute
						.submit(new CallAuthentification(login,mdp, this.webContext));
				Integer idUser = future.get();
				if ( idUser >= 0) {
					session.setAttribute("user", idUser);
					response.sendRedirect("Accueil");
				} else {
					request.setAttribute("errorAuth", "true");
					request.getRequestDispatcher("index.jsp").forward(request, response);
				}
			//CREATION COMPTE
			} else if (action.equals("newAcc")) {
				String login = request.getParameter("inputLogin");
				String mdp = request.getParameter("inputPassword");
				Future<Boolean> future = (Future<Boolean>) execute
						.submit(new CallCreerCompte(login,mdp, this.webContext));
				if (future.get()) {
					session.setAttribute("errorNewAcc", "false");
					request.getRequestDispatcher("index.jsp").forward(request, response);
				} else {
					session.setAttribute("errorNewAcc", "true");
					request.getRequestDispatcher("index.jsp").forward(request, response);
				}
			//USER ALREADY LOGGED	
			} else if (session.getAttribute("user") == null) {
				request.getRequestDispatcher("index.jsp").forward(request, response);
			} else {
				request.getRequestDispatcher("Accueil").forward(request, response);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void init(ServletConfig config) throws ServletException {
		try {
			this.initContext = new InitialContext();
			this.webContext = (Context) initContext.lookup("java:/comp/env");
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
