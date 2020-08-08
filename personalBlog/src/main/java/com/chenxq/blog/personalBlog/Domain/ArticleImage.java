package com.chenxq.blog.personalBlog.Domain;

import java.util.Date;

public class ArticleImage {
    private Long id;

    private Long article_id;

    private String image_url;

    private Date create_by;

    private Date modified_by;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getArticle_id() {
        return article_id;
    }

    public void setArticle_id(Long article_id) {
        this.article_id = article_id;
    }

    public String getImage_url() {
        return image_url;
    }

    public void setImage_url(String image_url) {
        this.image_url = image_url == null ? null : image_url.trim();
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

	@Override
	public String toString() {
		return "ArticleImage [id=" + id + ", article_id=" + article_id + ", image_url=" + image_url + ", create_by="
				+ create_by + ", modified_by=" + modified_by + "]";
	}
       
}