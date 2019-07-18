import Vue from 'vue'
import Router from 'vue-router'
import home from '@/components/home'
// import login from '@/components/login'
import table1 from '@/components/navigation1/table1';
import table2 from '@/components/navigation1/table2';
import table3 from '@/components/navigation1/table3';
import choose1 from '@/components/aboutOurs/choose1';
import choose2 from '@/components/aboutOurs/choose2';
import page1 from '@/components/navigation2/page1';
import page2 from '@/components/navigation2/page2';
import page3 from '@/components/navigation2/page3';

Vue.use(Router)

export default new Router({
  routes: [
    // {
    //   path: '/components/login',
    //   name: 'login',
    //   component: login
    // },
    {
      path: '/components/home',
      name: 'home',
      component: home
    },
    {
      path: '/components/navigation1/table1',
      name: 'table1',
      component:table1
    },
    {
      path: '/components/aboutOurs/choose1',
      name: 'choose1',
      component:choose1
    },
    {
      path: '/components/aboutOurs/choose2',
      name: 'choose2',
      component:choose2
    },
    {
      path: '/components/aboutOurs/choose1',
      name: 'choose1',
      component:choose1
    },
    {
      path: '/components/navigation1/table2',
      name: 'table2',
      component:table2
    },
    {
      path: '/components/navigation1/table3',
      name: 'table3',
      component:table3
    },
    {
      path: '/components/navigation2/page1',
      name: 'page1',
      component:page1
    },
    {
      path: '/components/navigation2/page2',
      name: 'page2',
      component:page2
    },
    {
      path: '/components/navigation2/page3',
      name: 'page3',
      component:page3
    }
  ]
})
