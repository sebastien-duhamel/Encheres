package fr.teamA.encheres.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
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
		request.getRequestDispatcher("WEB-INF/jsp/AfficherUtilisateur.jsp").forward(request, response);
	//	doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		
//		String pseudo = (String)request.getSession().getAttribute("MonPseudo");
		
//		try {
//			
//			Utilisateur utilisateur = UtilisateurManager.getInstance().afficherUtilisateur(pseudo);
//			System.out.println(utilisateur.toString());
//			request.setAttribute("utilisateur", utilisateur);
//			
//		} catch (BusinessException e) {
//			e.printStackTrace();
//		}
//		
//		request.getRequestDispatcher("WEB-INF/jsp/AfficherUtilisateur.jsp").forward(request, response);
		doGet(request, response);
	}
		
		
	

}
