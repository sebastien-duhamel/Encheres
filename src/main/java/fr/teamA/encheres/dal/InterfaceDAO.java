package fr.teamA.encheres.dal;

import fr.teamA.encheres.BusinessException;
import fr.teamA.encheres.bo.Utilisateur;


public interface InterfaceDAO {
	public void insert(Utilisateur utilisateur) throws BusinessException;
	
}