<template>
<div class="new-article">
    <el-form ref="articleform" :model="form"  :rules="rules" label-width="80px"> 
    <el-row>
        <el-col :span="12">
            <el-form-item label="文章标题" prop="title">
                <el-input v-model="form.title" ></el-input>
            </el-form-item>
            <el-form-item label="今日心情" prop="summary">
                <el-input v-model="form.summary" ></el-input>
            </el-form-item>
        </el-col>
    </el-row>
    <el-form-item label="文章内容" prop="content">
          <div class="editor" id="editor">
             <mavon-editor style="height: 100%;width: 100%;"  
                           v-model="form.content"
                           ref="md" 
                           defaultOpen="edit"
                           :toolbars="toolbarsValue"
                           @imgAdd="$imgAdd" 
                           @change="changeMavon"  
                           @save="saveMavon" />
         </div>
    </el-form-item>
     </el-form>
     <el-col :span="24">
         <div class="operation">
            <el-button type="success" @click="release">发布</el-button>
            <el-dialog  class="category-dialog"  :visible.sync="outerVisible" width="40%" >
                <p class="realease">确定要发布？</p>
                <div slot="footer" class="dialog-footer">
                <el-button @click="outerVisible = false" type="info">取 消</el-button>
                <el-button type="primary" class="innerDialog" @click="uploadArticle">确定</el-button>
                </div>
            </el-dialog>
            <el-button type="default" @click="saveDraft">暂存</el-button>
         </div>
      </el-col>
</div>
    
</template>
<script>
import {mavonEditor} from 'mavon-editor'
import  'mavon-editor/dist/css/index.css'
import { mapGetters } from 'vuex';
import {imgeApi,articleApi,draftApi} from '../../apiJS/api'
function getNowDate(){
    let date = new Date();
    let seperator1 = "-";
    let year = date.getFullYear();
    let month = date.getMonth() + 1;
    let strDate = date.getDate();
    let hour=date.getHours();
    let min=date.getMinutes();
    let second=date.getSeconds();
    if (month >= 1 && month <= 9) {
        month = "0" + month;
    }
    if (strDate >= 0 && strDate <= 9) {
        strDate = "0" + strDate;
    }
    if(hour>=1&&hour<=9){
        hour="0"+hour;
    };
    if(min>=1&&min<=9){
        min="0"+min;
    };
    if(second>=1&&second<=9){
        second="0"+second;
    }

    let currentdate = year + seperator1 + month + seperator1 + strDate;
    let currenttime=hour+":"+min+":"+second;
    return currentdate+" "+currenttime;
}
export default {
   components:{
     mavonEditor
   },
   mounted(){
     const categoryOption=this.arrList;
     this.categroies=categoryOption;
   },
    data(){
        var validateTitle=(rule,value,callback)=>{
            if(value===""){
                callback(new Error('标题不能为空'))
            }else{
                callback();
            }
        }
        var validateSummary=(rule,value,callback)=>{
            if(!value){
                callback(new Error('文章简介不能为空'))
            }else if(value.length>200){
                callback(new Error('简介不能超过200字符'))
            }else{
                callback();
            }
        }
        var validateContent=(rule,value,callback)=>{
            if(!value){
                callback(new Error('文章内容不能为空'))
            }else{
                callback();
            }
        }
        return{
            content:'请输入内容',
            configs:{},
            outerVisible: false,
            innerVisible: false,
            checkedCategories:[],
            checkAll:false,
            isIndeterminate:true,
            categroies:[],
            toolbarsValue: {
                bold: true, // 粗体
                italic: true, // 斜体
                header: true, // 标题
                underline: true, // 下划线
                strikethrough: true, // 中划线
                mark: true, // 标记
                superscript: true, // 上角标
                subscript: true, // 下角标
                quote: true, // 引用
                ol: true, // 有序列表
                ul: true, // 无序列表
                link: true, // 链接
                imagelink: true, // 图片链接
                code: true, // code
                table: true, // 表格
                fullscreen: true, // 全屏编辑
                readmodel: true, // 沉浸式阅读
                htmlcode: true, // 展示html源码
                help: true, // 帮助
                /* 1.3.5 */
                undo: true, // 上一步
                redo: true, // 下一步
                trash: true, // 清空
                save: false, // 保存（触发events中的save事件）
                /* 1.4.2 */
                navigation: true, // 导航目录
                /* 2.1.8 */
                alignleft: true, // 左对齐
                aligncenter: true, // 居中
                alignright: true, // 右对齐
                /* 2.2.1 */
                subfield: true, // 单双栏模式
                preview: true, // 预览
            },
            form:{
                pictureUrl:'',
                title:'',
                summary:'',
                create_by:'',
                content:'',
                categoryArr:[31]

            },
            rules:{
                title:[
                    {validator:validateTitle,trigger:'blur'}
                ],
                summary:[
                    {validator:validateSummary,trigger:'blur'}
                ],
                content:[
                    {validator:validateContent,trigger:'blur'}
                ],
            }
        }
    },   
    computed:{
       ...mapGetters('category',{
            arrList:'renderCate'
        })
    },
    methods:{
        changeMavon(){
        },
        saveMavon(value,render){
            
          console.log("this is render"+render);
          console.log("this is value"+value);
        },
        // 绑定@imgAdd event
        $imgAdd(pos, $file){
           var formdata = new FormData();
           formdata.append('file', $file);
           imgeApi(formdata).then(res=>{
                let url="/server/"+res.data.data;
                this.$refs.md.$img2Url(pos, url);
           });
        },
        release(){
            this.outerVisible=true;
        },
        uploadArticle(){  
            this.outerVisible=false;
            let result=this.form;
            result.create_by=getNowDate(); 
            let that=this.$refs.articleform; 
            that.validate((valid)=>{
                if(valid){
                    articleApi.addNew(result).then(res=>{
                      console.log(res.data);
                      alert("发布随笔成功！")
                     })  
                }else{
                    alert("请将信息补充完整")
                    return false;
                }
            })
            
        },
        chooseCategory(){
            if(this.checkedCategories.length===0){
                alert("分类不可以为空");
            }else{
                 this.innerVisible=true;
            }
           
        },
         //暂存至草稿箱
        saveDraft(){
            let draft={
                title:this.form.title,
                content:this.form.content,
                summary:this.form.summary,
                create_by:getNowDate(),
                modified_by:getNowDate()
            }
            draftApi.add(draft).then(res=>{
                if(res.data.code==1){
                    this.$message({
                        message: '已存至草稿箱，请至草稿箱查找详情',
                        type: 'success'
                    });
                }
            })
            
        }
      
    },
}
</script>
<style scoped>
.new-article{
    text-align:left;
    display: flex;
    display: -webkit-flex;
    flex-direction: column;
}

.content{
    display: flex;
    height:600px;
}
.title{
    margin-bottom: 20px;
}
.title input{
    width:580px;
    height:24px;
}
.title span,.content span{
     font-size:16px;
     font-weight: bold;
     margin-right: 20px;
}
.operation{
    margin-top:20px;
    text-align: right;
}
.category-dialog{
    text-align:left;
    font-size:16px;
}
.split{
    display: inline-block;
    width:10px;
    height:30px;
    background:green;
    margin-bottom: -8px;
}
.title-dialog{
    margin-top:-10px;
    font-size:18px;
    font-weight: 900;
    margin-left:10px;
    
}

.innerDialog{
    background-color: #006666;
    border-color: #006666;
   
}
.inner-dialog{
    font-size:16px;
    text-align: center;
}
.dialog-tag{
    border: none;
    color:#006666;
    margin-left:5px;
    background-color:rgba(244, 249, 255, 0.1);
    font-weight: bold;
}
.imgtest{
    width:50%;
    height:200px;
    margin-left:20px;
    margin-bottom: 20px;
}
.imgtest img{
    width:100%;
    height:100%;
}
</style>