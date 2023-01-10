import {createRouter, createWebHashHistory} from "vue-router";

// Views
import projectSubmissionsDetail from "@/views/admin/project/ProjectSubmissionsDetail";
import Profile from "@/views/admin/profile";
import Admin from "@/views/admin/dashboard.vue";
import Login from "@/views/Login.vue";
import Register from "@/views/RegisterPage.vue";
import LandingPage from "@/views/landingPage.vue";
import Specialists from "@/views/admin/specialist/Specialists";
import ClientList from "@/views/admin/client/ClientList";
import CreateClient from "@/views/admin/client/CreateClient.vue";
import ClientDetail from "@/views/admin/client/ClientDetail.vue";

// Components
import UnknownRoute from "@/components/404-page"
import SpecialistApplications from "@/views/admin/specialist/SpecialistApplications.vue";
import SpecialistApplicationModal from "@/components/SpecialistApplicationModal.vue";
import ProjectsOverview from "@/views/ProjectsOverview";
import projectSubmissions from "@/views/admin/project/projectSubmissions";
import ClientHomePage from "@/views/ClientHomePage";
import ClientSettings from "@/views/ClientSettings";
import CreateProjects from "@/views/createProjects";
import SpecialistProfile from "@/views/specialist/SpecialistProfile";
import SpecialistHomePage from "@/views/specialist/SpecialistHomePage";
import SpecialistSettings from "@/views/specialist/SpecialistSettings";
import SpecialistProjectsOverview from "@/views/specialist/SpecialistProjectsOverview";

import CreateAdmins from "@/components/admin/CreateAdmins";
import AdminsTable from "@/components/admin/AdminsTable";
import AdminDetail from "@/components/admin/AdminDetail";
import ClientProfile from "@/views/ClientProfile";
import projectEvent from "@/views/admin/project/projectEvent";
import AddSpecialistToProject from "@/views/admin/project/AddSpecialistToProject";
import SpecialistPendingPage from "@/views/specialist/SpecialistPendingPage";
import CreateNewProject from "@/views/admin/project/CreateNewProject";
import CreateSpecialist from "@/views/admin/specialist/CreateSpecialist";


export const router = createRouter({
    history: createWebHashHistory(),
    routes: [
        {
            path: '/admin',
            name: 'Admin dashboard',
            component: Admin
        },
        {
            path: '/admin/admins',
            name: 'Admin gebruikers',
            component: AdminsTable
        },
        {
            path: '/admin/create-admin',
            name: 'Nieuwe Admin aanmaken',
            component: CreateAdmins
        },
        {
            path: '/admin/detail/:id',
            name: 'Admin detail',
            component: AdminDetail
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
            name: 'Project',
            component: projectSubmissions
        },
        {
            path: '/projects/add-specialist/:id',
            name: 'Add specialist to project',
            component: AddSpecialistToProject
        },
        {
            path: '/projects/event/:id',
            name: 'Event',
            component: projectEvent
        },
        {
            path: '/projects/create-new-project',
            name: 'Admin Create Project',
            component: CreateNewProject
        },
        {
            path: '/projects/:id',
            name: 'Project details',
            component: projectSubmissionsDetail,
        },
        {
            path: '/specialists',
            name: 'Specialists',
            component: Specialists,
        },
        {
            path: '/specialists/create',
            name: 'Create Specialist',
            component: CreateSpecialist
        },
        {
            path: '/clients',
            name: 'Clients',
            component: ClientList,
        },
        {
            path: '/client/projects-overview',
            name: 'Projects',
            component: ProjectsOverview,
        },
        {
            path: '/create-project',
            name: 'Create Project',
            component: CreateProjects
        },
        {
            path: '/client/:id',
            name: 'Client',
            component: ClientDetail
        },
        {
            path: '/client/dashboard',
            name: 'Client dashboard',
            component: ClientHomePage
        },
        {
            path: '/client/settings',
            name: 'Client Settings',
            component: ClientSettings
        },
        {
            path: '/client/profile',
            name: 'Client Profile',
            component: ClientProfile
        },

        {
            path: '/specialist/dashboard',
            name: 'Specialist dashboard',
            component: SpecialistHomePage
        },
        {
            path: '/specialist/settings/:id',
            name: 'Specialist Settings',
            // component:  SpecialistSettings
            component: Profile
        },
        {
            path: '/specialist/profile',
            name: 'Specialist Profile',
            component: SpecialistProfile
        },
        {
            path: '/specialist/projects-overview',
            name: 'Specialist Projects',
            component: SpecialistProjectsOverview,
        },
        {
            path: '/client/create',
            name: 'Create client',
            component: CreateClient
        },

        {
            path: '/specialist/pending',
            name: 'Pending-page',
            component: SpecialistPendingPage
        },
        {
            path: '/:pathMatch(.*)',
            component: UnknownRoute
        },
    ]
})

router.beforeEach((to, from) => {
    console.log(to)

    console.log(localStorage.getItem("approvalStatus"))
    console.log(localStorage.getItem("userType"))

    // Whitelisted routes when logged out
    const accessibleLoggedOutRoutes = ['Landing-page', 'Login', 'Register']

    if (!accessibleLoggedOutRoutes.includes(to.name) && localStorage.getItem("id") === null) {
        return {name: 'Landing-page'}
    }
    if (to.path !== '/specialist/pending' && localStorage.getItem("userType") == 2 && localStorage.getItem("approvalStatus") == 2) {
        return {name: 'Pending-page'}
    }


})
