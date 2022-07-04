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
 * Servlet implementation class ServletAfficherUtilisateur
 */
@WebServlet("/AfficherUtilisateur")
public class ServletAfficherUtilisateur extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletAfficherUtilisateur() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//request.getRequestDispatcher("WEB-INF/jsp/AfficherUtilisateur.jsp").forward(request, response);
		
//		Utilisateur utilisateur = (Utilisateur) response.("utilisateur");
//		System.out.println(utilisateur.getPseudo());
//		try {
//			
//			UtilisateurManager.getInstance().afficherUtilisateur(utilisateur.getPseudo());
//			//request.setAttribute("utilisateur", utilisateur);
//		} catch (BusinessException e) {
//			e.printStackTrace();
//		}
		
		request.getRequestDispatcher("WEB-INF/jsp/AfficherUtilisateur.jsp").forward(request, response);
		//doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
//		try {
//			Utilisateur utilisateur = UtilisateurManager.getInstance().afficherUtilisateur("leboss");
//			request.setAttribute("utilisateur", utilisateur);
//		} catch (BusinessException e) {
//			e.printStackTrace();
//		}
		
		request.getRequestDispatcher("WEB-INF/jsp/AfficherUtilisateur.jsp").forward(request, response);
	}

}
