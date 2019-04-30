<template>
    <div>
        这是最新文章页面
        {{articleInfo}}
    </div>
</template>
<script>
import {articleApi} from '../../apiJS/api'
export default {
    data(){
        return{
            articleInfo:''
        }
    },
    methods:{
        getTheArticle(){
            articleApi.getLastArticle().then(res=>{
                let data=res.data.data;
                this.articleInfo=data;
            })
        }
    },
    created(){
        this.getTheArticle();
    }
}
</script>
<style scoped>

</style>
