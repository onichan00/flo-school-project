import {createRouter, createWebHashHistory} from "vue-router"
import HelloWorld from "@/components/HelloWorld";
import UnknownRoute from "@/components/404-page"

export const router = createRouter({
    history: createWebHashHistory(),
    routes: [
        {path: '/', component: HelloWorld},
        {path: '/:pathMatch(.*)', component: UnknownRoute},
        {
            path: '/dashboard',
            name: 'Dashboard',
            component: () => import('../views/Dashboard.vue')},
        {
            path: '/specialists',
            name: 'Specialists',
            component: () => import('../views/Specialists.vue')
        },
    ]
})