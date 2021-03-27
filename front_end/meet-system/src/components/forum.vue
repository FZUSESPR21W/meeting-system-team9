<template>
    <div id="forum">
        <div class="card1">
            <el-card class="box-card1">
                <div slot="header" class="clearfix">
                <span>论坛名</span>
                <el-button style="float: right; padding: 3px 0" type="text">进入</el-button>
                </div>
                <div class="text item">
                {{'巴拉巴拉' }}
                </div>
            </el-card>
            <el-card class="box-card1">
                <div slot="header" class="clearfix">
                <span>论坛时间、议题</span>
                <el-button style="float: right; padding: 3px 0" type="text">进入</el-button>
                </div>
                <div class="text item">
                {{'巴拉巴拉' }}
                </div>
            </el-card>
            <el-card class="box-card1">
                <div slot="header" class="clearfix">
                <span>分论坛主名、参与人数</span>
                <el-button style="float: right; padding: 3px 0" type="text">进入</el-button>
                </div>
                <div class="text item">
                {{'巴拉巴拉' }}
                </div>
            </el-card>
        </div>



    <div class="selectanddropdown">
      <div class="dropdown">
          <el-dropdown>
          <span class="el-dropdown-link">
            下拉菜单<i class="el-icon-arrow-down el-icon--right"></i>
          </span>
          <el-dropdown-menu slot="dropdown">
            <el-dropdown-item>巴拉巴拉下拉框</el-dropdown-item>
          </el-dropdown-menu>
        </el-dropdown>
      </div>
      <div class="input">
        <el-input v-model="input" placeholder="请输入内容"></el-input>
      </div>
    </div>




    <div class="cards">
      <el-card class="box-card" v-for="o in 10" :key="o" >
        <div  class="text1 item1" >
          {{'id:' }}
        </div>
        <div  class="text1 item1">
          {{'发布者id:' }}
        </div>
        <div  class="text1 item1">
          {{'发布论坛id:' }}
        </div>
        <div  class="text1 item1">
          {{'内容:' }}
        </div>
        <div  class="text1 item1">
          {{'发布时间:' }}
        </div>
      </el-card>
    </div>

    </div>
    <!-- 论坛页面 -->

</template>

<script>
export default {
    name: "Forum",

    data() {
        return {};
    },

    methods: {},
};
</script>

<style scoped>
#forum {
 /* border: 1px red solid;
    box-sizing: border-box; */
    width: 83%;
    height: 100%;
    background-color: #edf0f7;
    overflow: scroll;
}
.text1 {
   display: inline-block;
   font-size: 14px;
 }
.text {
  font-size: 14px;
}

.item {
  padding: 18px 0;
}
.item1 {
  padding: 18px 0;
  margin-left: 100px;
}

.box-card {
  width: 950px;
  height: 100px;
  margin: 5px;
  margin-left: 140px;
  margin-top: 20px;
}
.box-card1 {
  display: inline-block;
  margin-left: 80px;
  margin-top: 10px;
  width: 300px;
  float: left;
  height: 150px;
}
.selectanddropdown{
  width: 1400px;
  height: 50px;
  margin: 5px;
  margin-left: 100px;
  position: relative;
  top: 50px;
  right: 1000px;
}
.cards{
  position: relative;
  top: 40px;
}
.card1{
    height: 150px;
}
.el-dropdown-link {
  cursor: pointer;
  color: #409EFF;
}
.el-icon-arrow-down {
  font-size: 12px;
}
.dropdown{
  display: inline-block;
  width: 100px;
}
.input{
  display: inline-block;
  width: 200px;
}
</style>