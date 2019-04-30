<template>
    <div class="draft">
    <span class="split"></span>
    <span class="title">所有文章</span>
    <span class="search">
    <input type="text"/>
    <el-button circle><i class="icon  iconfont icon-sousuo"></i></el-button>
    </span>
    <el-table
    :data="articles"
    class="draft-table"
    border
    :default-sort = "{prop: 'create_by', order: 'descending'}"
    style="width: 100%">

    <el-table-column fixed type="index" label="序号" width="60"  style="text-align:center">
        <template slot-scope="scope"><span>{{scope.$index+(currentPage - 1) * pageSize + 1}} </span></template>
    </el-table-column>
    <el-table-column  prop="title" label="文章标题" ></el-table-column>
    <el-table-column  prop="summary" label="文章简介" ></el-table-column>
    <el-table-column  prop="create_by" label="发布时间" ></el-table-column>
    <el-table-column  prop="comment" label="文章评论数" ></el-table-column>
    
    <el-table-column
      fixed="right"
      label="操作"
      >
      <template slot-scope="scope">
        <el-button @click="handleClick(scope.row)" type="success" >查看</el-button>
        <el-button type="warning"  @click="handleEdit(scope.row)">编辑</el-button>
        <el-button type="danger" @click="dialogVisible = true" >删除</el-button>
        <el-dialog
        title="提示"
        :visible.sync="dialogVisible"
        :modal-append-to-body='false'
        style="width:50%;margin:auto;text-align:center"
        >
          <span>确定要删除文章<b>"{{scope.row.title}}"</b>?</span>
          <span slot="footer" class="dialog-footer"> 
             <el-button @click="dialogVisible = false">取 消</el-button>
             <el-button type="primary" @click="deleteArticle(scope.$index,scope.row)" >确 定</el-button>
          </span>
        </el-dialog>
      </template>
    </el-table-column>
  </el-table>
  <div class="my-pagination">
           <el-pagination
            background
            layout="prev, pager, next"
            :total="information.length"
            :page-size="pageSize"
            @current-change="current_change"
           >
          </el-pagination>
  </div>
 </div>
</template>
<script>
import {articleApi} from '../apiJS/api'
export default {

    data() {
      return {
        information:'',
        pageSize:10,
        currentPage:1,
        dialogVisible:false
        
            
      }
    },
    computed:{
        articles(){

            
            let pageSize=this.pageSize;
            return this.information.slice((this.currentPage-1)*pageSize,this.currentPage*pageSize)
        },
       
    },
    methods: {
      handleClick(row) {
        this.$router.push({path:'/articleinformation',query:{title:row.title,id:row.id}})
      },
      handleEdit(row){
        //this.$router.push({path:'/editinfo',query:{title:row.title}});
      },
      deleteArticle(index,row){
        this.dialogVisible=false;
          this.information.splice(index,1);

          console.log(this.information.length);
      },
      getAllArticleInformation(){
           articleApi.getAll().then(res=>{
               this.information=res.data.data;
           })
      },
      current_change:function(currentPage){
        this.currentPage = currentPage;
      },
    },
    created(){
        this.getAllArticleInformation();
    }
}
</script>
<style scoped>
.split{
    display: inline-block;
    width:10px;
    height:30px;
    background:green;
    margin-bottom: -8px;
}

.draft{
    text-align:left;
}
.draft-table{
    margin-top:20px;
}
.title{
    margin-top:-10px;
    font-size:18px;
    font-weight: 900;
    margin-left:10px;
    
}
.search{
    display: inline-block;
    float: right;
    margin-right:60px;
}
.search input{
    border-radius: 5px;
    border-color:#006666;
    height:20px;
}
.my-pagination{
  text-align: right;
  /* padding-right: 6%; */
  margin-top:5px;
}
</style>>