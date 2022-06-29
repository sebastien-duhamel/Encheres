package fr.teamA.encheres.dal;

public abstract class DAOFactory {
	
	public static UtilisateurDAO getUtilisateurDAO()
	{
		return new UtilisateurDaoJdbcImpl();
	}
	
	public static ArticleVenduDAO getArticleVenduDAO()
	{
		return new ArticleVenduDaoJdbcImpl();
	}
	
}
