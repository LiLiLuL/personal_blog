<template>
    <div>
        <div>
            <el-col :span="16">
                <h2>{{title}}</h2>
               
                <p class="summary">摘要：{{information.summary}}</p>
                <p> <b>发表时间:{{information.create_by}}</b><b class="author">作者：chenxq &nbsp; &nbsp;|| &nbsp;&nbsp;阅读：({{information.hits}})</b></p>
            </el-col>
            <el-col :span="8">
                <div class="imgPos"><img :src="information.pictureUrl" alt=""/></div>
            </el-col>
        </div>
        <div style="clear:both"></div>
        <div>
           <pre v-highlightB>
             <code class="html">
                 <div v-html="information.content" class="markdown" ></div>
                 <p class="opration">
                 
                   <span>阅读（{{information.hits}}）</span><span>编&nbsp;辑|</span><span>删&nbsp;除|</span>
                </p>
             </code>
           </pre>
        </div>
        <el-button type="primary" @click="dialogVisible=true">评论</el-button>
        <el-dialog
    
        :visible.sync="dialogVisible"
         width="30%"
         >
        <el-form label-position="top" label-width="80px" :model="commentForm">
            <el-form-item label="昵称">
                <el-input v-model="commentForm.name"></el-input>
            </el-form-item>
            <el-form-item label="评论">
                <el-input v-model="commentForm.content" type="textarea" :rows="3" ></el-input>
            </el-form-item>
        </el-form>
        <span slot="footer" class="dialog-footer">
            <el-button @click="dialogVisible = false">取 消</el-button>
            <el-button type="primary" @click="releaseComment()">确 定</el-button>
        </span>
        </el-dialog>

        <hr>
        <div v-show="images.length==0" style="width:100%;height:200px;">
          <img src="../../assets/images/null.jpg" alt="">
        </div>
        <ul v-show="images.length!=0" class="comment" >
          <li v-for="(item,index) in comments" :key="index"   >
              <el-row class="comment-row">
               <el-col :span="2"> <div class="userImg"><img :src="imageUrl(index)" alt="" ></div></el-col>
               <el-col :span="22">
                    <h3>{{item.name}}</h3>
                    <p>{{item.content}}</p>
                    <p style="text-align:right">{{item.create_by}}</p>
                </el-col>
              </el-row>

          </li>
      
        </ul>
    </div>
</template>
<script>
import {articleApi,commentApi} from '../../apiJS/api'
import {getNowDate} from '../../assets/util/commen'
import marked from 'marked'
export default {
    data(){
        return{
            title:this.$route.query.title,
            id:this.$route.query.id,
            information:{
                content:'',
                create_by:'',
                pictureUrl:'',
                summary:'',
                hits:''
            },
            dialogVisible:false,
            commentForm:{
                name:'',
                content:'',
                create_by:getNowDate(),
                article_id:this.$route.query.id,
            },
            comments:[],
            images:[],
            url:'',
            imgIndex:''
            
        }
    },   
    methods:{
        init(){
          let id=this.id;
          let that=this.information;
          articleApi.getOne(id).then(res=>{
             let result=res.data.data;

             that.summary=result.summary;
             that.content=marked(result.content||'',{
                    sanitize:true
                });
             that.pictureUrl="/server/"+result.pictureUrl;
             that.hits=result.hits;
             that.create_by=result.create_by;

          })
        },
        releaseComment(){
            this.dialogVisible=false;
            
            commentApi.add(this.commentForm).then(res=>{
                let code=res.data.code;
                if(code==1){
                    this.$message({
                        message:"评论发表成功",
                        type:'success'
                    });
                    this.getAllComment();
                }
            })

        },
        getAllComment(){
            commentApi.articleAll(this.id).then(res=>{
                this.comments=res.data.data;
                console.log(this.comments);
            }),
            commentApi.images().then(res=>{
                this.images=res.data.data;
            })
        },
        imageUrl(id){
            let n=Math.floor(Math.random() * this.images.length+5)-1; 
            return "/server/"+this.images[id+n];  
        }

       
    },
    created(){       
        this.init();
        this.getAllComment();
    },
    mounted(){
         
    }
    
}
</script>
<style scoped>
li{
    list-style: none;
}
.imgPos img{
    width:100%;
    height:100%;
}
.opration{
    /* text-align: right; */
}
.opration span{
    /* display: inline-block; */
    margin-right: 6px;
    font-size:14px;
    font-weight: 900;
    float: right;
}
.opration span:hover,
.opration span:focus,
.opration span:active{
    color:#006666;
}
.author{
    float: right;
    margin-right:20px;
}
.summary{
    min-height:120px;
    font-size:1.2rem;
    font-weight:900;
}
h2{
    font-size:2rem;
}
.userImg{
    width:80px;
    height:80px;
    border-radius: 50%;
    border:4px solid #83050f;
    overflow: hidden;
    margin: auto;
    margin-top:10px;
}
.userImg img{
    width:100%;
    height:100%;
    
}
.comment li{
    margin:5px;
    border-bottom: 1px solid #006666;
}
.comment-row{
    min-height:100px;
    
}
.comment li:last-child{
    border-bottom: none;
}
</style>
