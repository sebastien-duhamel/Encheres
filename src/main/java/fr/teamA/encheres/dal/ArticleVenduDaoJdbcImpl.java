package fr.teamA.encheres.dal;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import fr.teamA.encheres.BusinessException;
import fr.teamA.encheres.bo.ArticleVendu;
import fr.teamA.encheres.bo.Utilisateur;

public class ArticleVenduDaoJdbcImpl implements ArticleVenduDAO {

	private static final String INSERT_ARTICLES_VENDUS = "insert into ARTICLESVENDUS(nom_article,description,date_debut_encheres,date_fin_encheres,prix_initial,prix_vente,no_categorie) "
			+ "values(?,?,?,?,?,?,?)";
	private static final String GET_ARTICLE_EN_VENTE = "select no_article, nom_article, description,date_debut_encheres, date_fin_encheres, prix_initial, prix_vente, no_categorie, no_utilisateur from ARTICLES_VENDUS where GETDATE()>date_debut_encheres;";
	private static final String GET_LIST_FILTRE = "select no_article, nom_article, description,date_debut_encheres, date_fin_encheres, prix_initial, prix_vente, no_categorie, no_utilisateur from ARTICLES_VENDUS where (GETDATE()>date_debut_encheres AND nom_article LIKE ? AND no_categorie=? );";
	private static final String GET_LIST_FILTRE_CONTIENT = "select no_article, nom_article, description,date_debut_encheres, date_fin_encheres, prix_initial, prix_vente, no_categorie, no_utilisateur from ARTICLES_VENDUS where (GETDATE()>date_debut_encheres AND nom_article LIKE ?);";
	

	@Override
	public void insert(ArticleVendu articleVendu) throws BusinessException {
		if (articleVendu == null) {
			BusinessException businessException = new BusinessException();
			businessException.ajouterErreur(CodesResultatDAL.INSERT_ARTICLES_VENDUS_NULL);
			throw businessException;
		}

		try (Connection cnx = ConnectionProvider.getConnection()) {
			try {
				cnx.setAutoCommit(false);
				PreparedStatement pstmt;
				ResultSet rs;
				if (articleVendu.getNoArticle() == 0) {
					pstmt = cnx.prepareStatement(INSERT_ARTICLES_VENDUS, PreparedStatement.RETURN_GENERATED_KEYS);
					pstmt.setString(1, articleVendu.getNomArticle());
					pstmt.setString(2, articleVendu.getDescription());
					pstmt.setDate(3, java.sql.Date.valueOf(articleVendu.getDateDebutEncheres()));
					pstmt.setDate(4, java.sql.Date.valueOf(articleVendu.getDateFinEncheres()));
					pstmt.setInt(5, articleVendu.getMiseAPrix());
					pstmt.setInt(6, articleVendu.getPrixVente());
					pstmt.setInt(7, articleVendu.getNoCategorie());
					pstmt.executeUpdate();
					rs = pstmt.getGeneratedKeys();
					if (rs.next()) {
						articleVendu.setNoArticle(rs.getInt(1));

					}
					rs.close();
					pstmt.close();
				}

				cnx.commit();
			} catch (Exception e) {
				e.printStackTrace();
				cnx.rollback();
				throw e;
			}
		} catch (Exception e) {
			e.printStackTrace();
			BusinessException businessException = new BusinessException();
			businessException.ajouterErreur(CodesResultatDAL.INSERT_ARTICLES_VENDUS_ECHEC);
			throw businessException;
		}

	}

	@Override
	public List<ArticleVendu> afficherListeArticle() throws BusinessException {

		List<ArticleVendu> listeArticleVendu = new ArrayList<ArticleVendu>();
//			LocalDate date = LocalDate.now();

		try (Connection cnx = ConnectionProvider.getConnection();
				Statement stmt = cnx.createStatement();
				ResultSet rs = stmt.executeQuery(GET_ARTICLE_EN_VENTE)) {

//			//int noArticle, String nomArticle, String description, LocalDate dateDebutEncheres,LocalDate dateFinEncheres, int miseAPrix, int prixVente, int etatVente, Utilisateur vendeur 

			ArticleVendu article;
			UtilisateurDaoJdbcImpl userDAO = new UtilisateurDaoJdbcImpl();
//					if(rs.next()) {
			while (rs.next()) {
				article = new ArticleVendu(rs.getInt("no_article"), rs.getString("nom_article"),
						rs.getString("description"), rs.getDate("date_debut_encheres").toLocalDate(),
						rs.getDate("date_fin_encheres").toLocalDate(), rs.getInt("prix_initial"),
						rs.getInt("prix_vente"), 2, userDAO.getUtilisateurbyId(rs.getInt("no_utilisateur")), rs.getInt("no_categorie"));
				listeArticleVendu.add(article);
			}
//					}else {
//						listeArticleVendu = null;
//					}

		} catch (SQLException e) {
			e.printStackTrace();
			BusinessException businessException = new BusinessException();
			businessException.ajouterErreur(CodesResultatDAL.SELECT_PSEUDO_ECHEC_BDD);// TODO modifier cette erreur
			throw businessException;
		}

		return listeArticleVendu;
	}
	
	@Override
	public List<ArticleVendu> afficherListeArticleFiltre(String contient, int categorie) throws BusinessException {
		String requete ;
		
		if(categorie != 0) {
			requete = GET_LIST_FILTRE;
		}
		else {
			requete = GET_LIST_FILTRE_CONTIENT;
		}
		
		List<ArticleVendu> listeArticleFiltre= new ArrayList<ArticleVendu>();
		ArticleVendu articleFiltre;
		
		UtilisateurDaoJdbcImpl userDAO = new UtilisateurDaoJdbcImpl();
		
		
		try(Connection cnx = ConnectionProvider.getConnection();PreparedStatement pstmt=cnx.prepareStatement(requete)){
			
			pstmt.setString(1, contient);
			
			if(categorie != 0) {
			pstmt.setInt(2, categorie);
			}
			try(ResultSet rs = pstmt.executeQuery()){
				while (rs.next()) {
					articleFiltre = new ArticleVendu(rs.getInt("no_article"), rs.getString("nom_article"),
							rs.getString("description"), rs.getDate("date_debut_encheres").toLocalDate(),
							rs.getDate("date_fin_encheres").toLocalDate(), rs.getInt("prix_initial"),
							rs.getInt("prix_vente"), rs.getInt("no_categorie"), userDAO.getUtilisateurbyId(rs.getInt("no_utilisateur")),rs.getInt("no_categorie"));
					listeArticleFiltre.add(articleFiltre);
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
			BusinessException businessException = new BusinessException();
			businessException.ajouterErreur(CodesResultatDAL.SELECT_PSEUDO_ECHEC_BDD); //TODO modifier erreur
			throw businessException;
		}
		return listeArticleFiltre;
		
	}

}
