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

import action.CallListePartie;
import action.CallRejoindrePartie;
import model.Partie;

/**
 * Servlet implementation class RejoindrePartie
 */
public class RejoindrePartie extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Context initContext;
	private Context webContext;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public RejoindrePartie() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try{
		// TODO Auto-generated method stub
		HttpSession session = request.getSession(true);
		ExecutorService execute = Executors.newSingleThreadExecutor();
		Locale locale = (Locale) Config.get(session, Config.FMT_LOCALE);
		if (locale == null) {
			locale = request.getLocale();
		}
		if (request.getParameter("language") != null) {
			locale = new Locale(request.getParameter("language"));
		}
		Future<ArrayList<Partie>> future = (Future<ArrayList<Partie>>) execute
				.submit(new CallListePartie((Integer) session.getAttribute("user"), this.webContext));
		ArrayList<Partie> lesParties = future.get();
		if (lesParties == null) {
			System.out.println("aucune partie en cours");
			request.setAttribute("lesParties", null);
		} else {
			request.setAttribute("lesParties", lesParties);
		}
		request.getRequestDispatcher("listPartie.jsp").forward(request, response);
		}catch (Exception e){
			e.printStackTrace();
		}
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
