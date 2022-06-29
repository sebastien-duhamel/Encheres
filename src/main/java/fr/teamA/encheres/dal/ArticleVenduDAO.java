package fr.teamA.encheres.dal;

import fr.teamA.encheres.BusinessException;
import fr.teamA.encheres.bo.ArticleVendu;


public interface ArticleVenduDAO {
		public void insert(ArticleVendu articleVendu) throws BusinessException;
		
	}


