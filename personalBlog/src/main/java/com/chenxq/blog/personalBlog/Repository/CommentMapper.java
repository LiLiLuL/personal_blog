package com.chenxq.blog.personalBlog.Repository;

import com.chenxq.blog.personalBlog.Domain.Comment;
import com.chenxq.blog.personalBlog.Domain.CommentExample;
import java.util.List;

public interface CommentMapper {
    int deleteByPrimaryKey(Long id);

    int insert(Comment record);

    int insertSelective(Comment record);

    List<Comment> selectByExample(CommentExample example);

    Comment selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Comment record);

    int updateByPrimaryKey(Comment record);
}