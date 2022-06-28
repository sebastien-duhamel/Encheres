package fr.teamA.encheres.dal;

public abstract class DAOFactory {
	
	public static InterfaceDAO getInterfaceDAO()
	{
		return new DaoJdbcImpl();
	}
}
