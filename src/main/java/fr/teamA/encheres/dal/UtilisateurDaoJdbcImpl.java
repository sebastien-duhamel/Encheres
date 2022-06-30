package fr.teamA.encheres.dal;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import fr.teamA.encheres.BusinessException;
import fr.teamA.encheres.bo.Utilisateur;



public class UtilisateurDaoJdbcImpl implements UtilisateurDAO{
	
	private static final String INSERT_UTILISATEURS = "insert into UTILISATEURS(pseudo, nom, prenom, email, telephone, rue, code_postal, ville, mot_de_passe, credit , administrateur) values(?,?,?,?,?,?,?,?,?,?,?);";
	private static final String GET_USER_BY_PSEUDO ="select no_Utilisateur, pseudo, nom, prenom, email, telephone, rue, code_postal, ville, mot_de_passe, credit , administrateur from utilisateurs where pseudo=? ;";
	private static final String GET_LIST_PSEUDO ="select pseudo from UTILISATEURS ;";
	private static final String GET_LIST_EMAIL = "select email from UTILISATEURS ;";
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

	@Override
	public Utilisateur getUtilisateurbyPseudo(String identifiant) throws BusinessException {
		Utilisateur utilisateur = null;
		try(Connection cnx = ConnectionProvider.getConnection();PreparedStatement pstmt=cnx.prepareStatement(GET_USER_BY_PSEUDO)){
			pstmt.setString(1, identifiant);
			try(ResultSet rs = pstmt.executeQuery()){
				if(rs.next()) {
					utilisateur = new Utilisateur(rs.getInt("no_Utilisateur"), rs.getString("pseudo"), rs.getString("nom"), rs.getString("prenom"), 
						rs.getString("email"), rs.getString("telephone"), rs.getString("rue"), rs.getString("code_postal"), rs.getString("ville"),
						rs.getString("mot_de_passe"), rs.getInt("credit"), rs.getInt("administrateur"));
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
			BusinessException businessException = new BusinessException();
			businessException.ajouterErreur(CodesResultatDAL.SELECT_PSEUDO_ECHEC_BDD);
			throw businessException;
		}
		
		return utilisateur;
	}

	@Override
	public List<String> getListePseudo() throws BusinessException{
	
		List<String> listePseudo = new ArrayList<>();
		try(Connection cnx = ConnectionProvider.getConnection();PreparedStatement pstmt=cnx.prepareStatement(GET_LIST_PSEUDO)){
		
			try(ResultSet rs = pstmt.executeQuery()){
		
				
					while(rs.next()) {
						String pseudo =null;
						pseudo = rs.getString("pseudo");
						listePseudo.add(pseudo);
				
					}
				
			}
			
		} catch (SQLException e) {
		
			e.printStackTrace();
			BusinessException businessException = new BusinessException();
			businessException.ajouterErreur(CodesResultatDAL.SELECT_LISTE_PSEUDO_ECHEC_BDD);
			throw businessException;
		}
		
		return listePseudo;
	}
	
	
	@Override
	public List<String> getListeEmail() throws BusinessException{
	
		List<String> listeEmail = new ArrayList<>();
		try(Connection cnx = ConnectionProvider.getConnection();PreparedStatement pstmt=cnx.prepareStatement(GET_LIST_EMAIL)){
		
			try(ResultSet rs = pstmt.executeQuery()){
		
				
					while(rs.next()) {
						String email =null;
						email = rs.getString("email");
						listeEmail.add(email);
				
					}
				
			}
			
		} catch (SQLException e) {
		
			e.printStackTrace();
			BusinessException businessException = new BusinessException();
			businessException.ajouterErreur(CodesResultatDAL.SELECT_LISTE_PSEUDO_ECHEC_BDD);
			throw businessException;
		}
		
		return listeEmail;
	}

}
