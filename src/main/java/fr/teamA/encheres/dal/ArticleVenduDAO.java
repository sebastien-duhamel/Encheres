package fr.teamA.encheres.dal;


import java.util.List;

import fr.teamA.encheres.BusinessException;
import fr.teamA.encheres.bo.ArticleVendu;


public interface ArticleVenduDAO {
		public void insert(ArticleVendu articleVendu) throws BusinessException;
		
		public List<ArticleVendu>afficherListeArticle() throws BusinessException;

		List<ArticleVendu> afficherListeArticleFiltre(String contient, int categorie) throws BusinessException;
	}


