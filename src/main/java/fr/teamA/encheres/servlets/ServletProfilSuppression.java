package fr.teamA.encheres.servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.teamA.encheres.BusinessException;

import fr.teamA.encheres.bll.UtilisateurManager;

import fr.teamA.encheres.bo.Utilisateur;

/**
 * Servlet implementation class ServletProfilSupression
 */
@WebServlet("/ProfilSuppression")
public class ServletProfilSuppression extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletProfilSuppression() {
        super();
     
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doPost(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		
		
		request.setCharacterEncoding("UTF-8");
		List<Integer> listeCodesErreur = new ArrayList<>();

		Utilisateur user = (Utilisateur)request.getSession().getAttribute("utilisateur");
		String mdpActuel = request.getParameter("mdpActuel");
				
		try {
			
			UtilisateurManager.getInstance().supprimerUtilisateur(user, mdpActuel);
			
			response.sendRedirect("Accueil");
			
		} catch (NumberFormatException e) {
			e.printStackTrace();
			listeCodesErreur.add(CodesResultatServlets.SUPPRESSION_UTILISATEUR_ERREUR);

			request.setAttribute("listeCodesErreur", listeCodesErreur);
		} catch (BusinessException e) {
			request.setAttribute("listeCodesErreur", e.getListeCodesErreur());
			e.printStackTrace();
		}

		
		request.getSession().invalidate();
//		response.sendRedirect("Accueil");
	}

}
