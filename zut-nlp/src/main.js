// The Vue build version to load with the `import` command
// (runtime-only or standalone) has been set in webpack.base.conf with an alias.
import Vue from 'vue'
import App from './App'
import router from './router'
import 'element-ui/lib/theme-chalk/index.css'
import Axios from 'axios'
import ElementUI from 'element-ui'
//import VueResource from 'vue-resource'  //请求http
import VueAxios from 'vue-axios'
Vue.config.productionTip = false
Vue.use(ElementUI)
//Vue.use(VueAxios, axios)
//将其挂载到Vue实例上
Vue.prototype.$axios = Axios
//挂载HOST，解决跨域问题
Vue.prototype.HOST = '/api'
Axios.defaults.headers.post['Content-Type'] = 'application/x-www-form-urlencoded';
Vue.use(Axios,VueAxios)
/* eslint-disable no-new */
new Vue({
  el: '#app',
  router,
  components: { App },
  template: '<App/>'
})
// new Vue({
//   el: '#login',
//   router,
//   components: { login },
//   template: '<login/>'
// })
