package fr.teamA.encheres.dal;

import java.util.List;

import fr.teamA.encheres.BusinessException;
import fr.teamA.encheres.bo.Utilisateur;


public interface UtilisateurDAO {
	
	public void insert(Utilisateur utilisateur) throws BusinessException;

	public Utilisateur getUtilisateurbyPseudo(String identifiant) throws BusinessException;

	public List<String> getListePseudo() throws BusinessException;
	
	public List<String> getListeEmail() throws BusinessException;

	public Utilisateur getUtilisateurbyEmail(String identifiant) throws BusinessException;

	public List<Utilisateur> getListeUtilisateurbyPseudo()throws BusinessException;
	
	//04-07-2022 ariane
		public void update(Utilisateur utilisateur) throws BusinessException;

		
}