package com.chenxq.blog.personalBlog.Service;

import java.util.List;
import java.util.Map;

import com.chenxq.blog.personalBlog.Dae.ArticleInfo;
import com.chenxq.blog.personalBlog.Dae.ArticleWithImage ;
import com.chenxq.blog.personalBlog.Domain.ArticleCategory;
import com.chenxq.blog.personalBlog.Domain.ArticleImage;

public interface ArticleContentService {
	void addArticle(ArticleInfo articleInfo);
	
	void deleteArticleById(Long id);
//	
//	void updateArticle(ArticleInfo articleInfo);
//
//	void updateArticleCategory(Long articleId, Long categoryId);
//
	ArticleInfo getOneById(Long id);

     ArticleImage getPictureByArticleId(Long id); 
	 List <ArticleWithImage > getAll();
	 List <ArticleWithImage > getByCategoryId(Long id);
	 List<ArticleWithImage> listLastArticles();
	 List<ArticleWithImage> listLastArticlesByCategoryId( Long id);
	 //得到阅读量最高的五篇文章
	 List<ArticleWithImage> getReadArticles();
	 //得到不同分类下的相同文章
	 List<ArticleInfo> getTheSameArticle(String args);
	 
	 //得到最新的文章
	 ArticleWithImage  getNewArticle() ;
	

	
}
