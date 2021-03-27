<template>
    <div id="home">
        <div id="tabbar">
            <template v-if="isLogin">
                <div>
                    欢迎你, {{ user_name }}!
                    <span id="logout">&nbsp;&nbsp;(注销)</span>
                </div>
            </template>
            <template v-else>
                <div id="login" @click="go_login()">登陆 / 注册</div>
            </template>
        </div>
        <div id="content">
            <div id="sidebar">
                <div class="sidebar_item" @click="go_meeting">
                    <i class="icon el-icon-suitcase"></i>
                    会议信息
                </div>
                <div class="sidebar_item" @click="go_forum">
                    <i class="icon el-icon-place"></i>
                    论坛信息
                </div>
                <div class="sidebar_item" @click="go_person_info">
                    <i class="icon el-icon-user"></i>
                    参会人员
                </div>
                <div class="sidebar_item" @click="go_send_message">
                    <i class="icon el-icon-s-promotion"></i>
                    发布信息
                </div>
            </div>

            <router-view></router-view>
        </div>
    </div>
</template>

<script>
export default {
    name: "Home",

    data() {
        return {
            isLogin: false,
            user_name: "2333",
        };
    },

    created() {
        // 获取是否注册信息
    },

    methods: {
        go_login() {
            this.$router.push({ name: "login" });
        },

        go_meeting() {
            this.$router.push({ name: "meeting" });
        },

        go_forum() {
            this.$router.push({ name: "forum" });
        },

        go_person_info() {
            this.$router.push({ name: "person_info" });
        },

        go_send_message() {
            this.$router.push({ name: "send_message" });
        },
    },
};
</script>

<style scoped>
#home {
    /* border: 1px red solid;
    box-sizing: border-box; */
    height: 100%;
    width: 100%;
}

#tabbar {
    /* border: 1px red solid;
    box-sizing: border-box; */
    height: 7%;
    display: flex;
    justify-content: flex-end;
    align-items: center;
}

#tabbar > div {
    /* border: 1px red solid;
    box-sizing: border-box; */
    margin-right: 7%;
    font-size: 16px;
}

#logout {
    letter-spacing: 2px;
}

#login:hover,
#logout:hover {
    cursor: pointer;
    color: #409eff;
}

#content {
    /* border: 1px red solid;
    box-sizing: border-box; */
    height: 93%;
    display: flex;
}

#sidebar {
    /* border: 1px red solid;
    box-sizing: border-box; */
    height: 100%;
    width: 17%;
    box-shadow: 5px 0 10px #d7d9dd;
    z-index: 999;
}

.sidebar_item {
    /* border: 1px blue solid;
    box-sizing: border-box; */
    padding: 10% 0;
    text-align: center;
}

.icon {
    margin-right: 2%;
}

.sidebar_item:hover {
    cursor: pointer;
    background-color: #409eff;
    color: #fff;
}
</style>