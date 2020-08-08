package com.chenxq.blog.personalBlog.Dae;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

/**
 * 文章评论信息
 * 说明：关联了comment和article_comment两张表的信息
 *
 * @author:chenxq
 * @create:2019/4/9 11:06
 */
public class ArticleWithComment {
	//comment相关字段
	private Long id;

    private String content;
    @JsonFormat(locale="zh", timezone="GMT+8",pattern = "yyyy-MM-dd HH:mm:ss") 
    private Date create_by;

    private String email;

    private String name;

    private String ip;

    private Boolean is_effective;
    
    //article_comment基础字段
    private Long commentId; //article_comment主键id

    private Long article_id;

	@Override
	public String toString() {
		return "ArticleWithComment [id=" + id + ", content=" + content + ", create_by=" + create_by + ", email=" + email
				+ ", name=" + name + ", ip=" + ip + ", is_effective=" + is_effective + ", commentId=" + commentId
				+ ", article_id=" + article_id + "]";
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Date getCreate_by() {
		return create_by;
	}

	public void setCreate_by(Date create_by) {
		this.create_by = create_by;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

	public Boolean getIs_effective() {
		return is_effective;
	}

	public void setIs_effective(Boolean is_effective) {
		this.is_effective = is_effective;
	}

	public Long getCommentId() {
		return commentId;
	}

	public void setCommentId(Long commentId) {
		this.commentId = commentId;
	}

	public Long getArticle_id() {
		return article_id;
	}

	public void setArticle_id(Long article_id) {
		this.article_id = article_id;
	}
    

}
