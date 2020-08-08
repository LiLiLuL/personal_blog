package com.chenxq.blog.personalBlog.Service.Impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;


import com.chenxq.blog.personalBlog.Domain.Category;
import com.chenxq.blog.personalBlog.Domain.CategoryExample;
import com.chenxq.blog.personalBlog.Repository.CategoryMapper;
import com.chenxq.blog.personalBlog.Service.CategoryService;

@Service("com.chenxq.blog.personalBlog.Service.CategoryService")
public class CategoryServiceImpl implements CategoryService {
	
	@Resource
	private CategoryMapper categoryDao;
	//查找所有的分类值
	public List<Category> getAllCategories(){	
		return  categoryDao.selectByExample(null);
	}
	//根据ID值查找分类
	 public Category getCategoryById(long categoryId) {
		 return categoryDao.selectByPrimaryKey(categoryId);
	 } 
	 //根据name值查找分类
	 public List<Category> getCategoryByName(String name) {
		 CategoryExample example=new CategoryExample();
		 com.chenxq.blog.personalBlog.Domain.CategoryExample.Criteria criteria=example.createCriteria();
		 criteria.andNameEqualTo(name);
		  return categoryDao.selectByExample(example);
	 }
   
   //增加一个分类
	public boolean addCategory(Category record) {
		  boolean flag=false;
		  try {
			  categoryDao.insertSelective(record);
			  flag=true;
		  }catch(Exception e) {
			  e.printStackTrace();
		  }
		  return flag;
	 }
	//删除一个分类
	public  boolean deleteCategory(String name) {
		boolean flag=false;
		try {
		       categoryDao.deleteByName(name);
		       flag=true;			
		}catch(Exception e) {
			 e.printStackTrace();
		}
		 return flag;
	}
	//修改一个分类名称
	  public String update(Category record) {
	    int a= categoryDao.updateByPrimaryKeySelective(record);	
	    if(a==0) {
	    	return "failed";
	    }		 
		  return "success";
	  }
}
