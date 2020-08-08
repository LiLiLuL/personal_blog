package com.chenxq.blog.personalBlog.Domain;

public class User {
	private Integer user_id;

    private String username;

    private String password;

    private String lastloginip;

    private Integer lastlogintime;

    private String email;

    private String realname;

    private Boolean status;

    public Integer getUser_id() {
        return user_id;
    }

    public void setUser_id(Integer user_id) {
        this.user_id = user_id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username == null ? null : username.trim();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    public String getLastloginip() {
        return lastloginip;
    }

    public void setLastloginip(String lastloginip) {
        this.lastloginip = lastloginip == null ? null : lastloginip.trim();
    }

    public Integer getLastlogintime() {
        return lastlogintime;
    }

    public void setLastlogintime(Integer lastlogintime) {
        this.lastlogintime = lastlogintime;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
    }

    public String getRealname() {
        return realname;
    }

    public void setRealname(String realname) {
        this.realname = realname == null ? null : realname.trim();
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }
    @Override
    public String toString() {
    	return "{user_id:"+user_id+","+"username:"+username+","+"password:"+password
    			+","+ "lastloginip:"+lastloginip+","+"lastlogintime:"+lastlogintime+","+"email:"+
    			email+"realname:"+realname+"status:"+status+"}";
    }
}
