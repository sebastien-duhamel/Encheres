package fr.teamA.encheres.dal;

/**
 * Les codes disponibles sont entre 10000 et 19999
 */
public abstract class CodesResultatDAL {
	
	public static final int INSERT_UTILISATEUR_NULL=10000;
	
	public static final int ECHEC_MISE_A_JOUR=10001;

	public static final int LECTURE_LISTE_ECHEC = 10003;
	
	public static final int SELECT_PSEUDO_ECHEC_BDD = 10010;
	
	public static final int INSERT_ARTICLES_VENDUS_NULL = 10011;
	
	public static final int ERREUR_NON_GEREE= 10013;

	public static final int DELETE_UTILISATEUR_ECHEC = 10016;
}