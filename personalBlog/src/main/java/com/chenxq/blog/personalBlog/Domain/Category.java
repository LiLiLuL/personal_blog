package com.chenxq.blog.personalBlog.Domain;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

public class Category {
    private Long id;

    private String name;

    private Byte art_number;
    @JsonFormat(locale="zh", timezone="GMT+8",pattern = "yyyy-MM-dd HH:mm:ss") 
    private Date create_by;
    @JsonFormat(locale="zh", timezone="GMT+8",pattern = "yyyy-MM-dd HH:mm:ss") 
    private Date modified_by;

    private Boolean is_effective;
    
    
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public Byte getArt_number() {
        return art_number;
    }

    public void setArt_number(Byte art_number) {
        this.art_number = art_number;
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

    public Boolean getIs_effective() {
        return is_effective;
    }

    public void setIs_effective(Boolean is_effective) {
        this.is_effective = is_effective;
    }
    @Override
    public String toString() {
    	return "{id:"+id+","+"name:"+name+","+"art_number:"+art_number
    			+","+ "create_by:"+create_by+","+"modified_by:"+modified_by+","+"is_effective:"+is_effective+"}";
    }
}