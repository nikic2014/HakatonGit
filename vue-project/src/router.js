import { createRouter, createWebHistory } from 'vue-router'
import Login from './components/Login.vue'
import Main from './components/Main.vue'
import CourseInfo from './components/CourseInfo.vue'
import TaskInfo from './components/TaskInfo.vue'

const routes = [
  { path: '/', component: Login },
  { path: '/main', component: Main },
  { path: '/courseinfo', component: CourseInfo },
  { path: '/taskinfo', component: TaskInfo }
]

const router = createRouter({
  history: createWebHistory(),
  routes
})

export default router
