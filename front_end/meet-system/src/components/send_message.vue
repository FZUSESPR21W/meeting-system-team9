<template>
    <div id="send_message">
        <div id="message_part">
            <el-form label-position="right" label-width="100px">
                <el-form-item label="题目:">
                    <el-input
                        class="title"
                        v-model="title"
                        placeholder="请输入题目"
                        clearable
                    ></el-input>
                </el-form-item>
                <el-form-item label="发布到:">
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

                <el-form-item label="发布内容:">
                    <el-input
                        type="textarea"
                        :autosize="{ minRows: 10, maxRows: 8 }"
                        placeholder="请输入内容"
                        v-model="detail"
                        clearable
                    >
                    </el-input>
                </el-form-item>
                <el-form-item label="发布日期:">
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
    name: "Send_message",

    data() {
        return {
            title: "",
            forum: "",
            detail: "",
            date: "",
        };
    },

    methods: {
        go_forum() {
            this.$router.push({ name: "forum" });
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
    margin: 5% 13%;
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