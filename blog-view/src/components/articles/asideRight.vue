<template>
    <div>
        <div class="time">
            <p class="hour">{{time[1]}}</p>
           <p class="date"> {{time[0]}} {{time[2]}}</p>
        </div>
        <ul class="hits">
            <p class="title">博文推荐阅读>>></p>
            
            <li v-for="(item,index) in recommendList" :key="index">
               {{index+1}}. <a :href="item.url">{{item.title}}</a>
            </li>
            
        </ul>
        <ul class="hits">
            <p class="title">阅读排行榜>>></p>
            <li v-for="(item,index) in articleHits" :key="index">
            <router-link :to="{path:'/index/articleinformation',query:{title:item.title,id:item.id}}">
               <p class="mytitle">{{index+1}}.{{item.title}}  <span class="info">阅读({{item.hits}})</span></p>
               <p class="info info2">发表于{{item.create_by}}</p>
            </router-link>
            </li>
        </ul>
    </div>
</template>
<script>
import {time} from '../.././assets/util/common.js'
import {articleApi,recommendApi} from '../.././apiJS/api'


export default {
    data(){
        return{
            time:[],
            articleHits:[],
            recommendList:''
        }
    },
    methods:{
        async getHighHitsArticles(){
            let data=await articleApi.getHighHits();
            this.articleHits=data.data;
        },
        async init(){         
            let data=await recommendApi.getAll();
            this.recommendList=data.data;
        },

    },
    created(){
       setInterval(()=>{
         this.time=time().trim().split(/\s+/);
       },1000);
       this.init();
    },
    mounted(){
        this.getHighHitsArticles();
        
    }
    
}
</script>
<style scoped>
li{
    text-align: left;
}
.time{
    width:100%;
    height:120px;
    background: rgba(255, 255, 255, 0.447);
    color:rgba(223, 41, 125, 0.747);
    
    border-radius: 5px;
    
}
.hour{
    font-size:2.4rem;
    padding-top: 14px;
}
.date{
    font-size:1rem;
    
}
.info{
    font-size:12px;
}
.info2{
    text-align: right;
}
.hits{
    margin-top:50px;
    text-align: left;
    font-weight:600;
    background: rgba(255, 255, 255, 0.308);
    padding: 15px 0;
}
.hits li{
    margin-top:5px;
    color:rgba(80, 75, 75, 0.699);
}
.hits li:hover{
    color:rgb(248, 125, 146);
}
.title{
     color:rgba(223, 41, 125, 0.747);
     padding-left:2px;
     margin-bottom:10px;
}
.title:hover,
.title:focus,
.title:active{
    color:rgb(23, 143, 97);
}
</style>
