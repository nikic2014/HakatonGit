import { createRouter, createWebHistory } from 'vue-router'
import Login from './components/Login.vue'
import Main from './components/Main.vue'
import CourseInfo from './components/CourseInfo.vue'
import TaskInfo from './components/TaskInfo.vue'

const routes = [
  { path: '/', component: Login },
  { path: '/main', component: Main },
  {
    path: '/courseinfo',
    component: CourseInfo,
    props: (route) => ({ title: route.query.title })
  },
  {
    path: '/taskinfo',
    component: TaskInfo,
    props: (route) => ({
      title: route.query.title,
      titleTask: route.query.titleTask
    })
  }
]

const router = createRouter({
  history: createWebHistory(),
  routes
})

export default router
