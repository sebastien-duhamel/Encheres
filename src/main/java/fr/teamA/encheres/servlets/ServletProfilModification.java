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
 * Servlet implementation class ServletProfilModification
 */
@WebServlet("/ProfilModification")
public class ServletProfilModification extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletProfilModification() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/jsp/ProfilModification.jsp");
		
		rd.forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		List<Integer> listeCodesErreur = new ArrayList<>();
		Utilisateur user = (Utilisateur)request.getSession().getAttribute("utilisateur");
		String mdpActuel = request.getParameter("mdpActuel");
		String verifMDP=null;
		String nouveauMDP = null;
		String mdp=null;
		String email=user.getEmail();
		String pseudo=user.getPseudo();

		verifMDP = request.getParameter("verifMDP");
		nouveauMDP = request.getParameter("mdpFutur");
		
		
		Utilisateur utilisateur=null;
		try {
			utilisateur = new Utilisateur(user.getNoUtilisateur(),request.getParameter("pseudo"), request.getParameter("nom"),
					request.getParameter("prenom"), request.getParameter("email"), request.getParameter("telephone"),
					request.getParameter("rue"), request.getParameter("code_postal"), request.getParameter("ville"),
					request.getParameter("mdpFutur"), user.getCredit(), user.getAdministrateur());
		
			UtilisateurManager.getInstance().modifierUtilisateur(utilisateur,mdpActuel, verifMDP,email,pseudo);
			request.getSession().setAttribute("utilisateur", utilisateur);
			response.sendRedirect("Accueil");
			
		} catch (NumberFormatException e) {
			e.printStackTrace();
			listeCodesErreur.add(CodesResultatServlets.FORMAT_UTILISATEUR_ERREUR);
			request.getSession().setAttribute("utilisateur", utilisateur);
			doGet(request, response);

			request.setAttribute("listeCodesErreur", listeCodesErreur);
		} catch (BusinessException e) {
			request.setAttribute("listeCodesErreur", e.getListeCodesErreur());
			e.printStackTrace();
			request.getSession().setAttribute("utilisateur", utilisateur);
			doGet(request, response);
			}
		request.getSession().setAttribute("utilisateur", utilisateur);
		
	}

}
