import Vue from 'vue'
import Router from 'vue-router'
import BlogManagement from '../components/blog_management'
import BlogCategory from '../components/BlogCategory'
import ErrorPage from '../components/Error'
import Recommend from '../components/Recommend'
import WebSum from '../components/WebSum'
import Comment  from '../components/Comment'
import CacheManage  from '../components/CacheManage'
import ArticleManage  from '../components/ArticleManage'
import ArticleComment  from '../components/ArticleComment'
import Setting  from '../components/system/Setting'
import Log  from '../components/system/Log'
import Draft from '../components/blog/Draft'
import NewArticle from '../components/blog/NewArticle'
import NewEssay from '../components/blog/NewEssay'
import Login from '../components/login/login'
import DraftArticleDetail from '../components/detail/DraftArticleDetails'
import EditDetail from '../components/detail/EditDetails'
import CategoryArticleDetail from '../components/detail/CategoryArticleDetail'
import ArticlesDetails from '../components/detail/ArticlesDetails'
import PersonalCenter from '../components/personalcenter'
Vue.use(Router)

const router= new Router({
  mode:'history',
  routes: [
    {
      path:'/login',
      component:Login,
      name:'login'
    },
    {
      path: '/',
      name: 'BlogManagement',
      component: BlogManagement,
      redirect:'/category',
      meta: {
        requiresAuth: true
      },
      children:[
        {
          path:'category',
          name:'blogcategory',
          component:BlogCategory,
        },
        {
          path:'newarticle',
          name:'newarticle',
          component:NewArticle
        },
        {
           path:'draft',
           name:'draft',
           component:Draft
        },
        {
          path:'newessay',
          name:'newessay',
          component:NewEssay
        },
        {
          path:'articlemanage',
          name:'articlemanage',
          component:ArticleManage
        },
        {
          path:'websum',
          name:'websum',
          component:WebSum
        },
        {
          path:'articlecomment',
          name:'articlecomment',
          component:ArticleComment
        },
        {
          path:'comment',
          name:'comment',
          component:Comment
        },
        {
          path:'error',
          name:'error',
          component:ErrorPage
        },
        {
          path:'cachemanage',
          name:'cachemanage',
          component:CacheManage
        },
        {
          path:'setting',
          name:'setting',
          component:Setting
        },
        {
          path:'log',
          name:'log',
          component:Log

        },
        {
          path:'articleinfo',
          name:'articleinfo',
          component:DraftArticleDetail
        },
        {
          path:'editinfo',
          name:'editinfo',
          component:EditDetail
        },
        {
          path:'categoryArticles',
          name:'categoryArticles',
          component:CategoryArticleDetail
        },
        {
          path:'articleinformation',
          name:'articleinformation',
          component:ArticlesDetails
        },
        {
          path:'recommend',
          name:'recommend',
          component:Recommend
        },
        {
          path:'percenter',
          name:'percenter',
          component:PersonalCenter
        }
      ]
    },
    {
    
      path: '**',   // 错误路由
      redirect: '/login'   //重定向
    },
  ]
})


// 全局路由守卫
router.beforeEach((to, from, next) => {
  console.log('路由守卫');
  // to: Route: 即将要进入的目标 路由对象
  // from: Route: 当前导航正要离开的路由
  // next: Function: 一定要调用该方法来 resolve 这个钩子。执行效果依赖 next 方法的调用参数。

  //这个里面的值都是name值
  const nextRoute = ['blogcategory', 'newarticle','draft','newessay','articlemanage','websum','recommend','percenter',
  'articlecomment','comment','error','cachemanage','setting','log','articleinfo','editinfo','categoryArticles','articleinformation'];
  let login=window.localStorage.getItem("isLogin");
  let isLogin = login==null?false:login; // 是否登录
  
  console.log(isLogin)
  // 未登录状态；当路由到nextRoute指定页时，跳转至login
  if (nextRoute.indexOf(to.name) >= 0) {  
    console.log("kkk");
    if (!isLogin) {
      console.log('what fuck');
      router.push({ name: 'login' })
    }
  }
  // 已登录状态；当路由到login时，跳转至category
  if (to.name === 'login') {
    if (isLogin) {
      router.push({ name: 'blogcategory' });
    }
  }
  next();
});


export default router;