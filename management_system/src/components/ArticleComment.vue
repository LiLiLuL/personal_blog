<template>
    <div>
      <el-table :data="theComments">
          <el-table-column  type="index"></el-table-column>
          <el-table-column  prop="content" label="内容"></el-table-column>
          <el-table-column  prop="name" label="评论用户"></el-table-column>
          <el-table-column  prop="title" label="评论文章"></el-table-column>
          <el-table-column  prop="create_by" label="时间"></el-table-column>
      </el-table>
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
          key:1
        }
    },
    computed:{
      theComments(){
        let result=this.comments.map(ele=>{  
         ele.key=this.key;
          return ele;
        })
        return result;
      }

    },
    methods:{
       async getAllComments(){
          let data=await commentApi.allComments();
          let dataComments=data.data;
          console.log("111")
          let result=dataComments.map((ele)=>{
            (async ()=>{
              let resData= await articleApi.getOneArticle(ele.article_id);
              let titleData=resData.data;
              ele.title=titleData.title;
            })()
            return ele;
          })
         this.comments=result;
          console.log(this.comments);
          console.log("333")
           
       },
    },
    created(){
      this.getAllComments();
    }
}

</script>
<style scoped>

</style>