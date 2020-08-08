package com.chenxq.blog.personalBlog.Controller;

import java.io.File;
import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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
import com.chenxq.blog.personalBlog.Domain.ArticleComment;
import com.chenxq.blog.personalBlog.Domain.ArticleImage;
import com.chenxq.blog.personalBlog.Domain.Category;
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
@RequestMapping(value="/admin")
public class AdminManagerSystem {
	

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
	 
	 
	@ApiOperation("增加一条分类")
    @ApiImplicitParam(name = "name", value = "分类名称", required = true, dataType = "String")
	@RequestMapping(value="/category/add",method=RequestMethod.POST)
	 @ResponseBody
	 @SystemControllerLog(description = "增加一条分类",actionType = "1")
	public Result  addCategory(@RequestBody Category obj) {
	    List <Category> res= categoryService.getCategoryByName(obj.getName());
	    System.out.println(res.isEmpty());
	    if(res.isEmpty()==false) {
	        System.out.println("重复啦");       	
		    return  ResultUtil.error(102, "此分类已存在");    
	    }
	    boolean flag=categoryService.addCategory(obj);
	 	    if(!flag) {
	 	    	  return  ResultUtil.error(-1, "添加失败");    	
	 	    }
	 	    return  ResultUtil.success(null,"添加分类"+obj.getName()+"成功");    	 	    	  	    	
	    }
	
	
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
	
	@ApiOperation("根据名称删除分类")
    @ApiImplicitParam(name = "name", value = "分类名称", required = true, dataType = "String")
	@RequestMapping(value="/category/delete",method=RequestMethod.GET)
	@ResponseBody
	@SystemControllerLog(description = "删除一条分类",actionType = "3")
	public Result  deleteCategoryByName(@RequestParam(value="name") String name) {  
		System.out.println(name);
	    List <Category> res= categoryService.getCategoryByName(name);
	    if(res.isEmpty()) {
	    	return ResultUtil.error(ResultEnum.CATEGORY_NULL.getCode(),ResultEnum.CATEGORY_NULL.getMsg());
	    }
		boolean flag=categoryService.deleteCategory(name);
		if(flag) {
			 return  ResultUtil.success("", "删除分类"+name+"成功");
		}else {
			return  ResultUtil.error(ResultEnum.UNKNOW_ERROR);
		}
	   
	}
	
	@ApiOperation("根据ID修改分类名称")
    @ApiImplicitParam(name = "name", value = "分类名称", required = true, dataType = "String")
	@RequestMapping(value="/category/update",method= {RequestMethod.POST,RequestMethod.GET})
	@ResponseBody
	@SystemControllerLog(description = "修改分类",actionType = "2")
	public Result  updateCategoryByName(@RequestBody Category record) {  
	    Category cat=categoryService.getCategoryById(record.getId());
	    if(cat==null) {
	    	return ResultUtil.error(ResultEnum.CATEGORY_NULL);
	    }
		 List <Category> res= categoryService.getCategoryByName(record.getName());
		 if(res.isEmpty()==false) {
		    	return ResultUtil.error(ResultEnum.CATEGORY_EXISTS);
		 }
		String status=categoryService.update(record);
		return ResultUtil.success(status,"修改分类为"+record.getName()+"成功");  
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
	
	
	@ApiOperation("图片上传")
    @ApiImplicitParam(name = "file", value = "文件", required = true, dataType = "File")
	@RequestMapping(value="/upload",method= {RequestMethod.POST,RequestMethod.GET})
	@ResponseBody
	public Result upload(@RequestParam("file")MultipartFile file,HttpServletRequest request) {
		//定义要上传文件 的存放路径
        String localPath="F:/blog-images/";
        //获得文件名字
        String fileName=file.getOriginalFilename();
        fileName= FileNameUtil.getFileName(fileName);
        File dest = new File(localPath + fileName);
        if(FileUploadUtil.upload(file, localPath, fileName)){
            // 将上传的文件写入到服务器端文件夹
            // 获取当前项目运气的完整url
            String requestURL = request.getRequestURL().toString();
            // 获取当前项目的请求路径url
            String requestURI = request.getRequestURI();
            // 得到去掉了uri的路径
            String url = requestURL.substring(0, requestURL.length()-requestURI.length() + 1);
           String imgUrl="images/"+ fileName;

            
            return  ResultUtil.success(imgUrl);

        }       
        // 返回
        return ResultUtil.error(202,"未知错误导致上传失败");
    }
	
	
	@ApiOperation("添加用户")
    @ApiImplicitParam(name = "adduser", value = "添加一个新的用户", required = true, dataType = "File")
	@RequestMapping(value="/adduser",method= {RequestMethod.POST,RequestMethod.GET})
	@ResponseBody
	@SystemControllerLog(description = "添加用户信息",actionType = "1")
	public Result addUser(@RequestBody User user) throws NoSuchAlgorithmException, UnsupportedEncodingException {
		if(!userService.findUserByName(user.getUsername()).isEmpty()) {
			return ResultUtil.error(302, "此用户已存在");
		}
		String pwd=PasswordEncrypt.encodeByMd5(user.getPassword());
		 user.setPassword(pwd);
		 int a=userService.addUser(user);
		 return ResultUtil.success(a,"添加用户"+user.getUsername()+"成功");            
    }
	
	@ApiOperation("查找用户")
    @ApiImplicitParam(name = "username", value = "查找一个用户名", required = true, dataType = "String")
	@RequestMapping(value="/finduser",method= {RequestMethod.POST,RequestMethod.GET})
	@ResponseBody
	@SystemControllerLog(description = "查询用户信息",actionType = "4")
	public Result findUser(@RequestParam String username){
	    List<User> resList=userService.findUserByName(username);
	    if(resList.isEmpty()) {
	    	return ResultUtil.error(404, "此用户不存在");
	    }
		 return ResultUtil.success(resList, "根据用户名查找用户详情信息成功");       
    }
	
	
	@ApiOperation("删除用户")
    @ApiImplicitParam(name = "username", value = "查找一个用户名", required = true, dataType = "String")
	@RequestMapping(value="/deleteuser",method= {RequestMethod.POST,RequestMethod.GET})
	@ResponseBody
	@SystemControllerLog(description = "删除用户信息",actionType = "3")
	public Result deleteUser(@RequestParam String username){
	    if(userService.findUserByName(username).isEmpty()) {
	    	return ResultUtil.error(301, "删除失败,该用户不存在");	    	
	    }
	    userService.deleteUser(username);
		 return ResultUtil.success("","删除用户"+username+"成功");            
    }
	
	@ApiOperation("根据用户名和密码查找用户")
    @ApiImplicitParam(name = "username", value = "查找一个用户名和密码", required = true, dataType = "String")
	@RequestMapping(value="/checkuser",method= {RequestMethod.POST,RequestMethod.GET})
	@ResponseBody
	public Result checkUser(@RequestBody User user){
	    if(userService.findUserByName(user.getUsername()).isEmpty()) {
	    	return ResultUtil.error(302, "用户名不存在");
	    }
	    int res=userService.findUserByNameAndPassword(user.getUsername(), user.getPassword());
	    if(res==0) {
	    	return ResultUtil.error(301, "用户名或密码错误");
	    }
		 return ResultUtil.success();            
    }
	
	@ApiOperation("增加一个文章信息")
	@RequestMapping(value="/article/add",method= {RequestMethod.POST,RequestMethod.GET})
	@ResponseBody
	@SystemControllerLog(description = "添加文章信息",actionType = "1")
	public Result addArticle(@RequestBody ArticleInfo articleInfo) {

		articleService.addArticle(articleInfo);
		draftService.delete(articleInfo.getId());
		return ResultUtil.success("","添加文章成功");		
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

	
	
	
	
	
	
	
	
	@ApiOperation("增加一篇新的草稿")
	@RequestMapping(value="/draft/add",method= {RequestMethod.POST,RequestMethod.GET})
	@ResponseBody
	public Result addNewDraft(@RequestBody Draft draft) {
          int res=draftService.addNew(draft);
          if(res==0) {
        	  return ResultUtil.error(401, "存储失败");
          }
          return ResultUtil.success("暂存草稿成功");
		
	}
	
	@ApiOperation("查找所有草稿")
	@RequestMapping(value="/draft/all",method= {RequestMethod.POST,RequestMethod.GET})
	@ResponseBody
	public Result addNewDraft() {
          List<Draft> resDrafts=draftService.selectAllDraft();
          return ResultUtil.success(resDrafts);
		
	}
	
	@ApiOperation("根据标题查找草稿")
	@RequestMapping(value="/draft/select",method= {RequestMethod.POST,RequestMethod.GET})
	@ResponseBody
	public Result selectDraft(@RequestParam String name) {
          List<Draft> resDrafts=draftService.getDrftDraftByTitle(name);
          if(resDrafts.isEmpty()) {
        	  return ResultUtil.error(402, " 此草稿文章不存在");
          }
          return ResultUtil.success(resDrafts);		
	}
	

	@ApiOperation("根据标题删除草稿")
	@RequestMapping(value="/draft/delete",method= {RequestMethod.POST,RequestMethod.GET})
	@ResponseBody
	public Result deleteDraft(@RequestParam String name) {
          int res=draftService.deleteDraft(name);
          if(res==0) {
        	  return ResultUtil.error(403, "删除失败");
          }
          return ResultUtil.success("删除成功");		
	}
	
	@ApiOperation("根据标题更新草稿")
	@RequestMapping(value="/draft/update",method= {RequestMethod.POST,RequestMethod.GET})
	@ResponseBody
	public Result updateDraft(@RequestBody Draft draft) {
		List<Draft>  newDraft=draftService.getDrftDraftByTitle(draft.getTitle());	
		draft.setId(newDraft.get(0).getId());
		 if(newDraft.isEmpty()) {
       	  return ResultUtil.error(402, " 此草稿文章不存在");
         }
          draftService.updateDraft(draft);
          return ResultUtil.success("更新成功");		
	}
	
	@ApiOperation("获取所有的操作日志信息")
	@RequestMapping(value="/log/all",method= {RequestMethod.POST,RequestMethod.GET})
	@ResponseBody
	public Result getAllLogs() {
		List <SysLog>  allLog =sysLogService.listAllLog();
		return ResultUtil.success(allLog);
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
	
	@ApiOperation("增加一条推荐信息")
	@RequestMapping(value="/recommend/add",method= {RequestMethod.POST,RequestMethod.GET})
	@ResponseBody
	@SystemControllerLog(description = "增加一条推荐信息",actionType = "1")
	public Result  addRecommend(@RequestBody Recommend recommend) {
		System.out.println(recommend);
	     recommendService.addRecommend(recommend);
	     return ResultUtil.success("增加一条推荐信息成功");
	}
	
	@ApiOperation("更新一条推荐信息")
	@RequestMapping(value="/recommend/update",method= {RequestMethod.POST,RequestMethod.GET})
	@ResponseBody
	@SystemControllerLog(description = "更新一条推荐信息",actionType = "2")
	public Result  updateRecommend(@RequestBody Recommend recommend) {
	     recommendService.updateRecommend(recommend);
	     return ResultUtil.success("更新一条推荐信息成功");
	}
	
	@ApiOperation("删除一条推荐信息")
	@RequestMapping(value="/recommend/delete",method= {RequestMethod.POST,RequestMethod.GET})
	@ResponseBody
	@SystemControllerLog(description = "删除一条推荐信息",actionType = "3")
	public Result  deleteRecommend(@RequestParam Integer id) {
	     recommendService.deleteRecommend(id);
	     return ResultUtil.success("删除一条推荐信息成功");
	}
	
	
}
