package com.chenxq.blog.personalBlog.Util;

public enum ResultEnum {
	UNKNOW_ERROR(-1,"未知错误"),
	SUCCESS(1,"成功"),
	CATEGORY_NULL(101,"此分类不存在"),
	CATEGORY_EXISTS(102,"此分类已存在"),
	UPLOAD_FAILED(202,"图片上传失败"),
	USER_EXISTS(301,"此用户不存在"),
	COMMENT_NULL(203,"此文章暂无评论"),
	;
	private  Integer code;
	private  String msg;
		
   ResultEnum(Integer code,String msg) {
		// TODO Auto-generated constructor stub
	   this.code=code;
	   this.msg=msg;
	}



    public Integer getCode() {
      	return code;
    }



    public void setCode(Integer code) {
	   this.code = code;
    }



   public String getMsg() {
	    return msg;
    }



     public void setMsg(String msg) {
	    this.msg = msg;
      }
 
	
	

}
