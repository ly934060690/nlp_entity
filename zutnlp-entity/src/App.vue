<template xmlns:img="http://www.w3.org/1999/xhtml">
  <div>

    <el-container>
      <el-header></el-header>

      <el-container>
        <el-aside width="200px">
          <el-menu
            style="width: 100%"
            default-active="$route.path"
            router="true"
            class="el-menu-vertical-demo"
            @open="handleOpen"
            @close="handleClose"
            background-color="#7CCBFF"
            text-color="#2f882c"
            active-text-color="#ffd04b">

            <el-menu-item index="/components/home/homePage">
              <i class="el-icon-menu"></i>
              <span slot="title">首页</span>
            </el-menu-item>

            <el-submenu index="2">
              <template slot="title">
                <i class="el-icon-location"></i>
                <span>导航一</span>
              </template>
              <el-menu-item-group >
                <el-menu-item index="/components/d1/page1">page1</el-menu-item>
                <el-menu-item index="/components/d1/page2">page2</el-menu-item>
                <el-menu-item index="/components/d1/page3">page3</el-menu-item>

              </el-menu-item-group>
            </el-submenu>
            <el-submenu index="3">
              <template slot="title">
                <i class="el-icon-location"></i>
                <span>导航二</span>
              </template>
              <el-menu-item-group >
                <el-menu-item index="/components/d2/page1">page4</el-menu-item>
                <el-menu-item index="/components/d2/page2">page5</el-menu-item>
                <el-menu-item index="/components/d2/page3">page6</el-menu-item>
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

<style>

  .el-header{
    background-color: #ab7753;
    text-align: center;
    line-height: 200%;
  }

  .el-aside {
    background-color: #ffb826;
    text-align: center;
    height: 800px;
  }

  .el-main {
    background-color: #9fff4b;
    text-align: center;
    height: 800px;
  }
</style>
