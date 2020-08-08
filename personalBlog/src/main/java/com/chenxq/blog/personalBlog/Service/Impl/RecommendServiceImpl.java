package com.chenxq.blog.personalBlog.Service.Impl;

import java.util.Iterator;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.chenxq.blog.personalBlog.Domain.Recommend;
import com.chenxq.blog.personalBlog.Repository.RecommendMapper;
import com.chenxq.blog.personalBlog.Service.RecommendService;
/**
 * @Description:推荐管理模块serviceImpl
 * @Author: chenxq
 * @CreateDate: 2019/4/27 10：29
 * @Version: 1.0
 */
@Service
public class RecommendServiceImpl implements RecommendService{
	@Resource
	RecommendMapper  recommendMapper;
	//增加一条推荐
   public  void addRecommend(Recommend recommend) {
    	    recommendMapper.insertSelective(recommend); 	
    }
    //更改一条推荐信息
    public void updateRecommend(Recommend recommend) { 	
    	  recommendMapper.updateByPrimaryKeySelective(recommend);
    }
    //根据id值删除一条推荐
   public  void deleteRecommend(Integer id) {
	   Recommend recommend=recommendMapper.selectByPrimaryKey(id);
	   recommend.setIs_effective(false);
	   recommendMapper.updateByPrimaryKey(recommend);
    	
    }
    //得到所有的推荐列表
    public List<Recommend> getAllRecommends(){
    	List<Recommend> list=recommendMapper.selectByExample(null);
    	Iterator<Recommend> it = list.iterator();
    	while(it.hasNext()){
    	    Recommend x = it.next();
    	    if(x.getIs_effective()==false){
    	        it.remove();
    	    }
    	}
    	
    	return  list;
    }
}
