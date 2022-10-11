import { createRouter, createWebHistory } from 'vue-router'

const routes = [
    {
        path: '/dashboard',
        name: 'Dashboard',
        component: () => import('../views/Dashboard.vue')
    },

    {
        path: '/specialists',
        name: 'Specialists',
        component: () => import('../views/Specialists.vue')
    },
]

const router = createRouter({
    history: createWebHistory(process.env.BASE_URL),
    routes
})

export default router