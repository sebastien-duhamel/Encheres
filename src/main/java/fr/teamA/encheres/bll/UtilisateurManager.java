package fr.teamA.encheres.bll;

import fr.teamA.encheres.BusinessException;
import fr.teamA.encheres.bo.Utilisateur;
import fr.teamA.encheres.dal.DAOFactory;
import fr.teamA.encheres.dal.InterfaceDAO;
import fr.teamA.encheres.servlets.ServletProfilCreation;

public class UtilisateurManager {

	/*
	 * @author Administrator
	 *
	 * Cette classe permet d'effectuer les traitements attendus sur la classe Avis
	 */

	private InterfaceDAO interfaceDAO;

	/**
	 * Le constructeur permet d'initialiser la variable membre avisDAO pour
	 * permettre une communication avec la base de données.
	 */
	public UtilisateurManager() {
		this.interfaceDAO = DAOFactory.getInterfaceDAO();
	}

	/**
	 * @param description
	 * @param note
	 * @return un objet Avis en cas de succcès
	 * @throws BusinessException
	 */
	public Utilisateur ajouterUtilisateur(String pseudo, String nom, String prenom, String email, String telephone,
			String rue, String codePostal, String ville, String motDePasse) throws BusinessException {
		BusinessException exception = new BusinessException();

		Utilisateur utilisateur = new Utilisateur(pseudo, nom, prenom, email, telephone, rue, codePostal, ville,
				motDePasse, 0, 0);

		this.validerPseudo(utilisateur, exception);
		this.validerNom(utilisateur, exception);
		this.validerPrenom(utilisateur, exception);
		this.validerEmail(utilisateur, exception);
		this.validerTelephone(utilisateur, exception);
		this.validerRue(utilisateur, exception);
		this.validerCodePostal(utilisateur, exception);
		this.validerVille(utilisateur, exception);
		this.validerMotDePasse(utilisateur, exception);

		if (!exception.hasErreurs()) {
			this.interfaceDAO.insert(utilisateur);
		}

		if (exception.hasErreurs()) {
			throw exception;
		}
		return utilisateur;
	}

	private void validerPseudo(Utilisateur utilisateur, BusinessException businessException) {

		if (utilisateur.getPseudo() == null || utilisateur.getPseudo().trim().length() > 30) {
			businessException.ajouterErreur(CodesResultatBLL.REGLE_FORMAT_PSEUDO_ERREUR);
		}
	}

	private void validerNom(Utilisateur utilisateur, BusinessException businessException) {
		if (utilisateur.getNom() == null || utilisateur.getNom().trim().length() > 30) {
			businessException.ajouterErreur(CodesResultatBLL.REGLE_FORMAT_NOM_ERREUR);
		}
	}

	private void validerPrenom(Utilisateur utilisateur, BusinessException businessException) {
		if (utilisateur.getPrenom() == null || utilisateur.getPrenom().trim().length() > 30) {
			businessException.ajouterErreur(CodesResultatBLL.REGLE_FORMAT_PRENOM_ERREUR);
		}
	}

	private void validerEmail(Utilisateur utilisateur, BusinessException businessException) {
		if (utilisateur.getEmail() == null || utilisateur.getEmail().trim().length() > 20) {
			businessException.ajouterErreur(CodesResultatBLL.REGLE_FORMAT_EMAIL_ERREUR);
		}
	}

	private void validerTelephone(Utilisateur utilisateur, BusinessException businessException) {
		if (utilisateur.getTelephone() == null || utilisateur.getTelephone().trim().length() > 15) {
			businessException.ajouterErreur(CodesResultatBLL.REGLE_FORMAT_TELEPHONE_ERREUR);
		}
	}

	private void validerRue(Utilisateur utilisateur, BusinessException businessException) {
		if (utilisateur.getRue() == null || utilisateur.getRue().trim().length() > 30) {
			businessException.ajouterErreur(CodesResultatBLL.REGLE_FORMAT_RUE_ERREUR);
		}
	}

	private void validerCodePostal(Utilisateur utilisateur, BusinessException businessException) {
		if (utilisateur.getCodePostal() == null || utilisateur.getCodePostal().trim().length() > 10) {
			businessException.ajouterErreur(CodesResultatBLL.REGLE_FORMAT_CODE_POSTAL_ERREUR);
		}
	}

	private void validerVille(Utilisateur utilisateur, BusinessException businessException) {
		if (utilisateur.getVille() == null || utilisateur.getVille().trim().length() > 30) {
			businessException.ajouterErreur(CodesResultatBLL.REGLE_FORMAT_VILLE_ERREUR);
		}
	}
	
	private void validerMotDePasse(Utilisateur utilisateur, BusinessException businessException) {
		if (utilisateur.getMotDePasse() == null || utilisateur.getMotDePasse().trim().length() > 30) {
			businessException.ajouterErreur(CodesResultatBLL.REGLE_FORMAT_MDP_ERREUR);
		}
		
	}
}
