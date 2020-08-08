package com.chenxq.blog.personalBlog.Domain;

import java.util.Date;

public class SystemLog {
    private Long id;

    private String requestip;

    private String operate_type;

    private String userid;

    private String exceptioncode;

    private String exceptiondetail;

    private Date actiondate;

    private String description;

    private String actionmethod;

    private String params;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRequestip() {
        return requestip;
    }

    public void setRequestip(String requestip) {
        this.requestip = requestip == null ? null : requestip.trim();
    }

    public String getOperate_type() {
        return operate_type;
    }

    public void setOperate_type(String operate_type) {
        this.operate_type = operate_type == null ? null : operate_type.trim();
    }

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid == null ? null : userid.trim();
    }

    public String getExceptioncode() {
        return exceptioncode;
    }

    public void setExceptioncode(String exceptioncode) {
        this.exceptioncode = exceptioncode == null ? null : exceptioncode.trim();
    }

    public String getExceptiondetail() {
        return exceptiondetail;
    }

    public void setExceptiondetail(String exceptiondetail) {
        this.exceptiondetail = exceptiondetail == null ? null : exceptiondetail.trim();
    }

    public Date getActiondate() {
        return actiondate;
    }

    public void setActiondate(Date actiondate) {
        this.actiondate = actiondate;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
    }

    public String getActionmethod() {
        return actionmethod;
    }

    public void setActionmethod(String actionmethod) {
        this.actionmethod = actionmethod == null ? null : actionmethod.trim();
    }

    public String getParams() {
        return params;
    }

    public void setParams(String params) {
        this.params = params == null ? null : params.trim();
    }
}