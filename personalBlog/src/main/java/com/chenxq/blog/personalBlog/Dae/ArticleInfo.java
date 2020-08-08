package com.chenxq.blog.personalBlog.Dae;

import java.util.Arrays;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

/*
 * 文章信息表，关联了category、article_content、 article_infomation、  article_image、 article_category五张表
 */
public class ArticleInfo {
	 // article_information基础字段
    private Long id;                // 主键
    private String title;           // 文章标题
    private String summary;         // 文章简介
    private Boolean is_top;         // 文章是否置顶
    private Integer hits;       // 文章浏览量
  @JsonFormat(locale="zh", timezone="GMT+8",pattern = "yyyy-MM-dd HH:mm:ss") 
    private Date create_by;   // 文章创建时间
  @JsonFormat(locale="zh", timezone="GMT+8",pattern = "yyyy-MM-dd HH:mm:ss")  
    private Date modified_by;   //文章修改时间      "
 
    // article_content基础字段
    private Long articleContentId;  // ArticleContent表主键
    private String content;         // 文章内容

    // category基础字段
    private Long categoryId;        // 分类ID
    private String categoryName;    // 分类名称
    private Byte categoryNumber;    // 分类对应的数量
    private Long categoryArr[];

    // article_category基础字段
    private Long articleCategoryId; // ArticleCategory表主键

    // article_image基础字段
    private Long articleImageId;  // ArticlePicture表主键
    private String pictureUrl;      // 文章题图url
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getSummary() {
		return summary;
	}
	public void setSummary(String summary) {
		this.summary = summary;
	}
	public Boolean getIs_top() {
		return is_top;
	}
	public void setIs_top(Boolean is_top) {
		this.is_top = is_top;
	}
	public Integer getHits() {
		return hits;
	}
	public void setHits(Integer hits) {
		this.hits = hits;
	}
	
	public Date getCreate_by() {
		return create_by;
	}
	
	public void setCreate_by(Date create_by) {
		this.create_by = create_by;
	}
	 
	public Date getModified_by() {
		return modified_by;
	}
	public void setModified_by(Date modified_by) {
		this.modified_by = modified_by;
	}
	public Long getArticleContentId() {
		return articleContentId;
	}
	public void setArticleContentId(Long articleContentId) {
		this.articleContentId = articleContentId;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public Long getCategoryId() {
		return categoryId;
	}
	public void setCategoryId(Long categoryId) {
		this.categoryId = categoryId;
	}
	public String getCategoryName() {
		return categoryName;
	}
	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}
	public Byte getCategoryNumber() {
		return categoryNumber;
	}
	public void setCategoryNumber(Byte categoryNumber) {
		this.categoryNumber = categoryNumber;
	}
	public Long getArticleCategoryId() {
		return articleCategoryId;
	}
	public void setArticleCategoryId(Long articleCategoryId) {
		this.articleCategoryId = articleCategoryId;
	}
	public Long getArticleImageId() {
		return articleImageId;
	}
	public void setArticleImageId(Long articleImageId) {
		this.articleImageId = articleImageId;
	}
	public String getPictureUrl() {
		return pictureUrl;
	}
	public void setPictureUrl(String pictureUrl) {
		this.pictureUrl = pictureUrl;
	}
	public Long[] getCategoryArr() {
		return categoryArr;
	}
	public void setCategoryArr(Long[] categoryArr) {
		this.categoryArr = categoryArr;
	}
	
	@Override
	public String toString() {
		return "ArticleInfo [id=" + id + ", title=" + title + ", summary=" + summary + ", is_top=" + is_top + ", hits="
				+ hits + ", create_by=" + create_by + ", modified_by=" + modified_by + ", articleContentId="
				+ articleContentId + ", content=" + content + ", categoryId=" + categoryId + ", categoryName="
				+ categoryName + ", categoryNumber=" + categoryNumber + ", categoryArr=" + Arrays.toString(categoryArr)
				+ ", articleCategoryId=" + articleCategoryId + ", articleImageId=" + articleImageId + ", pictureUrl="
				+ pictureUrl +"]";
	}
    

}
