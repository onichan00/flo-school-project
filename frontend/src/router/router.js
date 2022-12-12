import {createRouter, createWebHashHistory} from "vue-router";

// Views
import projectSubmissions from "@/views/admin/project/projectSubmissions";
import projectSubmissionsDetail from "@/views/admin/project/ProjectSubmissionsDetail";
import clientSubmitions from "@/views/admin/client/clientSubmitions";
import Profile from "@/views/admin/profile";
import Admin from "@/views/admin/dashboard.vue";
import Login from "@/views/Login.vue";
import Register from "@/views/RegisterPage.vue";
import LandingPage from "@/views/landingPage.vue";
import Specialists from "@/views/admin/specialist/Specialists";
import Client from "@/views/admin/client/detailPageClients";

// Components
import UnknownRoute from "@/components/404-page"
import SpecialistApplications from "@/components/SpecialistApplications";
import SpecialistApplicationModal from "@/components/SpecialistApplicationModal";

export const router = createRouter({
    history: createWebHashHistory(),
    routes: [
        {
            path: '/admin',
            name: 'Admin',
            component: Admin
        },
        {
            path: '/',
            name: 'Landing-page',
            component: LandingPage
        },
        {
            path: '/login',
            name: 'Login',
            component: Login
        },
        {
            path: '/register',
            name: 'Register',
            component: Register
        },
        {
            path: '/profile/:id',
            name: 'Profile',
            component: Profile
        },
        {
            path: '/specialists/applications',
            component: SpecialistApplications,
            children: [{
                path: ':id',
                component: SpecialistApplicationModal
            }]
        },
        {
            path: '/projects',
            name: 'Projects',
            component: projectSubmissions,
        },
        {
            path: '/projects/:id',
            name: 'Project',
            component: projectSubmissionsDetail,
        },
        {
            path: '/specialists',
            name: 'Specialists',
            component: Specialists,
        },
        {
            path: '/clients',
            name: 'Clients',
            component: clientSubmitions,
        },
        {
            path: '/client/:id',
            name: 'Client',
            component: Client
        },
        {
            path: '/:pathMatch(.*)',
            component: UnknownRoute
        },
        {
            path: '/login', component: () => import('../views/landingPage.vue')
        }


    ]
})

router.beforeEach((to,from) => {
    console.log(to)
        if (to.name !== 'Landing-page' && to.name !== 'Login' && to.name !== 'Register' && localStorage.getItem("id") === null){
            return {name: 'Landing-page'}
        }

})
