package fr.teamA.encheres.dal;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import fr.teamA.encheres.BusinessException;
import fr.teamA.encheres.bo.ArticleVendu;


public class ArticleVenduDaoJdbcImpl implements ArticleVenduDAO{
		
		private static final String INSERT_ARTICLES_VENDUS = "insert into ARTICLESVENDUS(nomArticle,description,dateDebutEncheres,dateFinEncheres,miseAPrix,prixVente,etatVente) "
				+ "values(?,?,?,?,?,?,?)";
		
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


	}

