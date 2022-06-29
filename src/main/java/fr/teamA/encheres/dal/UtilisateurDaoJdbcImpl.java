package fr.teamA.encheres.dal;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import fr.teamA.encheres.BusinessException;
import fr.teamA.encheres.bo.Utilisateur;



public class UtilisateurDaoJdbcImpl implements UtilisateurDAO{
	
	private static final String INSERT_UTILISATEURS = "insert into UTILISATEURS(pseudo, nom, prenom, email, telephone, rue, code_postal, ville, mot_de_passe, credit , administrateur) values(?,?,?,?,?,?,?,?,?,?,?);";
	
	@Override
	public void insert(Utilisateur utilisateur) throws BusinessException {
		if(utilisateur==null)
		{
			BusinessException businessException = new BusinessException();
			businessException.ajouterErreur(CodesResultatDAL.INSERT_UTILISATEUR_NULL);
			throw businessException;
		}
		
		try(Connection cnx = ConnectionProvider.getConnection())
		{
			try
			{
				cnx.setAutoCommit(false);
				PreparedStatement pstmt;
				ResultSet rs;
				if(utilisateur.getNoUtilisateur()==0)
				{
					pstmt = cnx.prepareStatement(INSERT_UTILISATEURS , PreparedStatement.RETURN_GENERATED_KEYS);
					pstmt.setString(1, utilisateur.getPseudo());
					pstmt.setString(2, utilisateur.getNom());
					pstmt.setString(3, utilisateur.getPrenom());
					pstmt.setString(4, utilisateur.getEmail());
					pstmt.setString(5, utilisateur.getTelephone());
					pstmt.setString(6, utilisateur.getRue());
					pstmt.setString(7, utilisateur.getCodePostal());
					pstmt.setString(8, utilisateur.getVille());
					pstmt.setString(9, utilisateur.getMotDePasse());
					pstmt.setInt(10, utilisateur.getCredit());
					pstmt.setInt(11, 0);
					pstmt.executeUpdate();
					rs = pstmt.getGeneratedKeys();
					if(rs.next())
					{
						utilisateur.setNoUtilisateur(rs.getInt(1));
					
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
			businessException.ajouterErreur(CodesResultatDAL.INSERT_UTILISATEUR_ECHEC);
			throw businessException;
		}
		
	}


}
