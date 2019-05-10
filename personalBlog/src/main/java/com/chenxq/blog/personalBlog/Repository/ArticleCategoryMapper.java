package com.chenxq.blog.personalBlog.Repository;

import com.chenxq.blog.personalBlog.Domain.ArticleCategory;
import com.chenxq.blog.personalBlog.Domain.ArticleCategoryExample;
import java.util.List;
import java.util.Map;

public interface ArticleCategoryMapper {
	int deleteByPrimaryKey(Long id);

	int insert(ArticleCategory record);

	int insertSelective(ArticleCategory record);

	List<ArticleCategory> selectByExample(ArticleCategoryExample example);

	ArticleCategory selectByPrimaryKey(Long id);

	int updateByPrimaryKeySelective(ArticleCategory record);

	int updateByPrimaryKey(ArticleCategory record);

	//Map<String, Long> selectByCategories(String sql);

	List<Map<String , Long>> selectByCategories(String sql);
}