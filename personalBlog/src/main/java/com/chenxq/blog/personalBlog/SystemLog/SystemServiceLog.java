package com.chenxq.blog.personalBlog.SystemLog;
import java.lang.annotation.*;

/**
 * @Description:  定义注解，拦截service
 * @Author: chenxq
 * @CreateDate: 2019/4/8 9:58
 * @Version: 1.0
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.METHOD})
@Documented
public @interface SystemServiceLog {
	 //定义成员
    String decription() default "" ;
}
