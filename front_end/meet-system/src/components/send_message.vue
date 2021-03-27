<template>
    <div id="send_message">
        <div id="message_part">
            <el-form label-position="right" label-width="150px">
                <el-form-item label="题目:" required="“true”">
                    <el-input
                        class="title"
                        v-model="title"
                        placeholder="请输入题目"
                        clearable
                    ></el-input>
                </el-form-item>
                <el-form-item label="发布到:" required="“true”">
                    <el-select v-model="forum" placeholder="请选择">
                        <el-option
                            v-for="item in options"
                            :key="item.value"
                            :label="item.label"
                            :value="item.value"
                        >
                        </el-option>
                    </el-select>
                </el-form-item>

                <el-form-item label="发布内容:" required="“true”">
                    <el-input
                        type="textarea"
                        :autosize="{ minRows: 10, maxRows: 8 }"
                        placeholder="请输入内容"
                        v-model="detail"
                        clearable
                    >
                    </el-input>
                </el-form-item>
                <el-form-item label="发布日期:" required="“true”">
                    <el-date-picker
                        v-model="date"
                        type="date"
                        placeholder="选择日期"
                    >
                    </el-date-picker>
                </el-form-item>
            </el-form>
            <el-button type="primary" @click="go_forum">立即发布</el-button>
        </div>
    </div>
</template>

<script>
export default {
    data() {
        return {
            title: "",
            forum: "",
            options: [
                {
                    value: "选项1",
                    label: "黄金糕",
                },
                {
                    value: "选项2",
                    label: "双皮奶",
                },
                {
                    value: "选项3",
                    label: "蚵仔煎",
                },
                {
                    value: "选项4",
                    label: "龙须面",
                },
                {
                    value: "选项5",
                    label: "北京烤鸭",
                },
            ],
            detail: "",
            date: "",
        };
    },

    created() {
        //加载是向后端发送请求获取数据
        this.$axios({
            method: "get",
            url: "",
        }).then((re) => {
            console.log(re);
        });
    },

    methods: {
        go_forum() {
            if (!this.title) {
                this.$notify({
                    title: "警告",
                    message: "请输入题目",
                    type: "warning",
                    showClose: false,
                });
                return;
            }

            if (!this.forum) {
                this.$notify({
                    title: "警告",
                    message: "请选择论坛",
                    type: "warning",
                    showClose: false,
                });
                return;
            }

            if (!this.detail) {
                this.$notify({
                    title: "警告",
                    message: "请输入内容",
                    type: "warning",
                    showClose: false,
                });
                return;
            }

            if (!this.date) {
                this.$notify({
                    title: "警告",
                    message: "请选择发布日期",
                    type: "warning",
                    showClose: false,
                });
                return;
            }

            let data = {
                title: this.title, //后端关联表格（表头：变量名）
            };

            this.$axios({
                //传数据给后端
                method: "post",
                url: "",
                data: data,
            }).then((re) => {
                console.log(re);
                this.$router.push({ name: "forum" });
            });
        },
    },
};
</script>

<style scoped>
#send_message {
    /* border: 1px red solid;
    box-sizing: border-box; */
    width: 83%;
    height: 100%;
    background-color: #edf0f7;
}

#message_part {
    width: 80%;
    height: 80%;
    /* border: 1px red solid;
    box-sizing: border-box; */
    margin: 0% 10%;
    font-weight: bold;
}

.title {
    width: 50%;
    margin: 0;
}

.el-button {
    border-radius: 10px;
    text-align: center;
    margin-left: 18%;
}

.el-form-item {
    margin: 3%;
}
</style>

<style>
.el-textarea__inner {
    resize: none;
    width: 50%;
    margin: 0% 0;
    font-size: 18px;
    border-radius: 10px;
}

.el-form-item__label {
    font-size: 18px;
    color: #033;
}

.el-input__inner {
    font-size: 16px;
    border-radius: 10px;
}
</style>