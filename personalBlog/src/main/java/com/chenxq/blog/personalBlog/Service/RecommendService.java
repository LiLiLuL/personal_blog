package com.chenxq.blog.personalBlog.Service;

import java.util.List;

import com.chenxq.blog.personalBlog.Domain.Recommend;

/**
 * @Description:推荐管理模块service
 * @Author: chenxq
 * @CreateDate: 2019/4/27 10：29
 * @Version: 1.0
 */
public interface RecommendService {
	//增加一条推荐
    void addRecommend(Recommend recommend);
    //根据id值更改一条推荐信息
    void updateRecommend(Recommend recommend);
    //根据id值删除一条推荐
    void deleteRecommend(Integer id);
    //得到所有的推荐列表
    public List<Recommend> getAllRecommends();
    
}
