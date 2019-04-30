<template>
    <div>
        <h1>文章已有分类</h1>
        <ul class="tagDiv">
            <el-tag
            :key="index"
            v-for="(tag,index) in categories"
            type="info" 
            class="tag"
            >
            {{tag.name}}
            </el-tag>
            <el-button type="default">搜索</el-button>
        </ul>
        <hr />
        <el-card class="box-card" 
                :key="index"  
                v-for="(card,index)  in categoryView"   
                v-show="card.categoryArticles"    
                shadow="hover">
            <div slot="header" class="clearfix">
                <span><b>{{card.name}}</b></span>                   
            </div>
            <ul>
                <li v-for="(o,index) in card.categoryArticles" :key="index" class="textItem">   
                    {{index+1+"."}} {{ o.title }}
                </li>
            </ul>
            <p class="findMore"><el-button  v-show="card.categoryArticles"  class="find-more-button" type="text" @click="findMore(card.name)" >查看更多>>></el-button></p>
        </el-card>
    </div>
</template>
<script>
import {categoryApi} from '../.././apiJS/api'
export default {
    data(){
        return{
            categories:[],
            categoryView:[],
            showCard:true
        }
    },
    methods:{
        getAllCategories(){
            categoryApi.allCategory().then(res=>{
                this.categories=res.data.data;
                console.log("111")
                let category=res.data.data;
                let all=category.map(ele => {
                    let obj={
                            name:ele.name,
                            categoryArticles:'',
                         }
                     categoryApi.getLastArticles(ele.id).then(res=>{
                          let data=res.data.data; 
                          obj.categoryArticles=data;      
                     });
                     return obj;
                });
                this.categoryView=all;
                console.log(this.categoryView)
            })
        },
        findMore(name){
             this.$router.push({path:"/index/categoryArticles",query:{name:name}});
         }
    },
    created(){
        this.getAllCategories();
    }
    
}
</script>
<style scoped>
.tagDiv,h1{
    text-align: left;
}
h1{
    border-left:10px solid rgb(255, 91, 118);
    padding-left:20px;
    color:rgb(255, 91, 118);
    font: outline;
}
.tag{
    margin:10px;
    min-width: 100px;
    font-size:16px;
    font-weight: bold;
    text-align: center;
    border-radius: 5px;
    background: #ccc;
    color:rgba(223, 41, 125, 0.747);
    background-image:  url('../.././assets/img/03.png');

}
.tag:hover,
.tag:focus,
.tag:active{
    color:#fff;
    background:pink;
}
.box-card{
    width:300px;
    height:300px;
    float: left;
    margin:10px;
    position: relative;
    background: rgba(255, 255, 255, 0.589);
}
.textItem{
    text-align: left;
}
.findMore{
    width:100px;
    text-align: right;
    float: right;
    position: absolute;
    bottom:10px;
    right:10px; 
}
.find-more-button{
    font-weight: 900;
    color:rgb(95, 176, 252);
}
.find-more-button:hover,
.find-more-button:focus,
.find-more-button:active{
    color:rgba(223, 41, 125, 0.747);
}
.clearfix{
    text-align: center;
}
</style>
