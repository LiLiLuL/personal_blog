package com.chenxq.blog.personalBlog.Service;

import java.util.List;


import com.chenxq.blog.personalBlog.Domain.Category;

public interface CategoryService {
	    public List<Category> getAllCategories();
         public Category getCategoryById(long categoryId);
         public List<Category> getCategoryByName(String name);
         boolean addCategory(Category record);
         boolean deleteCategory(String name);
         public String update(Category record);
}
