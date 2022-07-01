package fr.teamA.encheres.servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.teamA.encheres.BusinessException;
import fr.teamA.encheres.bll.ArticleVenduManager;
import fr.teamA.encheres.bo.ArticleVendu;

/**
 * Servlet implementation class ServletAcceuil
 */
@WebServlet("/Acceuil")
public class ServletAcceuil extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public ServletAcceuil() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		try {
			List<ArticleVendu> listeArticleVendu = ArticleVenduManager.getInstanceArticle().venteEnCours();
				
			request.setAttribute("listeArticleVendu", listeArticleVendu);
			
			
		} catch (BusinessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
		}
		
		request.getRequestDispatcher("WEB-INF/jsp/accueil.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String contient = request.getParameter("contient");
		String categorie = request.getParameter("categorie");
		doGet(request, response);
	}

}
