import { mount } from '@vue/test-utils'
import Form from "@/components/admin/AdminDetail.vue";



describe("Form", () => {
    let wrapper;


    beforeEach(async () => {
        wrapper = mount(Form, {
            data() {
                return {
                    id: 1
                }
            }
        })
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
        wrapper.setData({ preposition: "testPreposition" });
        wrapper.setData({ last_name: "testLastname" });
        wrapper.setData({ phone: "06 12 34 56 78" });
        wrapper.setData({ email: "test@email.com" });
        wrapper.setData({ password: "password" });

        await wrapper.vm.$nextTick();

        expect(wrapper.find("#floating_first_name").element.value).toBe("testFirstname");
        expect(wrapper.find("#floating_preposition").element.value).toBe("testPreposition");
        expect(wrapper.find("#floating_last_name").element.value).toBe("testLastname");
        expect(wrapper.find("#email").element.value).toBe("test@email.com");
        expect(wrapper.find("#phone").element.value).toBe("06 12 34 56 78");
        expect(wrapper.find("#password").element.value).toBe("password");

    });
});
