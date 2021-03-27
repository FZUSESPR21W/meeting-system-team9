<template>
    <div id="meeting">
        <div id="meeting_items">
            <div class="meeting_item" id="meeting_name">
                <div>
                    <div class="title">会议名</div>
                    <div class="content" :title="title">{{ title }}</div>
                </div>
            </div>
            <div class="meeting_item" id="meeting_time">
                <div>
                    <div class="title">会议时间</div>
                    <div class="content">{{ time }}</div>
                </div>
            </div>
            <div
                class="meeting_item"
                id="meeting_num"
                v-loading="!isPower"
                element-loading-spinner="el-icon-warning-outline"
                element-loading-text="抱歉, 权限不足!"
                element-loading-background="#fff"
            >
                <div>
                    <div class="title">会议人数</div>
                    <div class="content">{{ num }}</div>
                </div>
            </div>
        </div>

        <div id="meeting_detail">
            <div id="meeting_process">
                <div>
                    <div class="schema">会议主题:</div>
                    <div class="detail">{{ schema }}</div>
                </div>
                <div>
                    <div class="schema">会议议程:</div>
                    <div class="detail">{{ detail }}</div>
                </div>
            </div>
            <div id="meeting_chart">
                <el-table
                    :data="forum_list"
                    border
                    height="100%"
                    v-loading="!isPower"
                    element-loading-spinner="el-icon-warning-outline"
                    element-loading-text="抱歉, 权限不足!"
                    element-loading-background="#fff"
                >
                    <el-table-column prop="name" label="论坛名">
                    </el-table-column>
                    <el-table-column prop="count" label="论坛人数">
                    </el-table-column>
                </el-table>
            </div>
        </div>
    </div>
</template>

<script>
export default {
    name: "Meeting",

    data() {
        return {
            isPower: false,
            title: "",
            num: 0,
            time: "",
            schema: "",
            detail: "",
            forum_list: [],
        };
    },

    created() {
        if(localStorage.getItem("role") == "用户") {
            this.isPower = false;
        } else {
            this.isPower = true;
        }

        this.$axios({
            method: "get",
            url: "/meeting",
        }).then((res) => {
            this.title = res.data.data.title,
            this.num = res.data.data.num,
            this.time = res.data.data.time,
            this.schema = res.data.data.name,
            this.detail = res.data.data.agenda,
            this.forum_list = res.data.data.list,
            console.log(res);
            // 获取会议相关信息
            // 判断权限
        });
    },
};
</script>

<style scoped>
#meeting {
    /* border: 1px red solid;
    box-sizing: border-box; */
    width: 83%;
    height: 100%;
    background-color: #edf0f7;
}

#meeting_items {
    /* border: 1px red solid;
    box-sizing: border-box; */
    height: 30%;
    margin: 2% 0;
    display: flex;
    justify-content: center;
}

.meeting_item {
    /* border: 1px red solid;
    box-sizing: border-box; */
    display: flex;
    justify-content: center;
    align-items: center;
    border-radius: 20px;
    width: 30%;
    margin: 0 1%;
    color: #fff;
}

.meeting_item > div {
    /* border: 1px white solid;
    box-sizing: border-box; */
    width: 60%;
    height: 50%;
}

.title {
    font-size: 18px;
    padding-bottom: 5%;
    border-bottom: 1px rgba(255, 255, 255, 0.5) solid;
}

.content {
    margin-top: 5%;
    font-size: 24px;
    font-weight: bold;
    white-space: nowrap;
    overflow: hidden;
    text-overflow: ellipsis;
}

#meeting_name {
    background-image: linear-gradient(to bottom right, #fc7b5f, #fcccb2);
    /* background-color: #fc7b5f; */
}

#meeting_num {
    background-image: linear-gradient(to bottom right, #398af1, #81d4fd);
    /* background-color: #398af1; */
}

#meeting_time {
    background-image: linear-gradient(to bottom right, #a170f1, #dfbafa);
    /* background-color: #a170f1; */
}

#meeting_detail {
    /* border: 1px red solid;
    box-sizing: border-box; */
    height: 55%;
    display: flex;
    justify-content: center;
}

#meeting_detail > div {
    margin: 0 2%;
}

#meeting_process {
    /* border: 1px red solid;
    box-sizing: border-box; */
    width: 45%;
    border-radius: 20px;
    background-image: linear-gradient(to bottom right, #40403a, #717375);
    color: #fff;
}

.schema {
    font-size: 18px;
    font-weight: bold;
    margin-top: 4%;
    margin-left: 5%;
}

.detail {
    margin-top: 2%;
    margin-left: 10%;
    margin-bottom: 5%;
    white-space: inherit;
    word-break: break-all;
    width: 80%;
    max-height: 110px;
    overflow: auto;
}

#meeting_chart {
    /* border: 1px red solid;
    box-sizing: border-box; */
    width: 45%;
}

.el-table {
    width: 100%;
    max-height: 100%;
    overflow: auto;
}
</style>