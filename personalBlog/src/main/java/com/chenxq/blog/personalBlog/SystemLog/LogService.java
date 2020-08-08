package com.chenxq.blog.personalBlog.SystemLog;

import javax.servlet.http.HttpServletRequest;

import org.aspectj.lang.JoinPoint;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;

import com.chenxq.blog.personalBlog.Domain.SysLog;
import com.chenxq.blog.personalBlog.Repository.SysLogMapper;

public class LogService {

    private static final String LOG_CONTENT = "[类名]:%s,[方法]:%s,[参数]:%s,[IP]:%s";

    private String username;

    @Autowired
    private SysLogMapper logRepository;

    public String initUsername(String username) {
        if(!StringUtils.isEmpty(username)){
            this.username = username;
        }
        return this.username;
    }


    
    
}
