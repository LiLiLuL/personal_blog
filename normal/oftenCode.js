// js常用代码集锦

//判断对象数组中是否有某属性值，有则返回true,无则返回false
let flag=arr.some(item=>{
    if(item.name==value){
        return true
    }
})

//如果某个属性值在对象数组中存在，找到这个对象
function findOne(item,arr){
    let newArr=arr.filter(function(items){
      return  items.key==item;
    });
    if(newArr.length==0){
      let str='此元素不存在';
        return str;
    }
    return newArr;
}



// 数组去重
function unique(arr) {
    if (!Array.isArray(arr)) {
        console.log('type error!')
        return
    }
    let res = []
    for (let i = 0; i < arr.length; i++) {
        if (res.indexOf(arr[i]) === -1) {
            res.push(arr[i])
        }
    }
    return res
}
//修改数组对象中的某个属性值
// 1
this.$set(this.iptDatas[index], `key`, value)
// 2
let result=arr.map((item,index)=>{
    if(item.name==tag.name){
        item.name=value
    }
    return item;
});

//获得当前的日期yyyy--mm--dd
function getNowDate(){
    let date = new Date();
    let seperator1 = "-";
    let year = date.getFullYear();
    let month = date.getMonth() + 1;
    let strDate = date.getDate();
    if (month >= 1 && month <= 9) {
        month = "0" + month;
    }
    if (strDate >= 0 && strDate <= 9) {
        strDate = "0" + strDate;
    }
    let currentdate = year + seperator1 + month + seperator1 + strDate;
    return currentdate;
}

//比较两个日期的大小yyyy--mm--dd
function compare(date1,date2){
    var oDate1 = new Date(date1);
    var oDate2 = new Date(date2);
    if(oDate1.getTime() > oDate2.getTime()){
        return true;
    } else {
        return false;
    }

}

//不通过路由直接获取url中的参数
//第一步：创建utils.js文件，并保存到项目根目录

 export default{
     getUrlKey:function(name){
         return decodeURIComponent((new RegExp('[?|&]'+name+'='+'([^&;]+?)(&|#|;|$)').exec(location.href)||[,""])[1].replace(/\+/g,'%20'))||null;
    }
 }
//第二步：在主js方法（main.js)中注册全局方法

 import utils         from './utils'             //获取url参数
 
 Vue.prototype.$utils=utils            //注册全局方法
//第三步：vue文件中引用方法

let channel=this.$utils.getUrlKey("channel")
