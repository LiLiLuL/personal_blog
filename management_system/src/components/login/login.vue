<template>
<div>
<div class="login">
   
    <div class="login-form">
        <img src=""/>
            <el-form :model="ruleForm"  :rules="rules" ref="ruleForm" label-width="80px" >
                <el-form-item label="用户名" prop="username">
                    <el-input v-model="ruleForm.username"></el-input>
                </el-form-item>
                <el-form-item label="密码" prop="password">
                    <el-input type="password" v-model="ruleForm.password"></el-input>
                </el-form-item>
                <el-form-item >
                   <el-button type="primary" @click="submitForm('ruleForm')">登录 </el-button>
                   <el-button  @click="resetForm('ruleForm')">重置</el-button>
                   <!-- <span v-on:click="forgetPassword">
                       <router-link to="/forgetpass">忘记密码？</router-link>
                   </span> -->
                </el-form-item>
            </el-form>

        
        
    </div>
</div>
    <p class="copyright">	&copy;Chenxq,2019</p>
</div>

</template>

<script>
import {loginApi}  from "../../apiJS/api"
import {mapState,mapGetters,mapActions} from 'vuex';
export default {
     data() {
      return {
        tabname:'login',
        ruleForm: {
          username: '',
          password: '',
        },
        rules:{
        username: [
            { required: true, message: '请输入用户名', trigger: 'blur' },
            { min: 3, max: 16, message: '长度在 3 到 16个字符', trigger: 'blur' }
          ],
          password: [
            { required: true, message: '请输入密码', trigger: 'blur' },
            { min: 6, max: 20, message: '长度在 6 到 20个字符', trigger: 'blur' }
          ],
        }
      };
    },
    computed:{
        ...mapState({
            isLogin:state=>state.login.isLogin
        }),

    },
    methods:{
        ...mapActions('login',[
            'USERISLOGIN','USERNOLOGIN'
        ]),
        handleClick(tab,event){

        },
        submitForm(formName){

             this.$refs[formName].validate((valid) => {
                if (valid) {
                   loginApi.login(this.ruleForm).then(res => {
                       let data=res.data;
                       console.log(data);
                       console.log(this.ruleForm);
                        //账号不存在
                        if (data.code == 302) {
                            this.$message({
                            type: 'info',
                            message: '账号不存在'
                            });
                            return;
                        }
                        //账号存在
                        else if(data.code===1) {
                            this.$message({
                            type: 'success',
                            message: '登录成功'
                            });
                            // //拿到返回的token和username，并存到store
                            // let token = data.token;
                            let username = this.ruleForm.username;
                            // this.$store.dispatch('UserLogin', token);
                            // this.$store.dispatch('UserName', username);
                            this.USERISLOGIN();
                            // //存对象
                            // // localStorage.setItem('hou', JSON.stringify(info));
                            // //存字符串
                            localStorage.setItem('name',username );
                            localStorage.setItem('isLogin',this.isLogin);
                            // //跳到目标页
                                this.$router.push('category');
                        }
                else{
                   this.$message({
                    type: 'error',
                    message: '账号或密码错误'
                    }); 
                }
                });
                }
             })
        },
        forgetPassword(){},
        resetForm(formName) {
            
            this.$refs[formName].resetFields();
            console.log(formName);
        }




    },
    created(){
        console.log(this.isLogin);
    }
}
</script>


<style scoped>
body{
    background: rgb(236, 227, 227);
}
.login{
    position: absolute;
    height: 500px;
    background: beige;
    width: 80%;
    left: 10%;
    top: 14%;
    display: flex;
    align-items: center;
    justify-content: center;
    align-content: space-between;
    background-image: url("../../assets/images/login.jpg");
    background-repeat: no-repeat;
    background-size: 100%;
}
.login-form{
    width:400px;
}
.copyright{
    position:absolute;
    bottom: 10%;
    left: 10%;
}

</style>


