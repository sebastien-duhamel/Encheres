package fr.teamA.encheres.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import fr.teamA.encheres.BusinessException;
import fr.teamA.encheres.bll.UtilisateurManager;
import fr.teamA.encheres.bo.Utilisateur;

/**
 * Servlet implementation class ServletSeConnecter
 */
@WebServlet("/seconnecter")
public class ServletSeConnecter extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	
    public ServletSeConnecter() {
        super();
       
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.getRequestDispatcher("WEB-INF/jsp/seconnecter.jsp").forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String identifiant = request.getParameter("identifiant");
		String motDePasse = request.getParameter("motDePasse");
		
		try {
			Utilisateur utilisateur = UtilisateurManager.getInstance().seConnecter(identifiant, motDePasse);
			
			request.getSession().setAttribute("utilisateur", utilisateur);
//			request.getSession().setAttribute("MonPseudo", utilisateur.getPseudo());
			response.sendRedirect("Accueil");
		} catch (BusinessException e) {
			
			request.setAttribute("listeCodesErreur", e.getListeCodesErreur());	
			doGet(request, response);
		}
	}

}
