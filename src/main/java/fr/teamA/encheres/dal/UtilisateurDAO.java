package fr.teamA.encheres.dal;

import java.util.List;

import fr.teamA.encheres.BusinessException;
import fr.teamA.encheres.bo.Utilisateur;


public interface UtilisateurDAO {
	
	public void insert(Utilisateur utilisateur) throws BusinessException;

	public Utilisateur getUtilisateurbyPseudo(String identifiant) throws BusinessException;

	List<String> getListePseudo() throws BusinessException;
	List<String> getListeEmail() throws BusinessException;
		
}