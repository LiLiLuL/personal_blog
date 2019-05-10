package com.chenxq.blog.personalBlog.Repository;

import java.util.List;

import com.chenxq.blog.personalBlog.Domain.User;
import com.chenxq.blog.personalBlog.Domain.UserExample;

public interface UserMapper {
    int deleteByPrimaryKey(Integer user_id);
    
    int deleteByUsername(String username);

    int insert(User record);

    int insertSelective(User record);
    

    List<User> selectByExample(UserExample example);

    User selectByPrimaryKey(Integer user_id);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);
}