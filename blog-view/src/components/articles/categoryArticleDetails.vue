<template>
    <div>
        <h1 class="articleTitle">【{{category}}】</h1>
        <ul>
         <li v-for="(article,index) in articles" :key="index"  class="articles">
             <p class="article-message"><span>阅读（{{article.hits}}）</span><span>评论（1）</span></p>
            <p >
                <router-link :to="{path:'/index/articleinformation',query:{title:article.title,id:article.id}}">
                <a > {{index+1}}.{{article.title}}</a>
                </router-link>
            </p>           
         </li>
        </ul>
    </div>
</template>
<script>
import {categoryApi} from '../.././apiJS/api'
export default {
    data(){
        return{
        category:this.$route.query.name,
        articles:''
        }
        
    },
    computed:{
    },
    methods:{
        init(){
          let name=this.category;
          categoryApi.findByName(name).then(res=>{
                  let data=res.data.data;
                  let id=data[0].id;
                  categoryApi.getAllArticles(id).then(res=>{
                     this.articles=res.data.data;
                     console.log(this.articles)
                  });

             });
        }
    },
    created(){
        this.init();
    }
}
</script>
<style scoped>
*{
    text-align: left;
}

.article-message{
    width:200px;
    float: right;
}
.articleTitle{
    color:#006666;

}
.articles{
    height: 30px;
    line-height: 30px;
    border-bottom: 2px dotted #006666;
    width: 90%;
    margin-bottom: 5px;
}
.articles:last-child{
    border-bottom: 0px;
}
a{
    text-decoration: none;
    color:#131414;
}
a:hover,
a:focus,
a:active{
   text-decoration: underline;
   color:rgb(255, 91, 118);
}
</style>
