<template>
    <div>
         
        <p>{{title}}</p>
       
         <!-- <link href="//cdn.bootcss.com/github-markdown-css/2.4.1/github-markdown.css" rel="stylesheet">
         <div v-highlight  class="markdown-body" v-html="readmeContent" >
             
         </div> -->
        
         <pre v-highlightB>
             <code class="html">
                 <div v-html="readmeContent" class="markdown" ></div>
             </code>
         </pre>
         
    
       
    </div>
</template>
<script>
import {draftApi} from '../../apiJS/api'
import marked from 'marked'


marked.setOptions({
    renderer: new marked.Renderer(),
    gfm: true,
    tables: true,
    breaks: false,
    pedantic: false,
    sanitize: false,
    smartLists: true,
    smartypants: false,
    // highlight:function(code){
    //     return hljs.highlightAuto(code).value;
    // }
    // highlight: function (code, lang, callback) {
    //      require('pygmentize-bundled')({lang:lang,format:"html"},code,function(err,result){
    //          callback(err,result.toString());
    //      })
    //  }
  });



export default {
    data(){
        return {
            title:this.$route.query.title,
            content:'',
            readmeContent:''
        }
    },
    computed:{
        
    },
    methods:{
        initArticle(){
            let newTitle=this.title;
            draftApi.findByTitle(newTitle).then(res=>{
                let newData=res.data.data;
                this.content=newData[0].content;
                this.readmeContent=marked(newData[0].content||'',{
                    sanitize:true
                })

            })
        }
    },
    created(){
       this.initArticle();
    },
    mounted(){
        this.initArticle();
    }
    
}
</script>
<style >
 .markdown img {
    max-width: 100%;
    box-sizing: content-box;
    background-color: #fff;
    border-style: none;
 }
</style>
