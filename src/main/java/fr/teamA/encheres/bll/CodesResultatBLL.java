package fr.teamA.encheres.bll;

/**
 * Les codes disponibles sont entre 20000 et 29999
 */
public abstract class CodesResultatBLL {
	
	/**
	 * Echec le nom de l'article ne respecte pas les règles définies
	 */
	public static final int REGLE_FORMAT_PSEUDO_ERREUR=20000;
	/**
	 * Echec le nom de l'article ne respecte pas les règles définies
	 */
	public static final int REGLE_FORMAT_NOM_ERREUR = 20001;

	public static final int REGLE_FORMAT_PRENOM_ERREUR = 20002;
	
	public static final int REGLE_FORMAT_EMAIL_ERREUR = 20003;
	
	public static final int REGLE_FORMAT_TELEPHONE_ERREUR = 20004;
	
	public static final int REGLE_FORMAT_RUE_ERREUR = 20005;
	
	public static final int REGLE_FORMAT_CODE_POSTAL_ERREUR = 20006;
	
	public static final int REGLE_FORMAT_VILLE_ERREUR = 20007;
	
	public static final int REGLE_FORMAT_MDP_ERREUR = 20008;
	
	public static final int REGLE_CONFIRMATION_MDP_ERREUR = 20009 ;
	
}
