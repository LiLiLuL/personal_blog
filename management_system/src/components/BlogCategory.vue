<template>
    <div class="category">
        <span class="split"></span>
        <span class="title">已有分类</span>
        <ul class="aleardy-info" id="aleardy-category">
            <el-tag
            :key="index"
            v-for="(tag,index) in category"
            type="info"
            v-on:click.native="handleTag(tag)"  
            @contextmenu.prevent.native="mouseDown"     
            class="tag"
            >
             <el-popover
                placement="bottom-end"            
                trigger="hover">
                <p>【{{tag.name}}】</p>
                <el-button type="warning" round  @click="deleteOp(tag)">删除</el-button>
                <el-button type="success" round  @click="edit(tag)">编辑</el-button>
                <el-button slot="reference" class="operation">{{tag.name}} </el-button>
              </el-popover>
               
            </el-tag>
            <span class="add-icon"><i  @click="addTag" class="iconfont icon-tianjia"></i></span>
        </ul>
        <div>
        <span class="split"></span>
        <span class="title">分类视图</span>
        </div>
        <el-card class="box-card" 
                :key="index"  
                v-for="(card,index)  in categoryView.slice((currentPage-1)*pagesize,currentPage*pagesize)"  
               
                shadow="hover">
            <div slot="header" class="clearfix">
                <span>{{card.categoryName}}</span>
                <el-button  v-show="card.categoryArticles"  class="clearfix-button" type="text" @click="findMore(card.categoryName)">查看更多>>></el-button>
            </div>
            <p v-show=" ! card.categoryArticles" class="nullImg">
                <img src="../assets/images/null.jpg" alt="" />
            </p>
            <div v-for="(o,index) in card.categoryArticles" :key="index" class="text item">
                
                {{index+1+"."}} {{ o.title }}
            </div>
        </el-card> 
        <div style="clear:both"></div> 
        <div class="my-pagination">
           <el-pagination
            background
            layout="prev, pager, next"
            :total="categoryView.length"
            :page-size="pagesize"
            @current-change="current_change"
           >
          </el-pagination> 
        </div>
    </div>
</template>
<script>

import {mapState,mapGetters,mapActions} from 'vuex';
import {categoryApi} from '../apiJS/api'
import {getNowDate} from '../assets/util/commen'
//根据属性值找个某个元素
function findOne(item,arr){
    let newArr=arr.filter(function(items){
        return items.name!=item;
    });
    return newArr;
}
export default {
    data(){
        return{
            item:{
              name:'jaba',num:10,
            },
            category:'',
            flag:true,
            categoryView:[],
            pagesize:6,
            currentPage:1,   
        }
    },
    computed:{
        ...mapState({
            categoryArr:state=>state.category.cate
        }),
        ...mapGetters('category',{
            arrList:'renderCate'
        })
    },

    methods:{
        ...mapActions('category',[
            'invokePushItems','invokeInitCategory'
        ]),
        initCategory(){
            categoryApi.allCategory().then(res=>{
                let cate=res.data.data;
                let oldCate=res.data.data;
                cate=cate.filter(x=>{
                    if(x.name!="随笔"){
                        return x;
                    }
                })
                this.invokeInitCategory(cate);
                this.category=cate;
                let allArticles=oldCate.map(category=>{
                    let obj={
                             categoryName:category.name,
                             categoryArticles:'',
                         }
                     categoryApi.getLastArticles(category.id).then(res=>{
                         let data=res.data.data; 
                         obj.categoryArticles=data;                   
                     })
                     return obj;
                })
                console.log(allArticles);
                this.categoryView=allArticles;
            })
        },
        handleTag(tag){
           console.log(tag.name);   
        },
        mouseDown(){
         
          console.log('鼠标右键')
        },
        addTag(){
            this.$prompt('新的分类名称','请输入',{
                confirmButtonText:'确定',
                cancelButtonText:'取消',
            }).then(({value})=>{
                let arr=this.category;
                console.log(arr);
                if(value==null){
                    this.$message({
                            type:'error',
                            message:'类别不可以为空'
                     });
                }else{                
                    let flag=arr.some(item=>{
                        if(item.name==value){
                            return true
                        }
                    })
                    if(flag){
                        this.$message({
                                type:'error',
                                message:value+'类别已存在'
                        });
                    
                    }else{
                        let newCategory={
                            name:value,
                            create_by:getNowDate(),
                            modified_by:getNowDate()
                        }
                        categoryApi.addCategory(newCategory).then(res=>{
                             console.log(res.data);
                             if(res.data.code==1){
                                 this.$message({
                                      type:'success',
                                      message:'添加分类【'+value+'】成功'
                                }); 
                                this.invokePushItems(newCategory);
                             }
                         }).catch(err=>{
                           this.$message({
                               type:'error',
                               message:'添加分类【'+value+'】失败'
                           })
                         })
                    }
                }
            }).catch(() => {
            this.$message({
                type: 'info',
                message: '取消输入'
            });       
            });
        },
        deleteOp(tag){
            let arr=this.category;
            this.$confirm('此操作将删除该分类, 是否继续?', '提示', {
            confirmButtonText: '确定',
            cancelButtonText: '取消',
            type: 'warning'
            }).then(() => {
            categoryApi.deleteCategory(tag.name).then(res=>{
                console.log(res.data);
                if(res.data.status=="删除成功"){
                    this.$message({
                        type: 'success',
                        message: '删除成功!'
                    });   
                }
            }).catch(err=>{
                console.log(err);
            })
            let result=findOne(tag.name,arr);
            this.category=result;
            }).catch(() => {
            this.$message({
                type: 'info',
                message: '已取消删除'
            });          
            });
        },
        edit(tag){
            this.$prompt('新的名称','请输入',{
                confirmButtonText:'修改',
                cancelButtonText:'取消',
            }).then(({value})=>{
                let arr=this.category;
                let newCate={
                    name:value,
                    id:tag.id,
                    modified_by:getNowDate()
                };
                 if(value==null){
                    this.$message({
                            type:'error',
                            message:'类别不可以为空'
                     });
                 }else{                
                    let flag=arr.some(item=>{
                        if(item.name==value){
                            return true
                        }
                    })
                    if(flag){
                        this.$message({
                                type:'error',
                                message:value+'类别已存在'
                        });                    
                    }else{
                        categoryApi.changeCategory(newCate).then(res=>{
                            console.log(res.data);
                            this.$message({
                            type:'success',
                            message:'修改分类名为【'+value+'】成功'
                            }); 
                             arr.map((item,index)=>{
                                if(item.name==tag.name){
                                    item.name=value
                                }
                                return item;
                            });
                        })
                       
                    }
                }
                        
            }).catch(() => {
            this.$message({
                type: 'info',
                message: '取消输入'
            });       
            });
        },
        current_change:function(currentPage){
        this.currentPage = currentPage;
         },
         findMore(name){
             this.$router.push({path:"/categoryArticles",query:{name:name}});
         }

    },
    created(){
        this.initCategory();
    },
    mounted(){       
    },
    updated(){
        
    }
    
}
</script>
<style scoped>
.category{
    text-align: left;
}

.tag{
    min-width: 80px;
    border: 2px solid green;
    background-color: #fff;
    font-size: 16px;
    margin: 5px;
    text-align: center;
    padding: 0px;
}
.split{
    display: inline-block;
    width:10px;
    height:30px;
    background:green;
    margin-bottom: -8px;
}
.title{
    margin-top:-10px;
    font-size:18px;
    font-weight: 900;
    margin-left:10px;
    
}
.aleardy-info{
    padding: 1px;
}
.add-icon{
    display: inline-block;
    z-index:2;
}
.add-icon i{
    font-size:40px;
    position: relative;
    top:6px;
}
.operation{
    padding: 6px 21px;
    border: none;
}
.operation:hover{
    background-color:rgba(255, 255, 255, 0);
    color:rgb(4, 39, 4);
    font-weight: bold;
}
.box-card {
    width: 400px;
    float: left;
    margin:10px;
    height: 320px;
    box-shadow: 5px 5px 10px #006666;
}
.box-card:hover,
.box-card:focus,
.box-card:active{
    box-shadow: 10px 5px 10px #06691f;
    width: 410px;

  
}
.text {
font-size: 14px;
}

.item {
margin-bottom: 18px;
}
.clearfix{
    font-weight:900;
    color:#006666;
    font-size:18px;
}
.clearfix:before,
.clearfix:after {
    display: table;
    content: "";
}
.clearfix:after {
    clear: both
}

.nullImg{
    text-align: center;
}
.nullImg img{
    width:50%;
    height:50%;
}
.clearfix-button{
    float: right; 
    padding: 3px 0;
    color:#006666;
}
</style>

