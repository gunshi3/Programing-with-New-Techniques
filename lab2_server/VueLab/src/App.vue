<template>
  <div id="app">
    <el-container style="height: 500px; border: 1px solid #eee">
        <el-main style="height:1000px">
            <router-view></router-view>
        </el-main>
    </el-container>
  </div>
</template>

<script>


</script>

<style>
#app {
  font-family: "Avenir", Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #2c3e50;
  margin-top: 60px;
}
.el-header {
  background-color: #b3c0d1;
  color: #333;
  line-height: 60px;
}

.el-aside {
  color: #333;
}
</style>
