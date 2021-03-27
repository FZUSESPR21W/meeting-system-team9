<template>
    <div id="forum">
        <div class="card1">
            <el-card class="box-card1" shadow="hover" style="background-image: linear-gradient(to bottom right, #fc7b5f, #fcccb2);">
                <div slot="header" class="clearfix">
                <span style="color:white">论坛名</span>
                </div>
                <div class="text item">
                {{'巴拉巴拉' }}
                </div> 
            </el-card>
            <el-card class="box-card1" shadow="hover" style="background-image: linear-gradient(to bottom right, #a170f1, #dfbafa);">
                <div slot="header" class="clearfix">
                <span style="color:white">分论坛主席名</span>
                </div>
                <div class="text item">
                {{'巴拉巴拉' }}
                </div>
            </el-card>
            <el-card class="box-card1" shadow="hover" style="background-image: linear-gradient(to bottom right, #398af1, #81d4fd);">
                <div slot="header" class="clearfix">
                <span style="color:white">参与人数</span>
                </div>
                <div class="text item">
                {{'巴拉巴拉' }}
                </div>
            </el-card>
        </div>



    <div class="selectanddropdown">
      <div class="dropdown">
            <el-select v-model="value" clearable placeholder="请选择" id="dropdown1" @change="show_change">
                <el-option
                v-for="item in options"
                :key="item.id"
                :label="item.name"
                :value="item.id">
                </el-option>
            </el-select>
      </div>
      <div class="input">
        <el-input v-model="search" placeholder="请输入内容" id="input"></el-input>
      </div>
      <div class="search"><el-button icon="el-icon-search" circle @click="btnsearch"></el-button></div>
    </div>




    <div class="cards">
      <el-card class="box-card" v-for="itemcard in totalinfo" :key="itemcard" shadow="hover">
        <div  class="text1 item1" >
          {{'id:' +itemcard.id}}
        </div>
        <div  class="text1 item1">
          {{'发布者id:' +itemcard.id2}}
        </div>
        <div  class="text1 item1" v-show="hidden">
          {{'发布论坛id:' +itemcard.id3}}
        </div>
        <div  class="text1 item1">
          {{'内容:' +itemcard.content}}
        </div>
        <div  class="text1 item1">
          {{'发布时间:' +itemcard.publishtime}}
        </div>
      </el-card>
    </div>

    </div>
    <!-- 论坛页面 -->

</template>

<script>
export default {
    created () {
        this.showinfo();
        this.creatselect();
    },
    name: "Forum",

    data() {
        return {
            search: '',
            hidden: true,
            input: '',
            options: [
                {
                    id: "1",
                    name: "论坛1",
                },
                {
                    id: "2",
                    name: "论坛2",
                },
                {
                    id: "3",
                    name: "论坛3",
                },
                {
                    id: "4",
                    name: "论坛4",
                },
                {
                    id: "5",
                    name: "论坛5",
                },],
            value: '',
            totalinfo:[
                {
                    id: '1',
                    id2: '2',
                    id3: '3',
                    content: 'bala bala',
                    publishtime: '3.11'
                },{
                    id: '2',
                    id2: '2',
                    id3: '3',
                    content: 'bala bala',
                    publishtime: '3.11'
                },{
                    id: '3',
                    id2: '2',
                    id3: '3',
                    content: 'bala bala',
                    publishtime: '3.11'
                }
                

            ],
        };
    },

    methods: {
    //     totalinfo(search){
    // 	// 我这里直接return（也可赋给变量return变量出去）
    //     return this.totalinfo.filter(itemcard => {
    //     	// 如果list(name)包含key(输入框) => true
    //         if(itemcard.name.includes(key)){
    //         	// 返回item
    //             return item;
    //        }
    //    })
    // },

        show_change(id){//根据下拉框选择的信息来更新totalinfo
            this.$axios({
                method: 'post',
                url: '...',
                data:{
                    forum: id,
                }
            }).then((res)=>{
                this.totalinfo = res;
            })
        },
        btnsearch(){
            this.$axios({//根据搜索的信息来更新totalinfo
                method: 'post',
                url: '...',
                data:{
                    searchitem: document.getElementById('input').value,
                }
            }).then((res)=>{
                this.totalinfo = res;
            })
        },
        showinfo(){//一开始showinfo全部的信息
            
        },
        creatselect(){
            console.log('更新下拉框');
            this.$axios.get('/sssss').then((res)=>{
                this.options = {};
                this.options = res;
            })
        }

    },
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
  color: white;
}

.item {
  padding: 18px 0;
}
.item1 {
  padding: 18px 0;
  margin-left: 40px;
}

.box-card {
  width: 950px;
  height: 100px;
  margin: 5px;
  margin-left: 140px;
  margin-top: 20px;
  text-align: center;
}
.box-card1 {
  display: inline-block;
  margin-left: 80px;
  margin-top: 10px;
  width: 300px;
  height: 150px;
}
.selectanddropdown{
  width: 1400px;
  height: 50px;
  margin: 5px;
  margin-left: 100px;
  position: relative;
  top: 50px;
  left: 40px;
}
.cards{
  position: relative;
  top: 40px;
}
.card1{
    display: flex;
    flex: 1;
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
.search{
  display: inline-block;
  width: 200px;
}

</style>