<template>
    <div>
        <h1>文章已有分类</h1>
        <ul class="tagDiv">
            <el-tag
            :key="index"
            v-for="(tag,index) in categories"
            type="info" 
            class="tag"
            @click="checkCategory(tag.id,index)"
            >
            {{tag.name}}
             <p v-show="show(index)" class="check"></p>
         
            </el-tag>
            <el-button type="default" @click="search(checkedCategories)">搜索</el-button>
        </ul>
        <hr />
        <div v-if="showList">
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
        <div v-else>
            <div v-show="theSameArticle!=null">
                <div v-for="(item,index) in theSameArticle" :key="index" class="sameArticle">
                
                    <div class="right">
                        <img :src="'/server/'+item.pictureUrl" alt=""/>
                    </div>
                    <div class="left">
                        <h2>{{index+1}}.{{item.title}}</h2>
                            <p><b>摘要：</b>{{item.summary}}</p>
                        <ul class="information">
                            <li>发表时间：{{item.create_by}} </li>
                            <li>阅读：{{item.hits}}</li>
                        </ul>
                        
                    </div>
                </div>
            </div>
            <div v-show="theSameArticle==null">
                 
                <img src="../../assets/img/cry.jpg" alt="" style="width:400px;height:400px;float:left;margin-top:-50px;"/>
                <h3>未查找到符合您搜索条件的文章！</h3>
                 
            </div>
        </div>
    </div>
</template>
<script>
import {categoryApi} from '../.././apiJS/api'
export default {
    data(){
        return{
            categories:[],
            categoryView:[],
            showCard:true,
            showCheck:[],
            checkedCategories:[],
            showList:true,
            showSearch:false,
            theSameArticle:[]
        }
    },
    methods:{
        getAllCategories(){
            categoryApi.allCategory().then(res=>{
                this.categories=res.data.data;
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
         },
        checkCategory(id,index){
           
            let flag=this.showCheck.indexOf(index);
            if(flag==-1){
                this.showCheck.push(index);
                this.checkedCategories.push(id);

            }else{
                this.showCheck.splice(flag,1);
                this.checkedCategories.splice(flag,1);
            }
             console.log(this.checkedCategories);
        },
        show(index){
            let flag=this.showCheck.indexOf(index);
            if(flag==-1){
                return false;
            }
            return true;
            
        },
        async search(categories){
            
            if(categories.length==0){
                this.showList=true;
            }else{
                categories=categories.join(",");
                console.log(categories);
                let data=await categoryApi.search(categories);
                this.theSameArticle=data.data;
                this.showList=false;
            }

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
h2{
    font-size:18px;
}
h3{
    font-size:4rem;
    height: 400px;
    margin-left:410px;
    text-align: center;
    /* color:rgb(241, 173, 14); */
    color:rgba(5, 51, 104, 0.548);
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


.check::after{
    content: '√';
    color:#fff;
    height: 10px;
    width:10px;
    font-size:12px;
    position:absolute;
    top:-15px;
    left:-4px;
}
.check{
    border:8px solid rgba(223, 41, 125, 0.747);
    width: 0;
    height:0;
    border-radius: 50%;
    position:relative;
    float:right;
    margin-top:16px;
    margin-right:-4px;
}
.left{
    height:156px;
    margin-right:240px;   
}
.right{
    width:240px;
    height:150px;
    float: right;
    border:2px solid saddlebrown;

}
.right img{
    width:100%;
    height:100%;
}
.information{
    display: flex;
    justify-content: space-around;
    font-size:14px;
    position:absolute;
    float: right;
    /* width:100%; */
    width:500px;
    position: relative;
    bottom:-60px;
    right:0;
    
}
.sameArticle{
    border-bottom:2px solid brown;
    margin-top:8px;
}
</style>
