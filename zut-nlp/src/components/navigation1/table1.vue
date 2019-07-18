<template>

  <el-table
    :data="tableData"
    style="width: 100%;height: 100%;background-color: #8f9e9e"

  >
    <el-table-column
      label="日期"
      line-height="50px"
      width="180">
      <template slot-scope="scope">
        <i class="el-icon-time"></i>
        <span style="margin-left: 10px">{{ scope.row.date }}</span>
      </template>
    </el-table-column>
    <el-table-column
      label="姓名"
      line-height="50px"
      width="180">
      <template slot-scope="scope">
        <i class="el-icon-user"></i>
        <span style="margin-left: 10px">{{ scope.row.name }}</span>
      </template>
    </el-table-column>
    <el-table-column
      label="住址"
      line-height="50px"
      width="220">
      <template slot-scope="scope">
        <i class="el-icon-s-home"></i>
        <span style="margin-left: 10px">{{ scope.row.address }}</span>
      </template>
    </el-table-column>
    <el-table-column label="操作">
      <template slot-scope="scope">
        <el-button
          size="mini"
          @click="handleEdit(scope.$index, scope.row)">编辑</el-button>
        <el-button
          size="mini"
          type="danger"
          @click="handleDelete(scope.$index, scope.row)">删除</el-button>
      </template>
    </el-table-column>
  </el-table>
</template>

<script>
  export default {
    data() {
      return {
        tableData: [{
          date: '2019-07-18',
          name: '刘研',
          address: '上海市普陀区金沙江路 1518 弄'
        }, {
          date: '2019-07-18',
          name: '刘研',
          address: '上海市普陀区金沙江路 1517 弄'
        }, {
          date: '2019-07-18',
          name: '邢朋举',
          address: '上海市普陀区金沙江路 1519 弄'
        }, {
          date: '2016-05-03',
          name: '王小虎',
          address: '上海市普陀区金沙江路 1516 弄'
        }]
      }
    },
    methods: {
      handleEdit(index, row) {
        console.log(index, row);
      },
      handleDelete(index, row) {
        console.log(index, row);
      }
    }
  }
</script>
