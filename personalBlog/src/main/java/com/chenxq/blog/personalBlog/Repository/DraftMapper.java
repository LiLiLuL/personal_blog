package com.chenxq.blog.personalBlog.Repository;

import com.chenxq.blog.personalBlog.Domain.Draft;
import com.chenxq.blog.personalBlog.Domain.DraftExample;
import java.util.List;

public interface DraftMapper {
    int deleteByPrimaryKey(Long id);
    
    int deleteByTitle(String name);

    int insert(Draft record);

    int insertSelective(Draft record);

    List<Draft> selectByExampleWithBLOBs(DraftExample example);

    List<Draft> selectByExample(DraftExample example);

    Draft selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Draft record);

    int updateByPrimaryKeyWithBLOBs(Draft record);

    int updateByPrimaryKey(Draft record);
}