<template>
<div>
    <head>
    <meta http-equiv="X-UA-COMPATIBLE" content="IE-edge,chrome=1"><!--告诉ie使用新的渲染方式，防止低版本的ie不能使用css3-->
    <meta name="viewport" content="width=device-width,initial-scale=1">
    </head>
    <body>
    <div class="container">
        <div class="nav">
            <input type="radio" name="radio-set" checked id="nav1">
            <a href="#panel1">首页</a>
            <input type="radio" name="radio-set" id="nav2">
            <a href="#panel2">博客推荐</a>
            <input type="radio" name="radio-set" id="nav3">
            <a href="#panel3">导航3</a>
    
        <div class="scroll">
            <section class="panel" id="panel1">
                <div class="icon" data-icon="C"></div>
                <h1 class="title">Welcome to Chenxq's personalBlog</h1>
                <div class="personImg"><img src="../assets/img/person.jpeg" alt="" /></div>
            </section>
            <section class="panel panelColor" id="panel2">
                <div class="icon" data-icon="X"></div>
                <h1>文章推荐</h1>
                <ul class="recommend">
                 <li v-for="(item,index) in recommendList" :key="index">
                     <a :href="item.url">{{item.title}}</a>
                 </li>
                </ul>
            </section>
            <section class="panel" id="panel3">
                <div class="icon" data-icon="Q"></div>
                <div class="myImg">
                <img src=".././assets/img/logo.jpg" alt="" />
                <div class="imgT" @click="login">点击进入首页</div>
                </div>
            </section>
   

        </div>
        </div>
    </div>
    </body>
    </div>
</template>
<script>
import {recommendApi} from '../apiJS/api'
window.onload= function () {
        var scroll=document.getElementsByClassName("scroll")[0];//ie不兼容，换成id会成功
        var panel=document.getElementsByClassName("panel");//ie不兼容，换成id会成功

        var clientH=window.innerHeight;
        scroll.style.height=clientH+"px";
        for(var i=0;i<panel.length;i++){
            panel[i].style.height=clientH+"px";
        }
        /*下面是关于鼠标滚动*/
        var inputC=document.getElementsByTagName("input");
        var wheel= function (event) {
            var delta=0;
            if(!event)//for ie
                event=window.event;
            if(event.wheelDelta){//ie,opera
                delta=event.wheelDelta/120;
            }else if(event.detail){
                delta=-event.detail/3;
            }
            if(delta){
                handle(delta,inputC);
            }
           
            
             event.returnValue=false;

              
        };
 
        if(window.addEventListener){
            window.addEventListener('DOMMouseScroll',wheel,{ passive: false } );
         }
       
        window.onmousewheel=wheel;
    };
    function handle(delta,arr) {
        var num;
        for(var i=0;i<arr.length;i++){//得到当前checked元素的下标
            if(arr[i].checked){
                num=i;
            }
        }
        if(delta>0 && num>0){//向上滚动
            num--;
            arr[num].checked=true;
        }else if(delta<0 && num<2){//向下滚动
            num++;
            arr[num].checked=true;
        }
    }
export default {
    data(){
        return {
            recommendList:''
        }
    },
    methods:{
        login(){
            this.$router.push("/index")
        },
        async init(){         
            let data=await recommendApi.getAll();
            this.recommendList=data.data;
            console.log(this.recommendList)
        },
    },
    created(){
       this.init();
    },
    
}
</script>

<style scoped>
*{
    margin:0;
    padding:0;
}
html{
    touch-action: none;
}
:-webkit-any(article,aside,nav,section) h1 {
    font-size: 1.5em;
    margin-block-start: 0em;
    margin-block-end: 0em;
}
body{
    font-family:Georia,serif;
    background:#ddd;
    font-weight:bold;
    font-size:15px;
    color:#333;
    overflow: hidden;
    -webkit-font-smoothing:antialiased;
}
a{
    text-decoration:none;
    color:#555;
}
.clr{
    width:0;
    height:0;
    overflow: hidden;
    clear:both;
    padding:0;
    margin:0;
}
.nav{
    width:100%;
    position:absolute;
    left:0;
    bottom:0;
    font-family:"Josefin Slab","Myriad pro" ,serif;
}
.nav input,.nav a{
    width:30px;
    height:20%;
    line-height:30px;
    position:fixed;

    top:0;
    cursor:pointer;
}
.nav input{
    opacity:0;
    z-index:1000;
}
.nav a{
    z-index:10;
    font-weight:700;
    font-size:16px;
    background:#e23a6e;
    color:#fff;
    text-align:center;
    text-shadow: 1px 1px 1px rgba(151,24,64,0.2);
}
#nav1,#nav1 + a{
    left:0%;
}
#nav2,#nav2 + a{
    left:0%;
    top:20%;
}
#nav3,#nav3 + a{
    left:0%;
    top:40%;
}

.nav input:checked + a,
.nav input:checked:hover +a{
    background:#821134;
}
.nav input:checked + a:after{
    content:"";
    width:0;
    height:0;
    overflow:hidden;
    border:20px solid transparent;
    border-left-color:#821134;
    position:absolute;
    bottom:30%;
    left:100%;
    /* margin-left:20px; */
}
.nav input:hover + a{
    background:#AD244f;
}
.scroll,.panel{
    width:100%;
    height:100%;
    position:relative;
    text-align:center;
    padding-top:180px;
}
.scroll{
    left:0;
    top:0;
    -webkit-transform: translate3d(0, 0, 0);
    -moz-transform: translate3d(0, 0, 0);
    -ms-transform: translate3d(0, 0, 0);
    -o-transform: translate3d(0, 0, 0);
    transform: translate3d(0, 0, 0);
    -webkit-backface-visibility: hidden;
    -moz-backface-visibility: hidden;
    backface-visibility: hidden;
    -webkit-transition: all 0.6s ease-in-out;
    -moz-transition: all 0.6s ease-in-out;
    -o-transition: all 0.6s ease-in-out;
    transition: all 0.6s ease-in-out;
    color:#e23a6e;
    font-weight:bold;
}
.panel{
    background:#fff;
    overflow: hidden;
}
/*动画*/
#nav1:checked ~ .scroll #panel1 h1{
    -webkit-animation: moveDown 0.6s ease-in-out 0.2s backwards;
    -o-animation: moveDown 0.6s ease-in-out 0.2s backwards;
    animation: moveDown 0.6s ease-in-out 0.2s backwards;
}
#nav2:checked ~ .scroll #panel2 h1{
    -webkit-animation: moveDown 0.6s ease-in-out 0.2s backwards;
    -o-animation: moveDown 0.6s ease-in-out 0.2s backwards;
    animation: moveDown 0.6s ease-in-out 0.2s backwards;
}
#nav3:checked ~ .scroll #panel3 h1{
    -webkit-animation: moveDown 0.6s ease-in-out 0.2s backwards;
    -o-animation: moveDown 0.6s ease-in-out 0.2s backwards;
    animation: moveDown 0.6s ease-in-out 0.2s backwards;
}

@keyframes moveDown {
    0%{
        -webkit-transform: translateY(-40px);
        -moz-transform: translateY(-40px);
        -ms-transform: translateY(-40px);
        -o-transform: translateY(-40px);
        transform: translateY(-40px);
        opacity:0;
    }
    100%{
        -webkit-transform: translateY(0);
        -moz-transform: translateY(0);
        -ms-transform: translateY(0);
        -o-transform: translateY(0);
        transform: translateY(0);
        opacity:1;
    }
}
.panel p{
    color:#000;
    margin-top:20px;
}
#nav1:checked ~ .scroll{
     -webkit-transform: translateY(0%);
     -moz-transform: translateY(0%);
     -ms-transform: translateY(0%);
     -o-transform: translateY(0%);
     transform: translateY(0%);
 }
#nav2:checked ~ .scroll{
    -webkit-transform: translateY(-100%);
    -moz-transform: translateY(-100%);
    -ms-transform: translateY(-100%);
    -o-transform: translateY(-100%);
    transform: translateY(-100%);
}
#nav3:checked ~ .scroll{
    -webkit-transform: translateY(-200%);
    -moz-transform: translateY(-200%);
    -ms-transform: translateY(-200%);
    -o-transform: translateY(-200%);
    transform: translateY(-200%);
}

.icon{
    width:200px;
    height:200px;
    background:#fa96b5;
    -webkit-transform:translateY(-50%) rotate(45deg);
    -moz-transform:translateY(-50%) rotate(45deg);
    -ms-transform:translateY(-50%) rotate(45deg);
    -o-transform:translateY(-50%) rotate(45deg);
    transform:translateY(-50%) rotate(45deg);
    position:absolute;
    left:50%;
    top:0;
    margin-left:-100px;
}
[data-icon]:after{
    content:attr(data-icon);
    width:200px;
    height:200px;
    color:#fff;
    font-size:90px;
    text-align:center;
    line-height:200px;
    position:absolute;
    left:18%;
    top:18%;
    -webkit-transform: rotate(-45deg);
    -moz-transform: rotate(-45deg);
    -ms-transform: rotate(-45deg);
    -o-transform: rotate(-45deg);
    transform: rotate(-45deg);
}
.panelColor{
    background:#fa96b5;
    color:#fff;
}
.panelColor .icon{
    background:#fff;
    color:#fa96b5;
}
.panelColor .icon:after{
    color:#fa96b5;
}
.scroll .panel h1{
    font-size:60px;
}
@media screen and (max-device-width: 520px){

}
.nav input,.nav a{
    display: none;
}
.panel:last-child{
    width:100%;
    height:100%;
    position:relative;
    text-align:center;
    padding-top:0px;
}
.myImg{
    width:100%;
    height:100%;
    margin: auto;
    overflow: hidden;
    
}
div.imgT {
  
    width:20%;
    height:30%;
    background: #f3eaedad;
    position: relative;   
    bottom: 140%;
    right:-66%;
    border-radius: 50%;
    font-size: 3rem;
    padding-top: 10%;
    border:10px solid #fa96b5;
    
}
div.imgT:hover,
div.imgT:focus,
div.imgT:active{
    background:#fff;
}
.recommend{
    text-align: left;
    padding: 20px;
    
}
.recommend li{
    display: inline-block;
    width:48%;
    float: left;
    padding: 0px 5px;
    background: rgba(255, 255, 255, 0.233);
}
.recommend li:nth-child(odd){
    text-align: end;
    border-right:5px solid rgb(255, 0, 98,0.685);
    margin-right:10px;
}
.recommend li:nth-child(even){
    border-left:5px solid rgba(255, 0, 98, 0.685);
    margin-left:10px;
}
.recommend a{
   display: inline;
   width:auto;
   background:transparent;
   top:auto;
   position:relative;
}
.recommend a:hover{
    color:tomato;
}
.personImg{
    width:400px;
    height:530px;
    position: fixed;
    bottom: 0;
    right:0;
}
.personImg img{
    width:100%;
    height:100%;
}
</style>
