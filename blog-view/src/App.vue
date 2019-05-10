<template>
  <div>
    <div id="app">
      <router-view/>
    </div>
    <p style="text-align:center">&copy;Chenxq2019,侵权必究</p>
  </div>
</template>

<script>
export default {
  name: 'App'
}
</script>

<style>
html{
  min-height:100%;
  position: relative;
}
#app {
  font-family: "STXingkai","Josefin Slab","Myriad pro",cursive;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  color: #2c3e50;
  font-size: 16px;  
  position: static;

}
#app::before{
  background-image: url('./assets/img/background.jpg');
  background-size: cover;
  background-position:50% 50%;
  content: "";
  width: 100%;
  height: 100%;
  position: absolute;
  top: 0;
  left: 0;
  z-index: -1;/*-1 可以当背景*/
  -webkit-filter: alpha(opacity=60);
  filter: alpha(opacity=60);
  opacity: 0.5;
  display: block;

}
.el-menu{
    background-color: transparent;
}
a{
  text-decoration: none;
}
div,p,ul{
    margin-block-start: 0em;
    margin-block-end: 0em;
}
ul{
  padding-inline-start: 0px;
}
li{
  list-style: none;
  margin:2px;
}

.markdown img {
    max-width: 100%;
    box-sizing: content-box;
    background-color: #fff;
    border-style: none;
 }
 .markdown p,.markdown div{
   width:100%;
   white-space: normal;
 }
 .markdown table{
   width:100%;
   border:1px solid  #f15f8d96;
 }
 .markdown table td,.markdown table th{
   border:1px solid  #f15f8d79;
   text-align: center;
 }
 .el-button--primary{
    background-color: pink;
    border-color: pink;
    color:saddlebrown;
    font-weight:700;
}
.el-button--primary:focus,
.el-button--primary:hover,
.el-button--primary:active{
   background-color: #f15f8e;
   border-color: #fa96b5;
}
.el-button--default{
    background-color: rgb(167, 194, 196);
    border-color: rgb(167, 194, 196);
    color:saddlebrown;
    font-weight:700;
}
.el-button--default:focus,
.el-button--default:hover,
.el-button--default:active{
   background-color: rgb(107, 129, 131);
   border-color: rgb(107, 129, 131);
   color:#fff;
}
a:-webkit-any-link {
    color: inherit;
}
.el-tag{
  padding: 0px;
}
.el-timeline-item__tail {
    border-left:2px solid #006666;
}
</style>
