<template>
   <div class="header-back">
       <h2>个人博客后台管理系统</h2>
       <p class="operation">
           <router-link to="/percenter"><el-button ><i class="icon iconfont icon-user"></i>个人中心</el-button></router-link>
           <el-button @click="logout"><i class="icon iconfont icon-tuichu"></i>退出</el-button>
       </p>

   </div>
</template>
<script>
import {mapState,mapGetters,mapActions} from 'vuex';
export default {
    data(){
        return{

        }
    },
    computed:{
        ...mapState({
            isLogin:state=>state.login.isLogin
        }),

    },
    methods:{
         ...mapActions('login',[
            'USERISLOGIN','USERNOLOGIN'
        ]),
        logout(){
            this.$router.push('login');
            window.localStorage.clear();
            this.USERNOLOGIN();
        }
    }
}
</script>
<style scoped>
.header-back{
    font-family: Impact, Haettenschweiler, 'Arial Narrow Bold', sans-serif;
    display: flex;
    justify-content: space-between;
}
.operation button{
    color:#fff;
    background: transparent;
    padding: 0;
    border:0px;
    font-weight:bold;
    font-size:16px;
    margin-right:20px;

}
.operation button:hover{
    color:rgb(230, 101, 27);
}
i{
    margin-right:5px;
}
</style>

