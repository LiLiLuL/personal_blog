package com.chenxq.blog.personalBlog.Service;

import java.util.List;

import com.chenxq.blog.personalBlog.Domain.Draft;
import com.chenxq.blog.personalBlog.Domain.DraftExample;

public interface DraftService {
   
	 int addNew(Draft record);
	 int delete(Long id);
	 int deleteDraft(String name);
	 int updateDraft(Draft draft);
	 List<Draft> selectAllDraft();
	 List<Draft> getDrftDraftByTitle(String title);
}
