package controller;

import java.io.IOException;
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

import action.CallCreerCompte;
import action.CallCreerPartie;
import model.Partie;

/**
 * Servlet implementation class CreerPartie
 */
public class CreerPartie extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Context initContext;
	private Context webContext;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public CreerPartie() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession(true);
		Locale locale = (Locale) Config.get(session, Config.FMT_LOCALE);
		if (locale == null) {
			locale = request.getLocale();
		}
		if (request.getParameter("language") != null) {
			locale = new Locale(request.getParameter("language"));
		}
		Config.set(session, Config.FMT_LOCALE, locale);
		request.getRequestDispatcher("creerPartie.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		try {
			HttpSession session = request.getSession(true);
			String action = request.getParameter("action");
			ExecutorService execute = Executors.newSingleThreadExecutor();
			// AUTHENTIFICATION
			if (action.equals("createPartie")) {
				String nomPartie = request.getParameter("inputPartie");
				int nbJoueur = Integer.parseInt(request.getParameter("nbJoueur"));
				Future<Partie> future = (Future<Partie>) execute.submit(
						new CallCreerPartie(nomPartie, nbJoueur, (int) session.getAttribute("user"), this.webContext));
				if (future.get() != null) {
					request.setAttribute("error", "false");
					response.sendRedirect("Jouer?p=" + future.get().getId());
				} else {
					request.setAttribute("error", "Echec de la création !");
					request.getRequestDispatcher("creerPartie.jsp").forward(request, response);
				}
			} else {
				doGet(request, response);
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
