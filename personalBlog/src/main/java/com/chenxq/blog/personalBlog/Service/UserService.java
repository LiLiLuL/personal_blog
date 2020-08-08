package com.chenxq.blog.personalBlog.Service;

import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.util.List;

import com.chenxq.blog.personalBlog.Domain.User;
import com.chenxq.blog.personalBlog.Domain.UserExample;

public interface UserService {
	//添加用户
	int addUser(User record);
	//查找用户
	 List<User> findUserByName(String username);
	//删除用户
	 int deleteUser(String username);
	 
	 //根据用户名和密码确认用户
	 int findUserByNameAndPassword(String username,String password) ;
	//更新用户信息
	

}
