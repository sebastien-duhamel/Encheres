package fr.teamA.encheres.bll;

/**
 * Les codes disponibles sont entre 20000 et 29999
 */
public abstract class CodesResultatBLL {

	/**
	 * Echec le nom de l'article ne respecte pas les règles définies
	 */
	public static final int REGLE_FORMAT_PSEUDO_ERREUR = 20000;
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

	public static final int REGLE_CONFIRMATION_MDP_ERREUR = 20009;

	public static final int IDENTIFIANT_KO = 20010;

	public static final int MOT_DE_PASSE_KO = 20011;

	public static final int REGLE_FORMAT_NOM_ARTICLE_ERREUR = 20012;

	public static final int REGLE_FORMAT_DESCRIPTION_ERREUR = 20013;

	public static final int REGLE_DEBUT_ERREUR = 20014;

	public static final int REGLE_FIN_ERREUR = 20015;

	public static final int REGLE_MISE_A_PRIX_ERREUR = 20016;
	
	public static final int REGLE_PSEUDO_DEJA_EXISTANT = 20017;
	
	public static final int REGLE_EMAIL_EXISTANT = 20018;

}
