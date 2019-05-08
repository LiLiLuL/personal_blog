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
        <div class="articleContent">
           <pre >
             <code class="html">
                 <div v-html="information.content" class="markdown" ></div>
             </code>
           </pre>
        </div>
        <el-button type="primary" @click="dialogVisible=true">评论</el-button>
         <hr>
        <div v-show="comments.length==0">
            还没有人评论，快来发表你的意见吧

        </div>
        <el-dialog
    
        :visible.sync="dialogVisible"
         width="30%"
         >
        <el-form label-position="top" label-width="80px" :model="commentForm">
            <el-form-item label="你的昵称">
                <el-input v-model="commentForm.name"></el-input>
            </el-form-item>
            <el-form-item label="评论内容">
                <el-input v-model="commentForm.content" type="textarea" :rows="3" ></el-input>
            </el-form-item>
        </el-form>
        <span slot="footer" class="dialog-footer">
            <el-button @click="dialogVisible = false">取 消</el-button>
            <el-button type="primary" @click="releaseComment()">确 定</el-button>
        </span>
        </el-dialog>

        <!-- <div v-show="images.length==0" style="width:100%;height:200px;">
          <img src="../../assets/img/null.jpg" alt="">
        </div> -->
        <ul v-show="images.length!=0" class="comment" >
          <li v-for="(item,index) in comments" :key="index"   >
              <el-row class="comment-row">
               <el-col :span="2"> <div class="userImg"><img :src="imageUrl(index)" alt="" ></div></el-col>
               <el-col :span="22">
                    <h3>{{item.name}}</h3>
                    <p>{{item.content}}</p>
                    <p style="text-align:right"><el-button @click="reply(item)" class="reply"><i class="icon iconfont icon-pinglun1"></i>回复</el-button>{{item.create_by}}</p>
                </el-col>
              </el-row>
            
               <el-timeline class="replyList">
                    <el-timeline-item
                    v-for="(reply,index) in item.reply" :key="index"
                    color="#006666"
                    :timestamp="reply.create_by">
                    <p>{{reply.name}}<b>回复:</b> {{reply.content}}</p>   
                    </el-timeline-item>
                </el-timeline>
             
          </li>
      
        </ul>
         <el-dialog   
        :title="reply_to"
        :visible.sync="dialogReply"
         width="30%"
         >
        <el-form label-position="top" label-width="80px" :model="replyForm">
            <el-form-item label="你的昵称">
                <el-input v-model="replyForm.name"></el-input>
            </el-form-item>
            <el-form-item label="回复内容">
                <el-input v-model="replyForm.content" type="textarea" :rows="3" ></el-input>
            </el-form-item>
        </el-form>
        <span slot="footer" class="dialog-footer">
            <el-button @click="dialogReply= false">取 消</el-button>
            <el-button type="primary"  @click="addReply()">确 定</el-button>
        </span>
        </el-dialog>
    </div>
</template>
<script>
import {articleApi,commentApi} from '../.././apiJS/api'
import {getNowDate} from '../.././assets/util/common'
import marked from 'marked'
const CustomForeach = async (arr, callback) => {
  const length = arr.length;
  const O = Object(arr);
  let k = 0;
  while (k < length) {
    if (k in O) {
      console.log('doing foreach...');
      const kValue = O[k];
      await callback(kValue, k, O);
    }
    k++;
  }
};
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
            dialogReply:false,
            commentForm:{
                name:'',
                content:'',
                create_by:'',
                article_id:this.$route.query.id,
            },
            comments:[],
            images:[],
            url:'',
            imgIndex:'',
            replyForm:{
                name:'',
                comment_id:'',
                create_by:'',
                content:''
            },
            reply_to:''
            
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

          });
          commentApi.images().then(res=>{
                this.images=res.data.data;
          })
        },
        releaseComment(){
            this.dialogVisible=false;
            let form=this.commentForm;
            form.create_by=getNowDate();
            commentApi.add(form).then(res=>{
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
        // getAllComment(){
        //     commentApi.articleAll(this.id).then(res=>{
        //         this.comments=res.data.data;
        //     }),
        //     commentApi.images().then(res=>{
        //         this.images=res.data.data;
        //     })
            
        // },
        async getAllComment(){
                let _this=this;
                let data=await commentApi.articleAllById(_this.id);
                data=data.data;
                
                for(let i=0; i<data.length;i++){
                    let reply=await commentApi.selectReply(data[i].commentId);
                    data[i].reply=reply.data;
                    
                }
               _this.comments=data;
        },
        imageUrl(id){
            let n=Math.floor(Math.random() * this.images.length+5)-1; 
            return "/server/"+this.images[id+n];  
        },
        reply(name){
           this.dialogReply=true;
           this.reply_to="【回复】"+name.name;
           let form=this.replyForm;
           form.comment_id=name.id;
           form.create_by=getNowDate();
           console.log(this.replyForm);
        },
        addReply(){
            this.dialogReply=false;
            commentApi.addReply(this.replyForm).then(res=>{
                let status=res.data.status;
                if(status=="success"){
                    this.$message({
                        message:"评论发表成功",
                        type:'success'
                    });
                    this.getAllComment();
                }
            })
         }

       
    },
    async created(){       
        this.init();
        await this.getAllComment();
        
    },
    watch:{
        '$route':function(to,from){
           this.title=this.$route.query.title;
           this.id=this.$route.query.id;
           this.init();
           this.getAllComment();
        }
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
.articleContent{
    background: rgba(255, 255, 255, 0.445);
    padding:10px ;
    margin-bottom: 10px;
}
.reply{
    font-weight:bold;
    margin-right:20px;
    color:rgb(119, 109, 111);
    border:0px;
    background:transparent;
    padding:4px;

}
.reply:hover{
    color:#006666;
}
.replyList{
    margin-left:100px;
}
.replyList li{
    border:0;
}

</style>
