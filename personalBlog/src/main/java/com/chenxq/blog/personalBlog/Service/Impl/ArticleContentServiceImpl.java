package com.chenxq.blog.personalBlog.Service.Impl;

import java.sql.Date;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.omg.CORBA.PRIVATE_MEMBER;
import org.omg.CORBA.PUBLIC_MEMBER;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.chenxq.blog.personalBlog.Dae.ArticleInfo;
import com.chenxq.blog.personalBlog.Dae.ArticleWithImage;
import com.chenxq.blog.personalBlog.Domain.*;
import com.chenxq.blog.personalBlog.Repository.*;
import com.chenxq.blog.personalBlog.Service.ArticleContentService;

@Service
public class ArticleContentServiceImpl implements ArticleContentService {

	private static final int Long = 0;
	@Autowired
	ArticleInformationMapper articleInformationMapper;
	@Autowired
	ArticleImageMapper articleImageMapper;
	@Autowired
	ArticleCategoryMapper articleCategoryMapper;
	@Autowired
	ArticleContentMapper articleContentMapper;
	@Autowired
	CategoryMapper categoryMapper;

	private static byte MAX_LASTEST_ARTICLE_COUNT = 5;

	// 增加一个文章信息
	public void addArticle(ArticleInfo articleInfo) {
		// 增加文章信息表
		java.util.Date createDate = articleInfo.getCreate_by();
		ArticleInformation articleInformation = new ArticleInformation();
		articleInformation.setTitle(articleInfo.getTitle());
		articleInformation.setSummary(articleInfo.getSummary());
		articleInformation.setCreate_by(createDate);
		articleInformation.setModified_by(createDate);
		articleInformationMapper.insertSelective(articleInformation);

		// 获取刚刚插入的文章信息的ID
		Long articleID = getArticleLastestId();

		// 增加文章题图信息
		ArticleImage articleImage = new ArticleImage();
		articleImage.setArticle_id(articleID);
		if (articleInfo.getPictureUrl().length() == 0) {
			String defaultImg = "images/188cc12b5ce6477fb1ef1ed31fde847c.jpg";
			articleImage.setImage_url(defaultImg);
		} else {
			articleImage.setImage_url(articleInfo.getPictureUrl());
		}
		articleImage.setCreate_by(createDate);
		articleImage.setModified_by(createDate);
		articleImageMapper.insertSelective(articleImage);

		// 增加文章内容信息表
		ArticleContent articleContent = new ArticleContent();
		articleContent.setArticle_id(articleID);
		articleContent.setContent(articleInfo.getContent());
		articleContent.setCreate_by(createDate);
		articleContent.setModified_by(createDate);
		articleContentMapper.insertSelective(articleContent);

		// 增加文章分类信息表
		Long arr[] = articleInfo.getCategoryArr();
		for (int i = 0; i < arr.length; i++) {
			ArticleCategory articleCategory = new ArticleCategory();
			articleCategory.setArticle_id(articleID);
			articleCategory.setCategory_id(arr[i]);
			articleCategory.setCreate_by(createDate);
			articleCategory.setModified_by(createDate);
			articleCategoryMapper.insertSelective(articleCategory);
			// 对应的文章数量要加1
			Category category = categoryMapper.selectByPrimaryKey(articleCategory.getCategory_id());
			category.setArt_number((byte) (category.getArt_number() + 1));
			categoryMapper.updateByPrimaryKeySelective(category);
		}

	}

	// 根据ID值删除文章
	public void deleteArticleById(Long id) {
		ArticleInfo article = getOneById(id);
		// 删除文章信息表中的相关信息
		articleInformationMapper.deleteByPrimaryKey(article.getId());
		// 删除文章题图表中的信息
		articleImageMapper.deleteByPrimaryKey(article.getArticleImageId());
		// 删除文章分类表的信息
		articleCategoryMapper.deleteByPrimaryKey(article.getArticleCategoryId());
		// 删除相关的文章
		articleContentMapper.deleteByPrimaryKey(article.getArticleContentId());
		// 减少分类中的art_number
		ArticleCategory articleCategory = articleCategoryMapper.selectByPrimaryKey(article.getArticleCategoryId());
		Category category = categoryMapper.selectByPrimaryKey(articleCategory.getCategory_id());
		category.setArt_number((byte) (category.getArt_number() - 1));
		categoryMapper.updateByPrimaryKey(category);

	}

//	
//	void updateArticle(ArticleInfo articleInfo);
//
//	void updateArticleCategory(Long articleId, Long categoryId);
//
//	ArticleInfo getOneById(Long id);
//
//	 ArticleImage getPictureByArticleId(Long id);
	// 获取所有的题图信息
	public List<ArticleWithImage> getAll() {
		List<ArticleWithImage> articles = listAllArticles();
//    	LinkedList<ArticleWithImage> list=new LinkedList<>();
//    	for(int i=0;i<articles.size();i++) {
//    		if(true==articles.get(i).getIs_top()) {
//    			list.addFirst(articles.get(i));
//    		}else {
//    			list.addLast(articles.get(i));
//    		}
//    	}
//    	articles=new ArrayList<>(list);
		return articles;
	}

	// 根据分类Id得到所有文章
	public List<ArticleWithImage> getByCategoryId(Long id) {
		ArticleCategoryExample example = new ArticleCategoryExample();
		example.or().andCategory_idEqualTo(id);
		List<ArticleCategory> articleCategories = articleCategoryMapper.selectByExample(example);
		List<ArticleWithImage> articles = new ArrayList<>();
		for (int i = 0; i < articleCategories.size(); i++) {
			Long articleId = articleCategories.get(i).getArticle_id();
			ArticleWithImage article = new ArticleWithImage();
//    		  ArticleInformationExample example1=new ArticleInformationExample();
//    		  example.or().andIdEqualTo(articleId);
//    		  ArticleInformation articleInfo=articleInformationMapper.selectByExample(example1).get(0);
			ArticleInformation articleInfo = articleInformationMapper.selectByPrimaryKey(articleId);
			article.setId(articleInfo.getId());
			article.setTitle(articleInfo.getTitle());
			article.setSummary(articleInfo.getSummary());
			article.setIs_top(articleInfo.getIs_top());
			article.setHits(articleInfo.getHits());
			// 填充图片信息
			ArticleImageExample exampleImg = new ArticleImageExample();
			exampleImg.or().andArticle_idEqualTo(articleInfo.getId());
			ArticleImage theImg = new ArticleImage();
			theImg = articleImageMapper.selectByExample(exampleImg).get(0);
			article.setArticleImageId(theImg.getId());
			article.setPictureUrl(theImg.getImage_url());
			articles.add(article);
		}
		LinkedList<ArticleWithImage> list = new LinkedList<>();
		for (int i = 0; i < articles.size(); i++) {
			if (true == articles.get(i).getIs_top()) {
				list.addFirst(articles.get(i));
			} else {
				list.addLast(articles.get(i));
			}
		}
		articles = new ArrayList<>(list);
		return articles;

	}

	/**
	 * 获取最新的文章信息，默认为5篇 说明：getAll默认已经按照id排序了，所以我们只需要返回前五篇就可以了 注意：需要判断当前的文章是否大于5篇
	 *
	 * @return 返回五篇最新的文章数据
	 */
	public List<ArticleWithImage> listLastArticles() {
		List<ArticleWithImage> articles = getAll();
		// 判断满足5个的情况
		if (articles.size() >= MAX_LASTEST_ARTICLE_COUNT) {
			List<ArticleWithImage> lastArticles = new ArrayList<>();
			for (int i = 0; i < 5; i++) {
				lastArticles.add(articles.get(i));
			}
			return lastArticles;
		}
		// 不大于5个则直接返回
		return articles;
	}

	/**
	 * 获取最新的文章信息，默认为5篇 说明：getAll默认已经按照id排序了
	 * 
	 * @return 得到阅读量最多的五篇文章
	 */
	public List<ArticleWithImage> getReadArticles() {
		List<ArticleWithImage> articles = getAll();
		Collections.sort(articles, new Comparator<ArticleWithImage>() {
			public int Compare(ArticleWithImage arg0, ArticleWithImage arg1) {
				return arg0.getHits().compareTo(arg1.getHits());
			}

			@Override
			public int compare(ArticleWithImage o1, ArticleWithImage o2) {
				// TODO Auto-generated method stub
				return o2.getHits().compareTo(o1.getHits());
			}
		});

		// 判断满足5个的情况
		if (articles.size() >= MAX_LASTEST_ARTICLE_COUNT) {
			List<ArticleWithImage> lastArticles = new ArrayList<>();
			for (int i = 0; i < 5; i++) {
				lastArticles.add(articles.get(i));
			}
			return lastArticles;
		}
		// 不大于5个则直接返回
		return articles;
	}

	/*
	 * (non-Javadoc) 根据id值得到其分类下最新的五篇文章
	 */

	public List<ArticleWithImage> listLastArticlesByCategoryId(Long id) {
		List<ArticleWithImage> articles = getByCategoryId(id);
		// 判断满足5个的情况
		if (articles.size() >= MAX_LASTEST_ARTICLE_COUNT) {
			List<ArticleWithImage> lastArticles = new ArrayList<>();
			for (int i = 0; i < 5; i++) {
				lastArticles.add(articles.get(i));
			}
			return lastArticles;
		}
		// 不大于5个则直接返回
		return articles;
	}

	// 得到最新的文章id
	private Long getArticleLastestId() {
		ArticleInformationExample example = new ArticleInformationExample();
		example.setOrderByClause("id desc");
		return articleInformationMapper.selectByExample(example).get(0).getId();
	}

	// 得到最新的文章
	public ArticleWithImage getNewArticle() {
		long id = getArticleLastestId();
		ArticleImage articleImage = getPictureByArticleId(id);
		ArticleInfo articleInfo = getOneById(id);
		ArticleWithImage article = new ArticleWithImage();
		article.setArticleImageId(articleImage.getId());
		article.setId(id);
		article.setCreate_by(articleInfo.getCreate_by());
		article.setHits(articleInfo.getHits());
		article.setIs_top(articleInfo.getIs_top());
		article.setPictureUrl(articleImage.getImage_url());
		article.setSummary(articleInfo.getSummary());
		article.setTitle(articleInfo.getTitle());
		return article;
	}

	/**
	 * 获取所有的文章信息（带题图）
	 *
	 * @return
	 */
	private List<ArticleWithImage> listAllArticles() {
		ArticleInformationExample example = new ArticleInformationExample();
		example.setOrderByClause("id desc");
		List<ArticleInformation> articleInfos = articleInformationMapper.selectByExample(example);
		List<ArticleWithImage> articles = new ArrayList<>();
		for (ArticleInformation articleInfo : articleInfos) {
			ArticleWithImage newArticle = new ArticleWithImage();
			newArticle.setId(articleInfo.getId());
			newArticle.setTitle(articleInfo.getTitle());
			newArticle.setSummary(articleInfo.getSummary());
			newArticle.setIs_top(articleInfo.getIs_top());
			newArticle.setHits(articleInfo.getHits());
			newArticle.setCreate_by(articleInfo.getCreate_by());

			ArticleImageExample exampleImg = new ArticleImageExample();
			exampleImg.or().andArticle_idEqualTo(articleInfo.getId());
			ArticleImage theImg = new ArticleImage();
			theImg = articleImageMapper.selectByExample(exampleImg).get(0);
			newArticle.setArticleImageId(theImg.getId());
			if (theImg.getImage_url().length() == 0) {
				String defaultImg = "images/188cc12b5ce6477fb1ef1ed31fde847c.jpg";
				newArticle.setPictureUrl(defaultImg);
			} else {
				newArticle.setPictureUrl(theImg.getImage_url());
			}
			articles.add(newArticle);
		}

		return articles;

	}

	/*
	 * 根据文章ID获取对应的文章题图信息
	 */
	public ArticleImage getPictureByArticleId(Long id) {
		ArticleImageExample example = new ArticleImageExample();
		example.or().andArticle_idEqualTo(id);
		return articleImageMapper.selectByExample(example).get(0);
	}

	public ArticleInfo getOneById(Long id) {
		ArticleInfo articleInfo = new ArticleInfo();
		ArticleInformation articleInformation = articleInformationMapper.selectByPrimaryKey(id);
		articleInfo.setId(articleInformation.getId());
		articleInfo.setTitle(articleInformation.getTitle());
		articleInfo.setSummary(articleInformation.getSummary());
		articleInfo.setCreate_by(articleInformation.getCreate_by());
		articleInfo.setModified_by(articleInformation.getModified_by());
		articleInfo.setIs_top(articleInformation.getIs_top());

		// 文章访问量加1
		articleInfo.setHits(articleInformation.getHits() + 1);
		articleInformation.setHits(articleInformation.getHits() + 1);
		articleInformationMapper.updateByPrimaryKey(articleInformation);

		// 填充文章题图信息
		ArticleImageExample exampleImg = new ArticleImageExample();
		exampleImg.or().andArticle_idEqualTo(id);
		ArticleImage articleImage = articleImageMapper.selectByExample(exampleImg).get(0);
		articleInfo.setPictureUrl(articleImage.getImage_url());
		articleInfo.setArticleImageId(articleImage.getId());

		// 增加文章内容信息表
		ArticleContentExample exampleContent = new ArticleContentExample();
		exampleContent.or().andArticle_idEqualTo(id);
		List<ArticleContent> list = articleContentMapper.selectByExampleWithBLOBs(exampleContent);
		if (list.size() == 0) {
			System.out.println("此文章不存在于文章信息表");
		} else {
			ArticleContent articleContent = list.get(0);
			articleInfo.setContent(articleContent.getContent());
			articleInfo.setArticleContentId(articleContent.getId());
		}

		// 增加文章分类信息表
		ArticleCategoryExample example = new ArticleCategoryExample();
		example.or().andArticle_idEqualTo(id);
		List<ArticleCategory> articleCategories = articleCategoryMapper.selectByExample(example);
		if (articleCategories.size() == 0) {
			System.out.println("此文章不属于任何分类");
		} else {
			ArticleCategory articleCategory = articleCategories.get(0);
			articleInfo.setArticleCategoryId(articleCategory.getId());
			CategoryExample exampleCategory = new CategoryExample();
			exampleCategory.or().andIdEqualTo(articleCategory.getCategory_id());
			Category category = categoryMapper.selectByExample(exampleCategory).get(0);
			articleInfo.setCategoryId(category.getId());
			articleInfo.setCategoryName(category.getName());
			articleInfo.setCategoryNumber(category.getArt_number());
		}
		return articleInfo;

	}

	// 得到不同分类下的相同文章
	public List<ArticleInfo> getTheSameArticle(String args){

	  String[] arr = args.split(",");
	   int len=arr.length;
		String sql="select article_id from"
				+ " (select category_id,article_id from article_category WHERE category_id in ("+args
				+ ")  GROUP BY category_id,article_id)b GROUP BY article_id HAVING count(category_id)="+len;
		 System.out.println(sql);
		 List <Map<String, Long>> resultList=articleCategoryMapper.selectByCategories(sql );
		System.out.println(resultList);
		LinkedList<ArticleInfo> articleList=new LinkedList<>();
		for (int i=0;i<resultList.size();i++) {
			System.out.println(resultList.get(i));
			Map<String, Long> tempMap = resultList.get(i);	
			System.out.println(tempMap.get("article_id"));
			long id=tempMap.get("article_id");
		   articleList.add(getOneById(id));		
		}
		Collections.sort(articleList, new Comparator<ArticleInfo>() {
			public int compare(ArticleInfo art1,ArticleInfo art2) {
				return art2.getCreate_by().compareTo(art1.getCreate_by());
			}
		});

		return articleList;
		   
		
			
		
	}

}
