import {createRouter, createWebHashHistory} from "vue-router";

// Views
import UnknownRoute from "@/components/404-page"
import projectSubmissions from "@/views/admin/project/projectSubmissions";
import projectSubmissionsDetail from "@/views/admin/project/ProjectSubmissionsDetail";
import clientSubmitions from "@/views/admin/client/clientSubmitions";
import Profile from "@/views/admin/profile";
import Dashboard from "@/views/admin/Dashboard";

// Components
import SpecialistApplications from "@/components/SpecialistApplications";
import SpecialistApplicationModal from "@/components/SpecialistApplicationModal";

export const router = createRouter({
    history: createWebHashHistory(),
    routes: [
        {path: '/', component: Dashboard},
        {path: '/profile/:id', name: 'profile', component: Profile},
        {path: '/:pathMatch(.*)', component: UnknownRoute},
        {
            path: '/specialists/applications',
            component: SpecialistApplications,
            children: [{
                path: ':id',
                component: SpecialistApplicationModal
            }]
        },
        {
            path: '/dashboard',
            name: 'Dashboard',
            component: () => import('../views/admin/Dashboard.vue')
        },
        {
            path: '/projects', name: 'Projects', component: projectSubmissions,
        },
        {
            path: '/projects/:id', name: 'Project', component: projectSubmissionsDetail,
        },
        {
            path: '/specialists',
            name: 'Specialists',
            component: () => import('../views/admin/specialist/Specialists.vue')
        },
        {
            path: '/clients',
            name: 'Clients',
            component: clientSubmitions,
        },
        {
            path: '/client/:id', name: 'Client', component: () => import('../views/admin/client/detailPageClients')
        },
    ]
})
