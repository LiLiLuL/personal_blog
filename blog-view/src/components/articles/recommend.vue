<template>
    <div>
        <h1>博文推荐</h1>
        <ul>
            <li v-for="(item,index) in recommendList" :key="index">
               {{index+1}}. <a :href="item.url">{{item.title}}</a>
               <p class="recommend"><b>简评：</b>{{item.summary}}</p>
            </li>
        </ul>
    </div>
</template>
<script>
import {recommendApi} from '../.././apiJS/api'
export default {
    data(){
        return {
             recommendList:''
        }
    },
    methods:{
        async init(){         
            let data=await recommendApi.getAll();
            this.recommendList=data.data;
            console.log(this.recommendList);
        }
    },
    created(){
       this.init();
    },
    
}
</script>
<style scoped>
h1{
    border-left:10px solid rgb(255, 91, 118);
    padding-left:20px;
    color:rgb(255, 91, 118);
    font: outline;
}
li{
    margin-top:10px;
}
.recommend{
    color:gray;
    font-size:14px;
}
</style>
