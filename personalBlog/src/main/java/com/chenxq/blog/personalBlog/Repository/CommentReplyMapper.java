package com.chenxq.blog.personalBlog.Repository;

import com.chenxq.blog.personalBlog.Domain.CommentReply;
import com.chenxq.blog.personalBlog.Domain.CommentReplyExample;
import java.util.List;

public interface CommentReplyMapper {
    int deleteByPrimaryKey(Long id);

    int insert(CommentReply record);

    int insertSelective(CommentReply record);

    List<CommentReply> selectByExample(CommentReplyExample example);

    CommentReply selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(CommentReply record);

    int updateByPrimaryKey(CommentReply record);
}