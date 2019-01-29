import Vue from 'vue'
import Router from 'vue-router'
import AdminIndex from './views/AdminIndex.vue'
import UserIndex from './views/UserIndex.vue'
import CheckRecordIndex from './views/CheckRecordIndex.vue'

Vue.use(Router)

export default new Router({
  routes: [
    {
      path: '/',
      name: 'AdminIndex',
      component: AdminIndex
    },
    {
      path: '/UserIndex',
      name: 'UserIndex',
      component: UserIndex
    },
    {
      path: '/CheckRecordIndex',
      name: 'CheckRecordIndex',
      component: CheckRecordIndex
    },
    {
      path: '/about',
      name: 'about',
      // route level code-splitting
      // this generates a separate chunk (about.[hash].js) for this route
      // which is lazy-loaded when the route is visited.
      component: () => import(/* webpackChunkName: "about" */ './views/About.vue')
    }
  ]
})
