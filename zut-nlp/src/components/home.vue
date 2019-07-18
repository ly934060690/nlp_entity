<template>
  <div align="center">
  <el-carousel indicator-position="outside"  type="card" height="400px"  content-position="center">
    <!--<el-carousel-item v-for="item in 4" :key="item">-->
      <!--<h3>{{ item }}</h3>-->
    <!--</el-carousel-item>-->
    <el-carousel-item >
      <img src="../assets/img1.jpg" class="carousel_image_type">
    </el-carousel-item>
    <el-carousel-item>
      <img src="../assets/img2.jpg" class="carousel_image_type">
    </el-carousel-item>
    <el-carousel-item>
      <img src="../assets/img3.jpg" class="carousel_image_type">
    </el-carousel-item>
    <el-carousel-item>
      <img src="../assets/img4.jpg" class="carousel_image_type">
    </el-carousel-item>
  </el-carousel>
    <span content-position="center" style="font-size: 50px">我们只负责实体关系</span>
    <el-divider content-position="right" style="font-size: 30px">
      <i class="el-icon-user-solid"></i> entity小组</el-divider>
    <el-avatar src="https://cube.elemecdn.com/0/88/03b0d39583f48206768a7534e55bcpng.png" align="left"></el-avatar><br><br>
    <el-tag
      :key="tag"
      v-for="tag in dynamicTags"
      closable
      :disable-transitions="false"
      @close="handleClose(tag)">
      {{tag}}
    </el-tag>
    <el-input
      class="input-new-tag"
      v-if="inputVisible"
      v-model="inputValue"
      ref="saveTagInput"
      size="small"
      @keyup.enter.native="handleInputConfirm"
      @blur="handleInputConfirm"
    >
    </el-input>
    <el-button v-else class="button-new-tag" size="small" @click="showInput">+ New Tag</el-button>

  </div>
</template>
<style>
  .el-carousel-item{
    align-items: center;
    justify-content: center;
  }

  .el-carousel{
    align-items: center;
    justify-content: center;
    align: center;
    width: 80%;
    height:500px;
  }
  .carousel_image_type{
    width: 100%;
    height: 100%;
  }

  .el-tag + .el-tag {
    margin-left: 10px;
  }
  .button-new-tag {
    margin-left: 10px;
    height: 32px;
    line-height: 30px;
    padding-top: 0;
    padding-bottom: 0;
  }
  .input-new-tag {
    width: 90px;
    margin-left: 10px;
    vertical-align: bottom;
  }
</style>
<script>
  export default {
    data() {
      return {
        dynamicTags: ['认真', '向上', '团结','不懈'],
        inputVisible: false,
        inputValue: ''
      };
    },
    methods: {
      handleClose(tag) {
        this.dynamicTags.splice(this.dynamicTags.indexOf(tag), 1);
      },

      showInput() {
        this.inputVisible = true;
        this.$nextTick(_ => {
          this.$refs.saveTagInput.$refs.input.focus();
        });
      },

      handleInputConfirm() {
        let inputValue = this.inputValue;
        if (inputValue) {
          this.dynamicTags.push(inputValue);
        }
        this.inputVisible = false;
        this.inputValue = '';
      }
    }
  }
</script>
