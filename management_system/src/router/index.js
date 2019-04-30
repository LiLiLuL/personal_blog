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

Vue.use(Router)

export default new Router({
  mode:'history',
  routes: [
    {
      path:'/login',
      component:Login
    },
    {
      path: '/',
      name: 'BlogManagement',
      component: BlogManagement,
      redirect:'/login',
      meta: {
        requiresAuth: true
      },
      children:[
        {
          path:'category',
          name:'blogcategory',
          component:BlogCategory
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
        }
      ]
    },
  ]
})
