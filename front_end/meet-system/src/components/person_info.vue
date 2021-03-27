<template>
    <div id="person_info">
        <div class="header">
            <i class="el-icon-info"></i>
            <span>会议信息</span>
        </div>
        <div class="choose">
            <div class="choose-select">
                <el-select :inline="true" v-model="forumsValue" clearable placeholder="请选择" @change="getTableByForum">
                    <el-option
                        v-for="item in forums"
                        :key="item.id"
                        :label="item.name"
                        :value="item.name">
                    </el-option>
                </el-select>
            </div>
            <div class="choose-search">
                <el-input
                    :inline="true"
                    placeholder="请输入内容"
                    v-model="searchInfo"
                    clearable>
                </el-input> 
            </div>
            <div class="choose-button">
                <el-button type="primary" icon="el-icon-search" circle></el-button>
            </div>
        </div>
        <div class="person-table">
            <el-table
                :data="tableData"
                border
                max-height="450"
                style="width: 100%">
                <el-table-column
                    prop="id"
                    label="id"
                    width="180">
                </el-table-column>
                <el-table-column
                    prop="username"
                    label="用户名"
                    width="180">
                </el-table-column>
                <el-table-column
                    prop="forum"
                    label="参与论坛">
                </el-table-column>
            </el-table>
        </div>
    </div>
    <!-- 论坛页面 -->
</template>

<script>
export default {
    name: "Person_info",

    data() {
        return {
            searchInfo: '',
            //选择框
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
            //表格
            tableData: [{
                id: '1',
                username: '蔡家鑫',
                forum: '论坛1，论坛2，论坛3'
                }, {
                id: '1',
                username: '蔡家鑫',
                forum: '论坛1，论坛2，论坛3'
                }, {
                id: '1',
                username: '蔡家鑫',
                forum: '论坛1，论坛2，论坛3'
                }, {
                id: '1',
                username: '蔡家鑫',
                forum: '论坛1，论坛2，论坛3'
                }, {
                id: '1',
                username: '蔡家鑫',
                forum: '论坛1，论坛2，论坛3'
                }, {
                id: '1',
                username: '蔡家鑫',
                forum: '论坛1，论坛2，论坛3'
                }, {
                id: '1',
                username: '蔡家鑫',
                forum: '论坛1，论坛2，论坛3'
                }, {
                id: '1',
                username: '蔡家鑫',
                forum: '论坛1，论坛2，论坛3'
                },{
                id: '1',
                username: '蔡家鑫',
                forum: '论坛1，论坛2，论坛3'
                }, {
                id: '1',
                username: '蔡家鑫',
                forum: '论坛1，论坛2，论坛3'
            }]
        };
    },

    created() {

    },

    methods: {
        getTableByForum(val="") {
            if (val.trim() ==  "") {
                console.log('获取全部');
            } else {
                console.log('单个'+val);
            }
        }
    },
};
</script>

<style scoped>
#person_info {
    box-sizing: border-box;
    padding: 3em;
    width: 83%;
    height: 100%;
    background-color: #edf0f7;
    overflow: scroll;
}

.header i {
    color: rgb(64,158,255);
    margin-right: .4em;
}

.header {
    font-size: 1.2em;
    font-weight: bold;
    margin-bottom: 1em;
}

.choose {
    display: flex;
}

.choose div {
    margin-right: 1em;
}

.choose-search >>> .el-input__inner {
    width: 100%;
}

.person-table {
    margin-top: 2em;
}
</style>