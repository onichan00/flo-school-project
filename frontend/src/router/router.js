import SpecialistProfile from "@/screens/SpecialistProfile";
import { createRouter, createWebHashHistory } from "vue-router"
import UnknownRoute from "@/components/404-page"
import projectSubmissions from "@/views/projectSubmissions";
import projectSubmissionsDetail from "@/views/ProjectSubmissionsDetail";
import SpecialistApplications from "@/components/SpecialistApplications";
import SpecialistApplicationModal from "@/components/SpecialistApplicationModal";
import clientSubmitions from "@/views/clientSubmitions";

export const router = createRouter({
    history: createWebHashHistory(),
    routes: [
        {path: '/', component: SpecialistProfile},
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
            component: () => import('../views/Dashboard.vue')
        },
        {
            path: '/projects', name: 'projects', component: projectSubmissions,
        },
        {
            path: '/projects/:id', name: 'projectsDetail', component: projectSubmissionsDetail,
        },
        {
            path: '/specialists',
            name: 'Specialists',
            component: () => import('../views/Specialists.vue')
        },
        {
            path: '/client-applications', component: clientSubmitions, children: [
                {path: ':id', component: () => import('../views/detailPageClients')}
            ]
        },
        {
            path: '/client-details:id',
            component: () => import('../views/detailPageClients.vue')
        },
  ]
})
