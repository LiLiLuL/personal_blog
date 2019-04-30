<template>
    <div class="draft">
    <span class="split"></span>
    <span class="title">草稿箱</span>
    <el-table
    :data="tableData"
    class="draft-table"
    border
    :default-sort = "{prop: 'modified_by', order: 'descending'}"
    style="width: 100%">
    
    <el-table-column fixed type="index" label="序号" width="50"  style="text-align:center"></el-table-column>
    <el-table-column  prop="title" label="文章标题" ></el-table-column>
    <el-table-column  prop="modified_by" label="更改时间" ></el-table-column>
    <el-table-column  prop="author" label="作者" ></el-table-column>
    
    <el-table-column
      fixed="right"
      label="操作"
      >
      <template slot-scope="scope">
        <el-button @click="handleClick(scope.row)" type="success" >查看</el-button>
        <el-button type="warning"  @click="handleEdit(scope.row)">编辑</el-button>
        <el-button type="danger" @click="handleDelete(scope.row)">删除</el-button>
        <el-dialog
          
            :visible.sync="deleteDialog"
            :append-to-body='true'
            width="30%"
            center>
            <p class="dialog-question">确定要删除文章<br/><b>"{{title}}"</b>?</p>
            <span slot="footer" class="dialog-footer">
                <el-button type="info" @click="deleteDialog = false">取 消</el-button>
                <el-button type="primary" @click="deleteDraft(scope.row)">确 定</el-button>
            </span>
        </el-dialog>
      </template>
    </el-table-column>
  </el-table>
 </div>
</template>
<script>
import {draftApi} from '../../apiJS/api'
export default {

    data() {
      return {
        tableData: [],
        deleteDialog: false,
        title:''
      }
    },
    methods: {
      handleClick(row) {
        this.$router.push({path:'/articleinfo',query:{title:row.title}});
      },
      handleDelete(row) {
        this.deleteDialog=true;
        this.title=row.title;
      },
      handleEdit(row){
        this.$router.push({path:'/editinfo',query:{title:row.title}});
      },
      initDraf(){
          draftApi.findall().then(res=>{
              if(res.data.code==1){
                this.tableData=res.data.data;
              }
          })
      },
      deleteDraft(row){
          draftApi.deleteByTitle(row.title).then(res=>{
              if(res.data.code==1){
                  this.$message({
                      message:'删除成功',
                      type:'success'
                  });
                  this.initDraf();
              }
          })
          this.deleteDialog = false
          
      }
    },
    mounted(){
        this.initDraf();
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
.dialog-question{
    text-align: center;
    font-size:18px;
    font-weight:bold;
}
</style>