import { mount } from '@vue/test-utils'
import { createRouter, createWebHashHistory } from 'vue-router'
import Form from "@/components/admin/AdminDetail.vue";
import routes from "@/router/router.js" // This import should point to your routes file declared above



describe("Form", () => {
    let wrapper;


    beforeEach(async () => {
        wrapper = mount(Form);
        wrapper.setData({id: 3})
        await wrapper.vm.$nextTick();

    });

    it("should render 3 input fields for first name, preposition and last name", () => {
        const inputFields = wrapper.findAll("input");
        const selectFields = wrapper.findAll("select");

        expect(inputFields.length).toBe(7);
        expect(selectFields.length).toBe(1);
    });

    it("should correctly set the value of the first name input when the value of the v-model changes", async () => {
        wrapper.setData({ first_name: "testFirstname" });
        await wrapper.vm.$nextTick();
        expect(wrapper.find("#floating_first_name").element.value).toBe("testFirstname");
    });

    it("should correctly set the value of the preposition input when the value of the v-model changes", async () => {
        wrapper.setData({ preposition: "testPreposition" });
        await wrapper.vm.$nextTick();
        expect(wrapper.find("#floating_preposition").element.value).toBe("testPreposition");
    });

    it("should correctly set the value of the last name input when the value of the v-model changes", async () => {
        wrapper.setData({ last_name: "Doe" });
        await wrapper.vm.$nextTick();
        expect(wrapper.find("#floating_last_name").element.value).toBe("Doe");
    });

    it("should correctly set the value of the email input when the value of the v-model changes", async () => {
        wrapper.setData({ email: "name@company.com" });
        await wrapper.vm.$nextTick();
        expect(wrapper.find("#email").element.value).toBe("name@company.com");
    });

    it("should correctly set the value of the phone input when the value of the v-model changes", async () => {
        wrapper.setData({ phone: "06 12 34 56 78" });
        await wrapper.vm.$nextTick();
        expect(wrapper.find("#phone").element.value).toBe("06 12 34 56 78");
    });
});
