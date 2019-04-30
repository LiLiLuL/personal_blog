import Vue from 'vue'
import Vuex from 'vuex'
import category from './module/category'
import login from './module/login'
Vue.use(Vuex)

export default new Vuex.Store({
      modules:{
          category,login
      }
})