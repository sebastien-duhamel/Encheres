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
 * Servlet implementation class ServletProfilSupression
 */
@WebServlet("/ProfilSupression")
public class ServletProfilSupression extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletProfilSupression() {
        super();
     
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/jsp/ProfilSuppression.jsp");
		rd.forward(request, response);
	
		response.sendRedirect("Accueil");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		List<Integer> listeCodesErreur = new ArrayList<>();
		
		Utilisateur noUtilisateur = (Utilisateur)request.getSession().getAttribute("NoUtilisateur");
		
		try {
			
			Utilisateur utilisateur = UtilisateurManager.getInstance().supprimerUtilisateur(noUtilisateur);
			request.getSession().setAttribute("utilisateur", utilisateur);
			response.sendRedirect("Accueil");
			
		} catch (NumberFormatException e) {
			e.printStackTrace();
			listeCodesErreur.add(CodesResultatServlets.FORMAT_UTILISATEUR_ERREUR);

			request.setAttribute("listeCodesErreur", listeCodesErreur);
		} catch (BusinessException e) {
			request.setAttribute("listeCodesErreur", e.getListeCodesErreur());
			e.printStackTrace();
		}

		
		request.getSession().invalidate();
		response.sendRedirect("Accueil");
	}

}
