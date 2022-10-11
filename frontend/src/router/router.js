import {createRouter, createWebHashHistory} from "vue-router"
import HelloWorld from "@/components/HelloWorld";
import UnknownRoute from "@/components/404-page"
import SpecialistApplications from "@/components/SpecialistApplications";
import SpecialistApplicationModal from "@/components/SpecialistApplicationModal";

export const router = createRouter({
    history: createWebHashHistory(),
    routes:[
        {path: '/', component: HelloWorld},
        {
            path: '/specialists/applications',
            component: SpecialistApplications,
            children: [{
                path: ':id',
                component: SpecialistApplicationModal
            }]
        },
        {path: '/:pathMatch(.*)', component: UnknownRoute}
    ]
})