package fr.teamA.encheres.servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import fr.teamA.encheres.BusinessException;
import fr.teamA.encheres.bll.UtilisateurManager;
import fr.teamA.encheres.bo.Utilisateur;

/**
 * Servlet implementation class ServletAjoutAvis
 */
@WebServlet("/ProfilCreation")
public class ServletProfilCreation extends HttpServlet {
	private static final long serialVersionUID = 1L;


	public ServletProfilCreation() {
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/jsp/AjoutProfilCreation.jsp");
		rd.forward(request, response);
	}


	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		List<Integer> listeCodesErreur = new ArrayList<>();
		String verifMDP;
	
//		HttpSession session = request.getSession();
//		session.setAttribute("sessionOK", session);
//		Cookie[] cookies = request.getCookies();

		try {
			Utilisateur utilisateur = new Utilisateur(request.getParameter("pseudo"), request.getParameter("nom"),
					request.getParameter("prenom"), request.getParameter("email"), request.getParameter("telephone"),
					request.getParameter("rue"), request.getParameter("code_postal"), request.getParameter("ville"),
					request.getParameter("motDePasse"), 0, 0);

			verifMDP = request.getParameter("verifMDP");
			
			UtilisateurManager.getInstance().ajouterUtilisateur(utilisateur, verifMDP);
			request.setAttribute("utilisateur", utilisateur);
			
		} catch (NumberFormatException e) {
			e.printStackTrace();
			listeCodesErreur.add(CodesResultatServlets.FORMAT_UTILISATEUR_ERREUR);

			request.setAttribute("listeCodesErreur", listeCodesErreur);
		} catch (BusinessException e) {
			request.setAttribute("listeCodesErreur", e.getListeCodesErreur());
			e.printStackTrace();
		}

		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/jsp/AjoutProfilCreation.jsp");
		rd.forward(request, response);
	}

}
