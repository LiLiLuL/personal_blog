package com.chenxq.blog.personalBlog.Repository;

import com.chenxq.blog.personalBlog.Domain.Recommend;
import com.chenxq.blog.personalBlog.Domain.RecommendExample;
import java.util.List;

public interface RecommendMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Recommend record);

    int insertSelective(Recommend record);

    List<Recommend> selectByExample(RecommendExample example);

    Recommend selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Recommend record);

    int updateByPrimaryKey(Recommend record);
}