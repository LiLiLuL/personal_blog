 const state = {
    token: window.sessionStorage.getItem('token'),
    username: '',
    isLogin:false
  };
  const mutations = {
    LOGIN: (state, data) => {
    // 更改token的值
      state.token = data ;
      window.sessionStorage.setItem('token', data);
    },
    LOGOUT: (state) => {
    // 登出的时候要清除token
      state.token = null ;
      window.sessionStorage.removeItem('token');
    },
    USERNAME: (state, data) => {
      // 把用户名存起来
      state.username = data ;
      window.sessionStorage.setItem('username', data);
    },
    ISLOGIN:(state)=>{
      state.isLogin=true;
    },
    NOLOGIN:(state)=>{
      state.isLogin=false;
    }
  };
  const actions = {
    UserLogin ({ commit }, data) {
      commit('LOGIN', data);
    },
    UserLogout ({ commit }) {
      commit('LOGOUT');
    },
    UserName ({ commit }, data) {
      commit('USERNAME', data);
    },
    USERISLOGIN({commit}){
      commit('ISLOGIN');
    },
    USERNOLOGIN({commit}){
      commit('NOLOGIN');
    }
  } ;
  export default{
    namespaced:true,
    state,
    mutations,
    actions
  };