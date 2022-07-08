package fr.teamA.encheres.bll;

import java.util.ArrayList;
import java.util.List;


import fr.teamA.encheres.BusinessException;
import fr.teamA.encheres.bo.Utilisateur;
import fr.teamA.encheres.dal.DAOFactory;

public class UtilisateurManager {

	private static UtilisateurManager instance;

	private UtilisateurManager() {
		super();
	}

	public static UtilisateurManager getInstance() {

		if (instance == null) {
			instance = new UtilisateurManager();
		}

		return instance;
	}

	public Utilisateur seConnecter(String identifiant, String motDePasse) throws BusinessException {
		Utilisateur utilisateur = null;
		if (identifiant.contains("@")) {
			utilisateur = DAOFactory.getUtilisateurDAO().getUtilisateurbyEmail(identifiant);
		} else {
			utilisateur = DAOFactory.getUtilisateurDAO().getUtilisateurbyPseudo(identifiant);
		}

		if (utilisateur == null || !motDePasse.equals(utilisateur.getMotDePasse())) {
			BusinessException businessException = new BusinessException();
			businessException.ajouterErreur(CodesResultatBLL.IDENTIFIANT_KO);
			throw businessException;

		}
		return utilisateur;
	}

	public Utilisateur ajouterUtilisateur(Utilisateur utilisateur, String verifMDP) throws BusinessException {
		BusinessException exception = new BusinessException();

		validerPseudo(utilisateur, exception);
		validerNom(utilisateur, exception);
		validerPrenom(utilisateur, exception);
		validerEmail(utilisateur, exception);
		validerTelephone(utilisateur, exception);
		validerRue(utilisateur, exception);
		validerCodePostal(utilisateur, exception);
		validerVille(utilisateur, exception);
		validerMotDePasse(utilisateur, verifMDP, exception);

		if (!exception.hasErreurs()) {

			DAOFactory.getUtilisateurDAO().insert(utilisateur);
		}

		if (exception.hasErreurs()) {
			throw exception;
		}
		return utilisateur;
	}

	public List<Utilisateur> afficherUtilisateur() throws BusinessException {
		BusinessException businessException = new BusinessException();
		List<Utilisateur> listeUtilisateur = DAOFactory.getUtilisateurDAO().getListeUtilisateurbyPseudo();
		if(listeUtilisateur==null) {
			businessException.ajouterErreur(CodesResultatBLL.REGLE_ERREUR_IMPREVU);
			throw businessException;
		}
		return listeUtilisateur;
	}

	public Utilisateur afficherUtilisateur(String pseudo) throws BusinessException {
		BusinessException businessException = new BusinessException();
		List<Utilisateur> listeUtilisateur = DAOFactory.getUtilisateurDAO().getListeUtilisateurbyPseudo();
		Utilisateur vendeur =null;

		if(listeUtilisateur==null) {
			businessException.ajouterErreur(CodesResultatBLL.REGLE_ERREUR_IMPREVU);
			throw businessException;
		}
		
		for (Utilisateur user : listeUtilisateur) {
			if (user.getPseudo().equals(pseudo)) {
				vendeur=user;
			}
		}
		if(vendeur==null) {
			businessException.ajouterErreur(CodesResultatBLL.REGLE_ERREUR_IMPREVU);
			throw businessException;
		}
		return vendeur;
	}
	

	//supprimer un utilisateur

    public void supprimerUtilisateur(int noUtilisateur) throws BusinessException {
    	
		BusinessException exception = new BusinessException();
		

		if (!exception.hasErreurs()) {
			
			DAOFactory.getUtilisateurDAO().delete(noUtilisateur);
		}

		if (exception.hasErreurs()) {
			throw exception;
		}
	
	}


/*
 * Methode modifier utilsateur prend en paramètre le mot de passe à vérifier
 * compare l'ancien email avec le nouveau s'il est modifier
 * compare l'ancien pseudo avec le nouveau s"il est modifier
 */
    
    public  void  modifierUtilisateur(Utilisateur utilisateur,String mdpActuel, String verifMDP,  String email, String pseudo) throws BusinessException {
  
    	BusinessException exception = new BusinessException();
    	
			
    	validerPseudoModification(utilisateur,pseudo, exception);
    	validerNom(utilisateur, exception);
    	validerPrenom(utilisateur, exception);
    	validerEmailModification(utilisateur,email, exception);
    	validerTelephone(utilisateur, exception);
    	validerRue(utilisateur, exception);
    	validerCodePostal(utilisateur, exception);
    	validerVille(utilisateur, exception);
    	validerMotDePasseModification(utilisateur, mdpActuel, verifMDP, exception);
    	

    	if (!exception.hasErreurs()) {
    	    DAOFactory.getUtilisateurDAO().update(utilisateur);
    	}

    	if (exception.hasErreurs()) {
    	    throw exception;
    	}

}

	private void validerPseudo(Utilisateur utilisateur, BusinessException businessException) {
		List<String> listePseudo = new ArrayList<>();
		

		try {
			listePseudo = DAOFactory.getUtilisateurDAO().getListePseudo();
		} catch (BusinessException e) {
			businessException.ajouterErreur(CodesResultatBLL.REGLE_ERREUR_IMPREVU);
			e.printStackTrace();
		}
		if (utilisateur.getPseudo() == null || utilisateur.getPseudo().trim().equals("")
				|| !utilisateur.getPseudo().chars().allMatch(Character::isLetterOrDigit)
				|| utilisateur.getPseudo().trim().length() > 30) {
			businessException.ajouterErreur(CodesResultatBLL.REGLE_FORMAT_PSEUDO_ERREUR);
		}
		if (listePseudo.contains(utilisateur.getPseudo())) {
			businessException.ajouterErreur(CodesResultatBLL.REGLE_PSEUDO_DEJA_EXISTANT);
		}
		//
		
	}
	

	private void validerPseudoModification(Utilisateur utilisateur,String pseudo ,BusinessException businessException) {
    	List<String> listePseudoAvant = new ArrayList<>();
    	List<String> listePseudoApres = new ArrayList<>();
    	
		try {
			listePseudoAvant = DAOFactory.getUtilisateurDAO().getListePseudo();
		} catch (BusinessException e) {
			businessException.ajouterErreur(CodesResultatBLL.REGLE_ERREUR_IMPREVU);
			e.printStackTrace();
		}
		
		for (String string : listePseudoAvant) {
			if(!pseudo.equals(string)) {
				
				listePseudoApres.add(string);
			}
		}
		if (listePseudoApres.contains(utilisateur.getPseudo())) {
			businessException.ajouterErreur(CodesResultatBLL.REGLE_PSEUDO_DEJA_EXISTANT);
		}
	
		if (utilisateur.getPseudo() == null || utilisateur.getPseudo().trim().equals("")
				|| !utilisateur.getPseudo().chars().allMatch(Character::isLetterOrDigit)
				|| utilisateur.getPseudo().trim().length() > 30) {
			businessException.ajouterErreur(CodesResultatBLL.REGLE_FORMAT_PSEUDO_ERREUR);
		}
				
	}

	private void validerNom(Utilisateur utilisateur, BusinessException businessException) {
		if (utilisateur.getNom() == null || utilisateur.getNom().trim().equals("")
				|| utilisateur.getNom().trim().length() > 30) {
			businessException.ajouterErreur(CodesResultatBLL.REGLE_FORMAT_NOM_ERREUR);
		}
	}

	private void validerPrenom(Utilisateur utilisateur, BusinessException businessException) {
		if (utilisateur.getPrenom() == null || utilisateur.getPrenom().trim().equals("")
				|| utilisateur.getPrenom().trim().length() > 30) {
			businessException.ajouterErreur(CodesResultatBLL.REGLE_FORMAT_PRENOM_ERREUR);
		}
	}

	private void validerEmail(Utilisateur utilisateur, BusinessException businessException) {
		List<String> listeEmail = new ArrayList<>();
		try {
			listeEmail = DAOFactory.getUtilisateurDAO().getListeEmail();
		} catch (BusinessException e) {

			e.printStackTrace();
			businessException.ajouterErreur(CodesResultatBLL.REGLE_ERREUR_IMPREVU);
		}

		if (utilisateur.getEmail() == null || utilisateur.getEmail().trim().equals("")
			||!utilisateur.getEmail().contains("@")	|| utilisateur.getEmail().trim().length() > 20) {
			businessException.ajouterErreur(CodesResultatBLL.REGLE_FORMAT_EMAIL_ERREUR);
		}

		if (listeEmail.contains(utilisateur.getEmail())) {
			businessException.ajouterErreur(CodesResultatBLL.REGLE_EMAIL_EXISTANT);
		}

	}
	
	private void validerEmailModification(Utilisateur utilisateur,String email, BusinessException businessException) {
		List<String> listeEmailAvant = new ArrayList<>();
		List<String> listeEmailApres = new ArrayList<>();
		try {
			listeEmailAvant = DAOFactory.getUtilisateurDAO().getListeEmail();
		} catch (BusinessException e) {

			e.printStackTrace();
			businessException.ajouterErreur(CodesResultatBLL.REGLE_ERREUR_IMPREVU);
		}

		for (String string : listeEmailAvant) {
			if(!email.equals(string)) {
				
				listeEmailApres.add(string);
			}
		}
		if (listeEmailApres.contains(utilisateur.getEmail())) {
			businessException.ajouterErreur(CodesResultatBLL.REGLE_EMAIL_EXISTANT);

		}
	
		if (utilisateur.getEmail() == null || utilisateur.getEmail().trim().equals("")
			||!utilisateur.getEmail().contains("@")	|| utilisateur.getEmail().trim().length() > 20) {
			businessException.ajouterErreur(CodesResultatBLL.REGLE_FORMAT_EMAIL_ERREUR);
		}

	}

	private void validerTelephone(Utilisateur utilisateur, BusinessException businessException) {
		if (utilisateur.getTelephone() == null || utilisateur.getTelephone().trim().equals("")
				|| utilisateur.getTelephone().trim().length() > 15) {
			businessException.ajouterErreur(CodesResultatBLL.REGLE_FORMAT_TELEPHONE_ERREUR);
		}
	}

	private void validerRue(Utilisateur utilisateur, BusinessException businessException) {
		if (utilisateur.getRue() == null || utilisateur.getRue().trim().equals("")
				|| utilisateur.getRue().trim().length() > 30) {
			businessException.ajouterErreur(CodesResultatBLL.REGLE_FORMAT_RUE_ERREUR);
		}
	}

	private void validerCodePostal(Utilisateur utilisateur, BusinessException businessException) {
		if (utilisateur.getCodePostal() == null || utilisateur.getCodePostal().trim().equals("")
				|| utilisateur.getCodePostal().trim().length() > 10) {
			businessException.ajouterErreur(CodesResultatBLL.REGLE_FORMAT_CODE_POSTAL_ERREUR);
		}
	}

	private void validerVille(Utilisateur utilisateur, BusinessException businessException) {
		if (utilisateur.getVille() == null || utilisateur.getVille().trim().equals("")
				|| utilisateur.getVille().trim().length() > 30) {
			businessException.ajouterErreur(CodesResultatBLL.REGLE_FORMAT_VILLE_ERREUR);
		}
	}

	private void validerMotDePasse(Utilisateur utilisateur, String verifMDP, BusinessException businessException) {
		if (utilisateur.getMotDePasse() == null || utilisateur.getMotDePasse().trim().equals("")
				|| utilisateur.getMotDePasse().trim().length() > 30) {
			businessException.ajouterErreur(CodesResultatBLL.REGLE_FORMAT_MDP_ERREUR);
		}

		if (!utilisateur.getMotDePasse().equals(verifMDP)) {
			businessException.ajouterErreur(CodesResultatBLL.REGLE_CONFIRMATION_MDP_ERREUR);
		}

	}
	
	private void validerMotDePasseModification(Utilisateur utilisateur,String mdpActuel, String verifMDP, BusinessException businessException) {
		
		String mdpFutur = utilisateur.getMotDePasse();

    	if(mdpActuel==null || mdpActuel.trim().equals("")) {
    		businessException.ajouterErreur(CodesResultatBLL.REGLE_PRESENCE_MDP_ACTUEL);
    	}
    	if(mdpActuel!=null && !mdpFutur.trim().equals("") ) {
    		if(mdpFutur.trim().equals("") || mdpFutur.trim().length() > 30) {
    			businessException.ajouterErreur(CodesResultatBLL.REGLE_FORMAT_NOUVEAU_MDP_ERREUR);
    		}
    		if(verifMDP.trim().equals("") || verifMDP.trim().length() > 30) {
    			businessException.ajouterErreur(CodesResultatBLL.REGLE_FORMAT_NOUVEAU_MDP_ERREUR);
    		}
    		if (!mdpFutur.equals(verifMDP)) {
				businessException.ajouterErreur(CodesResultatBLL.REGLE_FORMAT_NOUVEAU_MDP_ERREUR);
			}
    	}

	}
}	








