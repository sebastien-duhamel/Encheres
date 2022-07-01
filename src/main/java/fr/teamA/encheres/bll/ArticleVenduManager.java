package fr.teamA.encheres.bll;

import java.util.List;

import fr.teamA.encheres.BusinessException;
import fr.teamA.encheres.bo.ArticleVendu;
import fr.teamA.encheres.dal.DAOFactory;


public class ArticleVenduManager {

//
//	private ArticleVenduDAO articleVenduDAO;
//
//	
//	public ArticleVenduManager() {
//		this.articleVenduDAO = DAOFactory.getArticleVenduDAO();
//	}
	private static ArticleVenduManager instanceArticle;
	
	private ArticleVenduManager() {
		super();
	}
	
	public static ArticleVenduManager getInstanceArticle() {
		
		if (instanceArticle == null) {
			instanceArticle = new ArticleVenduManager();
		}
		
		return instanceArticle;
	}
	
	public List<ArticleVendu> venteEnCours() throws BusinessException{
		List<ArticleVendu> listeArticleVendu = DAOFactory.getArticleVenduDAO().afficherListeArticle();
		//recuperer dans la liste artcile le no_utilisateur
		
		return listeArticleVendu;
	}
	
	
	
	
	public ArticleVendu ajouterArticleVendu(ArticleVendu articleVendu) throws BusinessException {
		BusinessException exception = new BusinessException();

		validerNomArticle(articleVendu, exception);
		validerDescription(articleVendu, exception);
		validerDateDebutEncheres(articleVendu, exception);
		validerDateFinEncheres(articleVendu, exception);
		validerMiseAPrix(articleVendu, exception);
		

		if (!exception.hasErreurs()) {
			DAOFactory.getArticleVenduDAO().insert(articleVendu);
		}

		if (exception.hasErreurs()) {
			throw exception;
		}
		return articleVendu;
	}

	private void validerNomArticle(ArticleVendu articleVendu, BusinessException businessException) {

		if (articleVendu.getNomArticle() == null || articleVendu.getNomArticle().trim().length() > 30) {
			businessException.ajouterErreur(CodesResultatBLL.REGLE_FORMAT_NOM_ARTICLE_ERREUR);
		}
	}

	private void validerDescription(ArticleVendu articleVendu, BusinessException businessException) {
		if (articleVendu.getDescription() == null || articleVendu.getDescription().trim().length() > 300) {
			businessException.ajouterErreur(CodesResultatBLL.REGLE_FORMAT_DESCRIPTION_ERREUR);
		}
	}

	private void validerDateDebutEncheres(ArticleVendu articleVendu, BusinessException businessException) {
		if (articleVendu.getDateDebutEncheres() == null)
		{businessException.ajouterErreur(CodesResultatBLL.REGLE_DEBUT_ERREUR);
		}
	}

	private void validerDateFinEncheres(ArticleVendu articleVendu, BusinessException businessException) {
		if (articleVendu.getDateFinEncheres() == null) 
		{businessException.ajouterErreur(CodesResultatBLL.REGLE_FIN_ERREUR);
		}
	}

	private void validerMiseAPrix(ArticleVendu articleVendu, BusinessException businessException) {
		if (articleVendu.getMiseAPrix() == 0)
		{businessException.ajouterErreur(CodesResultatBLL.REGLE_MISE_A_PRIX_ERREUR);
		}
	}

		
	
}


