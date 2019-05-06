<template>
    <div>
         <b>前言：</b>本网站是我独立搭建的个人博客，主要分以下四部分：<br/>
         <ul class="separate">
           <li>1.前台展示页面构建（vue+element)</li>
           <li>2.后台管理页面(vue+element)</li>
           <li>3.数据库的构建（mysql)</li>
           <li>4.后台接口的实现（mybatis+spring boot)</li>
        </ul>
        在整个博客系统搭建的过程中，我学会的知识点有：<br/>
        （1）使用mybatis逆向工程快速生成实体类以及相关的方法；<br/>
        （2）使用markdown编辑器来从存储新文章以及使用marked和highlight.js来解析和高亮markdown编辑器编写的文章；<br/>
        （3）写代码的好习惯：调取接口时，最好将所有的api放入一个api.js文件，方便修改以及使用；<br/>
        （4）给一个div加一个背景图片时，可以用伪类::before，并且使z-index:-1；就可以使得图片为背景图片；<br/>
    </div>
</template>
<script>
export default {
    
}
</script>
<style scoped>
.separate{
    display: flex;
    margin-top:5px;
}
.separate li{
    background:rgba(255, 255, 255, 0.589);
    border-radius: 10px;
    text-align: center;
    vertical-align: middle;
    border:2px solid #00666685;
    width:200px;
    height:60px;
}
</style>
