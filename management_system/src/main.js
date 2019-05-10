// The Vue build version to load with the `import` command
// (runtime-only or standalone) has been set in webpack.base.conf with an alias.
import Vue from 'vue'
import router from './router'
import ElementUI from 'element-ui'
import 'element-ui/lib/theme-chalk/index.css'
import App from './App'
import store from './store'
import hljs from 'highlight.js'
import 'highlight.js/styles/atom-one-dark.css' //样式文件
// highlight.js代码高亮指令
import Highlight from './assets/util/highlight';
 

// import 'highlight.js/styles/googlecode.css';
//import 'highlight.js/styles/railscasts.css';
Vue.directive('highlight',function (el) {
  let blocks = el.querySelectorAll('pre code');
  blocks.forEach((block)=>{
    hljs.highlightBlock(block);
  })
});

Vue.config.productionTip = false
Vue.use(ElementUI)
Vue.use(Highlight);
/* eslint-disable no-new */
new Vue({
  el: '#app',
  router,
  store,
  components: { App },
  template: '<App/>'
})
