<template>
  <div>
    <h1 style="line-height:4px">下面是返回的信息：</h1>
    <h1 style="line-height:8px">
      <textarea  class="textarea" v-bind:value="data.text" ></textarea></h1>
    <el-button class="login_btn" @click.native="test" type="primary" round :loading="isBtnLoading">刷新</el-button>
    <router-view/>
  </div>
</template>

<script type="text/javascript">
  import axios from 'axios';
  export default {
    name:'page1',
    data() {
      return {
        //It like the statement of variables
        data:{},
      }
    },
    created() {
    },
    methods:{
      test:function () {
        alert('成功调用test')
        let that = this
        var url = 'http://localhost:8082/zutnlp/stanford/response'
        //if you want to change the value of HOST ,please go to /osals/config/index.js/->module.exports->dev->proxyTable->target
        alert('即将进入axios')
        this.$axios.get(url)
          .then(function (res) {
            alert('进入axios')
            that.data = res.data;
            //this res.data is from the server's response
            console.log("成功获得data");
            alert('成功获得data');
          })
          .then(function (res) {
            console.log(res);
            alert('失败获得data');
          })
      }
    }
  }
</script>

<style>
  .textarea{
    width: 1150px ;
    height: 100px ;
    border: double ;
    border-color: #c9ffaf;
    border-width: 5px ;
    font-size: 20px;
  }
</style>
