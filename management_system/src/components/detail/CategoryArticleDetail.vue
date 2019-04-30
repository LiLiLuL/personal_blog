<template>
    <div>
        <p>【{{category}}】</p>
        <ul>
         <li v-for="(article,index) in articles" :key="index"  class="articles">
            <span class="articleTitle">
                <router-link :to="{path:'/articleinformation',query:{title:article.title,id:article.id}}">
                <a > {{article.title}}</a>
                </router-link>
            </span>
            <span>阅读（{{article.hits}}）</span>
            <span>评论（1）</span>
         </li>
        </ul>
    </div>
</template>
<script>
import {categoryApi} from '../../apiJS/api'
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
.articleTitle{
    width:85%;
}
.articles span{
    display: inline-block;
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
}
a:hover,
a:focus,
a:active{
   text-decoration: underline;
}
</style>
