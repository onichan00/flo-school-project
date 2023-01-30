import SpecialistApplications from "@/views/admin/specialist/SpecialistApplications.vue";
import SpecialistApplicationModal from "@/components/SpecialistApplicationModal.vue";
import {createMemoryHistory, createRouter} from "vue-router";
import {mount, shallowMount} from "@vue/test-utils";
import { server } from "@/mocks/server";
import "whatwg-fetch";
import {reactive} from "vue";

let wrapper;
const routes = [
    {
        path: "",
        component: SpecialistApplications
    },
    {
        path: "/:id",
        component: SpecialistApplicationModal
    }
]

beforeAll(() => {
    server.listen();
})

afterEach(() => {
    server.resetHandlers();
})

afterAll(() => {
    server.close();
})

beforeEach(async function() {
    const router = createRouter({
        history: createMemoryHistory(),
        routes: routes
    });

    wrapper = await mount(SpecialistApplications, {
        global: {
            plugins: [router]
        }
    });
})

describe("SpecialistApplications.vue", () => {
    it("has rendered table headers properly", async () => {
        const tHeaders = wrapper.findAllDOMElements("th");
        expect(tHeaders[0].innerHTML).toEqual("Naam");
        expect(tHeaders[1].innerHTML).toEqual("Leeftijd");
        expect(tHeaders[2].innerHTML).toEqual("Email");
        expect(tHeaders[3].innerHTML).toEqual("Telefoon");
        expect(tHeaders[4].innerHTML).toEqual("Status");
    })

    it("has created a table row for each retrieved specialist", async () => {
        console.log(wrapper.vm.specialists);
    })

    it("opens a modal when a specialist's table row is clicked", () => {})

    it("changes a specialist's approval status to 1 ('approved') when 'Approve' button is clicked", () => {})

    it("closes the modal when the x button is clicked", () => {})
})
