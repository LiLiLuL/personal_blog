import axios from 'axios'

//文章分类的增加、删除、修改
let categoryApi={
    allCategory:()=>{
       return axios.get("/server/admin/category/all")
    },
    findByName:catename=>{
        return axios.get("/server/admin/category/find",{params:{name:catename}})
    },
    addCategory:category=>{
        return axios.post("/server/admin/category/add",category)        
    },
    deleteCategory:category=>{
        return axios.get("/server/admin/category/delete",{params:{name:category}})
    },
    changeCategory:category=>{
        return axios.post("/server/admin/category/update",category)
    },
    getAllArticles:category=>{
        return axios.get("/server/admin/category/getarticles",{params:{id:category}})
    },
    getLastArticles:category=>{
        return axios.get("/server/admin/category/getlastarticles",{params:{id:category}})
    }
}
//markdown图片上传API
let imgeApi=formdata=>{
    return axios({
        url: '/server/admin/upload',
        method: 'post',
        data: formdata,
        headers: { 'Content-Type': 'multipart/form-data' },
    })
}


//用户登陆的信息
let loginApi={
    login:formdata=>{
        return axios.post("/server/admin/checkuser",formdata)
    }
}

//文章的增删改查
let articleApi={
    addNew:formdata=>{
        return axios.post("/server/admin/article/add",formdata)
    },
    //得到所有文章的题图信息
    getAll:()=>{
        return axios.get("/server/admin/article/all")
    },
    //根据文章ID得到一篇文章的题图信息
    getOne:id=>{
        return axios.get("/server/admin/article/one",{params:{id:id}})
    }, 
    async getOneArticle(data) {
    try {
        let res = await axios.get("/server/admin/article/one", {params: {id:data}})
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
//草稿箱的增删改查
let  draftApi={
    add:formdata=>{
        return axios.post("/server/admin/draft/add",formdata)
    },
    findall:()=>{
        return axios.get("/server/admin/draft/all")
    },
    findByTitle:name=>{
        return axios.get("/server/admin/draft/select",{params:{name:name}})
    },
    deleteByTitle:name=>{
        return axios.get("/server/admin/draft/delete",{params:{name:name}})
    },
    update:formdata=>{
        return axios.post("/server/admin/draft/update",formdata)
    }

}
//操作日志的相关操作
let logApi={
    all:()=>{
        return axios.get("/server/admin/log/all")
    }
}

//评论模块的相关操作
let commentApi={
    add:comment=>{
        return axios.post("/server/admin/comment/add",comment)
    },
    articleAll:id=>{
        return axios.get("/server/admin/comment/articleAllComment",{params:{id:id}})
    },
    images:()=>{
        return axios.get("/server/admin/image/all")
    },
    async allComments(){
        let res=await axios.get("/server/admin/comment/allComments");
        return  res.data;
    }
}

//推荐管理的相关模块

let recommendApi={
    async getAll(){
        let res=await axios.get("/server/admin/recommend/all");
        return res.data;
    },
    add:recommend=>{
        return axios.post("/server/admin/recommend/add",recommend)
    },
    delete:id=>{
        return axios.get("/server/admin/recommend/delete",{params:{id:id}})
    },
    update:recommend=>{
        return axios.post("/server/admin/recommend/update",recommend)
    }
}
export {
    categoryApi,imgeApi,loginApi,articleApi,draftApi,logApi,commentApi,recommendApi
};