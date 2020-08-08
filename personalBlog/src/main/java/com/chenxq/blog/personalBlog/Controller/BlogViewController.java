package com.chenxq.blog.personalBlog.Controller;

import java.io.File;
import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.data.redis.RedisProperties.Lettuce;
import org.springframework.core.io.ResourceLoader;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.chenxq.blog.personalBlog.Dae.ArticleInfo;
import com.chenxq.blog.personalBlog.Dae.ArticleWithComment;
import com.chenxq.blog.personalBlog.Dae.ArticleWithImage;
import com.chenxq.blog.personalBlog.Domain.ArticleCategory;
import com.chenxq.blog.personalBlog.Domain.ArticleComment;
import com.chenxq.blog.personalBlog.Domain.ArticleImage;
import com.chenxq.blog.personalBlog.Domain.ArticleInformation;
import com.chenxq.blog.personalBlog.Domain.Category;
import com.chenxq.blog.personalBlog.Domain.CommentReply;
import com.chenxq.blog.personalBlog.Domain.Draft;
import com.chenxq.blog.personalBlog.Domain.Recommend;
import com.chenxq.blog.personalBlog.Domain.SysLog;
import com.chenxq.blog.personalBlog.Domain.User;
import com.chenxq.blog.personalBlog.Repository.ArticleCategoryMapper;
import com.chenxq.blog.personalBlog.Repository.CategoryMapper;
import com.chenxq.blog.personalBlog.Service.ArticleContentService;
import com.chenxq.blog.personalBlog.Service.CategoryService;
import com.chenxq.blog.personalBlog.Service.CommentService;
import com.chenxq.blog.personalBlog.Service.DraftService;
import com.chenxq.blog.personalBlog.Service.RecommendService;
import com.chenxq.blog.personalBlog.Service.SysLogService;
import com.chenxq.blog.personalBlog.Service.UserService;
import com.chenxq.blog.personalBlog.SystemLog.SystemControllerLog;
import com.chenxq.blog.personalBlog.Util.CommonReturnType;
import com.chenxq.blog.personalBlog.Util.FileNameUtil;
import com.chenxq.blog.personalBlog.Util.FileUploadUtil;
import com.chenxq.blog.personalBlog.Util.PasswordEncrypt;
import com.chenxq.blog.personalBlog.Util.Result;
import com.chenxq.blog.personalBlog.Util.ResultEnum;
import com.chenxq.blog.personalBlog.Util.ResultUtil;

import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import io.swagger.models.Model;


@RestController
@RequestMapping(value="/client")
public class BlogViewController {
	

	@Resource
	 private CategoryService categoryService;
	@Resource
	private UserService userService;
	@Resource
	private ArticleContentService articleService;
	@Resource
	private DraftService draftService;
    @Resource
    private SysLogService sysLogService;
    @Resource
    private CommentService commentService;
    @Resource
    private RecommendService recommendService;
	 
	 
	
	@ApiOperation(value="查询所有的分类值")
	@RequestMapping(value="/category/all",method= {RequestMethod.POST,RequestMethod.GET})
    @ResponseBody//, Model model
    public CommonReturnType  findAll(){	
		List <Category> category= categoryService.getAllCategories();
        return  CommonReturnType.create(category);
    }
	
	@ApiOperation("根据Id值查找分类")
    @ApiImplicitParam(name = "id", value = "分类的Id值", required = true, dataType = "Long")
	@RequestMapping("/category/showCategory")
    @ResponseBody//, Model model
    public CommonReturnType  findById(HttpServletRequest request){
		System.out.println("11111111");
       long id=  Long.parseLong(request.getParameter("id"));
       Category category = this.categoryService.getCategoryById(id);
        return  CommonReturnType.create(category);
    }
	
	@ApiOperation("根据名称查找分类")
    @ApiImplicitParam(name = "name", value = "分类名称", required = true, dataType = "String")
	@RequestMapping(value="/category/find",method= {RequestMethod.POST,RequestMethod.GET})
	@ResponseBody
	public CommonReturnType  findCategoryByName(@RequestParam(value="name") String name) {  
		System.out.println(name);
         List <Category> res= categoryService.getCategoryByName(name);
     	System.out.println(res);
	    return  CommonReturnType.create(res);
	}
	
	
	@ApiOperation("根据分类ID得到所有的文章题图信息")
    @ApiImplicitParam(name = "ID", value = "传一个ID值", required = true, dataType = "Long")
	@RequestMapping(value="/category/getarticles",method= {RequestMethod.POST,RequestMethod.GET})
	@ResponseBody
	public CommonReturnType  getArticles(@RequestParam Long id) {  
		List< ArticleWithImage> articlesList=articleService.getByCategoryId(id);
	  
		return CommonReturnType.create(articlesList);
	}
	
	
	@ApiOperation("根据分类ID得到其分类下最新的五篇文章")
    @ApiImplicitParam(name = "ID", value = "传一个ID值", required = true, dataType = "Long")
	@RequestMapping(value="/category/getlastarticles",method= {RequestMethod.POST,RequestMethod.GET})
	@ResponseBody
	public CommonReturnType  getLastArticles(@RequestParam Long id) {  
		List< ArticleWithImage> articlesList=articleService.listLastArticlesByCategoryId(id);	  
		if(articlesList.isEmpty()) {
			return CommonReturnType.create("", "isEmpty");
		}
		return CommonReturnType.create(articlesList);
	}
	

	@ApiOperation("获取所有的文章基础信息和题图")
	@RequestMapping(value="/article/all",method= {RequestMethod.POST,RequestMethod.GET})
	@ResponseBody
	public Result getAllArticles() {
		 List<ArticleWithImage> articles=articleService.getAll();
		 return ResultUtil.success(articles);
	}

	@ApiOperation("根据文章ID获取相关的文章信息")
	@RequestMapping(value="/article/one",method= {RequestMethod.POST,RequestMethod.GET})
	@ResponseBody
	public Result getOneArticle(@RequestParam Long id) {
		ArticleInfo article=articleService.getOneById(id);
		 return ResultUtil.success(article);
	}
	
	@ApiOperation("获取阅读量最高的五篇文章")
	@RequestMapping(value="/articles/read",method= {RequestMethod.POST,RequestMethod.GET})
	@ResponseBody
	public Result  getMostHitsArticles() {
	      List<ArticleWithImage>	 list=articleService.getReadArticles();
	     return ResultUtil.success(list);
	}
	
	@ApiOperation("获取最新的一篇文章")
	@RequestMapping(value="/articles/lastest",method= {RequestMethod.POST,RequestMethod.GET})
	@ResponseBody
	public Result  getLastArticles() {
	     ArticleWithImage	 info=articleService.getNewArticle();
	     return ResultUtil.success(info);
	}
	

	@ApiOperation("增加一条对应文章的留言")
    @ApiImplicitParam(name = "comment", value = "增加一条对应文章的留言", required = true, dataType = "Comment")
	@RequestMapping(value="/comment/add",method= {RequestMethod.POST,RequestMethod.GET})
	@ResponseBody
	@SystemControllerLog(description = "增加一条对应文章的留言",actionType = "1")
	public Result addArtticleComment(@RequestBody ArticleWithComment comment) {
		commentService.addArticleComment(comment);
		return ResultUtil.success(null, "发表文章评论成功");
	}
	
	@ApiOperation("获取相应文章下的所有评论信息")
    @ApiImplicitParam(name = "id", value = "文章id", required = true, dataType = "Long")
	@RequestMapping(value="/comment/articleAllComment",method= {RequestMethod.POST,RequestMethod.GET})
	@ResponseBody
	public Result getArticleAllComments(@RequestParam Long id) {
		List<ArticleWithComment> list=commentService.listAllArticleCommentById(id);
		if(list.isEmpty()) {
			return ResultUtil.error(ResultEnum.COMMENT_NULL);
		}
		return ResultUtil.success(list, "发表文章评论成功");
	}
	
	@ApiOperation("获取所有文章下的所有评论信息")
    @ApiImplicitParam(name = "id", value = "文章id", required = true, dataType = "Long")
	@RequestMapping(value="/comment/allComments",method= {RequestMethod.POST,RequestMethod.GET})
	@ResponseBody
	public Result getArticleAllComments() {
		List<ArticleComment> commentList=commentService.getAllArticleComments();	
		for(int i=0;i<commentList.size();i++) {
			for  ( int  j  =  commentList.size()  -   1 ; j  >  i; j -- )  {    
			     if(commentList.get(j).getArticle_id()==commentList.get(i).getArticle_id()) {
			     	commentList.remove(j);
			    }
			}
		}
		List<ArticleWithComment> list=new ArrayList<>();
		for(ArticleComment aComment : commentList) {
			List<ArticleWithComment> list2=commentService.listAllArticleCommentById(aComment.getArticle_id());
				 for(int i=0;i<list2.size();i++) {
		        	  list.add(list2.get(i));
		        }
		}
		return ResultUtil.success(list, "查找所有的文章评论");
	}
	
	
	
	@ApiOperation("获取所有的图片信息")
	@RequestMapping(value="/image/all",method= {RequestMethod.POST,RequestMethod.GET})
	@ResponseBody
	public Result  getAllImages() {
	      List<ArticleImage>	 list=commentService.getAllImages();
	      List<String> allImages=new ArrayList<>();
	      for (ArticleImage articleImage : list) {
			 allImages.add(articleImage.getImage_url());
		}	   	      
	     return ResultUtil.success(allImages);
	}
	
	@ApiOperation("获取所有的推荐")
	@RequestMapping(value="/recommend/all",method= {RequestMethod.POST,RequestMethod.GET})
	@ResponseBody
	public Result  getAllRecommends() {
	      List<Recommend>	 list=recommendService.getAllRecommends();  	    
	      if(list.isEmpty()) {
	    	  return ResultUtil.success("暂无任何推荐");
	      }
	     return ResultUtil.success(list);
	}
	
	@ApiOperation("获取不同分类下的相同文章")
    @ApiImplicitParam(name = "", value = "", required = true, dataType = "")
	@RequestMapping(value="/category/same",method= {RequestMethod.POST,RequestMethod.GET})
	@ResponseBody
	public CommonReturnType  getSameArticles(@RequestParam String args) {
	String[] arr = args.split(",");		
    List<ArticleInfo> articlesList=articleService.getTheSameArticle(args);
    if(articlesList.isEmpty()) {
    	return CommonReturnType.create("success","不存在同属于这几个分类的文章",null);
    }
	  
		return CommonReturnType.create(articlesList);
	}
	
	@ApiOperation("对对应留言回复一条评论")
    @ApiImplicitParam(name = "reply", value = "comment_reply", required = true, dataType = "")
	@RequestMapping(value="/reply/add",method= {RequestMethod.POST,RequestMethod.GET})
	@ResponseBody
	public CommonReturnType  addReply(@RequestBody CommentReply reply) {
		commentService.addCommentReply(reply);
		return CommonReturnType.create("success");
	}
	
	@ApiOperation("根据留言id查找回复")
    @ApiImplicitParam(name = "id", value = "id", required = true, dataType = "")
	@RequestMapping(value="/reply/select",method= {RequestMethod.POST,RequestMethod.GET})
	@ResponseBody
	public CommonReturnType  selectReply(@RequestParam Long comment_id){
		List<CommentReply> list=commentService.selectCommentReply(comment_id);
		return CommonReturnType.create(list);
	}
	
	@ApiOperation("删除一条回复")
    @ApiImplicitParam(name = "id", value = "id", required = true, dataType = "")
	@RequestMapping(value="/reply/delete",method= {RequestMethod.POST,RequestMethod.GET})
	@ResponseBody
	public CommonReturnType  deleteReply(@RequestParam Long id){
		commentService.deleteCommentReply(id);
		return CommonReturnType.create("删除成功");
	}
	
}
