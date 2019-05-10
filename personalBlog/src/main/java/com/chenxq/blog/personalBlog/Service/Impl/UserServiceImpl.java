package com.chenxq.blog.personalBlog.Service.Impl;

import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.chenxq.blog.personalBlog.Domain.User;
import com.chenxq.blog.personalBlog.Domain.UserExample;
import com.chenxq.blog.personalBlog.Domain.UserExample.Criteria;
import com.chenxq.blog.personalBlog.Repository.UserMapper;
import com.chenxq.blog.personalBlog.Service.UserService;
import com.chenxq.blog.personalBlog.Util.PasswordEncrypt;
@Service
public class UserServiceImpl  implements UserService{
	@Resource
	private UserMapper userDao;
	
	
	private PasswordEncrypt passwordEncrypt=new PasswordEncrypt();
	
	public int addUser(User record) {
		return userDao.insertSelective(record);
	}
	 
	//根据用户名查找用户信息
	public List<User> findUserByName(String username){
		UserExample example=new UserExample();
		com.chenxq.blog.personalBlog.Domain.UserExample.Criteria criteria=example.createCriteria();
		criteria.andUsernameEqualTo(username);
		return userDao.selectByExample(example);
		
	}
	//根据用户名删除用户
	public int deleteUser(String username) {
		return userDao.deleteByUsername(username);
	}
   
	
	public  int findUserByNameAndPassword(String username,String password) {
		  try {
			password=passwordEncrypt.encodeByMd5(password);
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		  UserExample example=new UserExample();
		 com.chenxq.blog.personalBlog.Domain.UserExample.Criteria criteria=example.createCriteria();
	     criteria.andUsernameEqualTo(username);
	     criteria.andPasswordEqualTo(password);
		 List<User> resList=userDao.selectByExample(example);
		 if(resList.isEmpty()) {
			 System.out.println("用户名或密码错误");
			 return 0;
		 }
		 System.out.println("正确");
		 return 1;
		  
		  
	}
}
