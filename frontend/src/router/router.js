import { createRouter, createWebHashHistory } from "vue-router"
import HelloWorld from "@/components/HelloWorld";
import UnknownRoute from "@/components/404-page"
import projectSubmissions from "@/views/projectSubmissions";
import projectSubmissionsDetail from "@/views/ProjectSubmissionsDetail";

export const router = createRouter({
  history: createWebHashHistory(),
  routes: [
    { path: '/', component: HelloWorld },
    { path: '/:pathMatch(.*)', component: UnknownRoute },
    {
      path: '/dashboard',
      name: 'Dashboard',
      component: () => import('../views/Dashboard.vue')
    },
    {
      path: '/projects', name: 'projects' ,component: projectSubmissions,
    },
    {
      path: '/projects/:id', name: 'projectsDetail', component: projectSubmissionsDetail,
    },
    {
      path: '/specialists',
      name: 'Specialists',
      component: () => import('../views/Specialists.vue')
    },
  ]
})
