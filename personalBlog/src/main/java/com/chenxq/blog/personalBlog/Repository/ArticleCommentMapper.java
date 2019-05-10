package com.chenxq.blog.personalBlog.Repository;

import com.chenxq.blog.personalBlog.Domain.ArticleComment;
import com.chenxq.blog.personalBlog.Domain.ArticleCommentExample;
import java.util.List;

public interface ArticleCommentMapper {
    int deleteByPrimaryKey(Long id);

    int insert(ArticleComment record);

    int insertSelective(ArticleComment record);

    List<ArticleComment> selectByExample(ArticleCommentExample example);

    ArticleComment selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(ArticleComment record);

    int updateByPrimaryKey(ArticleComment record);
}