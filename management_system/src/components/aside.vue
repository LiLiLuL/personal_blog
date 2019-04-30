<template>
    <div class="left">
        <el-menu class="left-menu">
            <el-menu-item index="category">
               
                 <template slot="title">
                      <router-link to="/category">
                          <i class="icon iconfont icon-leimupinleifenleileibie2"></i>
                          <span>博客分类</span>
                      </router-link>
                 </template>
             </el-menu-item>
             <el-submenu index="manage" class="blog">
                 <template slot="title">
                     <i class="icon iconfont icon-tianchongxing-"></i>
                     <span class="">博客管理</span>
                 </template>
                 <ul class="drop-menu">
                 <el-menu-item index="new_message">
                     <router-link to="/newarticle">&gt;&nbsp;新文章</router-link>
                 </el-menu-item>
                 <el-menu-item index="new_daily">
                     <router-link to="/newessay">&gt;&nbsp;新随笔</router-link>
                 </el-menu-item>
                 <el-menu-item index="draft">
                     <router-link to="/draft">&gt;&nbsp;草稿箱</router-link>
                 </el-menu-item>
                 </ul>
             </el-submenu>  
             <el-menu-item index="article_manage">
                 <template slot="title">
                     <router-link to="/articlemanage">
                        <i class="icon iconfont icon-ai-article"></i>
                        <span >文章管理</span>
                     </router-link>
                 </template>
             </el-menu-item>
             <el-menu-item index="websit_summary">
                 <template slot="title">
                     <router-link to="/websum">
                        <i class="icon iconfont icon-tongji"></i>
                        <span >网站统计</span>
                     </router-link>
                 </template>
             </el-menu-item>
              <el-menu-item index="comment_manage">
                 <template slot="title">
                     <router-link to="/articlecomment">
                        <i class="icon iconfont icon-icon"></i>
                        <span >评论管理</span>
                     </router-link>
                 </template>
             </el-menu-item>
               <el-menu-item index="comment">
                 <template slot="title">
                     <router-link to="/comment">
                        <i class="icon iconfont icon-liuyan2"></i>
                        <span >留言管理</span>
                     </router-link>
                 </template>
             </el-menu-item>
              <el-menu-item index="save">
                 <template slot="title">
                     <router-link to="/cachemanage">
                        <i class="icon iconfont icon-yunhuancun"></i>
                        <span >缓存管理</span>
                     </router-link>
                 </template>
             </el-menu-item>
              <el-menu-item index="erro">
                 <template slot="title">
                     <router-link to="/error">
                        <i class="icon iconfont icon-yichang"></i>
                        <span >异常管理</span>
                     </router-link>
                 </template>
             </el-menu-item>
             <el-menu-item index="recommend">
                 <template slot="title">
                     <router-link to="/recommend">
                        <i class="icon iconfont icon-yichang"></i>
                        <span >推荐管理</span>
                     </router-link>
                 </template>
             </el-menu-item>
              <el-submenu index="system_setting">
                 <template slot="title">
                     <i class="icon iconfont icon-xitong"></i>
                     <span >系统管理</span>
                 </template>
                  <ul class="drop-menu">
                 <el-menu-item index="setting">
                     <router-link to="/setting">&gt;&nbsp;系统设置</router-link>
                 </el-menu-item>
                 <el-menu-item index="log">
                     <router-link to="/log">&gt;&nbsp;操作日志</router-link>
                 </el-menu-item>
                  </ul>
             </el-submenu>  
        </el-menu>
 

    </div>
</template>
<script>

export default {
    data(){
        return {

        }
    }
}
</script>
<style scoped>
a{
    text-decoration: none;
    color:#fff;
    font-size:16px;
}
ul{
    padding-inline-start: 0px;
}
.left-menu{
    background:#006666;
    height: 100%;
    color:#fff;
    font-size:18px;
}
.left-menu span{
    color:#fff;
   font-size:16px;
}
.left-menu i{
    margin-right:10px;
}
li.is-active{
   background: rgb(126, 150, 112);
}
.left-menu li{
    border-bottom: 1px solid #fff;
}
.left-menu li:hover,
.left-menu li:focus,
.left-menu li:active{
    background: rgb(126, 150, 112);
}
.drop-menu{
    background:#006666;
}
.drop-menu li{
    border-bottom: 0px;
    padding: 0px;
    text-align: center;
}

.drop-menu li a{
      font-size:14px;
      font-weight: bold;
}
.left{
    min-height: 710px;
    background:#006666;
}
.el-menu-item{
    height: 30px;
    line-height: 30px;
     min-width: 160px;
}


</style>
