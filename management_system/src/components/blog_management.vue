<template>
    <div>
        <el-container>
            <el-header > <Header/></el-header>
            <el-container>
                <el-aside width="160px" height="200px">
                    <Aside/>
                </el-aside>
                <el-main><router-view /></el-main>
            </el-container>
        </el-container>
    </div>

</template>
<script>
import Aside from './aside.vue'
import Header from './header/header'
export default {
    name:'BlogManagemnet',
    data(){
        return {
            mss:'个人博客首页'
        }
    },
    components:{
        Aside,Header
    }
}
</script>
<style scoped>
.el-header{
    background: #006666;
    text-align: left;
    color:#fff;
    
}
</style>

