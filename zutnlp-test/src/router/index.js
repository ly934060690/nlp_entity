import Vue from 'vue'
import Router from 'vue-router'
import homePage from '@/components/home/homePage'
import page1 from '@/components/d1/page1'
import page2 from '@/components/d1/page2'
import page3 from '@/components/d1/page3'
import page4 from '@/components/d2/page4'
import page5 from '@/components/d2/page5'
import page6 from '@/components/d2/page6'

Vue.use(Router);

export default new Router({
  routes: [
    {
      path: '/components/home/homePage',
      name: 'homePage',
      component: homePage
    },
    {
      path:'/components/d1/page1',
      name:'page1',
      component: page1
    },
    {
      path:'/components/d1/page2',
      name:'page2',
      component: page2
    },
    {
      path:'/components/d1/page3',
      name:'page3',
      component: page3
    },
    {
      path:'/components/d2/page4',
      name:'page4',
      component: page4
    },
    {
      path:'/components/d2/page5',
      name:'page5',
      component: page5
    },
    {
      path:'/components/d2/page6',
      name:'page6',
      component: page6
    }
  ]
})
