<template>
    <div>
      <h>Welcome to use NLP system!</h>
      <br><textarea id="txt" type="text" placeholder="请输入处理的语句" v-model="postData"></textarea>
      <br><el-button class="message" @click.native="submit" type="primary" round :loading="isBtnLoading">提交</el-button>
    </div>
</template>

<script>
    export default {
      data(){
          return{
            postData:'',
            isBtnLoading:false,
          }
      },
      created:function(){
      },
      
      methods:{
          submit:function () {
            let content = document.getElementById("txt");
            let postData = {
              "text":content.value,
            }
            alert('您要提交的数据为：' + postData.text)
            this.transfer(postData)
          },
          transfer:function(postData){

            this.$axios({
              method:'post',
              url:'http://127.0.0.1:8080/request',
              data: postData,
            }).then((res) => {
              console.log(res.data)
            }).cache(err =>{
              console.log(err)
            })
          }
      }
    }
</script>

<style>
.txt{
  width: 700px ;
  height:200px ;
  font-size: 20px
}
</style>
