<template>
    <div v-loading="loading"
      element-loading-text="数据正在加载中"
      >
      <el-table 
      :data="results"

      >
          <el-table-column  type="index"></el-table-column>
          <el-table-column  prop="content" label="内容"></el-table-column>
          <el-table-column  prop="name" label="评论用户"></el-table-column>
          <el-table-column  prop="title" label="评论文章"></el-table-column>
          <el-table-column  prop="create_by" label="时间"></el-table-column>
      </el-table>
       <div class="my-pagination">
           <el-pagination
            background
            layout="prev, pager, next"
            :total="comments.length"
            :page-size="pagesize"
            @current-change="current_change"
           >
          </el-pagination> 
        </div>
    </div>
</template>
<script>
import {articleApi,commentApi} from '../apiJS/api'
import {getNowDate} from '../assets/util/commen'
export default {
    data(){
        return{
          comments:[],
          title:'',
          key:1,
          pagesize:15,
          currentPage:1,
          loading: true
        }
    },
    computed:{
      theComments(){
        let result=this.comments.map(ele=>{  
         ele.key=this.key;
          return ele;
        })
        return result;
      },
      results(){
        let data=this.comments;
        return data.slice((this.currentPage-1)*this.pagesize,this.currentPage*this.pagesize);
      }

    },
    methods:{
       async getAllComments(){
          let data=await commentApi.allComments();
          let dataComments=data.data;
          let result=await Promise.all(dataComments.map(async (ele)=>{
                 return (async ()=>{
                       let resData= await articleApi.getOneArticle(ele.article_id);
                       let titleData=resData.data;
                       ele.title=titleData.title
                     
                       return ele;
                 })()
          }))
         this.comments=result;
         this.loading=false;
         
           
       },
        current_change:function(currentPage){
        this.currentPage = currentPage;
         },
    },
     created(){
       this.getAllComments();
    }
}

</script>
<style scoped>

</style>