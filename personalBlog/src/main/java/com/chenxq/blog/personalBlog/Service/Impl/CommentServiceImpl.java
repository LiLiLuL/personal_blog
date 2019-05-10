package com.chenxq.blog.personalBlog.Service.Impl;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.chenxq.blog.personalBlog.Dae.ArticleWithComment;
import com.chenxq.blog.personalBlog.Domain.ArticleComment;
import com.chenxq.blog.personalBlog.Domain.ArticleCommentExample;
import com.chenxq.blog.personalBlog.Domain.ArticleImage;
import com.chenxq.blog.personalBlog.Domain.ArticleImageExample;
import com.chenxq.blog.personalBlog.Domain.Comment;
import com.chenxq.blog.personalBlog.Domain.CommentExample;
import com.chenxq.blog.personalBlog.Domain.CommentReply;
import com.chenxq.blog.personalBlog.Domain.CommentReplyExample;
import com.chenxq.blog.personalBlog.Repository.ArticleCommentMapper;
import com.chenxq.blog.personalBlog.Repository.ArticleImageMapper;
import com.chenxq.blog.personalBlog.Repository.CommentMapper;
import com.chenxq.blog.personalBlog.Repository.CommentReplyMapper;
import com.chenxq.blog.personalBlog.Service.CommentService;

/**
 * @Description:评论模块service实现
 * @Author: chenxq
 * @CreateDate: 2019/4/9 11:14
 * @Version: 1.0
 */
@Service
public class CommentServiceImpl  implements CommentService{
	@Autowired
	CommentMapper commentMapper;
	@Autowired
	ArticleCommentMapper articleCommentMapper;
	@Autowired
	ArticleImageMapper articleImageMapper;
	@Autowired
	CommentReplyMapper commentReplyMapper;
	
	/*
	 * (non-Javadoc)
	 * @see com.chenxq.blog.personalBlog.Service.CommentService#addComment(com.chenxq.blog.personalBlog.Domain.Comment)
	 * 添加一条评论信息
	 * 
	 */
	public void addComment(Comment comment) {
		commentMapper.insertSelective(comment);
	}
	
	/*
	 * (non-Javadoc)
	 * 增加一条文章评论信息
	 * @see com.chenxq.blog.personalBlog.Service.CommentService#addArticleComment(com.chenxq.blog.personalBlog.Dae.ArticleWithComment)
	 */
	public   void addArticleComment(ArticleWithComment articleWithComment) {
		//先更新comment表
		Comment comment=new Comment();
		comment.setId(articleWithComment.getId());
		comment.setContent(articleWithComment.getContent());
		comment.setCreate_by(articleWithComment.getCreate_by());
		comment.setName(articleWithComment.getName());
		HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
	    String ip = request.getRemoteAddr();
		comment.setIp(ip);
		comment.setEmail(articleWithComment.getEmail());
		addComment(comment);
		//再更新article_comment信息
		CommentExample example = new CommentExample();
        example.setOrderByClause("id desc");
        Long lastestCommentId = commentMapper.selectByExample(example).get(0).getId();
        ArticleComment articleComment = new ArticleComment();
        articleComment.setComment_id(lastestCommentId);
        articleComment.setArticle_id(articleWithComment.getArticle_id());
        articleComment.setCreate_by(articleWithComment.getCreate_by());
        articleComment.setModified_by(articleWithComment.getCreate_by());
        articleCommentMapper.insertSelective(articleComment);
	}
	/*
     * 通过留言ID删除一条数据
     * 说明：并不是直接删除数据库中的数据而是直接将is_effective字段置为false
     *
     * @param id 这里的id为comment的主键id
     */
	public  void deleteCommentById(Long id) {
		Comment comment=commentMapper.selectByPrimaryKey(id);
		comment.setIs_effective(false);
		commentMapper.updateByPrimaryKeySelective(comment);
	}
	
	/*
     * 通过留言ID删除一条数据
     * 说明：并不是直接删除数据库中的数据而是直接将is_effective字段置为false，这里有两个表的此字段均被设置为false
     *
     * @param id 这里的id为article_comment的主键id
     */
	public  void deleteArticleCommentById(Long id) {
		ArticleComment articleComment=articleCommentMapper.selectByPrimaryKey(id);
		articleComment.setIs_effective(false);
		articleCommentMapper.updateByPrimaryKeySelective(articleComment);
		deleteCommentById(articleComment.getComment_id());
	}
	
	/*
	 * (non-Javadoc)
	 * @see com.chenxq.blog.personalBlog.Service.CommentService#listAllComment()
	 * 查询所有有效的comment信息
	 */
	
	public List<Comment> listAllComment(){
		CommentExample example=new CommentExample();
		example.or().andIs_effectiveEqualTo(true);
		return commentMapper.selectByExample(example);
	}
   
	/*
	 * (non-Javadoc)
	 * @see com.chenxq.blog.personalBlog.Service.CommentService#listAllArticleCommentById(java.lang.Long)
	 * 查找对应文章下的所有评论
	 * @param id 这里的id指的的article_information中的文章id 
	 */
	public List<ArticleWithComment > listAllArticleCommentById(Long id){
		List<ArticleWithComment> comments = new ArrayList<>();
        ArticleCommentExample example = new ArticleCommentExample();
        example.or().andArticle_idEqualTo(id);
        List<ArticleComment> articleComments = articleCommentMapper.selectByExample(example);
        // 填充对应的评论信息
        for (ArticleComment articleComment : articleComments) {
            if (true == articleComment.getIs_effective()) {
                ArticleWithComment articleCommentDto = new ArticleWithComment();
                articleCommentDto.setCommentId(articleComment.getComment_id());
                articleCommentDto.setArticle_id(articleComment.getArticle_id());
                articleCommentDto.setCreate_by(articleComment.getCreate_by());
                // 查询对应的评论信息
                Comment comment = commentMapper.selectByPrimaryKey(articleComment.getComment_id());
                articleCommentDto.setId(comment.getId());
                articleCommentDto.setContent(comment.getContent());
                articleCommentDto.setEmail(comment.getEmail());
                articleCommentDto.setIp(comment.getIp());
                articleCommentDto.setName(comment.getName());
                comments.add(articleCommentDto);
            }
        }
        return comments;
    }
	/*
	 * (non-Javadoc)
	 * 获取所有的图片信息
	 * @see com.chenxq.blog.personalBlog.Service.CommentService#getAllImages()
	 */
	public  List<ArticleImage> getAllImages(){
	
		return articleImageMapper.selectByExample(null);	
	}
	
	/*
	 * (non-Javadoc)
	 * 获取所有的article_comment
	 * @see com.chenxq.blog.personalBlog.Service.CommentService#getAllArticleComments()
	 */
	public  List<ArticleComment> getAllArticleComments(){
		return articleCommentMapper.selectByExample(null);
		
	}
	/*
	 * (non-Javadoc)
	 * 根据留言id增加回复comment_reply
	 * @see com.chenxq.blog.personalBlog.Service.CommentService#addCommentReply(com.chenxq.blog.personalBlog.Domain.CommentReply)
	 */
	public   void addCommentReply(CommentReply commentReply) {
		HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
	    String ip = request.getRemoteAddr();
	    commentReply.setIp(ip);
		 commentReplyMapper.insertSelective(commentReply);
		 
	}
	/*
	 * (non-Javadoc)
	 * 根据回复id删除回复
	 * @see com.chenxq.blog.personalBlog.Service.CommentService#deleteCommentReply(java.lang.Long)
	 */
	public   void deleteCommentReply(Long id) {
		CommentReply record=commentReplyMapper.selectByPrimaryKey(id);
		record.setIs_effective(false);
		commentReplyMapper.updateByPrimaryKeySelective(record);
	}
	/*
	 * (non-Javadoc)
	 * 根据留言id查找回复
	 * @see com.chenxq.blog.personalBlog.Service.CommentService#selectCommentReply(java.lang.Long)
	 */
	public  List<CommentReply> selectCommentReply(Long comment_id){
		   CommentReplyExample example=new CommentReplyExample();
		   example.or().andComment_idEqualTo(comment_id);
		    List<CommentReply> list=commentReplyMapper.selectByExample(example);
		    LinkedList< CommentReply> theList=new LinkedList<>();
		    for(CommentReply reply:list) {
		    	if(true==reply.getIs_effective()) {
		    		theList.add(reply);
		    	}
		    }
		    return theList;
	}
}
