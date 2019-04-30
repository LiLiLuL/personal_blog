import Vue from 'vue'
import Router from 'vue-router'
import theIndex from '@/components/theIndex'
import ArticleIndex from '@/components/articles/index'
import Category from '@/components/articles/category'
import NewArticles from '@/components/articles/newArticles'
import AuthorMessage from '@/components/articles/authorMessage'
import CategoryArticleDetail from '@/components/articles/categoryArticleDetails'
import ArticleInformation from '@/components/articles/articleDetails'
import Recommend from '@/components/articles/recommend'


Vue.use(Router)

export default new Router({
  mode:'history',
  routes: [
    {
      path: '/',
      name: 'theIndex',
      component: theIndex
    },
    {
      path:'/index',
      name:'index',
      component:ArticleIndex,
      redirect:'/index/category',
      children:[
        {
          path:'category',
          name:'category',
          component:Category
        },
        {
          path:'newArticle',
          component:NewArticles
        },
        {
          path:'authormes',
          component:AuthorMessage

        },
        {
          path:'categoryArticles',
          component:CategoryArticleDetail
        },
        {
          path:'articleinformation',
          component:ArticleInformation
        },
        {
          path:'recommend',
          component:Recommend

        }
      ]

    }
  ]
})
