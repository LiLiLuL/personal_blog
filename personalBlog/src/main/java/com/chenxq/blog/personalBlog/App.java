package com.chenxq.blog.personalBlog;

import javax.servlet.MultipartConfigElement;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.MultipartConfigFactory;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * Hello world!
 *
 */

@SpringBootApplication
@MapperScan("com.chenxq.blog.personalBlog.Repository")

public class App extends SpringBootServletInitializer
{
    public static void main( String[] args )
    {
    	SpringApplication.run(App.class,args);
    }
    
  /*
   * 
   *文件上传临时目录
   */
    @Bean
    MultipartConfigElement multipartConfigElement() {
    	MultipartConfigFactory factory=new MultipartConfigFactory();
    	factory.setLocation("D:/temp");
    	return factory.createMultipartConfig();
    }
}