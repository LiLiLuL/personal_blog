package com.chenxq.blog.personalBlog.Util;

public class ResultUtil {
	 
    /**成功且带数据**/
    public static Result success(Object object){
        Result result = new Result();
        result.setCode(ResultEnum.SUCCESS.getCode());
        result.setMsg(ResultEnum.SUCCESS.getMsg());
        result.setData(object);
        return result;
    }
    /**成功且带数据和成功信息**/
    public static Result success(Object object,String msg){
        Result result = new Result();
        result.setCode(ResultEnum.SUCCESS.getCode());
        result.setMsg(msg);
        result.setData(object);
        return result;
    }
    /**成功但不带数据**/
    public static Result success(){
 
        return success(null);
    }
    /**失败**/
    public static Result error(Integer code,String msg){
        Result result = new Result();
        result.setCode(code);
        result.setMsg(msg);
        return result;
    }
	public static Result error(ResultEnum unknowError) {
		// TODO Auto-generated method stub
		Result result = new Result();
		result.setCode(unknowError.getCode());
		result.setMsg(unknowError.getMsg());
		return result;
	}
}