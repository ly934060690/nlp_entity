<template xmlns:img="http://www.w3.org/1999/xhtml">
  <div>

    <el-container>
      <el-header>
        <el-button type="primary" :loading="true" >welcome</el-button>
      </el-header>
      <el-container>
        <el-aside width="200px">
          <el-menu
            style="width: 100%"
            default-active="$route.path"
            router="true"
            class="el-menu-vertical-demo"
            @open="handleOpen"
            @close="handleClose"
            background-color=" #dce6df"
            text-color="black"
            active-text-color=" #b6e1e6">

            <el-menu-item index="/components/home">
              <i class="el-icon-s-home"></i>
              <span slot="title">首页</span>
            </el-menu-item>

            <el-submenu index="2">
              <template slot="title">
                <i class="el-icon-s-grid"></i>
                <span>导航一</span>
              </template>
              <el-menu-item-group >
                <el-menu-item index="/components/navigation1/table1">
                  <i class="el-icon-s-data"></i>
                  table1</el-menu-item>
                <el-menu-item index="/components/navigation1/table2">
                  <i class="el-icon-s-data"></i>table2</el-menu-item>
                <el-menu-item index="/components/navigation1/table3">
                  <i class="el-icon-s-data"></i>table3</el-menu-item>

              </el-menu-item-group>
            </el-submenu>
            <el-submenu index="3">
              <template slot="title">
                <i class="el-icon-s-grid"></i>
                <span>导航二</span>
              </template>
              <el-menu-item-group >
                <el-menu-item index="/components/navigation2/page1">
                 <i class="el-icon-magic-stick"></i>
                 waiting</el-menu-item>
                <el-menu-item index="/components/navigation2/page2">
                  <i class="el-icon-magic-stick"></i>waiting</el-menu-item>
                <el-menu-item index="/components/navigation2/page3">
                  <i class="el-icon-magic-stick"></i>waiting</el-menu-item>
              </el-menu-item-group>
            </el-submenu>
            <el-submenu index="4">
              <template slot="title">
                <i class="el-icon-s-custom"></i>
                <span>关于我们</span>
              </template>
              <el-menu-item-group >
                <el-menu-item index="/components/aboutOurs/choose1">
                  <i class="el-icon-tickets"></i>
                  关于我们</el-menu-item>
                <el-menu-item index="/components/aboutOurs/choose2">
                  <i class="el-icon-paperclip"></i>
                  帮助</el-menu-item>
              </el-menu-item-group>
            </el-submenu>
          </el-menu>
        </el-aside>

        <el-main>
          <router-view></router-view>
        </el-main>

      </el-container>
    </el-container>
  </div>
</template>

<script>
  export default {
    name: 'App'
  }
</script>

<style  >

  .el-header{
    background-color: #dce6df;
    text-align:center;
    line-height: 200%;
  }

  .el-aside {
    background-color: #dce6df;
    text-align: center;
    height: 1000px;
  }

  .el-main {
    background-color: #8f9e9e;
    text-align: center;
    height: 1000px;
  }
</style>
