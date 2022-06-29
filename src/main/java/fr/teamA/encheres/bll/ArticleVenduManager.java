package fr.teamA.encheres.bll;

import fr.teamA.encheres.BusinessException;
import fr.teamA.encheres.bo.ArticleVendu;
import fr.teamA.encheres.dal.ArticleVenduDAO;
import fr.teamA.encheres.dal.DAOFactory;


public class ArticleVenduManager {


	/*
	 * @author Administrator
	 *
	 * Cette classe permet d'effectuer les traitements attendus sur la classe Avis
	 */

	private ArticleVenduDAO articleVenduDAO;

	/**
	 * Le constructeur permet d'initialiser la variable membre avisDAO pour
	 * permettre une communication avec la base de données.
	 */
	public ArticleVenduManager() {
		this.articleVenduDAO = DAOFactory.getArticleVenduDAO();
	}

	/**
	 * @param description
	 * @param note
	 * @return un objet Avis en cas de succcès
	 * @throws BusinessException
	 */
	public ArticleVendu ajouterArticleVendu(ArticleVendu articleVendu) throws BusinessException {
		BusinessException exception = new BusinessException();

		this.validerNomArticle(articleVendu, exception);
		this.validerDescription(articleVendu, exception);
		this.validerDateDebutEncheres(articleVendu, exception);
		this.validerDateFinEncheres(articleVendu, exception);
		this.validerMiseAPrix(articleVendu, exception);
		

		if (!exception.hasErreurs()) {
			this.articleVenduDAO.insert(articleVendu);
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


