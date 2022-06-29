package fr.teamA.encheres.dal;

public abstract class DAOFactory {
	
	public static UtilisateurDAO getInterfaceDAO()
	{
		return new UtilisateurDaoJdbcImpl();
	}
	
}
