package fr.teamA.encheres.dal;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import fr.teamA.encheres.BusinessException;
import fr.teamA.encheres.bo.ArticleVendu;



public class ArticleVenduDaoJdbcImpl implements ArticleVenduDAO{
		
		private static final String INSERT_ARTICLES_VENDUS = "insert into ARTICLESVENDUS(nomArticle,description,dateDebutEncheres,dateFinEncheres,miseAPrix,prixVente,etatVente) "
				+ "values(?,?,?,?,?,?,?)";
		private static final String GET_ARTICLE_EN_VENTE = "select no_article, nom_article, description,date_debut_encheres, date_fin_encheres, prix_initial, prix_vente, no_utilisateur from ARTICLES_VENDUS where GETDATE()>date_debut_encheres;";
		
		
		
		@Override
		public void insert(ArticleVendu articleVendu) throws BusinessException {
			if(articleVendu==null)
			{
				BusinessException businessException = new BusinessException();
				businessException.ajouterErreur(CodesResultatDAL.INSERT_ARTICLES_VENDUS_NULL);
				throw businessException;
			}
			
			try(Connection cnx = ConnectionProvider.getConnection())
			{
				try
				{
					cnx.setAutoCommit(false);
					PreparedStatement pstmt;
					ResultSet rs;
					if(articleVendu.getNoArticle()==0)
					{
						pstmt = cnx.prepareStatement(INSERT_ARTICLES_VENDUS , PreparedStatement.RETURN_GENERATED_KEYS);
						pstmt.setString(1, articleVendu.getNomArticle());
						pstmt.setString(2, articleVendu.getDescription());
						pstmt.setDate(3, java.sql.Date.valueOf(articleVendu.getDateDebutEncheres()));
						pstmt.setDate(4, java.sql.Date.valueOf(articleVendu.getDateFinEncheres()));
						pstmt.setInt(5, articleVendu.getMiseAPrix());
						pstmt.setInt(6, articleVendu.getPrixVente());
						pstmt.setInt(7, articleVendu.getEtatVente());
						pstmt.executeUpdate();						
						rs = pstmt.getGeneratedKeys();
						if(rs.next())
						{
							articleVendu.setNoArticle(rs.getInt(1));
						
						}
						rs.close();
						pstmt.close();
					}
					
					cnx.commit();
				}
				catch(Exception e)
				{
					e.printStackTrace();
					cnx.rollback();
					throw e;
				}
			}
			catch(Exception e)
			{
				e.printStackTrace();
				BusinessException businessException = new BusinessException();
				businessException.ajouterErreur(CodesResultatDAL.INSERT_ARTICLES_VENDUS_ECHEC);
				throw businessException;
			}
			
		}
		
		@Override
		public List<ArticleVendu> afficherListeArticle() throws BusinessException{
			
			List<ArticleVendu> listeArticleVendu = new ArrayList<ArticleVendu>();
//			LocalDate date = LocalDate.now();
			
			try(Connection cnx = ConnectionProvider.getConnection();PreparedStatement pstmt=cnx.prepareStatement(GET_ARTICLE_EN_VENTE)){
				
//				pstmt.setDate(1, java.sql.Date.valueOf(date));
				
				try(ResultSet rs = pstmt.executeQuery()){
					ArticleVendu article;
					
//					if(rs.next()) {
						while(rs.next()) {
							article = new ArticleVendu(rs.getInt("no_article"), rs.getString("nom_article"), rs.getString("description"),
									rs.getDate("date_debut_encheres").toLocalDate(), rs.getDate("date_fin_encheres").toLocalDate(), 
									rs.getInt("prix_initial"), rs.getInt("prix_vente"), rs.getInt("no_utilisateur"));
							listeArticleVendu.add(article);
						}
//					}else {
//						listeArticleVendu = null;
//					}
					
				}
			} catch (SQLException e) {
				e.printStackTrace();
				BusinessException businessException = new BusinessException();
				businessException.ajouterErreur(CodesResultatDAL.SELECT_PSEUDO_ECHEC_BDD);//TODO modifier cette erreur
				throw businessException;
			}
			
			
			return listeArticleVendu;
		}

	}

