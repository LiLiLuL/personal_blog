<template>
    <div>
        <el-table :data="operation"  border :row-style="rowStyle" style="width:100%;">
            <el-table-column type="index" width="50"> </el-table-column>
            <el-table-column prop="ip" label="ip地址"></el-table-column>
            <el-table-column prop="remark" label="操作内容"></el-table-column>
            <el-table-column prop="operate_url" label="操作地址"></el-table-column>
            <el-table-column prop="operate_by" label="操作人"></el-table-column>
            <el-table-column prop="create_by" label="时间"></el-table-column>
        </el-table>
    </div>
</template>
<script>
import {logApi} from '../../apiJS/api'
export default {
    data(){
        return{
            operation:[]
        }
    },
    computed:{
      

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
       }
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