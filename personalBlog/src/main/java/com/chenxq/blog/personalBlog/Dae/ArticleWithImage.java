package com.chenxq.blog.personalBlog.Dae;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

public class ArticleWithImage {
	 // article_information基础字段
    private Long id;                // 主键
    private String title;           // 文章标题
    private String summary;         // 文章简介
    private Boolean is_top;         // 文章是否置顶
    private Integer hits;       // 文章浏览量
    // article_image基础字段
    private Long articleImageId;  // ArticlePicture表主键
    private String pictureUrl;      // 文章题图url
    @JsonFormat(locale="zh", timezone="GMT+8",pattern = "yyyy-MM-dd HH:mm:ss") 
    private Date  create_by;
    
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
	
	public Date getCreate_by() {
		return create_by;
	}
	public void setCreate_by(Date create_by) {
		this.create_by = create_by;
	}
	@Override
	public String toString() {
		return "ArticleWithImage [id=" + id + ", title=" + title + ", summary=" + summary + ", is_top=" + is_top
				+ ", hits=" + hits + ", articleImageId=" + articleImageId + ", pictureUrl=" + pictureUrl
				+ ", create_by=" + create_by + "]";
	}
    

}
