package com.chenxq.blog.personalBlog.Service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.chenxq.blog.personalBlog.Domain.Draft;
import com.chenxq.blog.personalBlog.Domain.DraftExample;
import com.chenxq.blog.personalBlog.Repository.DraftMapper;
import com.chenxq.blog.personalBlog.Service.DraftService;

@Service
public class DraftServiceImpl  implements DraftService{
	@Autowired
	DraftMapper draftMapper;
	//增加一篇新的草稿
    public int addNew(Draft record) {
    	 return draftMapper.insertSelective(record);
    }
    //删除草稿
    public int deleteDraft(String name) {
    	return draftMapper.deleteByTitle(name);
    }
    //更新草稿
    public int updateDraft(Draft draft) {
    	return draftMapper.updateByPrimaryKeySelective(draft);
    }
    //查找所有草稿
    public List<Draft> selectAllDraft(){
    	return draftMapper.selectByExampleWithBLOBs(null);
    }
    //根据标题查找草稿
    public  List<Draft> getDrftDraftByTitle(String title){
    	DraftExample example=new DraftExample();
    	com.chenxq.blog.personalBlog.Domain.DraftExample.Criteria criteria=example.createCriteria();
    	criteria.andTitleEqualTo(title);
    	return draftMapper.selectByExampleWithBLOBs(example);
    }
    //根据ID值删除草稿
    public int delete(Long id) {
    	return draftMapper.deleteByPrimaryKey(id);
    }

}
