import axios from 'axios'

//文章分类的查找
let categoryApi={
    allCategory:()=>{
       return axios.get("/server/client/category/all")
    },
    findByName:catename=>{
        return axios.get("/server/client/category/find",{params:{name:catename}})
    },
    getAllArticles:category=>{
        return axios.get("/server/client/category/getarticles",{params:{id:category}})
    },
    getLastArticles:category=>{
        return axios.get("/server/client/category/getlastarticles",{params:{id:category}})
    }
}

//文章的查找
let articleApi={
    //得到所有文章的题图信息
    getAll:()=>{
        return axios.get("/server/client/article/all")
    },
    //根据文章ID得到一篇文章的题图信息
    getOne:id=>{
        return axios.get("/server/client/article/one",{params:{id:id}})
    }, 
    async getOneArticle(data) {
    try {
        let res = await axios.get("/server/client/article/one", {params: {id:data}})
        res = res.data;
        return new Promise((resolve) => {
        if (res.code === 0) {
            resolve(res)
        } else {
            resolve(res)
        }
        })
    } catch (err) {
        alert('服务器出错')
        console.log(err)
    }
    },
    //得到阅读量最高的五篇文章
    async getHighHits() {
        try {
            let res = await axios.get("/server/client/articles/read")
            res = res.data
            return new Promise((resolve) => {
            if (res.code === 0) {
                resolve(res)
            } else {
                resolve(res)
            }
            })
        } catch (err) {
            alert('服务器出错')
            console.log(err)
        }
    },

    
}

//评论模块的相关操作
let commentApi={
    add:comment=>{
        return axios.post("/server/client/comment/add",comment)
    },
    articleAll:id=>{
        return axios.get("/server/client/comment/articleAllComment",{params:{id:id}})
    },
    images:()=>{
        return axios.get("/server/client/image/all")
    },
    async allComments(){
        let res=await axios.get("/server/client/comment/allComments");
        return  res.data;
    }
}
//博文推荐的相关操作
let recommendApi={
    async getAll(){
        let res=await axios.get("/server/client/recommend/all");
        return res.data;
    },
}
export {
    categoryApi,articleApi,commentApi,recommendApi
};