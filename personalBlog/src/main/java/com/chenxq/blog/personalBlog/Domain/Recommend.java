package com.chenxq.blog.personalBlog.Domain;

import java.io.Serializable;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

public class Recommend {
    private Integer id;

    private String url;

    private String title;

    private String summary;
   @JsonFormat(locale="zh", timezone="GMT+8",pattern = "yyyy-MM-dd HH:mm:ss") 
    private Date create_by;

    private Boolean is_effective;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url == null ? null : url.trim();
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

    public Boolean getIs_effective() {
        return is_effective;
    }

    public void setIs_effective(Boolean is_effective) {
        this.is_effective = is_effective;
    }

	@Override
	public String toString() {
		return "Recommend [id=" + id + ", url=" + url + ", title=" + title + ", summary=" + summary + ", create_by="
				+ create_by + ", is_effective=" + is_effective + "]";
	}
}