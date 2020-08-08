package com.chenxq.blog.personalBlog.Repository;

import com.chenxq.blog.personalBlog.Domain.ArticleInformation;
import com.chenxq.blog.personalBlog.Domain.ArticleInformationExample;
import java.util.List;

public interface ArticleInformationMapper {
    int deleteByPrimaryKey(Long id);

    int insert(ArticleInformation record);

    int insertSelective(ArticleInformation record);

    List<ArticleInformation> selectByExample(ArticleInformationExample example);

    ArticleInformation selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(ArticleInformation record);

    int updateByPrimaryKey(ArticleInformation record);
}