const state={
    cate:[]
}

const getters={  //实时监听state值得变化
    renderCate(state){ //承载变化的分类信息
        return state.cate;
    }
}

const mutations={
    pushCate(state,items){ //如何变化cate，插入items
        state.cate.push(items)
    },
    initCategory(state,arr){
        state.cate=arr;
    }
}

const actions={
      invokePushItems(context,item){ //处罚mutations里面的pushCate,传入数据形参对应到items
        context.commit('pushCate',item)

      },
      invokeInitCategory(context,arr){
         context.commit('initCategory',arr);
      }
}

export default {
    namespaced:true,
    state,
    getters,
    mutations,
    actions
}