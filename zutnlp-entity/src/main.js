// The Vue build version to load with the `import` command
// (runtime-only or standalone) has been set in webpack.base.conf with an alias.
import Vue from 'vue'
import App from './App'
import router from './router'
import ElementUI from 'element-ui'
import 'element-ui/lib/theme-chalk/index.css'
import Axios from 'axios'
import VueResource from 'vue-resource'  //请求http
import VueAxios from 'vue-axios'

Vue.config.productionTip = false

Vue.use(ElementUI)
//将其挂载到Vue实例上
Vue.prototype.$axios = Axios
//挂载HOST，解决跨域问题
Vue.prototype.HOST = '/api'
Axios.defaults.headers.post['Content-Type'] = 'application/x-www-form-urlencoded';

Vue.use(Axios,VueAxios)

/* eslint-disable no-new */
new Vue({
  el: '#app',     //index.html(id='app')->main('#app')
  router,
  components: { App },      //->App.vue
  template: '<App/>'      //引入组件<app>,模板将会替换挂载的元素。挂载元素的内容都将被忽略
                          //template: '<App/>' 表示用<app></app>替换index.html里面的<div id="app"></div>
})
