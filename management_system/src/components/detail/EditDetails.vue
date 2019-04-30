<template>
<div class="new-article">
    <el-form ref="articleform" :model="form"  :rules="rules" label-width="80px"> 
    <el-row>
        <el-col :span="12">
            <el-form-item label="文章标题" prop="title">
                <el-input v-model="form.title" ></el-input>
            </el-form-item>
            <el-form-item label="文章简介" prop="summary">
                <el-input v-model="form.summary" ></el-input>
            </el-form-item>
            <el-form-item label="选择题图">
                <div>
                <input type="file" ref="uploadimg" name="pic" id="upimg" accept="image/*"  @change="uploadimge" />
                </div>
            </el-form-item>
        </el-col>
        <el-col :span="12">   
            <div class="imgtest">
            <img src="" alt="" id="img" />  
            </div> 
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
                <p>
                    <span class="split"></span>
                    <span class="title-dialog">请选择要发布的类别</span>
                </p>
                 <el-checkbox :indeterminate="isIndeterminate" v-model="checkAll" @change="handleCheckAllChange">全选</el-checkbox>
                <div style="margin: 15px 0;"></div>
                <el-checkbox-group v-model="checkedCategories" @change="handleCheckedCategoriessChange">
                     <el-checkbox v-for="val in arrList" :label="val" :key="val.name">{{val.name}}</el-checkbox>
                </el-checkbox-group>
                <el-dialog
                width="30%"
                :visible.sync="innerVisible"
                append-to-body
                class="inner-dialog"
                >
                <p>您的文章即将发布在
                    <el-tag v-for="(tag,index) in checkedCategories" :key="index" class="dialog-tag">
                         {{tag.name}}
                    </el-tag>
                    中，是否确认？
                </p>
                  <el-button  type="info" @click="innerVisible=false">取 消</el-button>
                  <el-button type="primary" class="innerDialog"  @click="uploadArticle">确定</el-button>
                </el-dialog>
                <div slot="footer" class="dialog-footer">
                <el-button @click="outerVisible = false" type="info">取 消</el-button>
                <el-button type="primary" class="innerDialog" @click="chooseCategory">确定</el-button>
                </div>
            </el-dialog>
            {{newArr}}
            <el-button type="default" @click="saveDraft">暂存</el-button>
         </div>
      </el-col>
</div>
    
</template>
<script>
import {mavonEditor} from 'mavon-editor'
import  'mavon-editor/dist/css/index.css'
import { mapGetters } from 'vuex';
import {imgeApi,articleApi,draftApi,categoryApi} from '../../apiJS/api'
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
                title:this.$route.query.title,
                summary:'',
                create_by:'',
                content:'',
                categoryArr:''
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
        }),
        newArr(){
            let cc="随笔";
            categoryApi.findByName(cc).then(res=>{
                let result=res.data.data[0];
                return this.arrList.push(result);
            })
        }
    },
    created(){
        let newTitle=this.form.title;
        draftApi.findByTitle(newTitle).then(res=>{
                let newData=res.data.data[0];
                this.form=Object.assign(this.form,newData);
                 console.log(this.form);
        })

    },
    methods:{
        changeMavon(){
        },
        //富文本保存的方法
        saveMavon(value,render){
            
          console.log("this is render"+render);
          console.log("this is value"+value);
        },
        // 绑定@imgAdd event
        $imgAdd(pos, $file){
            console.log("触发图片上传");
            console.log(pos);
            console.log($file);
            // 第一步.将图片上传到服务器.
           var formdata = new FormData();
           formdata.append('file', $file);
           console.log(formdata);
           imgeApi(formdata).then(res=>{
               // 第二步.将返回的url替换到文本原位置![...](0) -> ![...](url)
               /**
               * $vm 指为mavonEditor实例，可以通过如下两种方式获取
               * 1. 通过引入对象获取: `import {mavonEditor} from ...` 等方式引入后，`$vm`为`mavonEditor`
               * 2. 通过$refs获取: html声明ref : `<mavon-editor ref=md ></mavon-editor>，`$vm`为 `this.$refs.md`
               */
                console.log(res.data);
                let url="/server/"+res.data.data;
                this.$refs.md.$img2Url(pos, url);
           });
        },
        release(){
            this.outerVisible=true;
        },
        handleCheckAllChange(val){
             this.checkedCategories = val ? this.arrList : [];
             this.isIndeterminate = false;          
        },
        handleCheckedCategoriessChange(value){
              let checkedCount = value.length;
              this.checkAll = checkedCount === this.categroies.length;
              this.isIndeterminate = checkedCount > 0 && checkedCount < this.categroies.length; 
        },
        //上传文章
        uploadArticle(){
            this.outerVisible=false;
            this.innerVisible=false;   
            let result=this.form;
            let arr=this.checkedCategories;
            let newArr=arr.map(function(v){return v.id});
            result.categoryArr=newArr;
            result.create_by=getNowDate(); 
            let that=this.$refs.articleform; 
            that.validate((valid)=>{
                if(valid){
                    articleApi.addNew(result).then(res=>{
                    console.log(res.data);
                     })  
                    console.log(result);
                    console.log(this.checkedCategories);
                    console.log(this.content);
                    //得到相应的html/文件
                    console.log(this.$refs.md.d_render);

                }else{
                    alert("请将信息补充完整")
                    return false;
                }
            })
            
        },
        //选择分类
        chooseCategory(){
            if(this.checkedCategories.length===0){
                alert("分类不可以为空");
            }else{
                 this.innerVisible=true;
            }
           
        },
        //上传题图以及其预览
        uploadimge(){
            let fileInput=document.getElementById("upimg");
            let file=fileInput.files[0];
            let reader=new FileReader();
            let imgFile;
            let that=this;
            reader.onload=function(e){
                imgFile=e.target.result;
                document.getElementById("img").src=imgFile;
                let formdata = new FormData();
                formdata.append('file', file);
                imgeApi(formdata).then(res=>{
                    let url=res.data.data;
                    that.form.pictureUrl=url;
                })
            };
            reader.readAsDataURL(file);
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