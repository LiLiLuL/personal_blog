<template>
    <div>
        <div class="personalInfo">
          <img src="../.././assets/img/02.jpg" alt="" />
          <h1>Chenxq</h1>
          <p class="introduce"><a href="https://github.com/LiLiLuL">github</a> <a href="https://www.cnblogs.com/LULULI/">博客园</a><a href="">邮箱</a></p>
          <el-menu class="myNav" :default-active="activeIndex" @select="handleSelect">
              <router-link to="/index/category">
                <el-menu-item index="category" :class = "activeIndex == 'category' ? 'active' : '' ">
                        <span>文章分类</span>  
                        <i class="icon iconfont icon-fenlei"></i>    
                </el-menu-item>
              </router-link>
              <router-link :to="{path:'/index/articleinformation',query:{title:articleTitle,id:articleId}}">
                <el-menu-item index="newarticle" :class = "activeIndex == 'newarticle' ? 'active' : '' ">
                    <span>最新文章</span>  
                     <i class="icon iconfont icon-zuixinwenzhang_huaban"></i>
                 </el-menu-item>
              </router-link>
               <router-link to="/index/recommend">
                <el-menu-item index="recommend" :class = "activeIndex == 'recommend' ? 'active' : '' ">
                    <span>文章推荐</span>
                     <i class="icon iconfont icon-tuijian"></i>
                </el-menu-item>
              </router-link>
              <router-link to="/index/authormes">
                <el-menu-item index="authormes" :class = "activeIndex == 'authormes' ? 'active' : '' ">
                    <span>作者有话说</span>
                    <i class="icon iconfont icon-liuyan"></i>
                </el-menu-item>
              </router-link>
          </el-menu>
        </div>
    </div>
</template>
<script>
import {articleApi} from '../../apiJS/api'
export default {
    data(){
        return{
            activeIndex:'category',
            articleTitle:'',
            articleId:''
        }
    },
    methods:{
         handleSelect(key, keyPath) {
          this.activeIndex=key;
        },
         getTheArticle(){
            articleApi.getLastArticle().then(res=>{
                let data=res.data.data;
                this.articleTitle=data.title;
                this.articleId=data.id;
            })
        }
    },
     created(){
        this.getTheArticle();
    }
    
}
</script>
<style scoped>
*{
    font-weight:900;
}
.personalInfo img{
    width:100%;
    height:100%;
    border-radius:50%;
}
.introduce{
    display: flex;
   justify-content: space-around;
}
.introduce a{
    text-decoration: none;
    font-weight: 900;
}
.myNav{
    margin-top:20px;
}
.myNav li.el-menu-item{
    font-size:16px;
    color:rgb(82, 74, 74);
}
.myNav li{
    border-bottom: 2px solid #fff;
}
.myNav a:last-child li{
    border:0px;
}

.myNav li.el-menu-item:hover,
.myNav li.el-menu-item:focus
{
    background: #e23a6f6e;
    color:#fff;
}

.active{
    background: rgba(230, 32, 95, 0.637);
    color:#fff ! important;
}
</style>
