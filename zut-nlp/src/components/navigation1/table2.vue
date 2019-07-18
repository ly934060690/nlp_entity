<template>
 <div>
   <span content-position="center" style="font-size: 20px">这里是实体关系提取页面</span>  <br>
   <br><textarea id="txt" type="text" placeholder="请输入处理的语句" v-model="postData"></textarea>
   <br><el-button  icon="el-icon-check" circle @click.native="submit" type="success" round :loading="isBtnLoading"></el-button>
   <h1 style="line-height: 4px">
     返回的信息为</h1>
   <h1 style="line-height: 8px">
     <textarea class="textarea" v-bind:value="data.text"></textarea><br>
     <el-button class="93login_btn" @click.native="test" type="primary" round :loading="isBtnLoading">获取</el-button>
   <router-view/>
   </h1>
 </div>
</template>
<script type="text/javascript">
    import axios from 'axios';
    export default {
      name: 'table2',
      data() {
        return {
          data: {}
        }
      }
      ,
      created() {
      },
      methods: {

        submit: function () {
          let content = document.getElementById("txt");
          let postData = {
            "text": content.value,
          }
          alert('您要提交的数据为：' + postData.text)
          this.transfer(postData)
        },
        transfer: function (postData) {
          this.$axios({
            method: 'post',
            url: 'http://localhost:8082/zutnlp/stanford/request',
            data: postData,
          }).then((res) => {
            console.log(res.data)
          }).cache(err => {
            console.log(err)
          })
        },
        test: function () {
          alter('成功调用test')
          let that = this
          var url = 'http://localhost:8082/zutnlp/stanford/response'
          alert('即将进入axios')
          this.$axios.get(url)
            .then(function (res) {
              alter('进入axios')
              that.data = res.data;
              console.log("成功获得data");
              alert('成功获得data');
            })
            .then(function (res) {
              console.log(res);
              alter('获取数据失败');
            })
        }

      }
    }
</script>

<style>
  .textarea{
    width: 1150px;
    height: 100px;
    border:double;
    border-color: #cedddd;
    border-width: 5px;
    font-size: 20px;
  }
  .txt{
    width: 1150px;
    height: 100px;
    border:double;
    border-color: #c2d7dd;
    border-width: 5px;
    font-size: 20px;
  }
</style>
