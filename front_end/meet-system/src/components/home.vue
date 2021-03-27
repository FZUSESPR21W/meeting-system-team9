<template>
    <div id="home">
        <div id="tabbar">
            <template v-if="isLogin">
                <div>
                    欢迎你, {{ user_name }}!
                    <span id="logout" @click="go_logout">
                        &nbsp;&nbsp;(注销)
                    </span>
                </div>
            </template>
            <template v-else>
                <div id="login" @click="go_login">登陆 / 注册</div>
            </template>
        </div>
        <div id="content">
            <div id="sidebar">
                <div
                    class="sidebar_item"
                    :class="{ is_show: isMeeting }"
                    @click="go_meeting"
                >
                    <i class="icon el-icon-suitcase"></i>
                    会议信息
                </div>
                <div
                    class="sidebar_item"
                    :class="{ is_show: isForum }"
                    @click="go_forum"
                >
                    <i class="icon el-icon-place"></i>
                    论坛信息
                </div>
                <div
                    class="sidebar_item"
                    :class="{ is_show: isInfo }"
                    @click="go_person_info"
                >
                    <i class="icon el-icon-user"></i>
                    参会人员
                </div>
                <div
                    class="sidebar_item"
                    :class="{ is_show: isMessage }"
                    @click="go_send_message"
                >
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
            user_name: "",
            isMeeting: true,
            isForum: false,
            isInfo: false,
            isMessage: false,
        };
    },

    created() {
        let id = localStorage.getItem("id");
        if (id != null) {
            this.isLogin = true;
            this.user_name = localStorage.getItem("username");
        }
    },

    watch: {
        $route: {
            handler(newValue) {
                let path = newValue.name;
                this.isMeeting = false;
                this.isForum = false;
                this.isInfo = false;
                this.isMessage = false;

                if (path == "meeting") {
                    this.isMeeting = true;
                } else if (path == "forum") {
                    this.isForum = true;
                } else if (path == "person_info") {
                    this.isInfo = true;
                } else if (path == "send_message") {
                    this.isMessage = true;
                }
            },

            immediate: true,
        },
    },

    methods: {
        tipInfo(info, type) {
            this.$message({
                message: info,
                type: type,
            });
        },

        go_login() {
            this.$router.push({ name: "login" });
        },

        go_logout() {
            localStorage.removeItem("id");
            this.$router.go(0);
        },

        go_meeting() {
            this.$router.push({ name: "meeting" });
        },

        go_forum() {
            this.$router.push({ name: "forum" });
        },

        go_person_info() {
            if (
                localStorage.getItem("role") != "秘书" &&
                localStorage.getItem("role") != "主席"
            ) {
                this.tipInfo("权限不足", "warning");
                return;
            }
            this.$router.push({ name: "person_info" });
        },

        go_send_message() {
            if (
                localStorage.getItem("role") != "秘书" &&
                localStorage.getItem("role") != "分论坛主席"
            ) {
                this.tipInfo("权限不足", "warning");
                return;
            }
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
    height: 10%;
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
    height: 90%;
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
    margin-right: 5%;
}

.is_show,
.sidebar_item:hover {
    cursor: pointer;
    background-color: #409eff;
    color: #fff;
}
</style>