<template>
    <el-tabs v-model="activeName" @tab-click="handleClick">
        <el-tab-pane label="推荐阅读" name="info">
            <ul>
                <li v-for="(item,index) in recommendList" :key="index">
                    <a :href="item.url">{{item.title}}</a>
                    <span>({{item.summary}})</span>
                </li>
            </ul>
        </el-tab-pane>
        <el-tab-pane label="增加推荐" name="add">
            <el-form ref="recommendInfo" :rules="rules" :model="recommendForm" label-width="100px" class="recommendForm">
                <el-form-item label="文章名称" prop="title"><el-input v-model="recommendForm.title"></el-input></el-form-item>
                <el-form-item label="文章地址" prop="url"><el-input v-model="recommendForm.url"></el-input></el-form-item>
                <el-form-item label="文章摘要" prop="summary"><el-input v-model="recommendForm.summary"></el-input></el-form-item>
                <el-form-item>
                    <el-button type="default" @click="resetForm('recommendInfo')">重置</el-button>
                    <el-button type="primary" @click="submitForm('recommendInfo')">立即创建</el-button>
                </el-form-item>
            </el-form>
        </el-tab-pane>
        <el-tab-pane label="删除推荐" name="delete">
            <el-table stripe style="width:100%" :data="recommendList" ref="recommendTable" @selection-change="handleSelectionChange">
                <el-table-column type="selection" width="60"></el-table-column>
                <el-table-column prop="title" label="文章名称"></el-table-column>
                <el-table-column prop="url" label="文章地址"></el-table-column>
                <el-table-column prop="summary" label="文章摘要"></el-table-column>                
            </el-table>
            <div style="margin-top: 20px">
                <el-button type="default"  @click="cancelSelection()">取消选择</el-button>
                <el-button type="primary" @click="deleteSelection()">选择删除</el-button>
            </div>

        </el-tab-pane>

  </el-tabs>
</template>
<script>
import {recommendApi} from '../apiJS/api'
import {getNowDate} from '../assets/util/commen'

export default {
    data(){
        return{
            activeName:'info',
            recommendList:'',
            recommendForm:{
                title:'',
                url:'',
                summary:'',
                create_by:'',
                is_effective:true
            },
            rules:{
                title: [
                  { required: true, message: '请输入文章标题', trigger: 'blur' },
                ],
                url:[
                    {required:true,message:'请输入文章链接',trigger:'blur'}
                ],
                summary:[
                    {required:true,message:'请输入文章摘要',trigger:'blur'}
                ]
            },
            recommendSelection:[]
            
        }
    },
    computed:{
        
    },
    methods:{
        handleClick(tab,event){
            console.log(tab,event);
        },
        submitForm(formName) {
            this.$refs[formName].validate((valid) => {
                    if (valid) {
                        let data=this.recommendForm;
                        data.create_by=getNowDate();
                        recommendApi.add(data).then(res=>{
                            this.$notify.success({
                                title: 'Info',
                                message: '增加推荐信息成功',
                                showClose: false
                            });
                        })
                        
                    } else {
                        alert("信息填写有误")
                        return false;
                    }
            });
        },
        resetForm(formName) {
          this.$refs[formName].resetFields();
          console.log("lll")
        },
        async init(){         
            let data=await recommendApi.getAll();
            this.recommendList=data.data;
        },
        cancelSelection(){
           this.$refs.recommendTable.clearSelection();
        },
        deleteSelection(){
            let arr=this.recommendSelection;
            arr.forEach(ele => {
                recommendApi.delete(ele.id).then(res=>{
                    alert("删除成功")
                })
                
            });
           console.log(this.recommendSelection)
        },
        handleSelectionChange(val){
            this.recommendSelection=val;
        }
    },
    mounted(){
        this.init();
    }
}
</script>
<style scoped>
li{
    margin:5px 0px;
}
.recommendForm{
    width:600px;
}
</style>