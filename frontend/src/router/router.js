import {createRouter, createWebHashHistory} from "vue-router";

// Views
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
import ProjectsOverview from "@/views/ProjectsOverview";
import projectSubmissions from "@/views/admin/project/projectSubmissions";
import ClientHomePage from "@/views/ClientHomePage";
import ClientSettings from "@/views/ClientSettings";
import CreateProjects from "@/views/createProjects";
import CreateAdmins from "@/components/admin/CreateAdmins";
import AdminsTable from "@/components/admin/AdminsTable";
import AdminDetail from "@/components/admin/AdminDetail";
import ClientProfile from "@/views/ClientProfile";

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
            path: '/create-project',
            name: 'Create Project',
            component: CreateProjects
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
            path: '/clients',
            name: 'Clients',
            component: clientSubmitions,
        },
        {
            path: '/client/projects-overview',
            name: 'Projects',
            component: ProjectsOverview,
        },
        {
            path: '/client/:id',
            name: 'Client',
            component: Client
        },
        {
            path: '/client/dashboard',
            name: 'Client dashboard',
            component:  ClientHomePage
        },
        {
            path: '/client/settings',
            name: 'Client Settings',
            component:  ClientSettings
        },
        {
            path: '/client/profile',
            name: 'Client Profile',
            component:  ClientProfile
        },
        {
            path: '/:pathMatch(.*)',
            component: UnknownRoute
        },
    ]
})

router.beforeEach((to,from) => {
    console.log(to)

    // Whitelisted routes when logged out
    const accessibleLoggedOutRoutes = ['Landing-page', 'Profile', 'Login', 'Register']

    if (!accessibleLoggedOutRoutes.includes(to.name) && localStorage.getItem("id") === null) {
        return { name: 'Landing-page' }
    }

})
