<template>
    <el-container>
        <el-aside width="200px" class="asideLeft"><Left /></el-aside>
        <el-container class="right">
          <el-main class="content"><router-view/></el-main>
          <el-aside width="240px" class="asideRight"><Right /></el-aside>
        </el-container>
    </el-container>
</template>
<script>
import Left from './asideLeft'
import Right from './asideRight'
export default {
    components:{
        Left,Right
    }
    
}
</script>
<style scoped>
.asideLeft{
    height:100%;
    text-align: center;
}

.asideLeft::before{
    content: '';
    background-image: url('../.././assets/img/blue.jpg');
    z-index:-1;
    width:200px;
    height:600px;
    position: absolute;
    top: 5px;
    left: 8px;
    opacity: 0.6;
    background-origin: content-box;
    background-size: cover;
    background-position: 2% 50%;
}
.content{
     background: rgba(167, 228, 243, 0.271);
}
.asideRight{
    text-align: center;
}
</style>
