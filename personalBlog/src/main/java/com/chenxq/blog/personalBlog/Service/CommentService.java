package com.chenxq.blog.personalBlog.Service;

import java.util.List;

import com.chenxq.blog.personalBlog.Dae.ArticleWithComment;
import com.chenxq.blog.personalBlog.Domain.ArticleComment;
import com.chenxq.blog.personalBlog.Domain.ArticleImage;
import com.chenxq.blog.personalBlog.Domain.Comment;
import com.chenxq.blog.personalBlog.Domain.CommentReply;

/**
 * @Description:评论模块service
 * @Author: chenxq
 * @CreateDate: 2019/4/9 11:14
 * @Version: 1.0
 */
public interface CommentService {
	//增加一条留言
	void addComment(Comment comment);
    //对应文章增加文章
    void addArticleComment(ArticleWithComment articleWithComment);
    //删除留言
    void deleteCommentById(Long id);
    //删除文章中的留言
    void deleteArticleCommentById(Long id);
     //得到所有的题图信息
    List<ArticleImage> getAllImages();
    //得到所有的留言
    List<Comment> listAllComment();
   //根据文章id得到当前文章所有的评论
    List<ArticleWithComment > listAllArticleCommentById(Long id);
    //得到所有文章的所有评论
    List<ArticleComment> getAllArticleComments();
    //根据留言id增加回复
    void addCommentReply(CommentReply commentReply);
    //删除回复
    void deleteCommentReply(Long id);
    //根据留言id查找回复
    List<CommentReply> selectCommentReply(Long comment_id);
}
