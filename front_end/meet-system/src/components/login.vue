<template>
    <div id="login">
        <div class="contain">
			<div class="big-box" :class="{active:isLogin}">
				<div class="big-contain" v-if="isLogin">
					<div class="btitle">账户登录</div>
					<div class="bform">
						<el-input
                            placeholder="请输入账号"
                            v-model="username"
                            clearable>
                        </el-input>
						<el-input placeholder="请输入密码" v-model="password" show-password></el-input>
					</div>
					<button class="bbutton" @click="login">登录</button>
				</div>
				<div class="big-contain" v-else>
					<div class="btitle">创建账户</div>
					<div class="bform">
						<el-input
                            placeholder="请输入账号"
                            v-model="username"
                            clearable>
                        </el-input>
						<el-input placeholder="请输入密码" v-model="password" show-password></el-input>
                        <el-select v-model="forumsValue" multiple placeholder="请选择感兴趣论坛">
                            <el-option
                                v-for="item in forums"
                                :key="item.id"
                                :label="item.name"
                                :value="item.id">
                            </el-option>
                        </el-select>
					</div>
					<button class="bbutton" @click="register">注册</button>
				</div>
			</div>
			<div class="small-box" :class="{active:isLogin}">
				<div class="small-contain" v-if="isLogin">
					<div class="stitle">你好，朋友!</div>
					<p class="scontent">开始注册，和我们一起旅行</p>
					<button class="sbutton" @click="changeType">注册</button>
				</div>
				<div class="small-contain" v-else>
					<div class="stitle">欢迎回来!</div>
					<p class="scontent">与我们保持联系，请登录你的账户</p>
					<button class="sbutton" @click="changeType">登录</button>
				</div>
			</div>
		</div>
    </div>
</template>

<script>
export default {
    name: "Login",

    data() {
        return {
            isLogin: true,
            emailError: false,
            passwordError: false,
            existed: false,
            username: '',
            password: '',
            forums: [{
                id: '1',
                name: '论坛1'
            }, {
                id: '2',
                name: '论坛2'
            }, {
                id: '3',
                name: '论坛3'
            }, {
                id: '4',
                name: '论坛4'
            }, {
                id: '5',
                name: '论坛5'
            }],
            forumsValue: [],
        }
    },
    created() {
        this.getForums()
    },
    methods: {
        getForums() {
            this.$axios({
                method:'get',
                url: '',
            })
            .then(res => {
                if (res.code == 200) {
                    this.forums = res.data;
                } else {
                    this.tipInfo('好像哪里出了点问题','error');
                }
            })
            .catch( err => {
                console.log(err);
                this.tipInfo('好像哪里出了点问题','error');
            }) 
        },

        tipInfo(info, type) {
            this.$message({
                message: info,
                type: type
            });
        },
        
        changeType() {
            this.isLogin = !this.isLogin
            this.username = ''
            this.password = ''
        },
        login() {
            if (this.username.trim() == "" || this.password.trim() == "") {
                this.tipInfo('用户名或密码不能为空！','error');
            }
            this.$axios({
                method:'post',
                url: '',
                data: {
                    username: this.username, 
                    password: this.password,
                }
            })
            .then(res => {
                if (res.code == 200) {
                    localStorage.setItem('id', res.id);
                    localStorage.setItem('username', res.username)
                    localStorage.setItem('role', res.role);
                    this.tipInfo('登陆成功！','success');
                    setTimeout(() => {
                        this.$router.push({name: 'meeting'});
                    },2000);
                } else {
                    this.tipInfo('用户名密码错误！','error');
                }
            })
            .catch( err => {
                console.log(err);
            })
            
        },
        register(){
            console.log('我是注册');
            if (this.username.trim() == "" || this.password.trim() == "") {
                this.tipInfo('用户名或密码不能为空！','error');
            }
            console.log(this.forumsValue);
            
            this.$axios({
                method:'post',
                url: '',
                data: {
                    username: this.username, 
                    password: this.password,
                    forums: this.forumsValue
                }
            })
            .then(res => {
                if (res.code == 200) {
                    localStorage.setItem('id', res.id);
                    localStorage.setItem('username', res.username)
                    localStorage.setItem('role', res.role);
                    this.tipInfo('注册成功！','success');
                    setTimeout(() => {
                        this.$router.push({name: 'meeting'});
                    },2000);
                } else {
                    this.tipInfo('注册失败（可能原因：用户名已被占用）','error');
                }
            })
            .catch( err => {
                console.log(err);
            })
        }
    },
};
</script>


<style scoped>

.bform >>> .el-input__inner {
     margin-bottom: 1em; 
}

.bform >>> .el-input__icon {
    position: relative;
    top: -0.5em;
}

.bform >>> .el-select__tags {
   transform: translateY(-70%);
}

#login {
    width: 100vw;
    height: 100vh;
    box-sizing: border-box;
}

.contain {
    width: 60%;
    height: 60%;
    position: relative;
    top: 50%;
    left: 50%;
    transform: translate(-50%,-50%);
    background-color: #fff;
    border-radius: 20px;
    box-shadow: 0 0 3px #f0f0f0,
                0 0 6px #f0f0f0;
}

.big-box {
    width: 70%;
    height: 100%;
    position: absolute;
    top: 0;
    left: 30%;
    transform: translateX(0%);
    transition: all 1s;
}

.big-contain {
    width: 100%;
    height: 100%;
    display: flex;
    flex-direction: column;
    justify-content: center;
    align-items: center;
}

.btitle{
    font-size: 1.5em;
    font-weight: bold;
    margin-bottom: 10px;
    color: rgb(64,158,255);
}

.bform{
    width: 70%;
    height: 40%;
    padding: 2em 2em;
    display: flex;
    flex-direction: column;
    justify-content: space-around;
    box-sizing: border-box;
}

.bform input{
    width: 50%;
    height: 30px;
    border: none;
    outline: none;
    border-radius: 10px;
    padding-left: 2em;
    background-color: #f0f0f0;
}

.bbutton{
    width: 20%;
    height: 40px;
    border-radius: 24px;
    border: none;
    outline: none;
    background-color: rgb(64,158,255);
    color: #fff;
    font-size: 0.9em;
    cursor: pointer;
}

.small-box{
    width: 30%;
    height: 100%;
    background: linear-gradient(135deg,rgb(64,158,255),rgb(140,197,255));
    position: absolute;
    top: 0;
    left: 0;
    transform: translateX(0%);
    transition: all 1s;
    border-top-left-radius: inherit;
    border-bottom-left-radius: inherit;
}

.small-contain{
    width: 100%;
    height: 100%;
    display: flex;
    flex-direction: column;
    justify-content: center;
    align-items: center;
}

.stitle{
    font-size: 1.5em;
    font-weight: bold;
    color: #fff;
}

.scontent{
    font-size: 0.8em;
    color: #fff;
    text-align: center;
    padding: 2em 4em;
    line-height: 1.7em;
}

.sbutton{
    width: 60%;
    height: 40px;
    border-radius: 24px;
    border: 1px solid #fff;
    outline: none;
    background-color: transparent;
    color: #fff;
    font-size: 0.9em;
    cursor: pointer;
}

.big-box.active{
    left: 0;
    transition: all 0.5s;
}

.small-box.active{
    left: 100%;
    border-top-left-radius: 0;
    border-bottom-left-radius: 0;
    border-top-right-radius: inherit;
    border-bottom-right-radius: inherit;
    transform: translateX(-100%);
    transition: all 1s;
}
</style>