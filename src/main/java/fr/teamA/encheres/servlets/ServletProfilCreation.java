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
@WebServlet("/ServletProfilCreation")
public class ServletProfilCreation extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ServletProfilCreation() {
		super();
		// TODO Auto-generated constructor stub
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
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		List<Integer> listeCodesErreur=new ArrayList<>();
		int noUtilisateur;
		String pseudo;
		String nom;
		String prenom;
		String email;
		String telephone;
		String rue;
		String codePostal;
		String ville;
		String motDePasse;
		String verifMDP;
		
		motDePasse = request.getParameter("mot_de_passe");
		verifMDP = request.getParameter("verifMDP");
		
////		BusinessException businessException = new BusinessException();
//		if(!motDePasse.equals(verifMDP) || verifMDP==null || motDePasse==null) {
////			businessException.ajouterErreur(CodesResultatBLL.REGLE_CONFIRMATION_MDP_ERREUR);
//			listeCodesErreur.add(CodesResultatServlets.CONFIRMATION_MDP_ERREUR);
//		}
//		
		try
		{
			System.out.println("je suis dans le try de la servletProfilCreation");
			pseudo = request.getParameter("pseudo");
			System.out.println("pseudo");

			nom = request.getParameter("nom");
			prenom = request.getParameter("prenom");
			email = request.getParameter("email");
			telephone = request.getParameter("telephone");
			rue = request.getParameter("rue");
			codePostal = request.getParameter("code_postal");
			ville = request.getParameter("ville");
			motDePasse = request.getParameter("motDePasse");
			verifMDP = request.getParameter("verifMDP");
			System.out.println();

			UtilisateurManager utilisateurManager = new UtilisateurManager();
			Utilisateur utilisateur = utilisateurManager.ajouterUtilisateur(pseudo, nom, prenom, email, telephone, rue, codePostal, ville, motDePasse);
			request.setAttribute("utilisateur", utilisateur);
		}
		catch(NumberFormatException e)
		{
			System.out.println("1er catch");
			e.printStackTrace();
			listeCodesErreur.add(CodesResultatServlets.FORMAT_UTILISATEUR_ERREUR);
			
			request.setAttribute("listeCodesErreur",listeCodesErreur);
		} catch (BusinessException e) { 
		System.out.println("2eme catch");
			request.setAttribute("listeCodesErreur", e.getListeCodesErreur());
			e.printStackTrace();
		}
		
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/jsp/AjoutProfilCreation.jsp");
		rd.forward(request, response);
	}

}
