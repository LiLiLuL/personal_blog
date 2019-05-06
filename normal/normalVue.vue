//watch的三种用法
//通过watch来直接监测demo，如果demo的值变化，value的值也会跟着一起变化。
<template>
  <div>
    <el-input v-model="demo"></el-input>
    {{value}}
  </div>
</template>
<script>
  export default {
    name: 'index',
    data() {
      return {
        demo: '',
        value: ''
      };
    },
    watch: {
      demo(val) {
        this.value = this.demo;
      }
    }
  };
</script>

//如果watch监测的是一个对象的话，直接使用watch是不行的，此时我们可以借助于computed计算属性来完成。
<template>
  <div>
    <el-input v-model="demo.name"></el-input>
    {{value}}
  </div>
</template>
<script>
  export default {
    name: 'index',
    data() {
      return {
        demo: {
          name: ''
        },
        value: ''
      };
    },
    computed: {
      newName() {
        return this.demo.name;
      }
    },
    watch: {
      newName(val) {
        this.value = val;
      }
    }
  };
</script>


// 数组的变化，不需要深度watch。
<div id="app">
  <input type="text" v-model="childrens.name" />
  <input type="text" v-model="lastName" />
</div>

<script type="text/javascript">
  var vm = new Vue( {
    el: '#app',
    data: {
      childrens: {
        name: '小强',
        age: 20,
        sex: '男'
      },
      tdArray:["1","2"],
      lastName:"张三"
    },
    watch:{
      childrens:{
        handler:function(val,oldval){
          console.log(val.name)
        },
        deep:true//对象内部的属性监听，也叫深度监听
      },
      'childrens.name':function(val,oldval){
        console.log(val+"aaa")
      },//键路径必须加上引号
      lastName:function(val,oldval){
        console.log(this.lastName)
      }
    },//以V-model绑定数据时使用的数据变化监测
  } );
  vm.$watch("lastName",function(val,oldval){
    console.log(val)
  })//主动调用$watch方法来进行数据监测
</script>
</body>