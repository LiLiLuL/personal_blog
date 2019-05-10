# personal_blog
一个自己搭建的个人博客项目，包括前台后台
# management_system 后台管理系统页面设计
主要的功能页面：**博客分类、博客管理、文章管理、评论管理以及系统操作日志。**<br/>
（1）博客分类<br/>
 博客分类的添加、删除、修改；每个分类下的最新的五篇文章展示。<br/>
（2）博客管理<br/>
新文章-->文章标题、文章简介、题图、以及内容，是否发布？发布到哪一个类别中？或者是暂存为草稿？<br/>
新随笔-->文章标题、文章简介、题图、以及内容，是否发布？（默认发布到“随笔”中）或者是暂存为草稿？<br/>
草稿箱-->查看已有草稿以及其详细内容，删除草稿，发布草稿，以及对草稿的修改。<br/>
（3）文章管理<br/>
文章管理的查看、修改、删除。<br/>
（4）评论管理<br/>
所有的评论的删除，修改。<br/>
(5)操作日志
系统的操作日志。
PS.要对所有的路由进行路由守卫
页面展示如下所示：
![image](https://github.com/LiLiLuL/personal_blog/blob/master/images/login.png)
![image](https://github.com/LiLiLuL/personal_blog/blob/master/images/management_page1.PNG)
![image](https://github.com/LiLiLuL/personal_blog/blob/master/images/manage.png)




# blog-view前台博客页面展示
![image](https://github.com/LiLiLuL/personal_blog/blob/master/images/view.png)
# mysql数据库设计
表与表之间的关联关系全部由代码控制
![image](https://github.com/LiLiLuL/personal_blog/blob/master/images/mysql.png)
# 后台接口设计personalBlog
主要是针对前台博客页面展示的接口/client/xxx,和针对后台博客管理系统的接口/admin/xxx
![image](https://github.com/LiLiLuL/personal_blog/blob/master/images/api1.png)
![image](https://github.com/LiLiLuL/personal_blog/blob/master/images/api2.png)
