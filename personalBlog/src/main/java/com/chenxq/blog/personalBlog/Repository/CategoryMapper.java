package com.chenxq.blog.personalBlog.Repository;

import com.chenxq.blog.personalBlog.Domain.Category;
import com.chenxq.blog.personalBlog.Domain.CategoryExample;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface CategoryMapper {
    int deleteByPrimaryKey(Long id);
    int deleteByName(String name);
    int insert(Category record);
    int insertSelective(Category record);

    List<Category> selectByExample(CategoryExample example);

    Category selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Category record);

    int updateByPrimaryKey(Category record);
}