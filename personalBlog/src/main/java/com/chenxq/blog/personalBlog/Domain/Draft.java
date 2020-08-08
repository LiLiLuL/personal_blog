package com.chenxq.blog.personalBlog.Domain;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

public class Draft {
    private Long id;

    private String author;

    private String title;

    private String summary;
   @JsonFormat(locale="zh", timezone="GMT+8",pattern = "yyyy-MM-dd HH:mm:ss") 
    private Date create_by;
   @JsonFormat(locale="zh", timezone="GMT+8",pattern = "yyyy-MM-dd HH:mm:ss") 
    private Date modified_by;

    private String content;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author == null ? null : author.trim();
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary == null ? null : summary.trim();
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

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }
}