<template>
  <div id="app">
    <router-view/>
  </div>
</template>

<script>
export default {
  name: 'App'
}
</script>

<style>
#app {
  font-family: 'Avenir', Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  /* text-align: center; */
  color: #2c3e50;
}
.el-submenu__title{
  height:30px;
  line-height: 30px;
}
.el-submenu__title:hover{
   background-color: rgb(126, 150, 112);
}
.el-aside{
    background: #006666;
}
.el-checkbox__input.is-checked .el-checkbox__inner, .el-checkbox__input.is-indeterminate .el-checkbox__inner {
    background-color: #006666;
    border-color: #006666;
}
.el-checkbox__input.is-checked+.el-checkbox__label {
    color: #006666;
}
.el-dialog__header {
    padding: 0px;
}
.el-form-item__label{
  font-size:16px;
  font-weight:900;
}
.el-button--primary{
    background-color: #006666;
    border-color: #006666;
}
.el-button--primary:focus,
.el-button--primary:hover,
.el-button--primary:active{
   background-color: #179494;
   border-color: #5f8181;
}
.markdown img {
    max-width: 100%;
    box-sizing: content-box;
    background-color: #fff;
    border-style: none;
 }
 .el-pagination.is-background .el-pager li:not(.disabled).active {
    background-color: #006666;
    color: #fff;
}
.el-checkbox__inner{
  border: 1px solid #c0c2c7;
}
.el-table td,.el-table th.is-leaf{
  border-bottom: 1px solid #c0c4cc;
  border-right: 1px solid #c0c4cc;

}
.el-table{
  border:1px solid #c0c4cc;
}
.el-table th>.cell{
  font-weight: bold;
  color: #006666;
  font-size:16px;

}
</style>
