<template>
    <div>
        <el-table :data="results"    style="width:100%;">
            <el-table-column type="index" width="50"> </el-table-column>
            <el-table-column prop="ip" label="ip地址"></el-table-column>
            <el-table-column prop="remark" label="操作内容"></el-table-column>
            <el-table-column prop="operate_url" label="操作地址" width="300"></el-table-column>
            <el-table-column prop="operate_by" label="操作人"></el-table-column>
            <el-table-column prop="create_by" label="时间"></el-table-column>
        </el-table>
        <div class="my-pagination">
           <el-pagination
            background
            layout="prev, pager, next"
            :total="operation.length"
            :page-size="pagesize"
            @current-change="current_change"
           >
          </el-pagination> 
        </div>
    </div>
</template>
<script>
import {logApi} from '../../apiJS/api'
export default {
    data(){
        return{
            operation:[],
            pagesize:20,
            currentPage:1,
            
        }
    },
    computed:{
       results(){
        let data=this.operation;
        return data.slice((this.currentPage-1)*this.pagesize,this.currentPage*this.pagesize);
      }

    },
    methods:{
       getAllLogs(){
         logApi.all().then(res=>{
             this.operation=res.data.data;
         })
       },
       rowStyle({row,rowIndex}){
           if(rowIndex%2==0){
               return 'background-color:#00807a3b'
           }
            return 'background-color:rgba(13, 66, 29, 0.23);'
       },
        current_change:function(currentPage){
          this.currentPage = currentPage;
        },
    },
    created(){
        this.getAllLogs();
    }
    
}
</script>
<style scoped>
.log-table tr:nth-child(even){
    background-color: antiquewhite;

}
</style>